/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app_fidness;

/**
 *
 * @author Osvaldo
 */

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;

class MainApp {
    
    static ArrayList<Ejercicio> rutina = new ArrayList<>();
    static Usuario usuarioActual;

    
    static ClienteSockets cliente = new ClienteSockets("localhost", ServidorSockets.PUERTO);

    public static void main(String[] args) {
        mostrarInicioSesion();
    }

    public static void mostrarInicioSesion() {
        while (true) {
            String[] opciones = {"Iniciar sesión", "Registrarse", "Salir"};
            int opcion = JOptionPane.showOptionDialog(null, "Bienvenido a Fidness", "Inicio",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                    null, opciones, opciones[0]);

            if (opcion == 0) iniciarSesion();
            else if (opcion == 1) registrarUsuario();
            else break;
        }
    }

    public static void registrarUsuario() {
        String nombreUsuario = JOptionPane.showInputDialog("Ingrese el nombre del usuario:");
        if (nombreUsuario == null) return;
        String contrasena = JOptionPane.showInputDialog("Ingrese la contraseña:");
        if (contrasena == null) return;
        String nombreCompleto = JOptionPane.showInputDialog("Ingrese el nombre completo:");
        if (nombreCompleto == null) return;
        String correo = JOptionPane.showInputDialog("Ingrese el correo electrónico:");
        if (correo == null) return;

        String comando = String.join(";", "REGISTRO", nombreUsuario, contrasena, nombreCompleto, correo);
        String respuesta = cliente.enviar(comando);

        if (respuesta != null && respuesta.startsWith("OK")) {
            JOptionPane.showMessageDialog(null, "El usuario fue registrado correctamente");
        } else {
            String msg = (respuesta == null) ? "Respuesta nula" : respuesta;
            JOptionPane.showMessageDialog(null, "Error en registro: " + msg);
        }
    }

    public static void iniciarSesion() {
        String usuario = JOptionPane.showInputDialog("Usuario:");
        if (usuario == null) return;
        String clave = JOptionPane.showInputDialog("Contraseña:");
        if (clave == null) return;

        String comando = String.join(";", "LOGIN", usuario, clave);
        String respuesta = cliente.enviar(comando);

        if (respuesta != null && respuesta.startsWith("OK")) {
            
            String[] partes = respuesta.split(";", -1);
            String nombreUsuario = (partes.length > 1) ? partes[1] : usuario;
            String nombreCompleto = (partes.length > 2) ? partes[2] : usuario;
            String correo = (partes.length > 3) ? partes[3] : "";

            usuarioActual = new Usuario(nombreUsuario, clave, nombreCompleto, correo);
            mostrarMenuPrincipal();
        } else {
            JOptionPane.showMessageDialog(null, "Credenciales incorrectas");
        }
    }

    public static void mostrarMenuPrincipal() {
        while (true) {
            String[] opciones = {"Seleccionar grupo muscular", "Ver rutina", "Exportar rutina", "Cerrar sesión"};
            int opcion = JOptionPane.showOptionDialog(null, "Bienvenido/a " + usuarioActual.getNombreCompleto(), "Menú Principal",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                    null, opciones, opciones[0]);

            if (opcion == 0) seleccionarGrupoMuscular();
            else if (opcion == 1) verRutina();
            else if (opcion == 2) exportarRutina();
            else break;
        }
    }

    public static void seleccionarGrupoMuscular() {
        String[] grupos = {"Pecho", "Espalda", "Brazos", "Abdominales", "Piernas", "Hombros"};
        String seleccion = (String) JOptionPane.showInputDialog(null, "Seleccione el grupo muscular a trabajar:",
                "Grupos Musculares", JOptionPane.QUESTION_MESSAGE, null, grupos, grupos[0]);
        if (seleccion == null) return;

        ArrayList<? extends Ejercicio> lista = new ArrayList<>();
        if (seleccion.equals("Pecho")) lista = EjercicioPecho.obtenerEjercicios();
        else if (seleccion.equals("Espalda")) lista = EjercicioEspalda.obtenerEjercicios();
        else if (seleccion.equals("Brazos")) lista = EjercicioBrazos.obtenerEjercicios();
        else if (seleccion.equals("Abdominales")) lista = EjercicioAbdominales.obtenerEjercicios();
        else if (seleccion.equals("Piernas")) lista = EjercicioPiernas.obtenerEjercicios();
        else if (seleccion.equals("Hombros")) lista = EjercicioHombros.obtenerEjercicios();

        if (lista.isEmpty()) return;

        String[] nombres = lista.stream().map(e -> e.nombre).toArray(String[]::new);
        String elegido = (String) JOptionPane.showInputDialog(null, "Seleccione ejercicio:",
                "Ejercicios de " + seleccion, JOptionPane.QUESTION_MESSAGE, null, nombres, nombres[0]);
        if (elegido == null) return;

        for (Ejercicio e : lista) {
            if (e.nombre.equals(elegido)) {
                int confirmar = JOptionPane.showConfirmDialog(null, e.nombre + "\n" + e.descripcion +
                        "\n\n¿Desea añadir este ejercicio a su rutina?", "Detalle del ejercicio", JOptionPane.YES_NO_OPTION);
                if (confirmar == JOptionPane.YES_OPTION) {
                    rutina.add(e);
                    JOptionPane.showMessageDialog(null, "Ejercicio agregado a la rutina");
                }
                break;
            }
        }
    }

    public static void verRutina() {
        if (rutina.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay ejercicios en la rutina");
            return;
        }

        StringBuilder sb = new StringBuilder("Rutina de " + usuarioActual.getNombreCompleto() + ":\n\n");
        for (Ejercicio e : rutina) {
            sb.append("- ").append(e.nombre).append(" [").append(e.grupoMuscular).append("]\n");
            sb.append("  ").append(e.descripcion).append("\n\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    public static void exportarRutina() {
        try {
            FileWriter writer = new FileWriter("rutina_" + usuarioActual.getNombreUsuario() + ".txt");
            writer.write("Rutina personalizada de " + usuarioActual.getNombreCompleto() + "\n\n");
            for (Ejercicio e : rutina) {
                writer.write(e.nombre + " (" + e.grupoMuscular + "):\n");
                writer.write(e.descripcion + "\n\n");
            }
            writer.close();
            JOptionPane.showMessageDialog(null, "Rutina exportada exitosamente");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al exportar la rutina");
        }
    }
}


