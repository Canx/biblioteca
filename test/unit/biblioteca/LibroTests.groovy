package biblioteca

import grails.test.*

class LibroTests extends GrailsUnitTestCase {
    protected void setUp() {
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testPersist() {
      def testLibros = [isbn: "111", titulo: "Prueba", autor:"Alguien", editorial: "Anaya", anyo: 1992, descripcion: "", fecha: new Date()]
      mockDomain(Libro, testLibros)
      assert 5 == Libro.count()
      def libro2 = Libro.get(2)
      assertToString(libro2, 'La galatea')
    }

    void testToString() {
      def libro = new Libro(titulo:'Groovy in action', anyo: 2007, autor:'Dierk König', isbn:'1-932394-84-2')
      assertToString(libro, 'Groovy in action')
    }
}
