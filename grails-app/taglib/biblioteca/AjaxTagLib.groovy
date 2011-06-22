package biblioteca

class AjaxTagLib {
    def editInPlace = {attrs, body ->
        def id = attrs.id
        out << "<span id='${id}' onClick=\"javascript:\$('#input${id}').show();\$('#${id}').hide();\">"
        out << body()
        out << "</span>"
        out << "<div id='input${id}' style='display:none;'>"
        out << "<form name='editInPlace${id}'>"
        out << "<input type='text' name='${attrs.paramName}' value='${body()}'/>"
        out << submitToRemote(update:id, url:attrs.url, value:'Guardar', onSuccess:"javascript:\$('#input${id}').hide();\$('#${id}').show();")
        out << "</form>"
        out << "</div>"
    }
}
