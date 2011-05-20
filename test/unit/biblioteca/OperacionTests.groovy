package biblioteca

import grails.test.*

class OperacionTests extends GrailsUnitTestCase {
    def operacion1

    protected void setUp() {
        super.setUp()
        mockDomain(Libro, [new Libro(titulo:'La colmena', anyo:1951, autor:'Camilo José Cela Trulock', isbn:'843992688X', editorial:'Anaya', fecha:new Date(), descripcion:'')] )
        mockDomain(Usuario, [new Usuario(login:"canchete",password:"holahola",nombre:"Ruben",apellidos:"Cancho Gasulla",tipo:"administrador")] )
        mockDomain(Operacion, [new Operacion(tipo:'prestamo', estado: true, fechaInicio: Date.parse("dd/MM/yyyy","01/01/2011"), fechaFin: Date.parse("dd/MM/yyyy","01/06/2011"), usuario:Usuario.get(1), libro:Libro.get(1))] )
        operacion1 = Operacion.get(1)
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testOperacionCreada() {
        assertFalse null == operacion1
    }

    void testTipoPrestamoOk() {
      operacion1.tipo = "prestamo"
      assertTrue operacion1.validate()
    }

    void testTipoReservaOk() {
      operacion1.tipo = "reserva"
      assertTrue operacion1.validate()
    }

    void testTipoMal() {
      operacion1.tipo = "caca"
      assertFalse operacion1.validate()
    }

    void testToString() {
      assertToString(operacion1, 'prestamo (true) [01/01/2011 - 01/06/2011]')
    }
}
