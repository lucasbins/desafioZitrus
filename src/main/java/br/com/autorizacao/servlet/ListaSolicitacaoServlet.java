package br.com.autorizacao.servlet;

import br.com.autorizacao.dao.ProcedimentoDAO;
import br.com.autorizacao.dao.SolicitacaoDAO;
import br.com.autorizacao.infra.ConnectionFactory;
import br.com.autorizacao.model.Solicitacao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet("/ListaSolicitacoes")
public class ListaSolicitacaoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection connection = ConnectionFactory.getConnection();
        SolicitacaoDAO solDao = new SolicitacaoDAO(connection);

        List<Solicitacao> solicitacaoList = solDao.findAll();

        req.setAttribute("listaSolicitacoes", solicitacaoList);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/listaSolicitacoes.jsp");
        dispatcher.forward(req, resp);
    }
}
