package biblioteca

class UsuarioFilters {

    def filters = {
        chequeoModificacionUsuario(controller: 'usuario', action: '*') {
            before = {
                if (actionName == 'edit' || actionName == 'update' || actionName == 'delete') {
                    if ((session?.usuario?.id as String != params?.id) && 
                        (session?.usuario?.tipo != "administrador")) {
                        flash.message = "Sólo puedes editar tu información"
                        redirect(controller:'usuario', action: 'list')
                        return false
                    }
                }
            }
        }

        chequeoCreacionUsuario(controller: 'usuario', action: '*') {
            before = {
                if (actionName == 'create' || actionName == 'save') {
                    if (session?.usuario?.tipo != "administrador") {
                        flash.message = "Sólo los administradores pueden crear usuarios"
                        redirect(controller:'usuario', action: 'list')
                        return false
                    }
                }
            }
        }
    }
}
