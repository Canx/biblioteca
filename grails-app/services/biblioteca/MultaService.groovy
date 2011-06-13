package biblioteca

class MultaService {

    static transactional = true

    def desactivarMultas() {
      Multa.findAllByEstadoAndFechaFinLessThan(true, new Date()).each {
        it.estado = false
        it.save()
      }
    }
}
