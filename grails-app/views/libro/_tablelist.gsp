<table>
    <tr>
        <th>ISBN</th> 
        <th>Título</th>
        <th>Autor</th>
        <th>Año</th>
        <th>Editorial</th>
    </tr>
    <g:each in="${libros}" var="libro">
        <tr>
            <td>${libro.isbn}</td>
            <td>${libro.titulo}</td>
            <td>${libro.autor}</td>
            <td>${libro.anyo}</td>
            <td>${libro.editorial}</td>
        </tr>
    </g:each>
</table>

