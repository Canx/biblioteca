import biblioteca.*

class BootStrap {

  def init = { servletContext ->
    new Usuario(login: 'frangarcia', 
                password: 'mipassword',
                nombre:'Francisco José',
                apellidos:'García Rico',
                tipo: 'administrador'
               ).save()
    new Usuario(login: "pablomarmol",
                password: "marmol",
                nombre: "Pablo",
                apellidos:'Mar Mol',
                tipo: "bibliotecario"
              ).save()
    new Usuario(login: "pedropp",
                password:"picapiedra",
                nombre:"Roberto",
                apellidos:"Pica Piedra",
                tipo:"profesor"
                ).save()
    new Usuario(login:'wilmapp',
                password:'picapiedra2',
                nombre:'Wilma',
                apellidos:'Pica Piedra',
                tipo:"socio"
               ).save()

    new Libro(titulo:'La colmena',
              anyo:1951,
              autor:"Camilo José Cela Trulock",
              isbn: '843992688X',
              editorial:'Anaya',
              fecha:new Date(),
              descripcion:''
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
  }
  def destroy = {}
}
