package com.Example.dao;

import com.Example.Controller.VehicleController;
import com.Example.Models.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Component
@Scope("singleton")
@Setter
@Getter
public class DatabaseOperations
{
    @Value("${database.url}")
    private String url;
    @Value("${database.username}")
    private String username;
    @Value("${database.password}")
    private String password;
    private Connection connection;

    public DatabaseOperations() {
    }

    @PostConstruct
    public void init() {
        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Database connected successfully");
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    @PreDestroy
    public void destroy() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Database connection closed");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }


    public void save(Vehicle vehicle) {

        String sql = "INSERT INTO vehicle (model, type) VALUES (?, ?)";

        try (Connection connection =
                     DriverManager.getConnection(url, username, password);
             PreparedStatement ps =
                     connection.prepareStatement(sql)) {

            ps.setString(1, vehicle.getModel());
            ps.setString(2, vehicle.getType().name());

            ps.executeUpdate();

            System.out.printf(
                    "-------------- %s saved to database ------------------%n",
                    vehicle.getModel()
            );

        } catch (SQLException e) {
            throw new RuntimeException("Failed to save vehicle", e);
        }
    }
    public void delete(int id) {
        String sql = "DELETE FROM vehicle WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            System.out.printf("Deleted %d vehicle(s) with ID %d%n", rows, id);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to delete vehicle", e);
        }
    }

    public void update(Vehicle vehicle) {
        String sql = "UPDATE vehicle SET model = ?, type = ? WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, vehicle.getModel());
            ps.setString(2, vehicle.getType().name());
            ps.setInt(3, vehicle.getId());

            int rows = ps.executeUpdate();
            System.out.printf("Updated %d vehicle(s) with ID %d%n", rows, vehicle.getId());
        } catch (SQLException e) {
            throw new RuntimeException("Failed to update vehicle", e);
        }
    }

    public Vehicle searchById(int id) {
        String sql = "SELECT * FROM vehicle WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String typeStr = rs.getString("type");
                    Vehicle vehicle = createVehicle(typeStr);
                    vehicle.setId(rs.getInt("id"));
                    vehicle.setModel(rs.getString("model"));
                    vehicle.setType(Type.valueOf(typeStr));
                    return vehicle;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to search vehicle by ID", e);
        }
        return null;
    }

    public List<Vehicle> getAllVehicles() {
        String sql = "SELECT * FROM vehicle";
        List<Vehicle> list = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                String typeStr = rs.getString("type");
                Vehicle vehicle = createVehicle(typeStr);
                vehicle.setId(rs.getInt("id"));
                vehicle.setModel(rs.getString("model"));
                vehicle.setType(Type.valueOf(typeStr));
                list.add(vehicle);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Failed to fetch all vehicles", e);
        }
        return list;
    }
    private Vehicle createVehicle(String type) {
        switch (type.toUpperCase()) {
            case "CAR": return new Car();
            case "BIKE": return new Bike();
            case "PLANE": return new Plane();
            default: throw new IllegalArgumentException("Unknown vehicle type: " + type);
        }
    }


}
