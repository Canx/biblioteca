package biblioteca

import grails.test.*

class UsuarioControllerTests extends ControllerUnitTestCase {
    def usuario1

    protected void setUp() {
        super.setUp()
        usuario1 = new Usuario(login:"canchete",password:"holahola",nombre:"Ruben",apellidos:"Cancho Gasulla",email:"ruben@gmail.com",tipo:"administrador")
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
        assertEquals mockFlash.message, "El usuario ${controller.params.login} no existe"
    }

    void testLogout() {
        mockSession.usuario = usuario1
        controller.logout()
        assertNull controller.session.usuario
        assertEquals "usuario", controller.redirectArgs["controller"]
        assertEquals "login", controller.redirectArgs["action"]

    }

    void testSaveUser() {
        mockSession.usuario = usuario1
        controller.params.login = "usuario2"
        controller.params.password = "passpass"
        controller.params.nombre = "Usuario 2"
        controller.params.apellidos = "Apellido1 Apellido2"
        controller.params.tipo = "socio"
        controller.params.email = "usuario2@gmail.com"
        controller.save()
        assertEquals "show", redirectArgs.action
        assertEquals 2, Usuario.count()
    }

    void testListUser() {
        controller.params.id = 1
        def returnMap = controller.show()
        assertEquals returnMap.usuarioInstance, usuario1
    }

    void testListUserFailure() {
        controller.params.id = 2
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
      controller.params.id = 1
      controller.delete()
      assertEquals 0, Usuario.count()
    }
}
