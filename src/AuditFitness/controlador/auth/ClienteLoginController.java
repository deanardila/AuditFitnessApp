/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AuditFitness.controlador.auth;

import AuditFitness.modelo.entidades.Cliente;
import AuditFitness.modelo.repository.ClienteRepository;
import AuditFitness.modelo.repository.UsuarioRepository;
import AuditFitness.modelo.service.ClienteService;
import AuditFitness.vista.auth.LoginClienteView;

/**
 *
 * @author deana
 */
/**
 * Controlador especializado para el inicio de sesión de clientes.
 * Hereda funcionalidades básicas de LoginController y añade características específicas para clientes.
 * Actúa como el "portero virtual" que verifica la identidad de los clientes del sistema.
 */
public class ClienteLoginController extends LoginController {
    private final ClienteService ClienteService; // El "asistente especial" que sabe cómo validar credenciales de clientes
    private final LoginClienteView loginView; // La pantalla de inicio de sesión diseñada específicamente para clientes

     /**
     * Constructor: Prepara el sistema de login para clientes.
     * @param repository El "libro de registros" donde se guardan los datos de clientes
     * @param loginView La ventana de login que verán los clientes
     */
    public ClienteLoginController(UsuarioRepository repository, LoginClienteView loginView) { 
        super(repository); // Primero configura las partes básicas heredadas del sistema general de login
        
        // Luego prepara los componentes específicos para clientes:
        this.ClienteService = new ClienteService((ClienteRepository) repository);
        this.loginView = loginView;
        
         // Configura el botón "Iniciar Sesión" para que al hacer clic:
        // 1. Capture el usuario y contraseña ingresados
        // 2. Verifique si corresponden a un cliente registrado
        this.loginView.BtnIniciarSesion.addActionListener(e -> iniciarSesion());
    }
    
    /**
     * Método que maneja todo el proceso de inicio de sesión:
     * 1. Recoge las credenciales ingresadas
     * 2. Las valida con el sistema
     * 3. Inicia la sesión si son correctas o muestra errores si falla
     */
    private void iniciarSesion() {
        // Obtiene el nombre de usuario y contraseña del formulario
        String username = loginView.getUsername();
        String password = loginView.getPassword();
        try {
            Cliente cliente = ClienteService.autenticar(username, password); // Pide al "asistente especial" que verifique las credenciales
            if (cliente != null) {
                // Autenticación exitosa
                SesionSingleton sesion = SesionSingleton.getInstance(); // Crea una "sesión virtual" para recordar que este cliente está logueado
                sesion.setIdenficacionSes(username);
                // Muestra mensaje de bienvenida
                loginView.mostrarMensaje("Login exitoso como Cliente");
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
