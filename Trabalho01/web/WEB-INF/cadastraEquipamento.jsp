<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Equipamentos</title>
    </head>
    <body>
        <h2>Cadastro de Equipamentos</h2>
        <form method="post">
            <p><label>Número de serie: <input type="text" name="serie" size="30"></p>
            <p><label>Local: <input type="text" name="local" size="40"></p>
            <p><label>Descricao:</p> <p><textarea name="descricao" rows="7" cols="48"></textarea></p>
            <p>Estado: <select name="estado">
                <option></option>
                <option value="0">Novo</option>
                <option value="1">Em uso</option>
                <option value="2">Danificado</option>
                <option value="3">Perdido</option>
            </select></p><br>
            <p><input type="submit" value="Cadastrar">
            <input type="reset" value="Limpar" /></p>
        </form>
    </body>
</html>