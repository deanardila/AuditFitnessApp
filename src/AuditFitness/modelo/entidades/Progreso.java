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
 * Clase que registra el progreso físico (peso) de un cliente en una fecha específica.
 * Es como una "ficha de control de peso" en el gimnasio que documenta la evolución del cliente.
 */
public class Progreso {
    private String clienteId; // Identificador único del cliente
    private double peso; // Peso registrado del cliente (en kilogramos)
    private LocalDate fecha; // Fecha cuando se tomó el registro (día, mes, año)
    
    /**
     * Crea un nuevo registro de progreso
     * @param clienteId Identificador del cliente
     * @param peso Valor numérico del peso 
     * @param fecha Fecha del registro 
     */
    public Progreso(String clienteId, double peso, LocalDate fecha) {
        this.clienteId = clienteId;
        this.peso = peso;
        this.fecha = fecha;
    }

    // === MÉTODOS PARA ACCEDER Y MODIFICAR DATOS ===
    
    /**
     * Obtiene el identificador del cliente
     * @return ID del cliente asociado a este progreso
     */
    public String getClienteId() {
        return clienteId;
    }

    /**
     * Cambia el cliente asociado a este registro
     * @param clienteId Nuevo ID de cliente
     */
    public void setClienteId(String clienteId) {
        this.clienteId = clienteId;
    }

    /**
     * Obtiene el peso registrado
     * @return Valor del peso en kg
     */
    public double getPeso() {
        return peso;
    }

    /**
     * Actualiza el peso registrado
     * @param peso Nuevo valor de peso
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }

    /**
     * Obtiene la fecha del registro
     * @return Fecha cuando se tomó esta medida
     */
    public LocalDate getFecha() {
        return fecha;
    }

    /**
     * Cambia la fecha del registro
     * @param fecha Nueva fecha a asignar
     */
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }  
}
