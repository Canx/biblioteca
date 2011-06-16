<div id="menu">
  <nobr>
    <usuario:identificado>
      <g:link controller="usuario" action="edit" id="${session.usuario?.id}">
      <b>${session.usuario?.nombre} ${session.usuario?.apellidos} (${session.usuario?.tipo})</b>
      </g:link> | <a href="javascript:void(0)" id="logout"><g:message code="encabezado.logout"/></a>
      <gui:dialog
        id="confirmLogout"
        title="Logout"
        modal="true"
        buttons="[
          [text:'Sí', handler:'logoutHandler', isDefault:true],
          [text:'No', handler:'function() {this.cancel();}', isDefault: false]]"
        triggers="[show:[id:'logout', on:'click']]">
      Estas seguro que quieres salir?
      </gui:dialog>
      <script>
        var logoutHandler = function(o) {
          window.location="${createLink(controller:'usuario',action:'logout')}"
        }
      </script>
    </usuario:identificado>

    <usuario:noidentificado>
      <g:link controller="usuario" action="login"><g:message code="encabezado.login"/></g:link> |
      <g:link controller="usuario" action="register">Registrarse</g:link>
    </usuario:noidentificado>
  </nobr>
</div>
