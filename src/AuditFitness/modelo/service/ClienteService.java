/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AuditFitness.modelo.service;

import AuditFitness.modelo.entidades.Cliente;
import AuditFitness.modelo.repository.ClienteRepository;
import java.io.IOException;


/**
 *
 * @author deana
 */
public class ClienteService {
    private final ClienteRepository clienteRepository;

    // Inyección de dependencia (requiere ClienteRepository)
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente autenticar(String username, String password){
       if (username == null || username.trim().isEmpty() || password == null || password.trim().isEmpty()){
           throw new IllegalArgumentException("Username y password son requeridos");
       }
       try {
           Cliente cliente = clienteRepository.buscarPorUsername(username.trim());
           if (cliente != null && cliente.getPassword().equals(password.trim())) {
               return cliente; //Autenticacion exitosa
           }
       } catch (IOException e) {
           e.printStackTrace(); // Manejo de excepciones
            }
           return null; //Credenciales invalidas
    }
}

