/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AuditFitness.controlador.admin;

import AuditFitness.modelo.entidades.Entrenador;
import AuditFitness.modelo.service.EntrenadorService;
import AuditFitness.vista.admin.AgregarEntrenadorView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author deana
 */
/**
 * Esta clase es el "cerebro" detrás de la pantalla para agregar entrenadores.
 * Coordina entre lo que el usuario ve y las operaciones con los datos de entrenadores.
 * Funciona como un asistente que gestiona el registro y consulta de entrenadores.
 */
public class AddEntrenadorController {
     private final AgregarEntrenadorView vista; // La pantalla/interfaz que el usuario ve para gestionar entrenadores
    private final EntrenadorService entrenadorService; // El "asistente experto" que sabe cómo buscar y manejar información de entrenadores
    
    /**
     * Constructor: Prepara todo el sistema para gestionar entrenadores.
     * @param vista La pantalla/interfaz que verá el usuario
     * @param entrenadorService El especialista que maneja los datos de entrenadores
     */
    public AddEntrenadorController(AgregarEntrenadorView vista, EntrenadorService entrenadorService) {
       this.vista = vista;
        this.entrenadorService = entrenadorService;
        // Configura el botón "Verificar" para que al hacer clic:
       // 1. Tome la identificación ingresada
       // 2. Verifique si el entrenador existe
        new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verificarEntrenador();
            }
        };
    }
     /**
     * Método que verifica si un entrenador está registrado en el sistema.
     * - Si existe: muestra su información en formato de tabla
     * - Si no existe: abre el formulario de registro nuevo
     */
        private void verificarEntrenador() {
        String Identificacion = vista.getIdentificacion();  // Obtiene el número de identificación que el usuario escribió
        
        // Consulta al "asistente experto" si existe un entrenador con esa identificación
        Entrenador entrenador = entrenadorService.buscarEntrenadorPorIdentificacion(Identificacion);
        if (entrenador != null) {
            // Si el cliente existe, mostrarlo en la tabla
            Object[][] data = {
                {entrenador.getUsername(), entrenador.getNombre(), entrenador.getIdentificacion()} 
            };
            String[] columnNames = {"Username", "Nombre", "Identificación"};
            vista.mostrarEntrenadores(data, columnNames); // Mostrar el entrenador en la tabla
        } else {
            // Si no existe, mostrar el formulario para registrar un nuevo cliente
            vista.abrirFormularioEntrenadoresView();
        }
        
    }
}
