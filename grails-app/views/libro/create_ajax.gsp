

<%@ page import="biblioteca.Libro" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'libro.label', default: 'Libro')}" />
        <g:javascript library="jquery" plugin="jquery" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
        <script>
            function appendTableRow(content) {
                $(#libros tr.last").after(content)
            } 
        </script>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.create.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>

            <div class="form">
                <g:formRemote name="saveform" update="libros" action="create_ajax" url="[action:'create_ajax']" on404="alert('not found')">
                    <div class="dialog">
                        <table>
                            <tr class="prop">
                                <th>ISBN</th> 
                                <th>Titulo</th>
                                <th>Autor</th>
                                <th>Año</th>
                                <th>Editorial</th>
                            </tr> 
                            <tr class="prop">
                                <td><g:textField name="isbn" value="${libroInstance?.isbn}" /></td> 
                                <td><g:textField name="titulo" value="${libroInstance?.titulo}" /></td>
                                <td><g:textField name="autor" value="${libroInstance?.autor}"/></td>
                                <td><g:textField name="anyo" value="${libroInstance?.anyo}"/></td>
                                <td><g:textField name="Editorial" value="${libroInstance?.editorial}"/></td>
                                <td><input type="submit" value="Salvar" /></td>
                            </tr>
                        </table> 
                    </div>
                </g:formRemote>
             </div>

             <div class="list" id="libros">
             </div>
        </div>
    </body>
</html>
