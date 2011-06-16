package biblioteca

import org.apache.commons.codec.digest.DigestUtils
import org.codehaus.groovy.grails.commons.ConfigurationHolder


class UsuarioController {
    def exportService, usuarioService, notificadorService, jcaptchaService

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
        
        if (params?.format && params.format != "html") {
            response.contentType = ConfigurationHolder.config.grails.mime.types[params.format]
            response.setHeader("Content-disposition", "attachment;filename=usuarios.${params.format}")
            exportService.export(params.format, response.outputStream, Usuario.list(params), [:], [:])
        }
        [usuarioInstanceList: Usuario.list(params), usuarioInstanceTotal: Usuario.count()]
    }

    def create = {
        def usuarioInstance = new Usuario()
        usuarioInstance.properties = params
        return [usuarioInstance: usuarioInstance]
    }

    def save = {
        //params.password = DigestUtils.md5Hex(params.password)
        def usuarioInstance = usuarioService.altaUsuario(params)
        if (!usuarioInstance.hasErrors()) {
            def url_activacion = createLink(controller:"usuario", action: "activarUsuario", id:usuarioInstance.id, absolute:true).toString()
            usuarioService.enviarEmailRegistro(usuarioInstance,url_activacion)
            flash.message = "usuario.created.message"
            flash.args = [usuarioInstance.login]
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

            // Comprobamos que los passwords coinciden
            if (params.password != params.confirm) {
                flash.message = "La confirmación de la contraseña no coincide con la contraseña"
                render(view: "edit", model: [usuarioInstance: usuarioInstance])
                return
            }
            else {
                def usuarioViejoPassword = usuarioInstance.password
                usuarioInstance.properties = params
                if (params.password == "") {
                    usuarioInstance.password = usuarioViejoPassword
                }
            }
            
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
        }
        else {
            if (usuario.password == params.password) {
                if (usuario.activo) {
                    session.usuario = usuario
                    redirect(controller:'operacion')
                    return
                }
                else {
                    flash.message = "usuario.not.active.message"
                    flash.args = [params.login]
                }
            }
            else {
                flash.message = "usuario.password.error.message"
            }
        }
        redirect(controller: 'usuario', action:'login')
    }

    def logout = {
      if (session.usuario) {
        session.usuario = null
        redirect(controller: 'usuario', action:'login')
      }
    }

    def activarUsuario = {
       def usuario = Usuario.get(params.id)
       if (usuario != null) {
           usuario.activo = true
           usuario.save()
           render "El usuario ha sido activado correctamente"
       }
       else {
           render "El usuario no existe"
       }
    }

    def register = {
        def usuarioInstance = new Usuario()
        usuarioInstance.properties = params
        return ['usuarioInstance':usuarioInstance]
    }

    def handleRegister = {
        def usuarioInstance = new Usuario()
        // proceso el captcha
        if (!jcaptchaService.validateResponse("image", session.id, params.responseCaptcha)) {
            flash.message = "El captcha no es correcto"
            redirect(controller: 'usuario', action: 'register')
        }
        else {
            // Compruebo la confirmación de la contraseña
            if (params.password != params.confirm) {
                flash.message = "La confirmación de la contraseña no coincide con la contraseña"
                redirect(action:register)
            }
            else {
                //params.password = DigestUtils.md5Hex(params.password)
                params.tipo = "socio"
                usuarioInstance = usuarioService.altaUsuario(params)
                if (!usuarioInstance.hasErrors()) {
                    //session.usuario = usuarioInstance
                    flash.message = "usuario.email.sent.message"
                    redirect(controller:'usuario',action:'login')
                }
                else {
                    render(view:'register', model:[usuarioInstance:usuarioInstance])
                }
            }
        }
    }
}
