/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AuditFitness.controlador.auth;

import AuditFitness.modelo.entidades.Entrenador;
import AuditFitness.modelo.repository.EntrenadorRepository;
import AuditFitness.modelo.repository.UsuarioRepository;
import AuditFitness.modelo.service.EntrenadorService;
import AuditFitness.vista.auth.LoginEntrenadorView;

/**
 *
 * @author deana
 */
public class EntrenadorLoginController extends LoginController {
    private final EntrenadorService entrenadorService;
    private final LoginEntrenadorView loginView;
    
    public EntrenadorLoginController(UsuarioRepository repository, LoginEntrenadorView loginView) {
        super(repository); // Llamar al constructor de la clase base
        this.entrenadorService = new EntrenadorService((EntrenadorRepository) repository);
        this.loginView = loginView;
        // Configurar el ActionListener para el botón de login
        this.loginView.BtnIniciarSesion.addActionListener(e -> iniciarSesion());
        }
    private void iniciarSesion() {
        String username = loginView.getUsername();
        String password = loginView.getPassword();
        try {
            Entrenador entrenador = entrenadorService.autenticar(username, password);
            if (entrenador != null) {
                // Autenticación exitosa
                loginView.mostrarMensaje("Login exitoso como Administrador");
                // Aquí puedes redirigir a la vista correspondiente
            } else {
                // Credenciales inválidas
                loginView.mostrarMensaje("Credenciales inválidas");
                }
            } catch (Exception e) {
            // Manejo de excepciones
            loginView.mostrarMensaje("Error durante la autenticación: " + e.getMessage());
        }
    }
}
