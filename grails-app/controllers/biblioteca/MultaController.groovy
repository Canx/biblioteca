package biblioteca
import org.codehaus.groovy.grails.commons.ConfigurationHolder


class MultaController {
    def exportService
      
    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)

        if (params?.format && params.format != "html") {
            response.contentType = ConfigurationHolder.config.grails.mime.types[params.format]
            response.setHeader("Content-disposition", "attachment;filename=multas.${params.format}")
            exportService.export(params.format, response.outputStream, Multa.findAllByEstado(true,params), [:], [:])
        }

        // [multaInstanceList: Multa.list(params), multaInstanceTotal: Multa.count()]
        [multaInstanceList: Multa.findAllByEstado(true,params), multaInstanceTotal: Multa.findAllByEstado(true).size()]
    }

    def create = {
        def multaInstance = new Multa()
        multaInstance.properties = params
        return [multaInstance: multaInstance]
    }

    def save = {
        def multaInstance = new Multa(params)
        multaInstance.estado = true
        if (multaInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'multa.label', default: 'Multa'), multaInstance.id])}"
            redirect(action: "show", id: multaInstance.id)
        }
        else {
            render(view: "create", model: [multaInstance: multaInstance])
        }
    }

    def show = {
        def multaInstance = Multa.get(params.id)
        if (!multaInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'multa.label', default: 'Multa'), params.id])}"
            redirect(action: "list")
        }
        else {
            [multaInstance: multaInstance]
        }
    }

    def edit = {
        def multaInstance = Multa.get(params.id)
        if (!multaInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'multa.label', default: 'Multa'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [multaInstance: multaInstance]
        }
    }

    def update = {
        def multaInstance = Multa.get(params.id)
        if (multaInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (multaInstance.version > version) {
                    
                    multaInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'multa.label', default: 'Multa')] as Object[], "Another user has updated this Multa while you were editing")
                    render(view: "edit", model: [multaInstance: multaInstance])
                    return
                }
            }
            multaInstance.properties = params
            if (!multaInstance.hasErrors() && multaInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'multa.label', default: 'Multa'), multaInstance.id])}"
                redirect(action: "show", id: multaInstance.id)
            }
            else {
                render(view: "edit", model: [multaInstance: multaInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'multa.label', default: 'Multa'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def multaInstance = Multa.get(params.id)
        if (multaInstance) {
            try {
                multaInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'multa.label', default: 'Multa'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'multa.label', default: 'Multa'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'multa.label', default: 'Multa'), params.id])}"
            redirect(action: "list")
        }
    }
}
