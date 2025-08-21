/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app_fidness;

/**
 *
 * @author Osvaldo
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionSQLite {
    private static final String URL = "jdbc:sqlite:usuarios.db";

    public static Connection conectar() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL);
            System.out.println("Conexión establecida con SQLite.");
        } catch (SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
        }
        return conn;
    }
}


