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
 * Clase que representa a un usuario Administrador en el sistema.
 * Hereda todas las características básicas de un Usuario común,
 * pero con privilegios y responsabilidades especiales.
 * 
 * Es como el "supervisor" o "gerente" de la aplicación,
 * con acceso a funciones de configuración y gestión global.
 */
public class Administrador extends Usuario {
     /**
     * Constructor para crear un nuevo Administrador
     * @param username Nombre de usuario para iniciar sesión (como un ID digital)
     * @param password Contraseña de acceso (clave secreta)
     * @param nombre Nombre real del administrador (ej: "Juan Pérez")
     * @param identificacion Número único de identificación (como un DNI administrativo)
     */
    public Administrador(String username, String password, String nombre, String identificacion){
        // Configura los datos básicos usando la clase padre (Usuario)
        // y asigna automáticamente el rol de ADMINISTRADOR
        super(username, password, nombre, identificacion, UsuarioRole.ADMINISTRADOR);
    }
    
    /**
     * Método que devuelve una representación en texto del Administrador
     * @return Cadena de texto con los datos clave formateados
     */
    @Override
    public String toString(){
        return "Administrador: " +
                "Username: " + getUsername() +
                ", Nombre: " + getNombre() +
                ", Identificacion: " + getIdentificacion();
    }
}
