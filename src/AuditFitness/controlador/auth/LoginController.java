/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AuditFitness.controlador.auth;

import AuditFitness.modelo.entidades.Usuario;
import AuditFitness.modelo.repository.UsuarioRepository;

import java.util.List;

/**
 *
 * @author deana
 */

/**
 * Clase base abstracta que contiene la lógica común para todos los tipos de login.
 * Es como el "manual de procedimientos" básico que todos los sistemas de acceso deben seguir,
 * pero que cada tipo de usuario (administrador, entrenador, cliente) personaliza a su manera.
 */
public abstract class LoginController {
    private final UsuarioRepository userRepository; // El "archivador general" donde se guardan todos los usuarios del sistema
    
    /**
     * Constructor: Establece la conexión con el archivador de usuarios.
     * @param userRepository El lugar donde están guardados todos los registros de usuarios
     */
    public LoginController(UsuarioRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    /**
     * Método protegido que verifica si unas credenciales son válidas para un rol específico.
     * Es como el "procedimiento estándar" para comprobar identidades en el sistema.
     * 
     * @param username Nombre de usuario a verificar
     * @param password Contraseña a validar
     * @param role Tipo de usuario (administrador, entrenador o cliente)
     * @return true si las credenciales son correctas para ese rol, false si no lo son
     */
    protected boolean validarCredenciales(String username, String password, String role) {
        List<Usuario> users = userRepository.readUsersFromCSV(); // Obtiene la lista completa de usuarios registrados
        
        // Prepara el sistema para recordar al usuario durante su sesión
        SesionSingleton sesion = SesionSingleton.getInstance();
        sesion.setIdenficacionSes(username);
        
        // Busca entre todos los usuarios si existe alguno que cumpla:
        // 1. Que el nombre de usuario coincida exactamente
        // 2. Que la contraseña sea la correcta
        // 3. Que tenga el rol específico que estamos verificando
        return users.stream()
                .anyMatch(user ->
                        user.getUsername().equals(username.trim()) &&
                                user.getPassword().equals(password.trim()) &&
                                user.getRole().equals(role)
                );
    }
}
