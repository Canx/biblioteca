package biblioteca

class OperacionFilters {

    def filters = {
        chequeoModificacionSoloBibliotecario(controller:'operacion', action: 'update|edit|delete') {
            before = {
                if (session?.usuario?.tipo != 'bibliotecario') {
                    flash.message = "Solo los bibliotecarios pueden modificar préstamos o reservas"
                    redirect(controller:'operacion', action: 'list')
                    return false
                }
            }
        }

        chequeoNuevoPrestamoReserva(controller: 'operacion', action: 'save') {
            before = {
               if ((params.tipo == "prestamo") && (session?.usuario?.tipo != "bibliotecario")) {
                  flash.message = "Solo los bibliotecarios pueden hacer prestamos"
                  redirect(controller:'operacion', action: 'list')
                  return false
               }

               if (params.tipo == "reserva") {
                  switch (session?.usuario?.tipo) {
                    case "profesor": break;
                    case "socio"   : break;
                    default        : flash.message == "Solo los profesores o socios pueden hacer reservas"
                                     redirect(controller:'operacion', action: 'list')
                                     return false
                  }
               }
            }
        }
    }
    
}
