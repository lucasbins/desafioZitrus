package br.com.autorizacao.dao;

import br.com.autorizacao.model.Solicitacao;

import java.util.List;
import java.util.Optional;

public interface ISolicitacaoDAO {

    Solicitacao save(Solicitacao solicitacao);
    void delete(Long id);
    List<Solicitacao> findAll();
    Optional<Solicitacao> findById(Long id);
}
