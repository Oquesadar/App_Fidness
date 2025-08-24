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

class EjercicioBrazos extends Ejercicio {
    public EjercicioBrazos(String nombre, String descripcion, String rutaImagen) {
        super(nombre, descripcion, "Brazos", rutaImagen);
    }

    public static ArrayList<EjercicioBrazos> obtenerEjercicios() {
        ArrayList<EjercicioBrazos> lista = new ArrayList<>();
        lista.add(new EjercicioBrazos("Curl en barra con agarre", "De pie con una barra, realiza un curl con las palmas hacia abajo sin mover los codos, y baja de forma controlada. Duración recomendada: 3 series de 10-12 repeticiones", "/Imagenes/Curl_barra_agarre.jpg"));
        lista.add(new EjercicioBrazos("Curl de predicador con martillo y mancuernas", "Sentado en banco predicador, baja y sube la mancuerna con agarre neutro manteniendo el brazo pegado al banco. Duración recomendada: 3 series de 10 repeticiones por brazo.", "/Imagenes/Curl_predicador_mancuerna.jpg"));
        return lista;
    }

    @Override
    public void mostrarDetalle() {
        System.out.println("Ejercicio de brazos: " + nombre + " - " + descripcion);
    }
}

