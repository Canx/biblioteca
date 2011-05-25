
<%@ page import="biblioteca.Operacion" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'operacion.label', default: 'Operacion')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.show.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="dialog">
                <table>
                    <tbody>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="operacion.id.label" default="Id" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: operacionInstance, field: "id")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="operacion.tipo.label" default="Tipo" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: operacionInstance, field: "tipo")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="operacion.estado.label" default="Estado" /></td>
                            
                            <td valign="top" class="value"><g:formatBoolean boolean="${operacionInstance?.estado}" /></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="operacion.fechaInicio.label" default="Fecha Inicio" /></td>
                            
                            <td valign="top" class="value"><g:formatDate date="${operacionInstance?.fechaInicio}" /></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="operacion.fechaFin.label" default="Fecha Fin" /></td>
                            
                            <td valign="top" class="value"><g:formatDate date="${operacionInstance?.fechaFin}" /></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="operacion.libro.label" default="Libro" /></td>
                            
                            <td valign="top" class="value"><g:link controller="libro" action="show" id="${operacionInstance?.libro?.id}">${operacionInstance?.libro?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="operacion.usuario.label" default="Usuario" /></td>
                            
                            <td valign="top" class="value"><g:link controller="usuario" action="show" id="${operacionInstance?.usuario?.id}">${operacionInstance?.usuario?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                    </tbody>
                </table>
            </div>
            <div class="buttons">
                <g:form>
                    <g:hiddenField name="id" value="${operacionInstance?.id}" />
                    <span class="button"><g:actionSubmit class="edit" action="edit" value="${message(code: 'default.button.edit.label', default: 'Edit')}" /></span>
                    <span class="button"><g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" /></span>
                </g:form>
            </div>
        </div>
    </body>
</html>
