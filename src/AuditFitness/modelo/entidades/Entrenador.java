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
public class Entrenador extends Usuario{
    private String especialidad;
    private List<Cliente> clientes;
    
    public Entrenador(String username, String password, String nombre, String identificacion){
        super(username, password, nombre, identificacion, UsuarioRole.ENTRENADOR);
        this.especialidad = especialidad;
        this.clientes = new ArrayList<>();
    }
    
    //Metodo para agregra un cliente
    public void agregarCliente(Cliente cliente){
        this.clientes.add(cliente);
    }
    
    public List<Cliente> getClientes(){
        return clientes;
    }
    
    //Getters y Setters
    public String getEspecialidad(){
        return especialidad;
    }
    
    public void setEspecialidad(String especialidad){
        this.especialidad = especialidad;
    }
    
    @Override
    public String toString(){
        return "Entrenador: " +
                "Username: " + getUsername() +
                ", Nombre: " + getNombre() +
                ", Identificacion: " + getIdentificacion() +
                ", Especialidad: " + getEspecialidad();
    }
}
