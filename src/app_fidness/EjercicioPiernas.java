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

class EjercicioPiernas extends Ejercicio {
    public EjercicioPiernas(String nombre, String descripcion, String rutaImagen) {
        super(nombre, descripcion, "Piernas", rutaImagen);
    }

    public static ArrayList<EjercicioPiernas> obtenerEjercicios() {
        ArrayList<EjercicioPiernas> lista = new ArrayList<>();
        lista.add(new EjercicioPiernas("Prensa de piernas", "En la prensa de piernas, baja el peso controladamente hasta que las piernas formen un ángulo de 45°, luego empuja hacia arriba sin bloquear las rodillas. Duración recomendada: 4 series de 10 repeticiones", "/Imagenes/Prensa_piernas.jpg"));
        lista.add(new EjercicioPiernas("Elevación de pantorrillas sentado", "Sentado con los pies en la plataforma, baja los talones y luego elévalos contrayendo las pantorrillas. Duración recomendada: 4 series de 15 repeticiones", "/Imagenes/Elevación_pantorrillas.jpg"));
        return lista;
    }

    @Override
    public void mostrarDetalle() {
        System.out.println("Ejercicio de piernas: " + nombre + " - " + descripcion);
    }
}


