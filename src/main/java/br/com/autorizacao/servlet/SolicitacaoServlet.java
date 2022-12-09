package br.com.autorizacao.servlet;

import br.com.autorizacao.dao.ProcedimentoDAO;
import br.com.autorizacao.dao.SolicitacaoDAO;
import br.com.autorizacao.infra.ConnectionFactory;
import br.com.autorizacao.model.Procedimento;
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

@WebServlet("/Solicitacao")
public class SolicitacaoServlet extends HttpServlet {

    Connection connection = ConnectionFactory.getConnection();
    ProcedimentoDAO procDAO = new ProcedimentoDAO(connection);
    SolicitacaoDAO solDao = new SolicitacaoDAO(connection);
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String paciente = req.getParameter("paciente");
        int idade = Integer.parseInt(req.getParameter("idade"));
        String sexo = req.getParameter("sexo");
        String procedimento = req.getParameter("procedimento");

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/naoAutorizada.jsp");

        List<Procedimento> procs = procDAO.findByCod(procedimento);

        Procedimento procedimento1 = null;

        if(procs.isEmpty()){
            dispatcher = req.getRequestDispatcher("/WEB-INF/notFound.jsp");
        }

        for(Procedimento proc : procs){
            if(proc.getSexo().equals(sexo) && proc.getIdade() == idade && proc.getPermissao() ){
                procedimento1 = proc;

                Solicitacao solicitacao = new Solicitacao(paciente, idade, sexo, procedimento1);

                solDao.save(solicitacao);
                dispatcher = req.getRequestDispatcher("/WEB-INF/autorizada.jsp");
                break;
            }
        }
        dispatcher.forward(req, resp);
    }
}
