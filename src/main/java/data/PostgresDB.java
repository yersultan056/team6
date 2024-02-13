package data;

import data.interfaces.IDB;

import java.sql.*;

public class PostgresDB implements IDB {
    @Override
    public Connection getConnection() {
        String connectionUrl = "jdbc:postgresql://localhost:5432/team6";
        try {
            // Here we load the driver’s class file into memory at the runtime
            Class.forName("org.postgresql.Driver");

            // Establish the connection
            Connection con = DriverManager.getConnection(connectionUrl, "postgres", "5859");

            return con;
        } catch (Exception e) {
            System.out.println("failed to connect to postgres: " + e.getMessage());

            return null;
        }
    }
}
