/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app_fidness;

/**
 *
 * @author Osvaldo
 */
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorSockets {
    public static final int PUERTO = 5000;

    private final BaseDatosUsuario baseDatos = new BaseDatosUsuario();

    public static void main(String[] args) {
        new ServidorSockets().iniciar();
    }

    public void iniciar() {
        System.out.println("Servidor Fidness escuchando en puerto " + PUERTO + " ...");
        try (ServerSocket serverSocket = new ServerSocket(PUERTO)) {
            while (true) {
                Socket cliente = serverSocket.accept();
                new Thread(() -> manejarCliente(cliente)).start();
            }
        } catch (IOException e) {
            System.err.println("Error en servidor: " + e.getMessage());
        }
    }

    private void manejarCliente(Socket socket) {
        try (
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
            PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true)
        ) {
            String linea = in.readLine();
            if (linea == null || linea.trim().isEmpty()) {
                out.println("ERROR;Solicitud vacía");
                return;
            }

            String[] partes = linea.split(";", -1);
            String comando = partes[0].toUpperCase();

            switch (comando) {
                case "REGISTRO":
                    
                    if (partes.length != 5) {
                        out.println("ERROR;Formato REGISTRO inválido");
                        break;
                    }
                    procesarRegistro(partes[1], partes[2], partes[3], partes[4], out);
                    break;

                case "LOGIN":
                    
                    if (partes.length != 3) {
                        out.println("ERROR;Formato LOGIN inválido");
                        break;
                    }
                    procesarLogin(partes[1], partes[2], out);
                    break;

                default:
                    out.println("ERROR;Comando no reconocido");
            }
        } catch (Exception e) {
            System.err.println("Error manejando cliente: " + e.getMessage());
        } finally {
            try { socket.close(); } catch (IOException ignore) {}
        }
    }

    private void procesarRegistro(String nombreUsuario, String contrasena, String nombreCompleto, String correo, PrintWriter out) {
        
        Usuario existente = baseDatos.buscarUsuario(nombreUsuario);
        if (existente != null) {
            out.println("ERROR;El nombre de usuario ya existe");
            return;
        }
        Usuario nuevo = new Usuario(nombreUsuario, contrasena, nombreCompleto, correo);
        baseDatos.insertarUsuario(nuevo);
        
        
        out.println("Usuario registrado correctamente");
    }

    private void procesarLogin(String nombreUsuario, String contrasena, PrintWriter out) {
        Usuario u = baseDatos.buscarUsuario(nombreUsuario);
        if (u != null && contrasena.equals(u.getContrasena())) {
            out.println("OK;" + u.getNombreUsuario() + ";" + u.getNombreCompleto() + ";" + u.getCorreo());
        } else {
            out.println("ERROR;Credenciales incorrectas");
        }
    }
}

