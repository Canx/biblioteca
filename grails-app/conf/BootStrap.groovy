import biblioteca.*
class BootStrap {

  def pass = "password"
  def init = { servletContext ->
    def u1 = new Usuario(login: 'frangarcia', 
                password: pass,
                nombre:'Francisco José',
                apellidos:'García Rico',
                tipo: 'administrador',
                email: 'fran@gmail.com',
                activo: true
               ).save()
    def u2 = new Usuario(login: "pablomarmol",
                password: pass,
                nombre: "Pablo",
                apellidos:'Mar Mol',
                tipo: "bibliotecario",
                email: "marmol@gmail.com",
                activo: true
              ).save()
    def profesor = new Usuario(login: "pedropp",
                password: pass,
                nombre:"Roberto",
                apellidos:"Pica Piedra",
                tipo:"profesor",
                email:"pedropp@gmail.com",
                activo:true
                ).save()
    def socio = new Usuario(login:'wilmapp',
                password: pass,
                nombre:'Wilma',
                apellidos:'Pica Piedra',
                tipo:"socio",
                email:"wilmapp@gmail.com",
                activo:true
               ).save()

    def l1 = new Libro(titulo:'La colmena',
              anyo:1951,
              autor:"Camilo José Cela Trulock",
              isbn: '843992688X',
              editorial:'Anaya',
              fecha:new Date(),
              descripcion:'',
              ).save()

    def l2 = new Libro(titulo:'El ingenioso hidalgo don Quijote de la Mancha',
              anyo:1605,
              autor:'Miguel de Cervantes Saavedra',
              isbn:'0844273619',
              editorial:'Anaya', fecha:new Date(),
              descripcion:'').save()

    new Libro(titulo:'La dorotea',
              anyo:1632,
              autor:'Félix Lope de Vega y Carpio',
              isbn:'847039360X',
              editorial:'Anaya',
              fecha:new Date(),
              descripcion:''
              ).save()

    new Libro(titulo:'La dragontea',
              anyo:1602,
              autor:'Félix Lope de Vega y Carpio',
              isbn:'8437624045',
              editorial:'Anaya',
              fecha:new Date(),
              descripcion:''
              ).save()
    def op1 = new Operacion(
              tipo:'prestamo',
              estado:true,
              fechaInicio:Date.parse("dd/MM/yyyy","12/01/2011"),
              fechaFin:Date.parse("dd/MM/yyyy","10/6/2011"),
              usuario: socio,
              libro: l1
              ).save()
    def op2 = new Operacion(
              tipo:'prestamo',
              estado:true,
              fechaInicio:new Date() - 10,
              fechaFin:new Date() + 1,
              usuario:profesor,
              libro: l2
              ).save()


    //socio.addToOperaciones(op1).save()
  }
  def destroy = {}
}
