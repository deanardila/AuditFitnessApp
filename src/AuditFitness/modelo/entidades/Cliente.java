/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AuditFitness.modelo.entidades;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author deana
 */
public class Cliente extends Usuario {
    private String rutinaAsignada;
    private boolean activo; //Estado del cliente

    //Constructor

    public Cliente(String username, String password, String nombre, String identificacion) {
        // Llama al constructor de la clase padre (Usuario)
        super(username, password, nombre, identificacion, UsuarioRole.CLIENTE);
        this.rutinaAsignada = null;
        this.activo = true;  // Por defecto, el cliente está activo
    }

    public void agregarRutina(String rutinaId){
        this.rutinaAsignada = rutinaId;
    }

   

    public String getRutinasAsignadas() {
        return rutinaAsignada;
    }

    public void setRutinasAsignadas(String rutinaAsignada) {
        this.rutinaAsignada = rutinaAsignada;
    }

   

   

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString(){
        return "Cliente: " +
                "Username: " + getUsername() +
                ", Nombre: " + getNombre() +
                ", Identificacion: " + getIdentificacion() +
                ", Rutinas: " + rutinaAsignada;
    }

    public String toCSVString() {
    return String.join(",",
        this.username,
        this.password,
        this.nombre,
        this.identificacion,
        this.rutinaAsignada
    );
}
}
