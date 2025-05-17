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
public class AddEntrenadorController {
     private final AgregarEntrenadorView vista;
    private final EntrenadorService entrenadorService; // Servicio para manejar entrenadores
    
    public AddEntrenadorController(AgregarEntrenadorView vista, EntrenadorService entrenadorService) {
       this.vista = vista;
        this.entrenadorService = entrenadorService;
        // Agregar ActionListener al botón de verificar
        vista.agregarListenerVerificar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verificarEntrenador();
            }
        });
    }
        private void verificarEntrenador() {
        String Identificacion = vista.getIdentificacion(); // Obtener la identificacion ingresada
        // Verificar si el cliente existe
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
