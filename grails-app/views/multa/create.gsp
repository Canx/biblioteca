

<%@ page import="biblioteca.Multa" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'multa.label', default: 'Multa')}" />
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
            <g:hasErrors bean="${multaInstance}">
            <div class="errors">
                <g:renderErrors bean="${multaInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" >
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="usuario"><g:message code="multa.usuario.label" default="Usuario" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: multaInstance, field: 'usuario', 'errors')}">
                                    <g:select name="usuario.id" from="${biblioteca.Usuario.findAllByTipoOrTipo("profesor","socio")}" optionKey="id" value="${multaInstance?.usuario?.id}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="fecha_fin"><g:message code="multa.fecha_fin.label" default="Fechafin" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: multaInstance, field: 'fecha_fin', 'errors')}">
                                    <g:datePicker name="fecha_fin" precision="day" value="${multaInstance?.fecha_fin}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="descripcion"><g:message code="multa.descripcion.label" default="Descripcion" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: multaInstance, field: 'descripcion', 'errors')}">
                                    <g:textField name="descripcion" value="${multaInstance?.descripcion}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="fecha_inicio"><g:message code="multa.fecha_inicio.label" default="Fechainicio" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: multaInstance, field: 'fecha_inicio', 'errors')}">
                                    <g:datePicker name="fecha_inicio" precision="day" value="${multaInstance?.fecha_inicio}"  />
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
