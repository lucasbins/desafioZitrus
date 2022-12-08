package br.com.autorizacao.servlet;

import br.com.autorizacao.dao.ProcedimentoDAO;
import br.com.autorizacao.infra.ConnectionFactory;
import br.com.autorizacao.model.Procedimento;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

@WebServlet("/Solicitacao")
public class Solicitacao extends HttpServlet {

    Connection connection = ConnectionFactory.getConnection();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String paciente = req.getParameter("paciente");
        String nascimento = req.getParameter("nascimento");
        String sexo = req.getParameter("sexo");
        String procedimento = req.getParameter("procedimento");

        try{
            ProcedimentoDAO procDAO = new ProcedimentoDAO(connection);
            Optional<Procedimento> proc = procDAO.findByCod(procedimento);

            PrintWriter writer = resp.getWriter();
            writer.println("permissao: " + proc.get().getPermissao());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
