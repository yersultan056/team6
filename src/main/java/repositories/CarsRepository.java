package repositories;

import data.interfaces.IDB;
import modules.Cars;
import repositories.interfaces.ICarsRepository;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class CarsRepository implements ICarsRepository {
    private final IDB db;  // Dependency Injection

    public CarsRepository(IDB db) {
        this.db = db;
    }

    @Override
    public boolean createCar(Cars car) {
        return false;
    }

    @Override
    public Cars getCar(int car_id) {
        Connection con = null;

        try {
            con = db.getConnection();
            String sql = "SELECT model,brand,number,category,car_class FROM users WHERE car_id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, car_id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new Cars(rs.getInt("car_id"),
                        rs.getString("model"),
                        rs.getString("brand"),
                        rs.getString("number"),
                        rs.getString("category"),
                        rs.getString("car_class"));
            }
        } catch (SQLException e) {
            System.out.println("sql error: " + e.getMessage());
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                System.out.println("sql error: " + e.getMessage());
            }
        }

        return null;
    }

    @Override
    public List<Cars> getAllCars() {
        Connection con = null;

        try {
            con = db.getConnection();
            String sql = "SELECT model,brand,number,category,car_class FROM users";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Cars> cars = new LinkedList<>();
            while (rs.next()) {
                Cars car = new Cars(rs.getInt("car_id"),
                        rs.getString("model"),
                        rs.getString("brand"),
                        rs.getString("number"),
                        rs.getString("category"),
                        rs.getString("car_class"));

                cars.add(car);
            }

            return cars;
        } catch (SQLException e) {
            System.out.println("sql error: " + e.getMessage());
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                System.out.println("sql error: " + e.getMessage());
            }
        }

        return null;
    }
}

