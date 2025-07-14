/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app_fidness;

/**
 *
 * @author Osvaldo
 */
import java.util.ArrayList;

class BaseDatosUsuario {
    private ArrayList<Usuario> listaUsuarios;

    public BaseDatosUsuario() {
        listaUsuarios = new ArrayList<>();
    }

    public void agregarUsuario(Usuario u) {
        listaUsuarios.add(u);
    }

    public Usuario buscarUsuario(String nombreUsuario) {
        for (Usuario u : listaUsuarios) {
            if (u.getNombreUsuario().equals(nombreUsuario)) {
                return u;
            }
        }
        return null;
    }

    public boolean validarLogin(String usuario, String clave) {
        for (Usuario u : listaUsuarios) {
            if (u.verificarCredenciales(usuario, clave)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }
}
