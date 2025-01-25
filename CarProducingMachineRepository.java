package repository;

import model.CarProducingMachine;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarProducingMachineRepository {
    private static final String URL = "jdbc:mysql://localhost:3306/car_factory";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public void addMachine(CarProducingMachine machine) {
        String query = "INSERT INTO CarProducingMachines (machine_name, capacity, operational) VALUES (?, ?, ?)";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, machine.getMachineName());
            stmt.setInt(2, machine.getCapacity());
            stmt.setBoolean(3, machine.isOperational());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<CarProducingMachine> getAllMachines() {
        List<CarProducingMachine> machines = new ArrayList<>();
        String query = "SELECT * FROM CarProducingMachines";
        try (Connection conn = connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                machines.add(new CarProducingMachine(
                        rs.getInt("id"),
                        rs.getString("machine_name"),
                        rs.getInt("capacity"),
                        rs.getBoolean("operational")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return machines;
    }
}
