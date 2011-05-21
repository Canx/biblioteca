package biblioteca

class UsuarioController {

    def scaffold = Usuario

    def login = {}

    def handleLogin = {
      def usuario = Usuario.findByLogin(params.login)
      if (!usuario) {
        flash.message = "El usuario ${params.login} no existe"
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
}
