
<%@ page import="biblioteca.Libro" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'libro.label', default: 'Libro')}" />
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
                            <th>Portada</th> 
                            <g:sortableColumn property="isbn" title="${message(code: 'libro.isbn.label', default: 'Isbn')}" />
                            <g:sortableColumn property="titulo" title="${message(code: 'libro.titulo.label', default: 'Titulo')}" />
                            <g:sortableColumn property="autor" title="${message(code: 'libro.autor.label', default: 'Autor')}" />
                            <g:sortableColumn property="editorial" title="${message(code: 'libro.editorial.label', default: 'Editorial')}" />
                            <g:sortableColumn property="anyo" title="${message(code: 'libro.anyo.label', default: 'Anyo')}" />
                            <g:sortableColumn property="descripcion"
title="${message(code: 'libro.descripcion.label', default:
'Descripción')}" />
                            <g:sortableColumn property="fecha"
title="${message(code: 'libro.fecha.label', default: 'Fecha')}" />
                            <th>Operaciones</th>
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${libroInstanceList}" status="i" var="libroInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}"
onclick="location.href='${createLink(action: 'show', id: libroInstance.id)}'">
                            <td><img height=50 src="${createLink(controller:'libro',action:'showPortada',id: libroInstance.id)}" /></td>
                            <td><a href="${createLink(action: 'show', id: libroInstance.id)}">${fieldValue(bean: libroInstance, field: "isbn")}</a></td>
                            <td>${fieldValue(bean: libroInstance, field: "titulo")}</td>
                            <td>${fieldValue(bean: libroInstance, field: "autor")}</td>
                            <td>${fieldValue(bean: libroInstance, field: "editorial")}</td>
                            <td>${fieldValue(bean: libroInstance, field: "anyo")}</td>
                            <td>${fieldValue(bean: libroInstance, field:
"descripcion")}</td>
                            <td><g:formatDate format="dd/MM/yyyy" date="${fieldValue(bean:
libroInstance, field: "fecha")}" /></td>
                            <td>
                              <a href="<g:createLink controller="operacion" action="list" params="[libroId:libroInstance.id]" />">operaciones</a>
                            </td>
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${libroInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
