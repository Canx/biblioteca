package biblioteca

class UsuarioFilters {

    def filters = {
        chequeoModificacionUsuario(controller: 'usuario', action: 'edit|update|delete') {
            before = {
                    if ((session?.usuario?.id as String != params?.id) && 
                        (session?.usuario?.tipo != "administrador")) {
                        flash.message = "Sólo puedes editar tu información"
                        redirect(controller:'usuario', action: 'list')
                        return false
                    }
            }
        }

        chequeoCreacionUsuario(controller: 'usuario', action: 'create|save') {
            before = {
                    if (session?.usuario?.tipo != "administrador") {
                        flash.message = "Sólo los administradores pueden crear usuarios"
                        redirect(controller:'usuario', action: 'list')
                        return false
                    }
            }
        }
    }
}
