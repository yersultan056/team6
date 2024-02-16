import java.sql.*;
import java.util.ArrayList;

import modules.User;
import controllers.UserController;
import controllers.CarController;
import data.PostgresDB;
import data.interfaces.IDB;
import repositories.CarsRepository;
import repositories.UserRepository;
import repositories.interfaces.IUserRepository;
import repositories.interfaces.ICarsRepository;

public class Main {
    public void selectCars(int id){
        IDB db2 = new PostgresDB();
        ICarsRepository repo2 = new CarsRepository(db2);
        CarController controller2 = new CarController(repo2);
        ChooseCar app2 = new ChooseCar(controller2);
        app2.start();
    }

    public static void main(String[] args){
        // Database connection string for PostgreSQL
        String connectionString = "jdbc:postgresql://localhost:5432/team6";
        // List to hold User objects fetched from database
        ArrayList<User> usersar = new ArrayList<>();
        Connection con = null;
        try {
            // Load PostgreSQL JDBC driver
            Class.forName("org.postgresql.Driver");
            // Establish connection to the database
            con = DriverManager.getConnection(connectionString, "postgres", "5859");

            // SQL query to select all users ordered by their rights category
            String sql = "SELECT id, name, surname, gender, rights_category FROM users ORDER BY rights_category ASC";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            // Iterate over the result set to create User objects and add them to the list
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                boolean gender = rs.getBoolean("gender");
                String rights_category = rs.getString("rights_category");

                // Create new User object and add to the list
                User user = new User(id, name, surname, gender, rights_category);
                usersar.add(user);
            }
        } catch (SQLException e) {
            // Handle SQL connection errors
            System.out.println("connection error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            // Handle errors related to JDBC driver loading
            System.out.println("driver error: " + e.getMessage());
        } finally {
            // Ensure the database connection is closed
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    System.out.println("could not close the connection: " + e.getMessage());
                }
            }
        }
        // Print out all users
        for (User user : usersar) {
            System.out.println(user);
        }

        // Setup and start the application
        IDB db = new PostgresDB(); // Database interface instance
        IUserRepository repo = new UserRepository(db); // User repository
        UserController controller = new UserController(repo); // User controller
        MyApplication app = new MyApplication(controller); // Application instance
        app.start(); // Start the application


    }
}

