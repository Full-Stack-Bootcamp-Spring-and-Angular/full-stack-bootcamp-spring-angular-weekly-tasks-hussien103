package main.example.DAO;

import main.example.models.Employee;
import java.sql.*;

public class EmployeeDAO {

    private String url = "jdbc:mysql://localhost:3306/springdb";
    private String user = "root";
    private String pass = "root";

    public void save(Employee emp) {
        String sql = "INSERT INTO employee(username,email,password) VALUES(?,?,?)";

        try (Connection con = DriverManager.getConnection(url, user, pass);
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, emp.getUsername());
            ps.setString(2, emp.getEmail());
            ps.setString(3, emp.getPassword());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}