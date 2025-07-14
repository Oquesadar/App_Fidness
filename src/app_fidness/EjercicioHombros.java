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

class EjercicioHombros extends Ejercicio {
    public EjercicioHombros(String nombre, String descripcion) {
        super(nombre, descripcion, "Hombros");
    }

    public static ArrayList<EjercicioHombros> obtenerEjercicios() {
        ArrayList<EjercicioHombros> lista = new ArrayList<>();
        lista.add(new EjercicioHombros("Elevación lateral con mancuernas", "Con una mancuerna en cada mano, elévalas lateralmente hasta la altura de los hombros con codos ligeramente flexionados, luego baja controladamente. Duración recomendada: 3 series de 12 repeticiones"));
        lista.add(new EjercicioHombros("Aperturas para deltoides posteriores con polea baja inclinado hacia adelante", "Inclinado hacia adelante, tira de los cables hacia los lados con codos semi-flexionados sin juntar los omóplatos excesivamente. Duración recomendada: 3 series de 12 repeticiones."));
        return lista;
    }

    @Override
    public void mostrarDetalle() {
        System.out.println("Ejercicio de hombros: " + nombre + " - " + descripcion);
    }
}

