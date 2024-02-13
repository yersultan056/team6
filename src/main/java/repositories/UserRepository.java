package repositories;

import data.interfaces.IDB;
import modules.User;
import repositories.interfaces.IUserRepository;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class UserRepository implements IUserRepository {
    private final IDB db;  // Dependency Injection for database connection interface

    // Constructor that injects a database connection interface (IDB) into the UserRepository
    public UserRepository(IDB db) {
        this.db = db;
    }

    @Override
    public boolean createUser(User user) {
        Connection con = null; // Database connection object

        try {
            con = db.getConnection(); // Attempt to establish a database connection
            String sql = "INSERT INTO users(name, surname, gender, rights_category) VALUES (?, ?, ?, ?)"; // SQL query to insert a new user
            PreparedStatement st = con.prepareStatement(sql);

            // Setting parameters for the SQL query based on the user object properties
            st.setString(1, user.getName());
            st.setString(2, user.getSurname());
            st.setBoolean(3, user.getGender());
            st.setString(4, user.getRightsCategory());

            st.execute(); // Execute the SQL query

            return true; // Return true if the user is successfully created
        } catch (SQLException e) {
            System.out.println("SQL error: " + e.getMessage()); // Print SQL error message
        } finally {
            try {
                if (con != null)
                    con.close(); // Ensure the database connection is closed
            } catch (SQLException e) {
                System.out.println("SQL error: " + e.getMessage()); // Print error message if connection closing fails
            }
        }

        return false; // Return false if user creation fails
    }

    @Override
    public User getUser(int id) {
        Connection con = null; // Database connection object

        try {
            con = db.getConnection(); // Attempt to establish a database connection
            String sql = "SELECT id, name, surname, gender, rights_category FROM users WHERE id=?"; // SQL query to get a user by id
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id); // Set the id parameter in the SQL query

            ResultSet rs = st.executeQuery(); // Execute the query and get the result set
            if (rs.next()) { // If a user is found
                return new User(rs.getInt("id"), // Create and return a new User object with the data from the result set
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getBoolean("gender"),
                        rs.getString("rights_category"));
            }
        } catch (SQLException e) {
            System.out.println("SQL error: " + e.getMessage()); // Print SQL error message
        } finally {
            try {
                if (con != null)
                    con.close(); // Ensure the database connection is closed
            } catch (SQLException e) {
                System.out.println("SQL error: " + e.getMessage()); // Print error message if connection closing fails
            }
        }

        return null; // Return null if no user is found
    }

    @Override
    public List<User> getAllUsers() {
        Connection con = null; // Database connection object

        try {
            con = db.getConnection(); // Attempt to establish a database connection
            String sql = "SELECT id, name, surname, gender, rights_category FROM users"; // SQL query to get all users
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql); // Execute the query and get the result set
            List<User> users = new LinkedList<>(); // Create an empty list to hold User objects
            while (rs.next()) { // Iterate through the result set
                User user = new User(rs.getInt("id"), // Create a new User object for each row in the result set
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getBoolean("gender"),
                        rs.getString("rights_category"));

                users.add(user); // Add the User object to the list
            }

            return users; // Return the list of User objects
        } catch (SQLException e) {
            System.out.println("SQL error: " + e.getMessage()); // Print SQL error message
        } finally {
            try {
                if (con != null)
                    con.close(); // Ensure the database connection is closed
            } catch (SQLException e) {
                System.out.println("SQL error: " + e.getMessage()); // Print error message if connection closing fails
            }
        }

        return null; // Return null if fetching users fails
    }
}
