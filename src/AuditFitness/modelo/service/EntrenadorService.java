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
public class EntrenadorService {
    private final EntrenadorRepository entrenadorRepository;
    private static final String RUTA_ENTRENADORES_CSV = "src/data/entrenadores.csv"; // Ruta al archivo CSV 
    
    //Inyeccion de dependencia por constructor
    public EntrenadorService(EntrenadorRepository entrenadorRepository){
        this.entrenadorRepository = entrenadorRepository;
    }

    public Entrenador autenticar(String username, String password){
       if (username == null || username.trim().isEmpty() || password == null || password.trim().isEmpty()){
           throw new IllegalArgumentException("Username y password son requeridos");
       }
       try {
           Entrenador entrenador = entrenadorRepository.buscarPorUsername(username.trim());
           if (entrenador != null && entrenador.getPassword().equals(password.trim())) {
               return entrenador; //Autenticacion exitosa
           }
       } catch (IOException e) {
           e.printStackTrace(); // Manejo de excepciones
            }
           return null; //Credenciales invalidas
    }
    
    public Entrenador buscarEntrenadorPorIdentificacion(String Identificacion) {
        try (BufferedReader br = new BufferedReader(new FileReader(RUTA_ENTRENADORES_CSV))) {
            String linea;
            while ((linea = br.readLine()) != null) {
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
            e.printStackTrace();
        }
        return null; // Retornar null si no se encuentra el entrenador
    }
}
