package repositories;

import data.interfaces.IDB;
import modules.Cars;
import repositories.interfaces.ICarsRepository;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class CarsRepository implements ICarsRepository {
    private final IDB db; // Database interface for dependency injection

    // Constructor to inject the database interface
    public CarsRepository(IDB db) {
        this.db = db;
    }

    @Override
    public boolean createCar(Cars car) {
        // Method stub for creating a car in the database
        // Currently returns false as it's not implemented
        return false;
    }

    @Override
    public Cars getCar(int car_id) {
        // Attempt to establish a database connection
        Connection con = null;
        try {
            con = db.getConnection();
            // SQL query to select a car by its ID
            String sql = "SELECT model, brand, number, category, car_class FROM cars WHERE car_id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, car_id); // Set the car_id parameter in the SQL query

            ResultSet rs = st.executeQuery();
            // Check if a car was found and return a new Cars object with the data
            if (rs.next()) {
                return new Cars(rs.getInt("car_id"),
                        rs.getString("model"),
                        rs.getString("brand"),
                        rs.getString("number"),
                        rs.getString("category"),
                        rs.getString("car_class"));
            }
        } catch (SQLException e) {
            System.out.println("sql error: " + e.getMessage()); // Log SQL errors
        } finally {
            // Ensure the database connection is closed
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                System.out.println("sql error: " + e.getMessage()); // Log errors on closing connection
            }
        }

        return null; // Return null if no car was found or if an error occurred
    }

    @Override
    public List<Cars> getAllCars() {
        // Attempt to establish a database connection
        Connection con = null;
        try {
            con = db.getConnection();
            // SQL query to select all cars
            String sql = "SELECT model, brand, number, category, car_class FROM cars";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Cars> cars = new LinkedList<>();
            // Iterate through the result set and add each car to the list
            while (rs.next()) {
                Cars car = new Cars(rs.getInt("car_id"),
                        rs.getString("model"),
                        rs.getString("brand"),
                        rs.getString("number"),
                        rs.getString("category"),
                        rs.getString("car_class"));

                cars.add(car);
            }

            return cars; // Return the list of cars
        } catch (SQLException e) {
            System.out.println("sql error: " + e.getMessage()); // Log SQL errors
        } finally {
            // Ensure the database connection is closed
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                System.out.println("sql error: " + e.getMessage()); // Log errors on closing connection
            }
        }

        return null; // Return null if an error occurred
    }
}

