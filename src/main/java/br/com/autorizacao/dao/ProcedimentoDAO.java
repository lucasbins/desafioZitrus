package br.com.autorizacao.dao;

import br.com.autorizacao.model.Procedimento;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProcedimentoDAO implements IProcedimentoDAO {

    private final Connection connection;

    public ProcedimentoDAO(Connection connection){
        this.connection = connection;
    }

    @Override
    public Procedimento save(Procedimento procedimento) {
        try{
            String sql = "INSERT INTO procedimento (codigo, idade, sexo, permissao) VALUES (?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, procedimento.getCodigo());
            preparedStatement.setInt(2, procedimento.getIdade());
            preparedStatement.setString(3, procedimento.getSexo());
            if(procedimento.getPermissao().equals(Boolean.TRUE)){
                preparedStatement.setDouble(4, 1);
            }else {
                preparedStatement.setDouble(4, 0);
            }

            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();

            Long generatedId = resultSet.getLong("id");
            procedimento.setId(generatedId);

            preparedStatement.close();
            resultSet.close();

        }catch (SQLException ex){
            throw new RuntimeException(ex);
        }
        return procedimento;
    }

    @Override
    public Procedimento update(Procedimento procedimento) {
        try{
            String sql = "UPDATE procedimento SET codigo = ?, idade = ?, sexo = ? , permissao = ? WHERE ID = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, procedimento.getCodigo());
            preparedStatement.setInt(2, procedimento.getIdade());
            preparedStatement.setString(3, procedimento.getSexo());
            if(procedimento.getPermissao().equals(Boolean.TRUE)){
                preparedStatement.setDouble(4, 1);
            }else {
                preparedStatement.setDouble(4, 0);
            }
            preparedStatement.setLong(5,procedimento.getId());

            preparedStatement.executeUpdate();
            preparedStatement.close();
        }catch (SQLException ex){
            throw new RuntimeException(ex);
        }
        return procedimento;
    }

    @Override
    public void delete(Long id) {
        try {
            String sql = "DELETE FROM procedimentos WHERE id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);

            preparedStatement.executeUpdate();

            preparedStatement.close();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<Procedimento> findAll() {
            String sql = "SELECT ID, CODIGO, IDADE, SEXO, PERMISSAO FROM PROCEDIMENTO";
            List<Procedimento> procs = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()){
                Long id = rs.getLong("id");
                String codigo = rs.getString("codigo");
                int idade = rs.getInt("idade");
                String sexo = rs.getString("sexo");
                Boolean permissao;
                if(rs.getDouble("permissao") == 1){
                    permissao = Boolean.TRUE;
                }else{
                    permissao = Boolean.FALSE;
                }

                Procedimento proc = new Procedimento(id,codigo,sexo,idade,permissao);
                procs.add(proc);
            }

            preparedStatement.close();
            rs.close();
        }catch (SQLException ex){
            throw new RuntimeException(ex);
        }
        return procs;
    }

    @Override
    public Optional<Procedimento> findById(Long id) {
        String sql = "SELECT ID, CODIGO, IDADE, SEXO, PERMISSAO FROM PROCEDIMENTO WHERE id = ?";
        Procedimento proc = null;
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1,id);

            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()){
                Long pKey = rs.getLong("id");
                String codigo = rs.getString("codigo");
                int idade = rs.getInt("idade");
                String sexo = rs.getString("sexo");
                Boolean permissao;
                if(rs.getDouble("permissao") == 1){
                    permissao = Boolean.TRUE;
                }else{
                    permissao = Boolean.FALSE;
                }

                proc = new Procedimento(pKey,codigo,sexo,idade,permissao);
            }

            preparedStatement.close();
            rs.close();
        }catch (SQLException ex){
            throw new RuntimeException(ex);
        }
        return Optional.ofNullable(proc);
    }

    @Override
    public List<Procedimento> findByCod(String cod) {
        String sql = "SELECT ID, CODIGO, IDADE, SEXO, PERMISSAO FROM PROCEDIMENTO WHERE codigo = ?";
        List<Procedimento> procs = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,cod);

            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()){
                Long id = rs.getLong("id");
                String codigo = rs.getString("codigo");
                int idade = rs.getInt("idade");
                String sexo = rs.getString("sexo");
                Boolean permissao;
                if(rs.getInt("permissao") == 1){
                    permissao = Boolean.TRUE;
                }else{
                    permissao = Boolean.FALSE;
                }

                Procedimento proc = new Procedimento(id,codigo,sexo,idade,permissao);
                procs.add(proc);
            }

            preparedStatement.close();
            rs.close();
        }catch (SQLException ex){
            throw new RuntimeException(ex);
        }
        return procs;
    }
}
