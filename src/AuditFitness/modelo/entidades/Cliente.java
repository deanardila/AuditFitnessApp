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
    private List<String> rutinasAsignadas;
    private List<String> progreso;
    private boolean activo; //Estado del cliente

    //Constructor

    public Cliente(String username, String password, String nombre, String identificacion) {
        // Llama al constructor de la clase padre (Usuario)
        super(username, password, nombre, identificacion, UsuarioRole.CLIENTE);
        this.rutinasAsignadas = new ArrayList<>();
        this.progreso = new ArrayList<>();
        this.activo = true;  // Por defecto, el cliente está activo
    }

    public void agregarRutina(String rutinaId){
        this.rutinasAsignadas.add(rutinaId);
    }

    public void agregarProgreso(String registro){
        this.progreso.add(registro);
    }

    public List<String> getRutinasAsignadas() {
        return rutinasAsignadas;
    }

    public void setRutinasAsignadas(List<String> rutinasAsignadas) {
        this.rutinasAsignadas = rutinasAsignadas;
    }

    public List<String> getProgreso() {
        return progreso;
    }

    public void setProgreso(List<String> progreso) {
        this.progreso = progreso;
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
                ", Rutinas: " + rutinasAsignadas.size();
    }

    public String toCSVString() {
    return String.join(",",
        this.username,
        this.password,
        this.nombre,
        this.identificacion
    );
}
}
