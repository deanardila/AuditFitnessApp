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

/**
 * Controlador especializado para el inicio de sesión de entrenadores.
 * Hereda funcionalidades básicas de LoginController y añade características específicas para entrenadores.
 * Actúa como el "control de acceso" exclusivo para los instructores del sistema.
 */
public class EntrenadorLoginController extends LoginController {
    private final EntrenadorService entrenadorService; // El "verificador oficial" de credenciales de entrenadores
    private final LoginEntrenadorView loginView; // La pantalla de acceso diseñada específicamente para entrenadores
    
    /**
     * Constructor: Configura el sistema de autenticación para entrenadores.
     * @param repository El "archivo maestro" donde se guardan los datos de entrenadores
     * @param loginView La interfaz de login especial para entrenadores
     */
    public EntrenadorLoginController(UsuarioRepository repository, LoginEntrenadorView loginView) {
        super(repository); // Configura las partes básicas heredadas del sistema general de login
        
        // Prepara los componentes exclusivos para entrenadores:
        this.entrenadorService = new EntrenadorService((EntrenadorRepository) repository);
        this.loginView = loginView;
        
        // Programa el botón "Iniciar Sesión" para que al presionarlo:
        // 1. Recoja las credenciales ingresadas
        // 2. Verifique si pertenecen a un entrenador autorizado
        this.loginView.BtnIniciarSesion.addActionListener(e -> iniciarSesion());
        }
    
    /**
     * Método que realiza el proceso completo de validación para entrenadores:
     * 1. Captura usuario y contraseña
     * 2. Los compara con los registros autorizados
     * 3. Otorga acceso o informa errores
     */
    private void iniciarSesion() {
        // Obtiene las credenciales del formulario
        String username = loginView.getUsername();
        String password = loginView.getPassword();
        try {
            Entrenador entrenador = entrenadorService.autenticar(username, password); // Solicita al "verificador oficial" que confirme las credenciales
            if (entrenador != null) {
                // Autenticación exitosa
                loginView.mostrarMensaje("Login exitoso como Administrador");
                // Aquí va a redirigir a la vista correspondiente
            } else {
                // Credenciales inválidas
                loginView.mostrarMensaje("Credenciales inválidas");
                }
            } catch (Exception e) {
           // SI HAY ALGÚN ERROR INESPERADO:
            loginView.mostrarMensaje("Error durante la autenticación: " + e.getMessage());
        }
    }
}
