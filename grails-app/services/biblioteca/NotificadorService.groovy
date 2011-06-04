package biblioteca

class NotificadorService {

    static transactional = false

    def mailService

    def mandarMails(email, titulo, contenido) {
        mailService.sendMail {
            to email
            from "informaticateacher@gmail.com"
            subject titulo
            body contenido
        }
    }
}
