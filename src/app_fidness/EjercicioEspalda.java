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

class EjercicioEspalda extends Ejercicio {
    public EjercicioEspalda(String nombre, String descripcion) {
        super(nombre, descripcion, "Espalda");
    }

    public static ArrayList<EjercicioEspalda> obtenerEjercicios() {
        ArrayList<EjercicioEspalda> lista = new ArrayList<>();
        lista.add(new EjercicioEspalda("Remo con polea sentado", "Sentado con la espalda recta, tira del mango hacia el abdomen, junta los omóplatos y luego extiende los brazos lentamente para volver. Duración recomendada: 4 series de 12 repeticiones"));
        lista.add(new EjercicioEspalda("Superman", "Acostado boca abajo con brazos a los lados, eleva el pecho y las piernas contrayendo la espalda baja, luego baja lentamente. Duración recomendada: 3 series de 15 repeticiones"));
        return lista;
    }

    @Override
    public void mostrarDetalle() {
        System.out.println("Ejercicio de espalda: " + nombre + " - " + descripcion);
    }
}


