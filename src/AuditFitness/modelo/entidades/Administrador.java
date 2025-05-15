/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AuditFitness.modelo.entidades;

/**
 *
 * @author deana
 */
public class Administrador extends Usuario {
    public Administrador(String username, String password, String nombre, String identificacion){
        super(username, password, nombre, identificacion, UsuarioRole.ADMINISTRADOR);
    }
    @Override
    public String toSring(){
        return "Administrador: " +
                "Username: " + getUsername() +
                ", Nombre: " + getNombre() +
                ", Identificacion: " + getIdentificacion();
    }
}
