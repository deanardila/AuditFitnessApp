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
public class Asistencia {
    private LocalDate fecha;
    private String usernameCliente;

    public Asistencia(String usernameCliente, LocalDate fecha) {
        this.fecha = fecha;
        this.usernameCliente = usernameCliente;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getUsernameCliente() {
        return usernameCliente;
    }

    public void setUsernameCliente(String usernameCliente) {
        this.usernameCliente = usernameCliente;
    }
    
    public String toCSVString() {
    return String.join(",",
        this.usernameCliente,
        this.fecha.toString()
    );
}}
