<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edição de Registros</title>
    </head>
    <body>
        <h2>Edição de Registros</h2>
        <form method="POST">
            <p><input type="hidden" name="id" value="${reclamacao.id}" />ID: ${reclamacao.id}</p>
            <p>Nome: <input type="text" name="nome" size="30" value="${reclamacao.nome}" /></p>
            <p>E-mail: <input type="text" name="email" size="29" value="${reclamacao.email}" /></p>
            Descrição: <p><textarea name="descricao" rows="10" cols="38" > ${reclamacao.descricao}" /></textarea></p>
            <p>Status: <select name="status" >
		    <option></option>
                    <option value="0" ${reclamacao.status==0?"selected":""}>Aberto</option>
                    <option value="1" ${reclamacao.status==1?"selected":""}>Confirmado</option>
                    <option value="2" ${reclamacao.status==2?"selected":""}>Recusado</option>
                    <option value="3" ${reclamacao.status==3?"selected":""}>Em execução</option>
                    <option value="4" ${reclamacao.status==4?"selected":""}>Resolvido</option>
                </select></p>
		<br>
                <input type="submit" value="Registrar"/>
                <input type="reset" value="Limpar"/>
        </form>
    </body>
</html>
