
<%@ page import="biblioteca.Operacion" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'operacion.label', default: 'Operacion')}" />
        <g:javascript library="jquery" plugin="jquery" />
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
                        
                            <g:sortableColumn property="tipo" title="${message(code: 'operacion.tipo.label', default: 'Tipo')}" />
                        
                            <g:sortableColumn property="estado" title="${message(code: 'operacion.estado.label', default: 'Estado')}" />
                        
                            <g:sortableColumn property="fechaInicio" title="${message(code: 'operacion.fechaInicio.label', default: 'Fecha Inicio')}" />
                        
                            <g:sortableColumn property="fechaFin" title="${message(code: 'operacion.fechaFin.label', default: 'Fecha Fin')}" />
                        
                            <th><g:message code="operacion.libro.label" default="Libro" /></th>
                            <th><g:message code="operacion.usuario.label" default="Usuario" /></th>
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${operacionInstanceList}" status="i" var="operacionInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                            <td onclick="location.href='${createLink(action: 'show', id: operacionInstance.id)}'">
                                ${fieldValue(bean: operacionInstance, field: "tipo")}</td>
                            <td><g:checkBox onChange="${remoteFunction(action:'cambiarEstado',id:operacionInstance.id)}" name="estado" value="${operacionInstance?.estado}" /></td>
                            
                            <td><g:formatDate date="${operacionInstance.fechaInicio}" /></td>
                            <td><g:formatDate date="${operacionInstance.fechaFin}" /></td>
                            <td>${fieldValue(bean: operacionInstance, field: "libro")}</td>
                            <td>${fieldValue(bean: operacionInstance,
field: "usuario")}</td>
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${operacionInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
