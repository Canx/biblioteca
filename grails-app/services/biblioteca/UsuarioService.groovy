package biblioteca

class UsuarioService {
    def notificadorService

    static transactional = true

    String titulo = "Biblioteca: registro de usuario"

    String plantilla = """
    Bienvenido, 

    Para activar tu cuenta haz click en el siguiente enlace: [activa_url]
"""

    Usuario altaUsuario(params) {
        def u = new Usuario(params)
        u.activo = false

        if (u.validate()) {
            u.save()
            log.trace("Usuario ${u} salvado")
        }
        return u
    }

    def enviarEmailRegistro(usuario, url_activacion) {
        log.trace("url activacion: ${url_activacion}")
        contenido = plantilla.replaceAll(/\[activa_url\]/, url_activacion)
        notificadorService.mandarEmail(usuario.email, titulo, contenido)
    }
}
