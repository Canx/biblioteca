package biblioteca

class Usuario {
  String login
  String password
  String nombre
  String apellidos
  String tipo

  static hasMany = [operaciones:Operacion]

  static constraints = {
    login(size:6..20, blank:false, unique:true)
    password(size:6..20, blank:false, password:true)
    nombre(blank:false)
    apellidos(blank:false)
    tipo(inList:["administrador", "bibliotecario", "profesor", "socio"])
  }

  String toString() {
    "$nombre $apellidos"
  }
}
