package cl.praxis.models.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Db {

    private static final String URL = "jdbc:postgresql://localhost:5432/startup";
    private static final String USER = "postgres";
    private static final String PASSWORD = "chanchito1234";

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el driver de PostgreSQL: " + e.getMessage());
        }
    }

    public static Connection getConnect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

