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
public abstract class LoginController {
    private final UsuarioRepository userRepository;
    
    public LoginController(UsuarioRepository userRepository) {
        this.userRepository = userRepository;
    }
    protected boolean validarCredenciales(String username, String password, String role) {
        List<Usuario> users = userRepository.readUsersFromCSV();
        
        SesionSingleton sesion = SesionSingleton.getInstance();
        sesion.setIdenficacionSes(username);
        
        return users.stream()
                .anyMatch(user ->
                        user.getUsername().equals(username.trim()) &&
                                user.getPassword().equals(password.trim()) &&
                                user.getRole().equals(role)
                );
    }
}
