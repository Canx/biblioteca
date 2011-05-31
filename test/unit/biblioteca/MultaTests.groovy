package biblioteca

import grails.test.*

class MultaTests extends GrailsUnitTestCase {
    protected void setUp() {
        super.setUp()
        mockDomain(Libro, [new Libro(titulo:'La colmena', anyo:1951, autor:'Camilo José Cela Trulock', isbn:'843992688X', editorial:'Anaya', fecha:new Date(), descripcion:'')] )
        mockDomain(Usuario, [new Usuario(login:"canchete",password:"holahola",nombre:"Ruben",apellidos:"Cancho Gasulla",tipo:"administrador")] )
        mockDomain(Operacion, [new Operacion(tipo:'prestamo', estado: true, fechaInicio: Date.parse("dd/MM/yyyy","01/01/2011"), fechaFin: Date.parse("dd/MM/yyyy","01/06/2011"), usuario:Usuario.get(1), libro:Libro.get(1))] )
        mockDate = new MockFor(Date.class)
        mockDate.Date() { new Date().parse("dd/MM/yyyy","01/01/2012" }
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testCrearMultaOk() {
      // TODO: al devolver el libro se tiene que generar la multa
    }
}
