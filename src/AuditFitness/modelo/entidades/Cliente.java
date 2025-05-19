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
 * Clase que representa a un cliente del gimnasio en el sistema.
 * Hereda las características básicas de Usuario y añade información específica
 * sobre rutinas de ejercicio y estado de membresía.
 * 
 * Es como la "ficha de socio" completa de un cliente en el gimnasio.
 */
    public class Cliente extends Usuario {
        private String rutinaAsignada; // La rutina de ejercicios asignada al cliente
        private boolean activo; // Indica si el cliente tiene su membresía activa o inactiva

    // === CONSTRUCTOR ===
    
    /**
     * Crea un nuevo cliente con información básica
     * @param username Nombre de usuario para login (ej: "cliente123")
     * @param password Contraseña de acceso
     * @param nombre Nombre real del cliente (ej: "Ana López")
     * @param identificacion Número único de identificación
     */

    public Cliente(String username, String password, String nombre, String identificacion) {
        // Configura los datos básicos heredados de Usuario
        super(username, password, nombre, identificacion, UsuarioRole.CLIENTE);
        this.rutinaAsignada = null; // Sin rutina asignada al crear
        this.activo = true;  // Por defecto, el cliente está activo
    }

     // === MÉTODOS PRINCIPALES ===
    
    /**
     * Asigna una nueva rutina de ejercicios al cliente
     * @param rutinaId Identificador de la rutina (ej: "RUTINA_PIERNA")
     */
    public void agregarRutina(String rutinaId){
        this.rutinaAsignada = rutinaId;
    }
    
    // === GETTERS Y SETTERS ===
    public String getRutinasAsignadas() {
        return rutinaAsignada;
    }

    public void setRutinasAsignadas(String rutinaAsignada) {
        this.rutinaAsignada = rutinaAsignada;
    }
    
    /**
     * Verifica si el cliente está activo
     * @return true si está activo, false si está inactivo
     */
    public boolean isActivo() {
        return activo;
    }
    
    /**
     * Cambia el estado de actividad del cliente
     * @param activo Nuevo estado (true para activar, false para desactivar)
     */
    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    // === MÉTODOS ESPECIALES ===
    
    /**
     * Devuelve una representación en texto de los datos del cliente
     * @return Cadena con toda la información formateada
     */
    @Override
    public String toString(){
        return "Cliente: " +
                "Username: " + getUsername() +
                ", Nombre: " + getNombre() +
                ", Identificacion: " + getIdentificacion() +
                ", Rutinas: " + rutinaAsignada;
    }

      /**
     * Convierte los datos del cliente a formato CSV para guardar en archivos
     * @return Cadena con los datos separados por comas
     */
    public String toCSVString() {
    return String.join(",",
        this.username,
        this.password,
        this.nombre,
        this.identificacion,
        this.rutinaAsignada);
    }
}
