package biblioteca

class OperacionController {
    def jcaptchaService
    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def beforeInterceptor = {
        log.trace("-- EMPIEZA ACCION --")
        log.trace("Usuario: ${session?.usuario?.login}")
        log.trace("Controlador: " + controllerName)
        log.trace("Accion:" + actionName)
    }

    def afterInterceptor = { model ->
        log.trace("-- ACABA ACCION --")
        log.trace("Usuario: ${session?.usuario?.login}")
        log.trace("Controlador: ${controllerName}")
        log.trace("Accion: ${actionName}")
    }

    def index = {
        redirect(action: "list", params: params)
    }

    def list = { 
        params.max = Math.min(params.max ? params.int('max') : 10, 100)

        if (params.usuarioId != null)
          [operacionInstanceList:
           Operacion.findAllWhere(usuario: Usuario.findById(params.usuarioId)),
           operacionInstanceTotal:
           Operacion.findAllWhere(usuario: Usuario.findById(params.usuarioId)).size()]
        else if (params.libroId != null)
          [operacionInstanceList:
           Operacion.findAllWhere(libro: Libro.findById(params.libroId)),
           operacionInstanceTotal:
           Operacion.findAllWhere(libro: Libro.findById(params.libroId)).size()]
        else
          [operacionInstanceList: Operacion.list(params), operacionInstanceTotal: Operacion.count()]
    }

    def create = {
        def operacionInstance = new Operacion()
        operacionInstance.properties = params
        return [operacionInstance: operacionInstance]
    }

    def save = {
        def operacionInstance = new Operacion(params)
        if (!jcaptchaService.validateResponse("image", session.id, params.responseCaptcha)) {
            flash.message = "El captcha no es correcto"
            render(view: 'create', model: [operacionInstance: operacionInstance])
            return
        }
        if (operacionInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'operacion.label', default: 'Operacion'), operacionInstance.id])}"
            redirect(action: "show", id: operacionInstance.id)
        }
        else {
            render(view: "create", model: [operacionInstance: operacionInstance])
        }
    }

    def show = {
        def operacionInstance = Operacion.get(params.id)
        if (!operacionInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'operacion.label', default: 'Operacion'), params.id])}"
            redirect(action: "list")
        }
        else {
            [operacionInstance: operacionInstance]
        }
    }

    def edit = {
        def operacionInstance = Operacion.get(params.id)
        if (!operacionInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'operacion.label', default: 'Operacion'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [operacionInstance: operacionInstance]
        }
    }

    def update = {
        def operacionInstance = Operacion.get(params.id)
        if (operacionInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (operacionInstance.version > version) {
                    
                    operacionInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'operacion.label', default: 'Operacion')] as Object[], "Another user has updated this Operacion while you were editing")
                    render(view: "edit", model: [operacionInstance: operacionInstance])
                    return
                }
            }
            operacionInstance.properties = params
            if (!operacionInstance.hasErrors() && operacionInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'operacion.label', default: 'Operacion'), operacionInstance.id])}"
                redirect(action: "show", id: operacionInstance.id)
            }
            else {
                render(view: "edit", model: [operacionInstance: operacionInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'operacion.label', default: 'Operacion'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def operacionInstance = Operacion.get(params.id)
        if (operacionInstance) {
            try {
                operacionInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'operacion.label', default: 'Operacion'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'operacion.label', default: 'Operacion'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'operacion.label', default: 'Operacion'), params.id])}"
            redirect(action: "list")
        }
    }
}
