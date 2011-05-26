package biblioteca

import grails.test.*

class UsuarioControllerTests extends ControllerUnitTestCase {
    def usuario1

    protected void setUp() {
        super.setUp()
        usuario1 = new Usuario(login:"canchete",password:"holahola",nombre:"Ruben",apellidos:"Cancho Gasulla",tipo:"administrador")
        mockDomain(Usuario, [usuario1])
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

    void testHandleLoginFailure() {
        mockParams.login = "loginmalo"
        mockParams.password = "passwordmalo"
        controller.handleLogin()
        assertNull controller.session.usuario
        assertEquals controller.flash.message, "El usuario ${controller.params.login} no existe"
    }

    void testLogout() {
        mockSession.usuario = usuario1
        controller.logout()
        assertNull controller.session.usuario
        assertEquals "usuario", controller.redirectArgs["controller"]
        assertEquals "login", controller.redirectArgs["action"]

    }
}
