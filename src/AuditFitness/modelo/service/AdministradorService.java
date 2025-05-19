/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AuditFitness.modelo.service;

import AuditFitness.modelo.entidades.Administrador;
import AuditFitness.modelo.repository.AdministradorRepository;
import java.io.IOException;

/**
 *
 * @author deana
 */
/**
 * Clase que maneja la lógica de negocio relacionada con los administradores.
 * Es como el "oficial de seguridad" que verifica las credenciales de acceso
 * y controla las operaciones que pueden realizar los administradores.
 */
public class AdministradorService {
    private final AdministradorRepository repository; // Conexión con el "archivo de registros" de administradores

    /**
     * Constructor que recibe el repositorio de administradores.
     * Esto es como darle al oficial de seguridad acceso al archivo de credenciales.
     * @param repository El repositorio que maneja el almacenamiento de administradores
     */
    public AdministradorService(AdministradorRepository repository){
        this.repository = repository;
    }

    /**
     * Verifica si un nombre de usuario y contraseña son válidos para un administrador.
     * Es como cuando el oficial de seguridad chequea tu credencial en la entrada.
     * 
     * @param username Nombre de usuario proporcionado
     * @param password Contraseña proporcionada
     * @return El administrador autenticado si las credenciales son correctas, null si no
     * @throws IllegalArgumentException Si no se proporcionan username o password
     */
    public Administrador autenticar(String username, String password){
       if (username == null || username.trim().isEmpty() || password == null || password.trim().isEmpty()){
           throw new IllegalArgumentException("Username y password son requeridos");
       }
       try {
           Administrador admin = repository.buscarPorUsername(username.trim()); // Busca el administrador en los registros
           if (admin != null && admin.getPassword().equals(password.trim())) { // Verifica si existe y si la contraseña coincide
               return admin; //Autenticacion exitosa
           }
       } catch (IOException e) {
           e.printStackTrace(); // Manejo de excepciones
            }
           return null; //Credenciales invalidas
    }
}

