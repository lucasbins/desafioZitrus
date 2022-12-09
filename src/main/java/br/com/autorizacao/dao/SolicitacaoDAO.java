package br.com.autorizacao.dao;

import br.com.autorizacao.model.Procedimento;
import br.com.autorizacao.model.Solicitacao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SolicitacaoDAO implements ISolicitacaoDAO {

    private final Connection connection;

    public SolicitacaoDAO(Connection connection){
        this.connection = connection;
    }

    @Override
    public Solicitacao save(Solicitacao solicitacao) {
        try{
            String sql = "INSERT INTO SOLICITACAO (paciente, idade, sexo, procedimento) VALUES (?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, solicitacao.getPaciente());
            preparedStatement.setInt(2, solicitacao.getIdade());
            preparedStatement.setString(3, solicitacao.getSexo());
            preparedStatement.setLong(4, solicitacao.getProcedimento().getId());

            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();

            Long generatedId = resultSet.getLong("id");

            solicitacao.setId(generatedId);

            preparedStatement.close();
            resultSet.close();

        }catch (SQLException ex){
            throw new RuntimeException(ex);
        }
        return solicitacao;
    }

    @Override
    public Solicitacao update(Solicitacao solicitacao) {
        try{
            String sql = "UPDATE SOLICITACAO SET PACIENTE = ?, SEXO = ?, idade = ?, PROCEDIMENTO = ? WHERE ID = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, solicitacao.getPaciente());
            preparedStatement.setString(2, solicitacao.getSexo());
            preparedStatement.setInt(3, solicitacao.getIdade());
            preparedStatement.setLong(4, solicitacao.getProcedimento().getId());
            preparedStatement.setLong(5, solicitacao.getId());

            preparedStatement.executeUpdate();
            preparedStatement.close();
        }catch (SQLException ex){
            throw new RuntimeException(ex);
        }
        return solicitacao;
    }

    @Override
    public void delete(Long id) {
        try {
            String sql = "DELETE FROM SOLICITACAO WHERE id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);

            preparedStatement.executeUpdate();

            preparedStatement.close();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<Solicitacao> findAll() {
        String sql = "SELECT ID, PACIENTE, IDADE, SEXO, PROCEDIMENTO FROM SOLICITACAO";
        List<Solicitacao> sols = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()){
                Long id = rs.getLong("id");
                String paciente = rs.getString("paciente");
                int idade = rs.getInt("idade");
                String sexo = rs.getString("sexo");
                Long proc = rs.getLong("procedimento");

                ProcedimentoDAO procDao = new ProcedimentoDAO(connection);
                Optional<Procedimento> procedimento = procDao.findById(proc);

                Solicitacao sol = new Solicitacao(id,paciente,idade,sexo,procedimento.get());
                sols.add(sol);
            }

            preparedStatement.close();
            rs.close();
        }catch (SQLException ex){
            throw new RuntimeException(ex);
        }
        return sols;
    }

    @Override
    public Optional<Solicitacao> findById(Long id) {
        String sql = "SELECT ID, PACIENTE, IDADE, SEXO, PROCEDIMENTO FROM SOLICITACAO WHERE id = ?";
        Solicitacao sol = null;
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1,id);

            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()){
                Long pKey = rs.getLong("id");
                String paciente = rs.getString("paciente");
                int idade = rs.getInt("idade");
                String sexo = rs.getString("sexo");
                Long proc = rs.getLong("procedimento");

                ProcedimentoDAO procDao = new ProcedimentoDAO(connection);
                Optional<Procedimento> procedimento = procDao.findById(proc);


                sol = new Solicitacao(id,paciente,idade,sexo,procedimento.get());
            }

            preparedStatement.executeUpdate();
            preparedStatement.close();
        }catch (SQLException ex){
            throw new RuntimeException(ex);
        }
        return Optional.ofNullable(sol);
    }
}
