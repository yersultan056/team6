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
    public Cars getCar(int car_id) {
        Connection con = null;

        try {
            con = db.getConnection();
            String sql = "SELECT model,brand,number,category,carClass FROM users WHERE car_id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new User(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getBoolean("gender"),
                        rs.getString("rights_category"));
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
    public List<User> getAllUsers() {
        Connection con = null;

        try {
            con = db.getConnection();
            String sql = "SELECT id,name,surname,gender,rights_category FROM users";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<User> users = new LinkedList<>();
            while (rs.next()) {
                User user = new User(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getBoolean("gender"),
                        rs.getString("rights_category"));

                users.add(user);
            }

            return users;
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

