package biblioteca

class UsuarioController {
    def usuarioService, notificadorService

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
        [usuarioInstanceList: Usuario.list(params), usuarioInstanceTotal: Usuario.count()]
    }

    def create = {
        def usuarioInstance = new Usuario()
        usuarioInstance.properties = params
        return [usuarioInstance: usuarioInstance]
    }

    def save = {
        def usuarioInstance = usuarioService.altaUsuario(params)
        if (!usuarioInstance.hasErrors()) {
            flash.message = "usuario.created.message"
            flash.args = [usuarioInstance.nombre, usuarioInstance.apellidos]
            redirect(action: "show", id: usuarioInstance.id)
        }
        else {
            render(view: "create", model: [usuarioInstance: usuarioInstance])
        }
    }

    def show = {
        def usuarioInstance = Usuario.get(params.id)
        if (!usuarioInstance) {
            flash.message = "usuario.not.found.message"
            flash.args = [params.id]
            redirect(action: "list")
        }
        else {
            [usuarioInstance: usuarioInstance]
        }
    }

    def edit = {
        def usuarioInstance = Usuario.get(params.id)
        if (!usuarioInstance) {
            flash.message = "usuario.not.found.message"
            flash.args = [params.id]
            redirect(action: "list")
        }
        else {
            return [usuarioInstance: usuarioInstance]
        }
    }

    def update = {
        def usuarioInstance = Usuario.get(params.id)
        if (usuarioInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (usuarioInstance.version > version) {
                    
                    usuarioInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'usuario.label', default: 'Usuario')] as Object[], "Another user has updated this Usuario while you were editing")
                    render(view: "edit", model: [usuarioInstance: usuarioInstance])
                    return
                }
            }
            usuarioInstance.properties = params
            if (!usuarioInstance.hasErrors() && usuarioInstance.save(flush: true)) {
                flash.message = "usuario.updated.message"
                flash.args = [usuarioInstance.nombre, usuarioInstance.apellidos]
                redirect(action: "show", id: usuarioInstance.id)
            }
            else {
                render(view: "edit", model: [usuarioInstance: usuarioInstance])
            }
        }
        else {
            flash.message = "usuario.not.found.message"
            flash.args = [params.id]
            redirect(action: "list")
        }
    }

    def delete = {
        def usuarioInstance = Usuario.get(params.id)
        if (usuarioInstance) {
            try {
                usuarioInstance.delete(flush: true)
                flash.message = "usuario.deleted.message"
                flash.args = [usuarioInstance.nombre, usuarioInstance.apellidos]
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "usuario.not.deleted.message"
                flash.args = [usuarioInstance.nombre, usuarioInstance.apellidos]
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "usuario.not.found.message"
            flash.args = [params.id]
            redirect(action: "list")
        }
    }

    def login = {}

    def handleLogin = {
      def usuario = Usuario.findByLogin(params.login)
      if (!usuario) {
        flash.message = "usuario.not.found.message"
        flash.args = [params.login]
        redirect(controller: 'usuario', action:'login')
        return
      }
      else {
        session.usuario = usuario
        redirect(controller:'operacion')
      }
    }

    def logout = {
      if (session.usuario) {
        session.usuario = null
        redirect(controller: 'usuario', action:'login')
      }
    }

    def mandarMails = {
        notificadorService.mandarMails("canchete@gmail.com", "hola!", "Esto es una prueba")
        render "El email ha sido enviado correctamente"
    }
}
