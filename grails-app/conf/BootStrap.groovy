import biblioteca.*

class BootStrap {

  def init = { servletContext ->
    def u1 = new Usuario(login: 'frangarcia', 
                password: 'mipassword',
                nombre:'Francisco José',
                apellidos:'García Rico',
                tipo: 'administrador',
                email: 'fran@gmail.com'
               ).save()
    new Usuario(login: "pablomarmol",
                password: "marmol",
                nombre: "Pablo",
                apellidos:'Mar Mol',
                tipo: "bibliotecario",
                email: "marmol@gmail.com"
              ).save()
    new Usuario(login: "pedropp",
                password:"picapiedra",
                nombre:"Roberto",
                apellidos:"Pica Piedra",
                tipo:"profesor",
                email:"pedropp@gmail.com"
                ).save()
    new Usuario(login:'wilmapp',
                password:'picapiedra2',
                nombre:'Wilma',
                apellidos:'Pica Piedra',
                tipo:"socio",
                email:"wilmapp@gmail.com"
               ).save()

    def l1 = new Libro(titulo:'La colmena',
              anyo:1951,
              autor:"Camilo José Cela Trulock",
              isbn: '843992688X',
              editorial:'Anaya',
              fecha:new Date(),
              descripcion:'',
              ).save()

    new Libro(titulo:'El ingenioso hidalgo don Quijote de la Mancha',
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
    new Operacion(
              tipo:'prestamo',
              estado:true,
              fechaInicio:Date.parse("dd/MM/yyyy","12/01/2011"),
              fechaFin:Date.parse("dd/MM/yyyy","10/6/2011"),
              usuario: u1,
              libro: l1
              ).save()
  }
  def destroy = {}
}
