/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AuditFitness.controlador.entrenador;

import AuditFitness.modelo.entidades.Rutina;
import AuditFitness.modelo.service.RutinaService;
import AuditFitness.vista.cliente.ClienteMenuView;
import AuditFitness.vista.cliente.VerMisRutinasView;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author deana
 */
public class AsignarRutinaController {
    private final ClienteMenuView vistaMenu; // Vista del menú del cliente
    private final RutinaService rutinaService; // Servicio para manejar las rutinas
    
    public AsignarRutinaController(ClienteMenuView vistaMenu, RutinaService rutinaService) {
        this.vistaMenu = vistaMenu;
        this.rutinaService = rutinaService;
        // Agregar el ActionListener al botón "Ver Rutinas"
        this.vistaMenu.agregarListenerBotonVerMisRutinas(e -> verMisRutinas());
    }
    private void verMisRutinas() {
        VerMisRutinasView verMisRutinasView = new VerMisRutinasView();
        List<Rutina> todasLasRutinas = new ArrayList<>();
        // Cargar rutinas desde los archivos CSV
        todasLasRutinas.addAll(rutinaService.obtenerRutinas("espalda_biceps.csv"));
        todasLasRutinas.addAll(rutinaService.obtenerRutinas("hombro_abdomen.csv"));
        todasLasRutinas.addAll(rutinaService.obtenerRutinas("pecho_triceps.csv"));
        todasLasRutinas.addAll(rutinaService.obtenerRutinas("pierna.csv"));
        // Preparar las rutinas para mostrar en la vista
        List<String[]> rutinasParaMostrar = new ArrayList<>();
        for (Rutina rutina : todasLasRutinas) {
            rutinasParaMostrar.add(new String[]{rutina.getNombre(), String.valueOf(rutina.getRepeticiones()), String.valueOf(rutina.getSeries())});
        }
        // Mostrar las rutinas en la vista
        verMisRutinasView.mostrarRutinas(rutinasParaMostrar);
    }
}
