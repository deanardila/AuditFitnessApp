/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Singleton.java to edit this template
 */
package AuditFitness.controlador.auth;

/**
 *
 * @author deana
 */

/**
 * Clase especial que maneja la información de la sesión del usuario actual.
 * Es como un "carnet virtual" que guarda temporalmente quién está usando el sistema.
 * 
 * Características principales:
 * - Solo puede existir UNA instancia en todo el programa (Singleton)
 * - Almacena datos clave del usuario logueado
 * - Está disponible desde cualquier parte de la aplicación
 */
public class SesionSingleton {
    public String idenficacionSes = null; // Número de identificación del usuario en sesión (como una cedula virtual)
    private String nombre; // Nombre del usuario actualmente logueado
    
    /**
     * Constructor PRIVADO: Nadie puede crear nuevas instancias directamente.
     * Esto garantiza que solo habrá una sesión activa en todo momento.
     */
    private SesionSingleton() {
    }
    
    /**
     * Método para obtener la única instancia permitida de la sesión.
     * @return La sesión activa (si no existe, crea una nueva)
     */
    public static SesionSingleton getInstance() {
        return SesionSingletonHolder.INSTANCE;
    }
    
    /**
     * Clase interna que guarda la única instancia permitida.
     * Es como una caja fuerte que protege el único carnet de sesión.
     */
    private static class SesionSingletonHolder {
        private static final SesionSingleton INSTANCE = new SesionSingleton(); // La única instancia permitida en toda la aplicación
    }

   // === MÉTODOS PARA ACCEDER A LOS DATOS DE LA SESIÓN ===
    
    /**
     * Obtiene el número de identificación del usuario en sesión
     * @return El ID del usuario logueado
     */
    public String getIdenficacionSes() {
        return idenficacionSes;
    }
    
    /**
     * Establece/actualiza el número de identificación en la sesión
     * @param idenficacionSes El nuevo ID a guardar
     */
    public void setIdenficacionSes(String idenficacionSes) {
        this.idenficacionSes = idenficacionSes;
    }
    
    /**
     * Obtiene el nombre del usuario en sesión
     * @return El nombre guardado
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Establece/actualiza el nombre en la sesión
     * @param nombre El nuevo nombre a guardar
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    } 
}
