/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Singleton.java to edit this template
 */
package AuditFitness.controlador.auth;

/**
 *
 * @author deana
 */
public class SesionSingleton {
    
    public String idenficacionSes = null;
    private String nombre;
    
    private SesionSingleton() {
    }
    
    public static SesionSingleton getInstance() {
        return SesionSingletonHolder.INSTANCE;
    }
    
    private static class SesionSingletonHolder {

        private static final SesionSingleton INSTANCE = new SesionSingleton();
    }

    public String getIdenficacionSes() {
        return idenficacionSes;
    }

    public void setIdenficacionSes(String idenficacionSes) {
        this.idenficacionSes = idenficacionSes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
