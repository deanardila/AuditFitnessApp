/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AuditFitness.controlador.admin;

import AuditFitness.modelo.entidades.Cliente;
import AuditFitness.modelo.service.ClienteService;
import AuditFitness.vista.admin.AgregarClientesView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 *
 * @author deana
 */
public class AddClienteController {
   private final AgregarClientesView vista;
    private final ClienteService clienteService; // Servicio para manejar clientes
    
    public AddClienteController(AgregarClientesView vista, ClienteService clienteService) {
       this.vista = vista;
        this.clienteService = clienteService;
        // Agregar ActionListener al botón de verificar
        vista.agregarListenerVerificar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verificarCliente();
            }
        });
        
    }
    
    private void verificarCliente() {
        String Identificacion = vista.getIdentificacion(); // Obtener la identificacion ingresada
        // Verificar si el cliente existe
        Cliente cliente = clienteService.buscarClientePorIdentificacion(Identificacion);
        if (cliente != null) {
            // Si el cliente existe, mostrarlo en la tabla
            Object[][] data = {
                {cliente.getUsername(), cliente.getNombre(), cliente.getIdentificacion()} 
            };
            String[] columnNames = {"Username", "Nombre", "Identificación"};
            vista.mostrarClientes(data, columnNames); // Mostrar el cliente en la tabla
        } else {
            // Si no existe, mostrar el formulario para registrar un nuevo cliente
            vista.abrirFormularioClientesView();
        }
    }
}
