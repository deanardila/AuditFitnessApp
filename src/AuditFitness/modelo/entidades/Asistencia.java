/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AuditFitness.modelo.entidades;

import java.time.LocalDate;

/**
 *
 * @author deana
 */

/**
 * Clase que representa el registro de asistencia de un cliente al gimnasio.
 * Es como una "ficha de control" que guarda qué cliente vino y en qué fecha.
 */
public class Asistencia {
    private LocalDate fecha; // La fecha cuando el cliente asistió (día, mes, año)
    private String usernameCliente; // El nombre de usuario único del cliente que asistió

    /**
     * Crea un nuevo registro de asistencia
     * @param usernameCliente El identificador único del cliente (ej: "cliente123")
     * @param fecha La fecha exacta de la asistencia (ej: 2023-11-15)
     */
    public Asistencia(String usernameCliente, LocalDate fecha) {
        this.fecha = fecha;
        this.usernameCliente = usernameCliente;
    }
    
    // === MÉTODOS PARA ACCEDER A LOS DATOS ===
    
    /**
     * Obtiene la fecha registrada de asistencia
     * @return La fecha cuando el cliente asistió
     */
    public LocalDate getFecha() {
        return fecha;
    }
    
     /**
     * Actualiza/cambia la fecha de asistencia
     * @param fecha La nueva fecha a registrar
     */
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    
    /**
     * Obtiene el nombre de usuario del cliente
     * @return El ID único del cliente que asistió
     */
    public String getUsernameCliente() {
        return usernameCliente;
    }
    
    /**
     * Actualiza/cambia el cliente asociado a esta asistencia
     * @param usernameCliente El nuevo nombre de usuario a registrar
     */
    public void setUsernameCliente(String usernameCliente) {
        this.usernameCliente = usernameCliente;
    }
    
    /**
     * Convierte los datos de asistencia a formato CSV (para guardar en archivos)
     * @return Cadena de texto con los datos separados por comas
     * Ejemplo: "cliente2,2025-05-15"
     */
    public String toCSVString() {
    return String.join(",",
        this.usernameCliente,
        this.fecha.toString());
    }
}
