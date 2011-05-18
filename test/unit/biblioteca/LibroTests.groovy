package biblioteca

import grails.test.*

class LibroTests extends GroovyTestCase {

    protected void setUp() {
      Libro.list()*.delete()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testPersist() {
      new Libro(titulo:'La colmena', anyo:1951, autor:'Camilo José Cela Trulock', isbn:'843992688X', editorial:'Anaya', fecha:new Date(), descripcion:'').save()
      assert 5 == Libro.count()
      def libro2 = Libro.get(2)
      assertToString(libro2, 'La galatea')
    }

    void testToString() {
      def libro = new Libro(titulo:'Groovy in action', anyo: 2007, autor:'Dierk König', isbn:'1-932394-84-2')
      assertToString(libro, 'Groovy in action')
    }
}
