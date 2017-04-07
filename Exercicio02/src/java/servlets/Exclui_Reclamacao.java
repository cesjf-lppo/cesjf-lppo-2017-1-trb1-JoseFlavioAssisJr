package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Exclui_Reclamacao", urlPatterns = {"/exclui.html"})
public class Exclui_Reclamacao extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 1 pegar o iud dos parâmetros
        Long id = Long.parseLong(request.getParameter("id"));
        
        // 2 excluir o registro do banco
        try {
            //Pegar os dados do banco
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/lppo-2017-1", "usuario", "senha");
            Statement operacao = conexao.createStatement();
            operacao.executeUpdate("DELETE FROM reclamacao WHERE id="+ id);
            

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Lista_Reclamacao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Lista_Reclamacao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // 3 redirecionar para a listagem
        response.sendRedirect("lista.html");
        
    }

}