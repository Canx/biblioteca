
<%@ page import="biblioteca.Multa" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'multa.label', default: 'Multa')}" />
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
                        
                            <g:sortableColumn property="id" title="${message(code: 'multa.id.label', default: 'Id')}" />
                        
                            <th><g:message code="multa.usuario.label" default="Usuario" /></th>
                        
                            <g:sortableColumn property="fecha_fin" title="${message(code: 'multa.fecha_fin.label', default: 'Fechafin')}" />
                        
                            <g:sortableColumn property="descripcion" title="${message(code: 'multa.descripcion.label', default: 'Descripcion')}" />
                        
                            <g:sortableColumn property="fecha_inicio" title="${message(code: 'multa.fecha_inicio.label', default: 'Fechainicio')}" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${multaInstanceList}" status="i" var="multaInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${multaInstance.id}">${fieldValue(bean: multaInstance, field: "id")}</g:link></td>
                        
                            <td>${fieldValue(bean: multaInstance, field: "usuario")}</td>
                        
                            <td><g:formatDate date="${multaInstance.fecha_fin}" /></td>
                        
                            <td>${fieldValue(bean: multaInstance, field: "descripcion")}</td>
                        
                            <td><g:formatDate date="${multaInstance.fecha_inicio}" /></td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${multaInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
