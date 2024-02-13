import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyApplication {
    public static void main(String[] args){
        String connectionString = "jdbc:postgresql://localhost:5432/team6";

        try{
            Connection con = DriverManager.getConnection(connectionString, "postgres", "5859");
        } catch (SQLException e){
            System.out.println("connection error: " + e.getMessage());
        }
    }
}
