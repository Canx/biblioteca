package biblioteca

class Usuario {
  String login
  String password
  String nombre
  String apellidos
  String tipo
  String email
  Boolean activo

  static hasMany = [operaciones:Operacion, multas:Multa]

  static constraints = {
    login(size:6..20, blank:false, unique:true)
    password(size:6..20, blank:false, password:true)
    nombre(blank:false)
    apellidos(blank:false)
    email(email:true, blank:false)
    tipo(inList:["administrador", "bibliotecario", "profesor", "socio"])
  }

  String toString() {
    "$nombre $apellidos"
  }
}
