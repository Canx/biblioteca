package biblioteca

class NotificadorService {

    static transactional = false

    def mailService

    def mandarEmail(email, titulo, contenido) {
        mailService.sendMail {
            to email
            from "informaticateacher@gmail.com"
            subject titulo
            body contenido
        }
        log.trace("email a ${email} enviado.")
    }
}
