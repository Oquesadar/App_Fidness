/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app_fidness;

/**
 *
 * @author Osvaldo
 */
import java.io.Serializable;

public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;

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

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public boolean verificarCredenciales(String usuario, String clave) {
        return this.nombreUsuario.equals(usuario) && this.contrasena.equals(clave);
    }
}

