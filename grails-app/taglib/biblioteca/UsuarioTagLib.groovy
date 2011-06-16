package biblioteca

class UsuarioTagLib {
    static namespace = 'usuario'

    def identificado = { attrs, body ->
        if (session.usuario != null) {
            out << body()
        }
    }
    
    def noidentificado = { attrs, body ->
        if (session.usuario == null) {
            out << body()
        }
    }
}
