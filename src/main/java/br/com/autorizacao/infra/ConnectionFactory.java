package br.com.autorizacao.infra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private ConnectionFactory(){}

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/desafiodb", "postgres", "d&v");
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
