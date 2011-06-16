

<%@ page import="biblioteca.Usuario" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'usuario.label', default: 'Usuario')}" />
        <g:javascript library="jquery" plugin="jquery" />
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
            <g:hasErrors bean="${usuarioInstance}">
                <div class="errors">
                    <g:set var="primerError" value="${true}" />
                        <g:eachError bean="${usuarioInstance}">
                            <g:if test="${primerError}">
                                <g:message error="${it}" />
                            </g:if>
                            <g:set var="primerError" value="${false}" />
                    </g:eachError>
                </div>
            </g:hasErrors>
            <g:form action="handleRegister" method="post">
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="login"><g:message code="usuario.login.label" default="Login" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: usuarioInstance, field: 'login', 'errors')}">
                                    <g:remoteField action="checkLogin" update="spanCheckLogin" name="login" paramName="login"/>
                                    <span id="spanCheckLogin"></span>
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
                                    <label for="confirm"><g:message code="usuario.password.confirm.label" default="Confirmar Password" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: usuarioInstance, field: 'password', 'errors')}">
                                    <g:passwordField name="confirm" maxlength="20"  />
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
                                    <g:remoteField action="checkEmail" update="spanCheckEmail" name="email" paramName="email"/>
                                    <div id="spanCheckEmail"></div>
                                </td>
                            </tr>
                          
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="tipo">Captcha:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:usuarioInstance,field:'responseCaptcha','errors')}">
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
