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
/**
 * Esta clase actúa como el "cerebro" detrás de la pantalla para agregar clientes.
 * Se encarga de coordinar entre lo que el usuario ve (la vista) y 
 * las operaciones con los datos (el servicio).
 */
public class AddClienteController {
   private final AgregarClientesView vista; // La pantalla/interfaz que el usuario ve para agregar clientes
   private final ClienteService clienteService; // El "ayudante" que sabe cómo buscar y manejar información de clientes
    
   /**
    * Constructor: Prepara todo para que funcione la pantalla de agregar clientes.
    * @param vista La pantalla que verá el usuario
    * @param clienteService El ayudante para manejar datos de clientes
    */
    public AddClienteController(AgregarClientesView vista, ClienteService clienteService) {
       this.vista = vista;
        this.clienteService = clienteService;
        
        // Configura el botón "Verificar" para que cuando se haga clic,
       // ejecute la acción de verificar el cliente
        new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verificarCliente();
            }
        };
        
    }
    
     /**
    * Método que verifica si un cliente ya existe en el sistema.
    * - Si existe: muestra su información en una tabla
    * - Si no existe: abre el formulario para registrarlo como nuevo cliente
    */
    private void verificarCliente() {
        String Identificacion = vista.getIdentificacion(); // Obtiene el número de identificación que el usuario escribió
        // Verificar si el cliente existe
        Cliente cliente = clienteService.buscarClientePorIdentificacion(Identificacion); // Pregunta al "ayudante" si existe un cliente con esa identificación
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
