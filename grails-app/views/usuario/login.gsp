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
          <label for="login">Nombre de usuario</label><br/>
            <input type="text" maxlength="20" id="login" name="login"
             value="${fieldValue(bean:usuarioInstance, field:'login')}"/>
          <br/>
          <label for="password">Contraseña</label><br/>
            <input type="password" maxlength="20" id="password" name="password"/>
          <br/> 
        <div class="buttons">
          <span class="button"><g:actionSubmit value="Login" action="handleLogin"/></span>
        </div>
      </form>
    </div>
  </body>
</html>
