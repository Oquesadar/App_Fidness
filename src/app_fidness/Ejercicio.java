/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app_fidness;

/**
 *
 * @author Osvaldo
 */
abstract class Ejercicio {
    protected String nombre;
    protected String descripcion;
    protected String grupoMuscular;

    public Ejercicio(String nombre, String descripcion, String grupoMuscular) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.grupoMuscular = grupoMuscular;
    }

    public abstract void mostrarDetalle();
}

