package biblioteca

class ErroresController {

    def forbidden = { 
        flash.message = "URI no permitida"
        redirect(uri:"/")
    }
    def notFound = { 
        flash.message = "URI no encontrada"
        redirect(uri:"/")
    }
}
