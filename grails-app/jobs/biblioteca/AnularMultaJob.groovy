package biblioteca

class AnularMultaJob {
    def multaService

    def cronExpression = "0 0 0 * * ?"
    def execute() {
        multaService.desactivarMultas()
    }
}
