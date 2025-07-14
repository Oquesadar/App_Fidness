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

class EjercicioAbdominales extends Ejercicio {
    public EjercicioAbdominales(String nombre, String descripcion) {
        super(nombre, descripcion, "Abdominales");
    }

    public static ArrayList<EjercicioAbdominales> obtenerEjercicios() {
        ArrayList<EjercicioAbdominales> lista = new ArrayList<>();
        lista.add(new EjercicioAbdominales("Crunch abdominal", "Acostado con rodillas flexionadas y manos al pecho, eleva el torso hasta estar perpendicular al suelo y baja lentamente. Duración recomendada: 3 series de 20 repeticiones"));
        lista.add(new EjercicioAbdominales("Crunch con peso", "Acostado con las rodillas a 90°, sostén un disco sobre el pecho y elévalo hacia los pies contrayendo el abdomen. Duración recomendada: 3 series de 15 repeticiones"));
        return lista;
    }

    @Override
    public void mostrarDetalle() {
        System.out.println("Ejercicio de abdominales: " + nombre + " - " + descripcion);
    }
}

