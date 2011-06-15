package biblioteca

class LibroController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def beforeInterceptor = {
        log.trace("${session?.usuario?.login} Empieza la acción ${controllerName} Controlador.${actionName}() : parámetros $params")
    }

    def afterInterceptor = { model ->
        log.trace("${session?.usuario?.login} Termina la acción ${controllerName} Controlador.${actionName}() : devuelve $model")
    }

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [libroInstanceList: Libro.list(params), libroInstanceTotal: Libro.count()]
    }

    def create = {
        def libroInstance = new Libro()
        libroInstance.properties = params
        return [libroInstance: libroInstance]
    }

    def save = {
        def libroInstance = new Libro(params)
        if (params.portada != null) {
            libroInstance.nombreImagen = params.portada.originalFilename
            libroInstance.contentTypeImagen = params.portada.contentType
        }

        if (libroInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'libro.label', default: 'Libro'), libroInstance.id])}"
            redirect(action: "show", id: libroInstance.id)
        }
        else {
            render(view: "create", model: [libroInstance: libroInstance])
        }
    }

    def show = {
        def libroInstance = Libro.get(params.id)
        if (!libroInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'libro.label', default: 'Libro'), params.id])}"
            redirect(action: "list")
        }
        else {
            [libroInstance: libroInstance]
        }
    }

    def edit = {
        def libroInstance = Libro.get(params.id)
        if (!libroInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'libro.label', default: 'Libro'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [libroInstance: libroInstance]
        }
    }

    def update = {
        def libroInstance = Libro.get(params.id)
        if (libroInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (libroInstance.version > version) {
                    
                    libroInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'libro.label', default: 'Libro')] as Object[], "Another user has updated this Libro while you were editing")
                    render(view: "edit", model: [libroInstance: libroInstance])
                    return
                }
            }

            libroInstance.properties = params
            if (params.portada != null) {
                libroInstance.nombreImagen = params.portada.originalFilename
                libroInstance.contentTypeImagen = params.portada.contentType
            }

            if (!libroInstance.hasErrors() && libroInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'libro.label', default: 'Libro'), libroInstance.id])}"
                redirect(action: "show", id: libroInstance.id)
            }
            else {
                render(view: "edit", model: [libroInstance: libroInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'libro.label', default: 'Libro'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def libroInstance = Libro.get(params.id)
        if (libroInstance) {
            try {
                libroInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'libro.label', default: 'Libro'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'libro.label', default: 'Libro'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'libro.label', default: 'Libro'), params.id])}"
            redirect(action: "list")
        }
    }

    def showPortada = {
        def libroInstance = Libro.get(params.id)
        response.setHeader("Content-disposition", "inline; filename='${libroInstance.nombreImagen}'")
        response.contentType="${libroInstance.contentTypeImagen}"
        response.outputStream << libroInstance.portada
    }

    def feed = {
        render(feedType: "atom", feedVersion:"1.0") {
            title = "Los nuevos libros"
            link = "http://localhost:8080/biblioteca/libro/feed"
            description = "Fuente RSS de los nuvos libros adquiridos por la biblioteca"

            Libro.list().each() { libro ->
                entry(libro.titulo) {
                    link = "http://localhost:8080/biblioteca/libro/show/${libro.id}"
                    author = libro.autor
                    publishedDate = libro.fecha
                    libro.descripcion
                }
            }
        }
    }
}
