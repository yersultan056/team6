import java.sql.*;

public class MyApplication {
    public static void main(String[] args){
        String connectionString = "jdbc:postgresql://localhost:5432/team6";
        Connection con = null;
        try{
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(connectionString, "postgres", "5859");

            String sql = "SELECT id, name, surname, gender, rights_category FROM users ORDER BY rights_category ASC";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }
        } catch (SQLException e){
            System.out.println("connection error: " + e.getMessage());
        } catch (ClassNotFoundException e){
            System.out.println("driver error: " + e.getMessage());
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    System.out.println("could not close the connection: " + e.getMessage());
                }
            }
        }
        }
}
