/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app_fidness;

/**
 *
 * @author Osvaldo
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BaseDatosUsuario {

    public BaseDatosUsuario() {
        crearTablaUsuarios();
    }

    
    private void crearTablaUsuarios() {
        String sql = "CREATE TABLE IF NOT EXISTS usuarios ("
                + "nombreUsuario TEXT PRIMARY KEY,"
                + "contrasena TEXT NOT NULL,"
                + "nombreCompleto TEXT,"
                + "correo TEXT"
                + ");";
        try (Connection conn = ConexionSQLite.conectar();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabla usuarios lista.");
        } catch (SQLException e) {
            System.out.println("Error al crear tabla: " + e.getMessage());
        }
    }

    
    public void insertarUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuarios(nombreUsuario, contrasena, nombreCompleto, correo) VALUES(?,?,?,?)";
        try (Connection conn = ConexionSQLite.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, usuario.getNombreUsuario());
            pstmt.setString(2, usuario.getContrasena());
            pstmt.setString(3, usuario.getNombreCompleto());
            pstmt.setString(4, usuario.getCorreo());
            pstmt.executeUpdate();
            System.out.println("Usuario insertado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al insertar: " + e.getMessage());
        }
    }

    
    public List<Usuario> listarUsuarios() {
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";
        try (Connection conn = ConexionSQLite.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Usuario u = new Usuario(
                        rs.getString("nombreUsuario"),
                        rs.getString("contrasena"),
                        rs.getString("nombreCompleto"),
                        rs.getString("correo")
                );
                lista.add(u);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar: " + e.getMessage());
        }
        return lista;
    }

    
    public Usuario buscarUsuario(String nombreUsuario) {
        String sql = "SELECT * FROM usuarios WHERE nombreUsuario = ?";
        try (Connection conn = ConexionSQLite.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nombreUsuario);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Usuario(
                        rs.getString("nombreUsuario"),
                        rs.getString("contrasena"),
                        rs.getString("nombreCompleto"),
                        rs.getString("correo")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar: " + e.getMessage());
        }
        return null;
    }

    
    public void eliminarUsuario(String nombreUsuario) {
        String sql = "DELETE FROM usuarios WHERE nombreUsuario = ?";
        try (Connection conn = ConexionSQLite.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nombreUsuario);
            pstmt.executeUpdate();
            System.out.println("Usuario eliminado.");
        } catch (SQLException e) {
            System.out.println("Error al eliminar: " + e.getMessage());
        }
    }
}