
<%@ page import="biblioteca.Usuario" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'usuario.label', default: 'Usuario')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                            <g:sortableColumn property="login" title="${message(code: 'usuario.login.label', default: 'Login')}" />
                            <g:sortableColumn property="nombre" title="${message(code: 'usuario.nombre.label', default: 'Nombre')}" />
                            <g:sortableColumn property="apellidos" title="${message(code: 'usuario.apellidos.label', default: 'Apellidos')}" />
                            <g:sortableColumn property="tipo" title="${message(code: 'usuario.tipo.label', default: 'Tipo')}" />
                            <g:sortableColumn property="email" title="${message(code: 'usuario.email.label', default: 'Email')}" />
                            <th>Operaciones</th>
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${usuarioInstanceList}" status="i" var="usuarioInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}"
onclick="location.href='${createLink(action: 'show', id:usuarioInstance.id)}'">
                            <td><a href="${createLink(action: 'show', id:usuarioInstance.id)}">${fieldValue(bean: usuarioInstance, field: "login")}</a></td>
                            <td>${fieldValue(bean: usuarioInstance, field: "nombre")}</td>
                            <td>${fieldValue(bean: usuarioInstance, field: "apellidos")}</td>
                            <td>${fieldValue(bean: usuarioInstance, field: "tipo")}</td>
                            <td>${fieldValue(bean: usuarioInstance, field: "email")}</td>
                            <g:if test="${(usuarioInstance.tipo == 'socio') || (usuarioInstance.tipo == 'profesor')}">
                              <td>Enlace a listado de operaciones</td>
                            </g:if>
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${usuarioInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
