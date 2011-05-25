
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
                        
                            <g:sortableColumn property="id" title="${message(code: 'libro.id.label', default: 'Id')}" />
                        
                            <g:sortableColumn property="isbn" title="${message(code: 'libro.isbn.label', default: 'Isbn')}" />
                        
                            <g:sortableColumn property="titulo" title="${message(code: 'libro.titulo.label', default: 'Titulo')}" />
                        
                            <g:sortableColumn property="autor" title="${message(code: 'libro.autor.label', default: 'Autor')}" />
                        
                            <g:sortableColumn property="editorial" title="${message(code: 'libro.editorial.label', default: 'Editorial')}" />
                        
                            <g:sortableColumn property="anyo" title="${message(code: 'libro.anyo.label', default: 'Anyo')}" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${libroInstanceList}" status="i" var="libroInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${libroInstance.id}">${fieldValue(bean: libroInstance, field: "id")}</g:link></td>
                        
                            <td>${fieldValue(bean: libroInstance, field: "isbn")}</td>
                        
                            <td>${fieldValue(bean: libroInstance, field: "titulo")}</td>
                        
                            <td>${fieldValue(bean: libroInstance, field: "autor")}</td>
                        
                            <td>${fieldValue(bean: libroInstance, field: "editorial")}</td>
                        
                            <td>${fieldValue(bean: libroInstance, field: "anyo")}</td>
                        
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
