/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AuditFitness.controlador.auth;


import AuditFitness.modelo.entidades.Administrador;
import AuditFitness.modelo.repository.AdministradorRepository;
import AuditFitness.modelo.repository.UsuarioRepository;
import AuditFitness.modelo.service.AdministradorService;
import AuditFitness.vista.auth.LoginAdminView;



/**
 *
 * @author deana
 */
public class AdminLoginController extends LoginController{
    private final AdministradorService administradorService;
    private final LoginAdminView loginView;
    
    
public AdminLoginController(UsuarioRepository repository, LoginAdminView loginView) {
        super(repository); // Llamar al constructor de la clase base
        this.administradorService = new AdministradorService((AdministradorRepository) repository);
        this.loginView = loginView;
        // Configurar el ActionListener para el botón de login
        this.loginView.BtnIniciarSesion.addActionListener(e -> iniciarSesion());
        }
    private void iniciarSesion() {
        String username = loginView.getUsername();
        String password = loginView.getPassword();
        try {
            Administrador admin = administradorService.autenticar(username, password);
            if (admin != null) {
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

