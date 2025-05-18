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
   private String archivoRutina;
   private String clienteId;

    public Rutina(String archivoRutina, String clienteId) {
        this.archivoRutina = archivoRutina;
        this.clienteId = clienteId;
    }

    public String getArchivoRutina() {
        return archivoRutina;
    }

    public void setArchivoRutina(String archivoRutina) {
        this.archivoRutina = archivoRutina;
    }

    public String getClienteId() {
        return clienteId;
    }

    public void setClienteId(String clienteId) {
        this.clienteId = clienteId;
    }
   
   
}
