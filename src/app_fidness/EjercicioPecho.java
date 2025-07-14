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

class EjercicioPecho extends Ejercicio {
    public EjercicioPecho(String nombre, String descripcion) {
        super(nombre, descripcion, "Pecho");
    }

    public static ArrayList<EjercicioPecho> obtenerEjercicios() {
        ArrayList<EjercicioPecho> lista = new ArrayList<>();
        lista.add(new EjercicioPecho("Press de banca con mancuernas", "Acostado en un banco plano con una mancuerna en cada mano, bájalas lentamente hasta que estén a la altura del pecho y luego presiónalas hacia arriba contrayendo el pecho. Duración recomendada: 4 series de 10 repeticiones"));
        lista.add(new EjercicioPecho("Press de banca inclinado", "Acostado en un banco inclinado, baja la barra hasta el pecho manteniendo la espalda tensa y luego empuja hacia arriba con fuerza desde los pies y los brazos. Duración recomendada: 4 series de 8-10 repeticiones"));
        return lista;
    }

    @Override
    public void mostrarDetalle() {
        System.out.println("Ejercicio de pecho: " + nombre + " - " + descripcion);
    }
}


