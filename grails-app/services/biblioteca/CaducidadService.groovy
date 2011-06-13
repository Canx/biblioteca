package biblioteca

class CaducidadService {
    def notificadorService
    static transactional = true

    def dias_preaviso = 5
    String titulo = "Biblioteca: recordatorio devolucion"

    String plantilla = """
    Sr. [nombre],

    Le recordamos que debe devolver el libro "[libro]" antes del [fechafin].

    Reciba un cordial saludo,
    El bibliotecario.
"""

    String contenido


    def enviarMails() {
       def operaciones=Operacion.findAllByTipoAndFechaFinBetween("prestamo",
                         new Date() - dias_preaviso, new Date() - dias_preaviso + 1)

        operaciones.each {
          contenido = plantilla.replaceAll(/\[nombre\]/, it.usuario)
          contenido = contenido.replaceAll(/\[libro\]/, operaciones.libro)
          contenido = contenido.replaceAll(/\[fechafin\]/, operaciones.Fechafin)
          log.trace("EMAIL: ${contenido}")
          notificadorService.mandarEmail(it.usuario.email, titulo, contenido)
        }
    }
}
