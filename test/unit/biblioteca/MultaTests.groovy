package biblioteca

import grails.test.*

class MultaTests extends GrailsUnitTestCase {
    def bibliotecario, profesor, socio
    protected void setUp() {
        super.setUp()
        bibliotecario = new Usuario(login:"canchete",password:"holahola",nombre:"Ruben",apellidos:"Cancho Gasulla",tipo:"bibliotecario")
        profesor = new Usuario(login:"antonio", password:"holahola",nombre:"Antonio", apellidos:"Machado", tipo:"profesor")
        socio = new Usuario(login:"juan", password:"holahola", nombre:"Juan", apellidos:"Perez Perez", tipo: "socio")
        mockDomain(Usuario, [bibliotecario, profesor, socio])
        mockDomain(Multa)
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testCrearMultaOk() {
      def multa = new Multa(usuario:socio, descripcion:"No ha devuelto los libros a tiempo", fecha_inicio: new Date(), fecha_fin: new Date()+30)
      assertTrue multa.validate()
      multa.save()
      assertEquals 1, Multa.count()
      def multa2 = new Multa(usuario:bibliotecario, descripcion:"No ha devuelto los libros a tiempo", fecha_inicio: new Date(), fecha_fin: new Date()+30)
      assertTrue multa2.validate()
      multa2.save()
      assertEquals 2, Multa.count()
    }

    void testCrearMultaBibliotecarioFailure() {
      def multa = new Multa(usuario:bibliotecario, descripcion:"No ha devuelto los libros a tiempo", fecha_inicio: new Date(), fecha_fin: new Date()+30)
      assertFalse multa.validate()
    }

}
