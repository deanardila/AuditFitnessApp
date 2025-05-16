/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AuditFitness.modelo.service;

import AuditFitness.modelo.entidades.Rutina;
import AuditFitness.modelo.repository.RutinaRepository;
import java.util.List;

/**
 *
 * @author deana
 */
public class RutinaService {
    private final RutinaRepository rutinaRepository;
    public RutinaService(RutinaRepository rutinaRepository) {
        this.rutinaRepository = rutinaRepository;
    }
    public List<Rutina> obtenerRutinas(String nombreArchivo) {
        return rutinaRepository.cargarRutinasDesdeCSV(nombreArchivo);
    }
}
