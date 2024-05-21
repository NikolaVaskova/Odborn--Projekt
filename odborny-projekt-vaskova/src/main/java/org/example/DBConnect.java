package org.example;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBConnect {
    private static String url;

    public DBConnect() {
            connect();
        }

    public void connect() {
        url = "jdbc:sqlite:CompanyProgram.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        System.out.println("Connection to SQLite has been established.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    public void executeSQL(String sql) {
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
                // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /*public void insertCustomer(String nameCustomer) {
        String sql = "INSERT INTO Customer(name) VALUES('" + nameCustomer + "')" ;
        executeSQL(sql);
    }*/

    public List<ChecklistItem> getChecklistItems() {
        String sql = "SELECT id, label FROM ChecklistItems";
        List<ChecklistItem> items = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String label = rs.getString("label");
                items.add(new ChecklistItem(id, label));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return items;
    }

    public void addUser(String name, String email, String password) {
        String sql = "INSERT INTO Users(name, email, password) VALUES(?, ? , ?)";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

        pstmt.setString(1, name);
        pstmt.setString(2, email);
        pstmt.setString(3, password);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}