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

/**
 * Controlador especializado para el inicio de sesión de administradores.
 * Hereda funcionalidades básicas de LoginController y añade características específicas para administradores.
 * Es como el "guardián de seguridad" que verifica la identidad de los administradores del sistema.
 */
public class AdminLoginController extends LoginController{
    private final AdministradorService administradorService; // El "asistente especializado" que sabe cómo autenticar administradores
    private final LoginAdminView loginView; // La pantalla de inicio de sesión específica para administradores
    
    /**
     * Constructor: Prepara el sistema de autenticación para administradores.
     * @param repository El "archivo de registros" donde se guardan los datos de usuarios
     * @param loginView La pantalla de login que verá el administrador
     */
        public AdminLoginController(UsuarioRepository repository, LoginAdminView loginView) {
                // Primero configura las partes básicas heredadas del sistema general de login
                super(repository); 
                this.administradorService = new AdministradorService((AdministradorRepository) repository); // Luego prepara los componentes específicos para administradores:
                this.loginView = loginView;

                // Configura el botón "Iniciar Sesión" para que al hacer clic:
                // 1. Tome el usuario y contraseña ingresados
                // 2. Verifique si son credenciales válidas de administrador
                this.loginView.BtnIniciarSesion.addActionListener(e -> iniciarSesion());
                }

                /**
             * Método que realiza el proceso completo de autenticación:
             * 1. Recoge las credenciales ingresadas
             * 2. Las verifica contra el sistema
             * 3. Da acceso o muestra mensajes de error según el resultado
             */
        private void iniciarSesion() {
            // Obtiene el nombre de usuario y contraseña que se escribieron
                String username = loginView.getUsername();
                String password = loginView.getPassword();
                
                try {
                    Administrador admin = administradorService.autenticar(username, password); // Pide al "asistente especializado" que verifique las credenciales
                    if (admin != null) {
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

