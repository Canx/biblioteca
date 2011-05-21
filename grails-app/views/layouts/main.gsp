<!DOCTYPE html>
<html>
    <head>
        <title><g:layoutTitle default="Grails" /></title>
        <link rel="stylesheet" href="${resource(dir:'css',file:'main.css')}" />
        <link rel="shortcut icon" href="${resource(dir:'images',file:'favicon.ico')}" type="image/x-icon" />
        <g:layoutHead />
        <g:javascript library="application" />
    </head>
    <body>
        <div id="spinner" class="spinner" style="display:none;">
            <img src="${resource(dir:'images',file:'spinner.gif')}" alt="${message(code:'spinner.alt',default:'Loading...')}" />
        </div>
        <div id="header">
            <g:render template="/common/header"/>
        </div>
        <div id="headertitle">
          <h1>Biblioteca</h1>
          <div id="enlaces_menu">
            <g:link controller="libro">Libros</g:link>
            <g:link controller="usuario">Usuarios</g:link>
            <g:link controller="operacion">Operaciones</g:link>
          </div>
        </div>
        <div id="content">
          <g:layoutBody />
        </div>
        <div id="footer">
          <g:render template="/common/footer"/>
        </div>
    </body>
</html>
