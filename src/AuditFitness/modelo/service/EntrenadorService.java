/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AuditFitness.modelo.service;

import AuditFitness.modelo.entidades.Entrenador;
import AuditFitness.modelo.repository.EntrenadorRepository;
import java.io.IOException;

/**
 *
 * @author deana
 */
public class EntrenadorService {
    private final EntrenadorRepository entrenadorRepository;

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
}
