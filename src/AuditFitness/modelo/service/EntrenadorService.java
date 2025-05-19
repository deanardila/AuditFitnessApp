/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AuditFitness.modelo.service;

import AuditFitness.modelo.entidades.Entrenador;
import AuditFitness.modelo.repository.EntrenadorRepository;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author deana
 */

/**
 * Clase que maneja todas las operaciones relacionadas con entrenadores en el sistema.
 * Actúa como el "coordinador de entrenadores" que gestiona su autenticación y búsqueda.
 */
public class EntrenadorService {
    private final EntrenadorRepository entrenadorRepository; // Conexión con el archivo donde se guardan los entrenadores
    private static final String RUTA_ENTRENADORES_CSV = "src/data/entrenadores.csv"; // Ubicación del archivo CSV con datos de entrenadores
    /**
     * Constructor que configura el servicio con acceso al repositorio de entrenadores.
     * @param entrenadorRepository El "archivo de registros" de entrenadores
     */
    public EntrenadorService(EntrenadorRepository entrenadorRepository){
        this.entrenadorRepository = entrenadorRepository;
    }

    /**
     * Verifica las credenciales de un entrenador para permitir su acceso al sistema.
     * @param username Nombre de usuario del entrenador
     * @param password Contraseña del entrenador
     * @return El entrenador autenticado si es correcto, null si no
     * @throws IllegalArgumentException Si faltan username o password
     */
    public Entrenador autenticar(String username, String password){
        // Validación básica de datos de entrada
       if (username == null || username.trim().isEmpty() || password == null || password.trim().isEmpty()){
           throw new IllegalArgumentException("Username y password son requeridos");
       }
       try {
           // Buscar el entrenador en los registros
           Entrenador entrenador = entrenadorRepository.buscarPorUsername(username.trim());
           // Verificar si existe y si la contraseña coincide
           if (entrenador != null && entrenador.getPassword().equals(password.trim())) {
               return entrenador; //Autenticacion exitosa
           }
       } catch (IOException e) {
           e.printStackTrace(); // Error al acceder a los datos
            }
           return null; //Credenciales invalidas
    }
    
    /**
     * Busca un entrenador por su número de identificación único.
     * @param Identificacion Número de identificación a buscar
     * @return El entrenador encontrado o null si no existe
     */
    public Entrenador buscarEntrenadorPorIdentificacion(String Identificacion) {
        try (BufferedReader br = new BufferedReader(new FileReader(RUTA_ENTRENADORES_CSV))) {
            String linea;
            while ((linea = br.readLine()) != null) { // Leer el archivo línea por línea
                String[] datos = linea.split(","); // Los datos están separados por comas
                String username = datos[0];
                String password = datos[1];
                String nombre = datos[2];
                String identificacion = datos[3];
                // Verificar si la identificacion coincide
                if (identificacion.equals(Identificacion)) {
                    return new Entrenador(username, password, nombre, identificacion); // Retornar el entrenador encontrado
                }
            }
        } catch (IOException e) {
            e.printStackTrace(); // Error al leer el archivo
        }
        return null; // Entrenador no encontrado
    }
}
