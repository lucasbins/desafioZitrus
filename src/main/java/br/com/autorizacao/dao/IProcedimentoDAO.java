package br.com.autorizacao.dao;

import br.com.autorizacao.model.Procedimento;

import java.util.List;
import java.util.Optional;

public interface IProcedimentoDAO {
    Procedimento save(Procedimento procedimento);
    Procedimento update(Procedimento procedimento);
    void delete(Long id);
    List<Procedimento> findAll();
    Optional<Procedimento> findById(Long id);
    Optional<Procedimento> findByCod(String cod);
}
