

<%@ page import="biblioteca.Operacion" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'operacion.label', default: 'Operacion')}" />
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
            <g:hasErrors bean="${operacionInstance}">
            <div class="errors">
                <g:renderErrors bean="${operacionInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" >
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="tipo"><g:message code="operacion.tipo.label" default="Tipo" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: operacionInstance, field: 'tipo', 'errors')}">
                                    <g:select name="tipo" from="${operacionInstance.constraints.tipo.inList}" value="${operacionInstance?.tipo}" valueMessagePrefix="operacion.tipo"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="estado"><g:message code="operacion.estado.label" default="Estado" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: operacionInstance, field: 'estado', 'errors')}">
                                    <g:checkBox name="estado" value="${operacionInstance?.estado}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="fechaInicio"><g:message code="operacion.fechaInicio.label" default="Fecha Inicio" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: operacionInstance, field: 'fechaInicio', 'errors')}">
                                    <g:datePicker name="fechaInicio" precision="day" value="${operacionInstance?.fechaInicio}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="fechaFin"><g:message code="operacion.fechaFin.label" default="Fecha Fin" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: operacionInstance, field: 'fechaFin', 'errors')}">
                                    <g:datePicker name="fechaFin" precision="day" value="${operacionInstance?.fechaFin}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="libro"><g:message code="operacion.libro.label" default="Libro" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: operacionInstance, field: 'libro', 'errors')}">
                                    <g:select name="libro.id" from="${biblioteca.Libro.list()}" optionKey="id" value="${operacionInstance?.libro?.id}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="usuario"><g:message code="operacion.usuario.label" default="Usuario" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: operacionInstance, field: 'usuario', 'errors')}">
                                    <g:select name="usuario.id" from="${biblioteca.Usuario.list()}" optionKey="id" value="${operacionInstance?.usuario?.id}"  />
                                </td>
                            </tr>
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="tipo">Captcha:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:operacionInstance,field:'responseCaptcha','errors')}">
                                    <jcaptcha:jpeg name="image" /><br>
                                    <g:textField name="responseCaptcha" value="" /><br>
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
