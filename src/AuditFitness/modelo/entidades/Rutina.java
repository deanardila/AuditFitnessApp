/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AuditFitness.modelo.entidades;

/**
 *
 * @author deana
 */
public class Rutina {
    private String nombre;
    private int repeticiones;
    private int series;
    
    public Rutina(String nombre, int repeticiones, int series) {
        this.nombre = nombre;
        this.repeticiones = repeticiones;
        this.series = series;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public int getRepeticiones() {
        return repeticiones;
    }
    
    public int getSeries() {
        return series;
    }
}
