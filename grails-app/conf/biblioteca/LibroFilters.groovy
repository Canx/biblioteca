package biblioteca

class LibroFilters {

    def filters = {
        chequeoModificacionCreacionUsuario(controller:'libro', action:'create|save|edit|update|delete') {
            before = {
                    if ((session?.usuario?.id as String != params?.id) && (session?.usuario?.tipo != "bibliotecario")) {
                        flash.message = "Solo los bibliotecarios pueden cambiar la información de los libros."
                        redirect(controller:'libro', action: 'list')
                        return false
                    }
            }
        }
    }
}
