package biblioteca

class OperacionWebTests extends grails.util.WebTest {

    void testCreateFails() {
       invoke(url:"http://localhost:8080/biblioteca")
       clickLink "Login"
       setSelectField(id: "login", text: "frangarcia")
       clickButton "Login"
       clickLink "New Operacion"
       setCheckbox(name: "estado")
       setSelectField(name: "usuario.id", text: "Pablo Mar Mol")
       setSelectField(name: "libro.id", text: "La dorotea")
       clickButton "Create"
       verifyText(description: "Verify that text is contained in the page", "Solo los bibliotecarios pueden hacer prestamos")
    }

    void testCreateOk() {
        invoke(url:"http://localhost:8080/biblioteca")
        clickLink "Login"
        setSelectField(name: "login", text: "pablomarmol")
        clickButton "Login"
        clickLink "New Operacion"
        setSelectField(name: "usuario.id", text: "Roberto Pica Piedra")
        setSelectField(name: "libro.id", text: "El ingenioso hidalgo don Quijote de la Mancha")
        clickButton "Create"
        verifyText(description: "Verify that text is contained in the page", "Operacion 2 created")
    }
}
