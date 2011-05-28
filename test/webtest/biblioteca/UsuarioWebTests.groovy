package biblioteca

class UsuarioWebTests extends grails.util.WebTest {

   void testUsuarioListNewDelete() {
        invoke 'usuario'
        verifyText 'Home'

        group(description:'intento identificarme en el sistema') {
            clickLink 'Login'
            verifyText 'Login'
            clickButton 'Login'
            verifyText 'Logout'
            clickLink 'Home', description:'Back home'
            verifyText 'biblioteca.UsuarioController'
            clickLink 'biblioteca.UsuarioController'
        }

        verifyListSize 4

        clickLink 'New Usuario'
        verifyText 'Create Usuario'
        setInputField(name:'login', 'usuario2')
        setInputField(name:'password', 'mipassword')
        setInputField(name:'nombre', 'Usuario')
        setInputField(name:'apellidos', 'Dos')
        setInputField(name:'email', 'miemail@ua.es')
        clickButton 'Create'
        verifyText 'Show Usuario', description: 'Detail page'
        clickLink 'List', description: 'Back to list view'

        verifyListSize 5
        
        group(description:'edit the one element') {
            showFirstElementDetails()
            clickButton 'Edit'
            verifyText 'Edit Usuario'
            clickButton 'Update'
            verifyText 'Show Usuario'
            clickLink 'List', description: 'Back to list view'
        }

        verifyListSize 5

        group(description:'delete the only element') {
            showFirstElementDetails()
            clickButton 'Delete'
            verifyXPath xpath: "//div[@class='message']",
                        text: /usuario.deleted.message/,
                        regex: true
            }

            verifyListSize 4
    }

    String ROW_COUNT_XPATH = "count(//div[@class='list']//tbody/tr)"

    def verifyListSize(int size) {
          ant.group(description:"verify Usuario list view with $size row(s)") {
              verifyText 'Usuario List'
              verifyXPath xpath: ROW_COUNT_XPATH,
              text: size,
              description:"$size row(s) of data expected"
          }
    }

    def showFirstElementDetails() {
        clickLink 'usuario2', description: 'go to detail view'
    }
}
