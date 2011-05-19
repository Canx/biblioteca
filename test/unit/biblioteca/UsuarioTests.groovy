package biblioteca

import grails.test.*

class UsuarioTests extends GrailsUnitTestCase {
    def usuario1

    protected void setUp() {
      super.setUp()
      mockDomain(Usuario)
      mockForConstraintsTests(Usuario)
      usuario1 = new Usuario(login:"canchete",password:"holahola",nombre:"Ruben",apellidos:"Cancho Gasulla",tipo:"administrador")
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testValidateShortLoginFailure() {
      usuario1.login = "xx"
      assertFalse usuario1.validate()
    }

    void testValidateLongLoginFailure() {
      usuario1.login = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxx"
      assertFalse usuario1.validate()
    }

    void testValidateEmailFailure() {
      usuario1.email = "xxxxxxxx"
      assertFalse usuario1.validate()
    }

    void testString() {
      assertToString(usuario1, 'Ruben Cancho Gasulla')
    }
}
