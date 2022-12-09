package br.com.autorizacao.dao;

import br.com.autorizacao.infra.ConnectionFactory;
import br.com.autorizacao.model.Procedimento;
import br.com.autorizacao.model.Solicitacao;
import junit.framework.TestCase;
import org.junit.Test;

import java.sql.Connection;
import java.util.List;

public class SolicitacaoDAOTest extends TestCase {

    Connection connection = ConnectionFactory.getConnection();
    SolicitacaoDAO solDao = new SolicitacaoDAO(connection);

    @Test
    public void testSave() {
        Procedimento proc = new Procedimento(1L,"1234", "M", 20, Boolean.TRUE);
        Solicitacao sol = new Solicitacao("Teste", 20, "M", proc);

        Solicitacao retornoEsperado = sol;

        Solicitacao retornoFeito = solDao.save(sol);

        solDao.delete(retornoFeito.getId());

        assertEquals(retornoEsperado, retornoFeito);
    }

    @Test
    public void testDelete() {
        Procedimento proc = new Procedimento(1L,"1234", "M", 20, Boolean.TRUE);
        Solicitacao sol = new Solicitacao("Teste", 20, "M", proc);

        Solicitacao retornoFeito = solDao.save(sol);

        solDao.delete(retornoFeito.getId());
    }

    @Test
    public void testFindAll() {
        List<Solicitacao> retornoEsperado = solDao.findAll();

        assertNotNull(retornoEsperado);
    }

    @Test
    public void testFindById() {
        Procedimento proc = new Procedimento(1L,"1234", "M", 20, Boolean.TRUE);
        Solicitacao sol = new Solicitacao("Teste", 20, "M", proc);

        Solicitacao solicitacao = solDao.save(sol);

        assertNotNull(solDao.findById(solicitacao.getId()));
    }
}