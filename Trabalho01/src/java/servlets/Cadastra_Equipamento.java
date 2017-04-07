package servlets;

import java.io.IOException;
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

@WebServlet(name = "Cadastra_Equipamento", urlPatterns = {"/insere.html"})
public class Cadastra_Equipamento extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/cadastraEquipamento.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Equipamento equipamento = new Equipamento();
        equipamento.setSerie(request.getParameter("serie"));
        equipamento.setLocal(request.getParameter("local"));
        equipamento.setDescricao(request.getParameter("descricao"));
        equipamento.setEstado(Integer.parseInt(request.getParameter("estado")));

        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String url = "jdbc:derby://localhost:1527/lppo-2017-1";
            Connection conexao = DriverManager.getConnection(url, "usuario", "senha");
            Statement operacao = conexao.createStatement();
            String sql = "INSERT INTO equipamento(serie, local, descricao, estado) VALUES('"
                    + equipamento.getSerie()+ "', '"
                    + equipamento.getLocal()+ "','"
                    + equipamento.getDescricao()+ "',"
                    + equipamento.getEstado()+ ")";
            operacao.executeUpdate(sql);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Cadastra_Equipamento.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Cadastra_Equipamento.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect("lista.html");

    }
}