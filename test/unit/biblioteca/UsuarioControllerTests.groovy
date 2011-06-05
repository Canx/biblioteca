package biblioteca

import grails.test.*

class UsuarioControllerTests extends ControllerUnitTestCase {
    def usuario1, usuario_no_activo

    protected void setUp() {
        super.setUp()
        usuario1 = new Usuario(login:"canchete",password:"holahola",nombre:"Ruben",apellidos:"Cancho Gasulla",email:"ruben@gmail.com",tipo:"administrador",activo:true)
        usuario_no_activo = new Usuario(login:"canchete2",password:"holahola",nombre:"Ruben",apellidos:"Cancho Gasulla",email:"ruben2@gmail.com",tipo:"administrador",activo:false)
        mockDomain(Usuario, [usuario1, usuario_no_activo])
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testHandleLogin() {
        mockParams.login = usuario1.login
        mockParams.password = usuario1.password
        controller.handleLogin()
        assertEquals controller.session.usuario, usuario1
        assertEquals "operacion", controller.redirectArgs["controller"]
    }

    void testHandleLoginNotFound() {
        mockParams.login = "loginmalo"
        mockParams.password = "passwordmalo"
        controller.handleLogin()
        assertNull controller.session.usuario
        assertEquals "usuario.not.found.message", mockFlash.message
    }

    void testHandleLoginNotActive() {
        mockParams.login = usuario_no_activo.login
        mockParams.password = usuario_no_activo.password
        controller.handleLogin()
        assertNull controller.session.usuario
        assertEquals "usuario.not.active.message", mockFlash.message
    }

    void testLogout() {
        mockSession.usuario = usuario1
        controller.logout()
        assertNull controller.session.usuario
        assertEquals "usuario", controller.redirectArgs["controller"]
        assertEquals "login", controller.redirectArgs["action"]
    }

    void testShowUser() {
        controller.params.id = 1
        def returnMap = controller.show()
        assertEquals returnMap.usuarioInstance, usuario1
    }

    void testShowUserFailure() {
        controller.params.id = 1000
        controller.show()
        assertEquals controller.flash.message, "usuario.not.found.message" 
    }

    void testUpdateUser() {
      controller.params.id = 1
      controller.show()
      controller.params.email = "otro@gmail.com"
      controller.update()
      assertEquals "otro@gmail.com", Usuario.get(1).email
    }

    void testDeleteUser() {
      mockSession.usuario = usuario1
      mockParams.id = 1
      def total = Usuario.count()
      controller.delete()
      assertEquals total-1, Usuario.count()
    }

    void testActivarUsuario() {
      assertFalse usuario_no_activo.activo
      mockParams.id = usuario_no_activo.id
      controller.activarUsuario()
      assertTrue usuario_no_activo.activo
    }
}
