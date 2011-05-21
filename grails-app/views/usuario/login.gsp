<%@ page import="biblioteca.*" %>

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="layout" content="main"/>
    <title>Login</title>
  </head>
  <body>
    <div class="body">
      <g:if test="${flash.message}">
        <div class="message">
          ${flash.message}
        </div>
      </g:if>
      <p>Bienvenido a la aplicación Biblioteca. Por favor, identifícate.
      </p>
      <form>
        <span class="nameClear">
          <label for="login">
            Selecciona el usuario:
          </label>
        </span>
        <g:select name="login" from="${Usuario.list()}" optionKey="login" optionValue="login"></g:select>
        <br/>
        <div class="buttons">
          <span class="button"><g:actionSubmit value="Login" action="handleLogin"/></span>
        </div>
      </form>
    </div>
  </body>
</html>
