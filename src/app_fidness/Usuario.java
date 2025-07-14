/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app_fidness;

/**
 *
 * @author Osvaldo
 */
public class Usuario {
    private String nombreUsuario;
    private String contrasena;
    private String nombreCompleto;
    private String correoElectronico;

    public Usuario(String nombreUsuario, String contrasena, String nombreCompleto, String correoElectronico) {
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.nombreCompleto = nombreCompleto;
        this.correoElectronico = correoElectronico;
    }

    public boolean verificarCredenciales(String usuario, String clave) {
        return this.nombreUsuario.equals(usuario) && this.contrasena.equals(clave);
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }
}

