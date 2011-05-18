package biblioteca

import grails.test.*

class LibroTests extends GrailsUnitTestCase {

    protected void setUp() {
      super.setUp()
      mockDomain(Libro)
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testPersist() {
      new Libro(titulo:'La colmena', anyo:1951, autor:'Camilo José Cela Trulock', isbn:'843992688X', editorial:'Anaya', fecha:new Date(), descripcion:'').save()
      new Libro(titulo:'La galatea', anyo:1585, autor:'Miguel de Cervantes Saavedra' ,isbn:'0936388110', editorial:'Anaya', fecha:new Date(), descripcion:'').save()
      new Libro(titulo:'El ingenioso hidalgo don Quijote de la Mancha', anyo:1605, autor:'Miguel de Cervantes Saavedra', isbn:'0844273619', editorial:'Anaya', fecha:new Date(), descripcion:'').save()
      new Libro(titulo:'La dorotea', anyo:1632, autor:'Félix Lope de Vega y Carpio', isbn:'847039360X', editorial:'Anaya', fecha:new Date(), descripcion:'').save()
      new Libro(titulo:'La dragontea', anyo:1602, autor:'Félix Lope de Vega y Carpio', isbn:'8437624045', editorial:'Anaya', fecha:new Date(), descripcion:'').save()

      assert 5 == Libro.count()
      def libro2 = Libro.get(2)
      assertToString(libro2, 'La galatea')
    }

    void testToString() {
      def libro = new Libro(titulo:'Groovy in action', anyo: 2007, autor:'Dierk König', isbn:'1-932394-84-2')
      assertToString(libro, 'Groovy in action')
    }
}
