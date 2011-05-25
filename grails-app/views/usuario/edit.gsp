

<%@ page import="biblioteca.Usuario" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'usuario.label', default: 'Usuario')}" />
        <title><g:message code="default.edit.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.edit.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${usuarioInstance}">
            <div class="errors">
                <g:renderErrors bean="${usuarioInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <g:hiddenField name="id" value="${usuarioInstance?.id}" />
                <g:hiddenField name="version" value="${usuarioInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="login"><g:message code="usuario.login.label" default="Login" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: usuarioInstance, field: 'login', 'errors')}">
                                    <g:textField name="login" maxlength="20" value="${usuarioInstance?.login}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="password"><g:message code="usuario.password.label" default="Password" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: usuarioInstance, field: 'password', 'errors')}">
                                    <g:passwordField name="password" maxlength="20" value="${usuarioInstance?.password}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="nombre"><g:message code="usuario.nombre.label" default="Nombre" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: usuarioInstance, field: 'nombre', 'errors')}">
                                    <g:textField name="nombre" value="${usuarioInstance?.nombre}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="apellidos"><g:message code="usuario.apellidos.label" default="Apellidos" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: usuarioInstance, field: 'apellidos', 'errors')}">
                                    <g:textField name="apellidos" value="${usuarioInstance?.apellidos}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="email"><g:message code="usuario.email.label" default="Email" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: usuarioInstance, field: 'email', 'errors')}">
                                    <g:textField name="email" value="${usuarioInstance?.email}" />
                                </td>
                            </tr>
                       <g:if test="${session?.usuario?.tipo == 'administrador' }"> 
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="tipo"><g:message code="usuario.tipo.label" default="Tipo" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: usuarioInstance, field: 'tipo', 'errors')}">
                                    <g:select name="tipo" from="${usuarioInstance.constraints.tipo.inList}" value="${usuarioInstance?.tipo}" valueMessagePrefix="usuario.tipo"  />
                                </td>
                            </tr>
                       </g:if> 
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="operaciones"><g:message code="usuario.operaciones.label" default="Operaciones" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: usuarioInstance, field: 'operaciones', 'errors')}">
                                    
<ul>
<g:each in="${usuarioInstance?.operaciones?}" var="o">
    <li><g:link controller="operacion" action="show" id="${o.id}">${o?.encodeAsHTML()}</g:link></li>
</g:each>
</ul>
<g:link controller="operacion" action="create" params="['usuario.id': usuarioInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'operacion.label', default: 'Operacion')])}</g:link>

                                </td>
                            </tr>
                        
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><g:actionSubmit class="save" action="update" value="${message(code: 'default.button.update.label', default: 'Update')}" /></span>
                    <span class="button"><g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
