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

@WebServlet(name = "Insere_Reclamacao", urlPatterns = {"/insere.html"})
public class Insere_Reclamacao extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.getRequestDispatcher("WEB-INF/insereReclamacao.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String descricao = request.getParameter("descricao");
        int status = Integer.parseInt(request.getParameter("status"));
        
        Logger.getLogger(Insere_Reclamacao.class.getName()).log(Level.INFO, "POST: " +nome+" "+email+" "+descricao+" "+status);

            try {
                Class.forName("org.apache.derby.jdbc.ClientDriver");
                String url = "jdbc:derby://localhost:1527/lppo-2017-1";
                Connection conexao = DriverManager.getConnection(url, "usuario", "senha");
                System.out.println("Sucesso na conexão!");
             
             String sql = " INSERT INTO reclamacao (nome, email, descricao, status) VALUES('"
                     +nome+ "' , '"
                     +email+ "' , '"
                     +descricao+"', "
                     +status+")";
             Statement operacao = conexao.createStatement();
             operacao.executeUpdate(sql);   
        } 
            catch (Exception e) {
            Logger.getLogger(Insere_Reclamacao.class.getName()).log(Level.SEVERE, "Erro!" +e);
            }
            response.sendRedirect("lista.html");
    }
}
