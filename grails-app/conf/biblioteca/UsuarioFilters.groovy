package biblioteca

class UsuarioFilters {

    def filters = {
        chequeoModificacionUsuario(controller: 'usuario', action: 'edit|update|delete') {
            before = {
                    if ((session?.usuario?.id as String != params?.id) && 
                        (session?.usuario?.tipo != "administrador")) {
                        flash.message = "usuario.edit.error.message"
                        redirect(controller:'usuario', action: 'list')
                        return false
                    }
            }
        }

        chequeoCreacionUsuario(controller: 'usuario', action: 'create|save') {
            before = {
                    if (session?.usuario?.tipo != "administrador") {
                        flash.message = "usuario.create.error.message"
                        redirect(controller:'usuario', action: 'list')
                        return false
                    }
            }
        }
    }
}
