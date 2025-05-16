/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package AuditFitness.modelo.repository;

import AuditFitness.modelo.entidades.Rutina;
import java.util.List;

/**
 *
 * @author deana
 */
public interface RutinaRepository {
   List<Rutina> cargaRutinasDesdeCSV(String nombreArchivo);

    public List<Rutina> cargarRutinasDesdeCSV(String nombreArchivo);
}
