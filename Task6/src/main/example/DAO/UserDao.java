package main.example.DAO;

import main.example.models.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDao {

    @Value("${database.url}")
    private String JDBC_URL;

    @Value("${database.username}")
    private String JDBC_USER;

    @Value("${database.password}")
    private String JDBC_PASSWORD;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("MySQL JDBC Driver not found", e);
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }

    public void addUser(User user) throws SQLException {
        String sql = """
            INSERT INTO users 
            (username, password, country, programming_language, linux, mac_os, windows)
            VALUES (?, ?, ?, ?, ?, ?, ?)
            """;

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getCountry());
            ps.setString(4, user.getProgrammingLanguage());
            ps.setBoolean(5, user.isLinux());
            ps.setBoolean(6, user.isMacOs());
            ps.setBoolean(7, user.isWindows());

            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    user.setId(rs.getInt(1));
                }
            }
        }
    }

    public User getUserById(int id) throws SQLException {
        String sql = "SELECT * FROM users WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapRowToUser(rs);
                }
            }
        }
        return null;
    }

    public List<User> getAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                users.add(mapRowToUser(rs));
            }
        }
        return users;
    }

    public void updateUser(User user) throws SQLException {
        String sql = """
            UPDATE users SET
            username = ?,
            password = ?,
            country = ?,
            programming_language = ?,
            linux = ?,
            mac_os = ?,
            windows = ?
            WHERE id = ?
            """;

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getCountry());
            ps.setString(4, user.getProgrammingLanguage());
            ps.setBoolean(5, user.isLinux());
            ps.setBoolean(6, user.isMacOs());
            ps.setBoolean(7, user.isWindows());
            ps.setInt(8, user.getId());

            ps.executeUpdate();
        }
    }

    public void deleteUser(int id) throws SQLException {
        String sql = "DELETE FROM users WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    private User mapRowToUser(ResultSet rs) throws SQLException {
        return new User(
                rs.getInt("id"),
                rs.getString("username"),
                rs.getString("password"),
                rs.getString("country"),
                rs.getString("programming_language"),
                rs.getBoolean("linux"),
                rs.getBoolean("mac_os"),
                rs.getBoolean("windows")
        );
    }
}
