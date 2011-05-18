package biblioteca

class Operacion {
  String tipo
  Boolean estado
  Date fechaInicio
  Date fechaFin
  Usuario usuario
  Libro libro

  static belongsTo = [Usuario, Libro]

  static constraints = {
    tipo(inList:["prestamo", "reserva"])
    estado()
    fechaInicio(nullable:false)
    fechaFin(nullable:false)
  }

  String toString() {
    "$tipo ($estado) [$fechaInicio - $fechaFin]"
  }
}
