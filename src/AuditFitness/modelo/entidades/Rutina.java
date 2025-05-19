/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AuditFitness.modelo.entidades;

/**
 *
 * @author deana
 */

/**
 * Clase que representa una rutina de ejercicios asignada a un cliente.
 * Es como un "plan de entrenamiento personalizado" que vincula:
 * - El archivo/documento con los ejercicios específicos
 * - El cliente al que pertenece esa rutina
 */
    public class Rutina {
        private String archivoRutina; // Nombre/ruta del archivo que contiene los detalles de la rutina
        private String clienteId; // Identificador único del cliente dueño de esta rutina

        /**
     * Crea una nueva asociación entre cliente y rutina
     * @param archivoRutina Ubicación/nombre del archivo de rutina 
     * @param clienteId ID del cliente asignado 
     */
    public Rutina(String archivoRutina, String clienteId) {
        this.archivoRutina = archivoRutina;
        this.clienteId = clienteId;
    }

    // === MÉTODOS DE ACCESO ===
    
    /**
     * Obtiene la ubicación del archivo de rutina
     * @return Ruta/nombre del archivo
     */
    public String getArchivoRutina() {
        return archivoRutina;
    }

    /**
     * Cambia el archivo asociado a esta rutina
     * @param archivoRutina Nueva ruta/nombre de archivo
     */
    public void setArchivoRutina(String archivoRutina) {
        this.archivoRutina = archivoRutina;
    }

    /**
     * Obtiene el ID del cliente asociado
     * @return Identificador del cliente
     */
    public String getClienteId() {
        return clienteId;
    }
    /**
     * Reasigna la rutina a otro cliente
     * @param clienteId Nuevo ID de cliente
     */
    public void setClienteId(String clienteId) {
        this.clienteId = clienteId;
    } 
}
