package biblioteca

class Libro {
  String isbn
  String titulo
  String autor
  String editorial
  byte[] portada
  String nombreImagen
  String contentTypeImagen
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
    portada(nullable:true, blank:true)
    nombreImagen(nullable:true, blank:true)
    contentTypeImagen(nullable:true, blank:true,inList:["image/gif", "image/jpeg","image/png"])
  }

  String toString() {
    titulo
  }
}
