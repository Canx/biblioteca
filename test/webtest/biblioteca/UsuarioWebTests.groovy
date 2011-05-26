package biblioteca



class UsuarioWebTests extends grails.util.WebTest {

   void testUsuarioListNewDelete() {
        invoke 'usuario'
        verifyText 'Home'
        verifyListSize 0

        clickLink 'New Usuario'
        verifyText 'Create Usuario'
        clickButton 'Create'
        verifyText 'Show Usuario', description: 'Detail page'
        clickLink 'List', description: 'Back to list view'

        verifyListSize 1
        
        group(description:'edit the one element') {
            showFirstElementDetails()
            clickButton 'Edit'
            verifyText 'Edit Usuario'
            clickButton 'Update'
            verifyText 'Show Usuario'
            clickLink 'List', description: 'Back to list view'
        }

        verifyListSize 1

        group(description:'delete the only element') {
            showFirstElementDetails()
            clickButton 'Delete'
            verifyXPath xpath: "//div[@class='message']",
                        text: /.*Usuario.*deleted.*/,
                        regex: true
            }

            verifyListSize 0
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
        clickLink '1', description: 'go to detail view'
    }
}
