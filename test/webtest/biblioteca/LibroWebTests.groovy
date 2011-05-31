package biblioteca

class LibroWebTests extends grails.util.WebTest {

    void testLibroCreateFailure() {
       invoke(url:"http://localhost:8080/biblioteca")
       clickLink "Login"
       setSelectField(name: "login", text: "wilmapp")
       clickButton "Login"
       clickLink "Libros"
       clickLink "New Libro"
       verifyText(description: "Verify that text is contained in the page", "Solo los bibliotecarios pueden cambiar la información de los libros")
    }

    void testLibroCreateOk() {
        invoke(url:"http://localhost:8080/biblioteca")
        clickLink "Login"
        setSelectField(name: "login", text: "pablomarmol")
        clickButton "Login"
        clickLink "Libros"
        clickLink "New Libro"
        setInputField(name: "isbn", value: "123456789")
        setInputField(name: "titulo", value: "Indignaos")
        setInputField(name: "autor", value: "Jose Luis Sampedro & company")
        setInputField(name: "editorial", value: "Ni idea")
        setInputField(name: "anyo", value: "2011")
        setSelectField(name: "fecha_day", text: "10")
        setSelectField(name: "fecha_month", text: "January")
        setSelectField(name: "fecha_year", text: "2011")
        setInputField(name: "descripcion", value: "Habla de que hay que indignarse")
        clickButton "Create"
        verifyText(description: "Verify that text is contained in the page", "Libro 5 created")
    }

    void testLibroUpdateOk() {
        invoke "http://localhost:8080/biblioteca/"
        clickLink "Login"
        setSelectField(name: "login", text: "pablomarmol")
        clickButton "Login"
        clickLink "Libros"
        clickLink "843992688X"
        clickButton "Edit"
        setInputField(name: "descripcion", value: "Un libro muy bonito")
        clickButton "Update"
        verifyText(description: "Verify that text is contained in the page", "Libro 1 updated")
    }
}
