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
 * Clase base abstracta que representa a cualquier usuario del sistema del gimnasio.
 * Es como la "plantilla general" para todos los tipos de usuarios (clientes, entrenadores, administradores).
 * 
 * Contiene la información común que todos comparten:
 * - Credenciales de acceso
 * - Datos personales básicos
 * - Tipo de rol (permisos)
 */
    public abstract class Usuario {
        private UsuarioRole role; // Tipo de usuario (CLIENTE, ENTRENADOR o ADMINISTRADOR)
        String username; // Nombre de usuario para iniciar sesión
        String password; // Contraseña de acceso (almacenada de forma segura)
        String nombre; // Nombre real
        String identificacion; // Número de identificación único

    // === CONSTRUCTOR ===
    
    /**
     * Crea un nuevo usuario con información básica
     * @param username Nombre de usuario (sin espacios extras)
     * @param password Contraseña (sin espacios extras)
     * @param nombre Nombre completo (sin espacios extras)
     * @param identificacion Número único de identificacion
     * @param role Tipo de usuario (rol)
     */
    public Usuario(String username, String password, String nombre, String identificacion, UsuarioRole role) {
        // Asigna y limpia los espacios en blanco sobrantes:
        this.username = username.trim(); 
        this.password = password.trim();
        this.nombre = nombre.trim();
        this.identificacion = identificacion.trim();
        this.role = role;
    }

    // Getters y Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username.trim(); // Trim para limpiar espacios
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password.trim();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre.trim();
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion.trim();
    }

    public UsuarioRole getRole() {
        return role;
    }

    // === MÉTODOS ESPECIALES ===
    
    /**
     * Convierte los datos del usuario a formato CSV para guardar en archivos
     * @return Cadena con los datos separados por comas
     */
    public String toCSVString(){
        return String.join(",",
                this.username,
                this.username,
                this.password,
                this.nombre,
                this.identificacion,
                this.role.name()); // Convierte el rol a texto
    }

    /**
     * Método abstracto que cada tipo de usuario debe implementar
     * @return Representación personalizada en texto del usuario
     */
    public abstract String toString();
}
