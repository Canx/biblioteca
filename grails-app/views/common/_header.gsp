<div id="menu">
  <nobr>
    <g:if test="${session.usuario}">
      <g:link controller="usuario" action="edit" id="${session.usuario?.id}">
      <b>${session.usuario?.nombre} ${session.usuario?.apellidos} (${session.usuario?.tipo})</b>
      </g:link> | <a href="javascript:void(0)" id="logout">Logout</a>
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
          this.cancel();
        }
      </script>
    </g:if>

    <g:else>
      <g:link controller="usuario" action="login">Login</g:link>
    </g:else>
  </nobr>
</div>
