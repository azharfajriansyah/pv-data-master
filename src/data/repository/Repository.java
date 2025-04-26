/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Azhar
 */
public abstract class Repository<T> {
    static Connection connection;
    
    static {
        connection = connect();
    }
    
    private static Connection connect() {
        Connection _connection;
        String url = "jdbc:mysql://localhost:3306/penjualan";
        String username = "root";
        String password = "12345";

        System.out.println("Connecting database ...");

        try {
            _connection = DriverManager.getConnection(url, username, password);
            System.out.println("Database connected!");
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
        return _connection;
    }
    
    protected void executeUpdateQuery(String query) throws Exception {
        System.out.println(query);
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            throw e;
        }
    }
    
    public abstract ArrayList<T> populate(String searchText);
    public abstract void save(T object) throws Exception;
    public abstract void update(T object) throws Exception;
    public abstract void delete(String id) throws Exception;
    
}
