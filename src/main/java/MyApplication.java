import java.sql.*;
import java.util.ArrayList;

import modules.User;

public class MyApplication {
    public static void main(String[] args){
        String connectionString = "jdbc:postgresql://localhost:5432/team6";
        ArrayList<User> usersar = new ArrayList<>();
        Connection con = null;
        try{
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(connectionString, "postgres", "5859");

            String sql = "SELECT id, name, surname, gender, rights_category FROM users ORDER BY rights_category ASC";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                boolean gender = rs.getBoolean("gender");
                String rights_category = rs.getString("rights_category");

                User user = new User(id, name, surname, gender, rights_category);
                usersar.add(user);
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
        for (User user : usersar) {
            System.out.println(user);
        }
        }
}
