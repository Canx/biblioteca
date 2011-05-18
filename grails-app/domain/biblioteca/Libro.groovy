package biblioteca

class Libro {
  String isbn
  String titulo
  String autor
  String editorial
  Integer anyo
  String descripcion
  Date fecha

  static hasMany = [operaciones:Operacion]

  static constraints = {
    isbn(blank:false)
    titulo(blank:false)
    autor(blank:false)
    editorial()
    anyo()
    fecha(nullable:true)
    descripcion(maxSize:1000,nullable:true)
  }

  String toString() {
    titulo
  }
}
