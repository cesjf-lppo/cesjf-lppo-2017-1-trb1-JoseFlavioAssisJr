<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Equipamentos</title>
    </head>
    <body>
        <form method="get">
        <h2>Lista de Equipamentos</h2>
        <table border="1">
            <tr>
                <th>Id</th>
                <th>Serie</th>
                <th>Local</th>
                <th>Descricao</th>
                <th>Estado</th>
            </tr>
            <c:forEach var="equipamento" items="${equipamentos}">
                <tr>
                <td><a href="edita.html?id=${equipamento.id}">${equipamento.id}</a></td>
                <td>${equipamento.serie}</td>
                <td>${equipamento.local}</td>
                <td>${equipamento.descricao}</td>
                <td>${equipamento.estado}</td>
                <td><a href="exclui.html?id=${equipamento.id}">X</a></td>
                </tr>
            </c:forEach>
        </table>
            <br><select name="filtro">
            <option value="" ${(filtro=="")?"selected":""}>Todos</option>
            <option value="WHERE estado=0" ${(filtro=="WHERE estado=0")?"selected":""}>Novo</option>
            <option value="WHERE estado=1" ${(filtro=="WHERE estado=1")?"selected":""}>Em uso</option>
            <option value="WHERE estado=2" ${(filtro=="WHERE estado=2")?"selected":""}>Danificado</option>
            <option value="WHERE estado=3" ${(filtro=="WHERE estado=3")?"selected":""}>Perdido</option>
            </select>
            <p><input type="submit" value="Filtrar" class="btn btn-default"></p>
        </form> 
    </body>
</html>
