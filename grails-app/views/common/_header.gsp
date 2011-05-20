<div id="menu">
  <nobr>
    <g:if test="${session.usuario}">
      <b>${session.usuario?.nombre} ${session.usuario?.apellidos}</b> |
        <g:link controller="usuario" action="logout">Logout</g:link>
      </g:if>
      <g:else>
        <g:link controller="usuario" action="login">Login</g:link>
      </g:else>
    </nobr>
</div>
