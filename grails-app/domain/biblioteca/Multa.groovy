package biblioteca

class Multa {
    Usuario usuario
    String descripcion
    Date fecha_inicio
    Date fecha_fin

    static constraints = {
      usuario(validator: { return ((it?.tipo == "socio") || (it?.tipo == "profesor")) ? true : false })
    }

    // def beforeInsert() {}
    // def beforeUpdate() {}
    // def beforeDelete() {}
    // def afterInsert() {}
    // def afterUpdate() {}
    // def afterDelete() {}
    // def onLoad() {}
}
