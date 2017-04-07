<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Equipamento</title>
    </head>
    <body>
        <h2>Editar Equipamento</h2>
        <form method="post">
            <p><input type="hidden" name="id" value="${equipamento.id}"/>ID: ${equipamento.id}</p>
            <p>Serie: <input type="text" name="serie" value="${equipamento.serie}"</p>
            <p>Local: <input type="text" name="local" value="${equipamento.local}"</p>
            <p>Descricao: <textarea name="descricao">${equipamento.descricao}</textarea></p>
            <select name="estado" value="${equipamento.estado}">
                <option value="0" ${equipamento.estado==0?"selected":""}>Novo</option>
                <option value="1" ${equipamento.estado==1?"selected":""}>Em uso</option>
                <option value="2" ${equipamento.estado==2?"selected":""}>Danificado</option>
                <option value="3" ${equipamento.estado==3?"selected":""}>Perdido</option>
            </select>
            <p><input type="submit" value="Editar" />
            <input type="reset" value="Limpar" /></p>
        </form>
    </body>
</html>