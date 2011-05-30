package biblioteca

import grails.test.*

class OperacionControllerTests extends ControllerUnitTestCase {
    def usuario1, usuario2, libro1

    protected void setUp() {
        super.setUp()
        usuario1 = new Usuario(login:"canchete",password:"holahola",nombre:"Ruben",apellidos:"Cancho Gasulla",email:"ruben@gmail.com",tipo:"administrador")
        usuario2 = new Usuario(login:"antonio",password:"holahola",nombre:"Antonio",apellidos:"Perez Perez",email:"Antonio@gmail.com",tipo:"socio")
        libro1 = new Libro(titulo:'La colmena', anyo:1951, autor:'Camilo José Cela Trulock', isbn:'843992688X', editorial:'Anaya', fecha:new Date(), descripcion:'')
        mockDomain(Libro, [libro1])
        mockDomain(Usuario, [usuario1, usuario2])
    }

    protected void tearDown() {
        super.tearDown()
    }

    // TODO
    void testSaveOperacion() {
//        mockSession.usuario = usuario1
//        controller.params.tipo = "prestamo"
//        controller.params.fecha_inicio = "..."
//        controller.params.fecha_fin = "..."
//        controller.params.libro = ".."
//        controller.params.usuario = ".."
//        controller.create()
    }

    // TODO
    // void testCreateOperacion()
    //
    // TODO
    // void testDeleteOperacion()
    //
    // TODO
    // void testListOperacion()
}
