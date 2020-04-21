package org.example;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLConnection {
    String url="jdbc:mysql://127.0.0.1:3306/proj_jogo_e_produto";
    String usuario = "root";
    String senha = "root";

    public Connection getConnection() {
        try {
            return DriverManager.getConnection(url, usuario, senha);

        } catch (final Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
