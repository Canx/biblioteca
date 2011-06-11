<html>
    <head>
        <title>Welcome to Grails</title>
        <meta name="layout" content="main" />
        <style type="text/css" media="screen">

        #nav {
            margin-top:20px;
            margin-left:30px;
            width:228px;
            float:left;

        }
        .homePagePanel * {
            margin:0px;
        }
        .homePagePanel .panelBody ul {
            list-style-type:none;
            margin-bottom:10px;
        }
        .homePagePanel .panelBody h1 {
            text-transform:uppercase;
            font-size:1.1em;
            margin-bottom:10px;
        }
        .homePagePanel .panelBody {
            background: url(images/leftnav_midstretch.png) repeat-y top;
            margin:0px;
            padding:15px;
        }
        .homePagePanel .panelBtm {
            background: url(images/leftnav_btm.png) no-repeat top;
            height:20px;
            margin:0px;
        }

        .homePagePanel .panelTop {
            background: url(images/leftnav_top.png) no-repeat top;
            height:11px;
            margin:0px;
        }
        h2 {
            margin-top:15px;
            margin-bottom:15px;
            font-size:1.2em;
        } 

	#pageBody {
            margin-left:20px;
            margin-right:20px;
        }
        </style>
    </head>
    <body>
        <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
        </g:if>
        <div id="pageBody">
            <h1>Bienvenido a la aplicación Biblioteca</h1>

<p>Bienvenido a la aplicación Biblioteca. Esta aplicación ha sido desarrollada utilizando el framework de desarrollo rápido de aplicaciones Grails y permite la gestión de una biblioteca de un centro educativo cualquiera, con la posibilidad de reservar y prestar libros, así como gestionar las sanciones impuestas a los usuarios por el retraso en la devolución de los libros.</p>

        </div>
    </body>
</html>
