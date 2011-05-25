

<%@ page import="biblioteca.Libro" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'libro.label', default: 'Libro')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
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
            <g:hasErrors bean="${libroInstance}">
            <div class="errors">
                <g:renderErrors bean="${libroInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" >
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="isbn"><g:message code="libro.isbn.label" default="Isbn" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: libroInstance, field: 'isbn', 'errors')}">
                                    <g:textField name="isbn" value="${libroInstance?.isbn}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="titulo"><g:message code="libro.titulo.label" default="Titulo" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: libroInstance, field: 'titulo', 'errors')}">
                                    <g:textField name="titulo" value="${libroInstance?.titulo}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="autor"><g:message code="libro.autor.label" default="Autor" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: libroInstance, field: 'autor', 'errors')}">
                                    <g:textField name="autor" value="${libroInstance?.autor}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="editorial"><g:message code="libro.editorial.label" default="Editorial" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: libroInstance, field: 'editorial', 'errors')}">
                                    <g:textField name="editorial" value="${libroInstance?.editorial}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="anyo"><g:message code="libro.anyo.label" default="Anyo" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: libroInstance, field: 'anyo', 'errors')}">
                                    <g:textField name="anyo" value="${fieldValue(bean: libroInstance, field: 'anyo')}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="fecha"><g:message code="libro.fecha.label" default="Fecha" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: libroInstance, field: 'fecha', 'errors')}">
                                    <g:datePicker name="fecha" precision="day" value="${libroInstance?.fecha}" default="none" noSelection="['': '']" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="descripcion"><g:message code="libro.descripcion.label" default="Descripcion" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: libroInstance, field: 'descripcion', 'errors')}">
                                    <g:textArea name="descripcion" cols="40" rows="5" value="${libroInstance?.descripcion}" />
                                </td>
                            </tr>
                        
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
