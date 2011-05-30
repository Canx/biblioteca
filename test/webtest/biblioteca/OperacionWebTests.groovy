package biblioteca

class OperacionWebTests extends grails.util.WebTest {

    void testCreateFails() {
       invoke(url:"http://localhost:8080/biblioteca")
       clickLink "Login"
       clickButton "Login"
       clickLink "New Operacion"
       setCheckbox(name: "estado")
       setSelectField(name: "usuario.id", text: "Pablo Mar Mol")
       setSelectField(name: "libro.id", text: "La dorotea")
       clickButton "Create"
       verifyText(description: "Verify that text is contained in the page", "Solo los bibliotecarios pueden hacer prestamos")
    }
}
