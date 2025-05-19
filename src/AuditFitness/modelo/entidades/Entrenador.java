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

/**
 * Clase que representa a un entrenador en el sistema del gimnasio.
 * Hereda las características básicas de Usuario y añade información
 * sobre su especialidad y los clientes que entrena.
 * 
 * Es como el "expediente profesional" de un entrenador en el gimnasio,
 * que incluye sus credenciales, habilidades y lista de alumnos.
 */
    public class Entrenador extends Usuario{
        private String especialidad; // Área de especialización del entrenador
        private List<Cliente> clientes; // Lista de clientes que están bajo su supervisión
    
    // === CONSTRUCTOR ===
    
    /**
     * Crea un nuevo entrenador con información básica
     * @param username Nombre de usuario para login
     * @param password Contraseña de acceso
     * @param nombre Nombre real 
     * @param identificacion Número único de identificación
     */
    public Entrenador(String username, String password, String nombre, String identificacion){
        super(username, password, nombre, identificacion, UsuarioRole.ENTRENADOR); // Configura los datos básicos heredados de Usuario
        this.especialidad = especialidad;
        this.clientes = new ArrayList<>(); // Lista vacía de clientes al inicio
    }
    
    // === MÉTODOS PRINCIPALES ===
    
    /**
     * Agrega un nuevo cliente a la lista de supervisados
     * @param cliente El cliente a agregar (debe estar registrado)
     */
    public void agregarCliente(Cliente cliente){
        this.clientes.add(cliente);
    }
    /**
     * Obtiene la lista completa de clientes asignados
     * @return Lista de clientes bajo su responsabilidad
     */
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
    // === MÉTODOS ESPECIALES ===
    
    /**
     * Devuelve una representación en texto de los datos del entrenador
     * @return Cadena con información formateada
     */
    @Override
    public String toString(){
        return "Entrenador: " +
                "Username: " + getUsername() +
                ", Nombre: " + getNombre() +
                ", Identificacion: " + getIdentificacion() +
                ", Especialidad: " + getEspecialidad();
    }
}
