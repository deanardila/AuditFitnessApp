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
public class ClienteLoginController extends LoginController {

    private final ClienteService ClienteService;
    private final LoginClienteView loginView;

    public ClienteLoginController(UsuarioRepository repository, LoginClienteView loginView) {
        super(repository);
        this.ClienteService = new ClienteService((ClienteRepository) repository);
        this.loginView = loginView;
        this.loginView.BtnIniciarSesion.addActionListener(e -> iniciarSesion());
    }

    private void iniciarSesion() {
        String username = loginView.getUsername();
        String password = loginView.getPassword();
        try {
            Cliente cliente = ClienteService.autenticar(username, password);
            if (cliente != null) {
                // Autenticación exitosa
                SesionSingleton sesion = SesionSingleton.getInstance();
                sesion.setIdenficacionSes(username);
                loginView.mostrarMensaje("Login exitoso como Cliente");
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
