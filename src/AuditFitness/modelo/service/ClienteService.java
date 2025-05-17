/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AuditFitness.modelo.service;

import AuditFitness.modelo.entidades.Cliente;
import AuditFitness.modelo.repository.ClienteRepository;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


/**
 *
 * @author deana
 */
public class ClienteService {
    private final ClienteRepository clienteRepository;
    private static final String RUTA_CLIENTES_CSV = "src/data/clientes.csv"; // Ruta al archivo CSV
    
    // Inyección de dependencia 
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
    
    public Cliente buscarClientePorIdentificacion(String Identificacion) {
        try (BufferedReader br = new BufferedReader(new FileReader(RUTA_CLIENTES_CSV))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(","); // Los datos están separados por comas
                String username = datos[0];
                String password = datos[1];
                String nombre = datos[2];
                String identificacion = datos[3];
                // Verificar si la identificacion coincide
                if (identificacion.equals(Identificacion)) {
                    return new Cliente(username, password, nombre, identificacion); // Retornar el cliente encontrado
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null; // Retornar null si no se encuentra el cliente
    }
}

