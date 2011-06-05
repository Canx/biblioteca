package biblioteca

class AllFilters {

    def filters = {
        all(controller:'*', action:'edit|update|delete|create|save|list') {
            before = {
                if (session?.usuario?.id != null) {
                    if (Usuario.get(session?.usuario?.id).activo == true) {
                        return true
                    }
                    else {
                        flash.message = "usuario.not.active.message"
                        flash.args = [session?.usuario?.login]
                    }
                }
                else {
                    flash.message = "usuario.not.logged.message"
                }
                redirect(controller:'usuario', action: 'login')
                return false
            }
        }
    }
}
