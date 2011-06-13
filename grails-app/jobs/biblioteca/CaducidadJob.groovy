package biblioteca


class CaducidadJob {
    def caducidadService
    def cronExpression = "0 0 4 * * ?"

    def execute() {
      caducidadService.enviarMails()
    }
}
