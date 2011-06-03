package biblioteca

class UsuarioService {

    static transactional = true

    Usuario altaUsuario(params) {
        def u = new Usuario(params)

        // Comprobamos los datos introducidos con las restricciones
        // de la clase de dominio Usuario
        if (u.validate()) {
            // Almacenamos en la base de datos
            u.save()
        }
        return u
    }

}
