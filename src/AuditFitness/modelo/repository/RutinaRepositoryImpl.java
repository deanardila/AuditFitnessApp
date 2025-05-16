/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AuditFitness.modelo.repository;

import AuditFitness.modelo.entidades.Rutina;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author deana
 */
public class RutinaRepositoryImpl implements RutinaRepository{
    @Override
    public List<Rutina> cargarRutinasDesdeCSV(String nombreArchivo) {
        List<Rutina> rutinas = new ArrayList<>();
        String linea;
        String rutaArchivo = "src/data/rutinas/" + nombreArchivo; 
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                Rutina rutina = new Rutina(datos[0], Integer.parseInt(datos[1]), Integer.parseInt(datos[2]));
                rutinas.add(rutina);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rutinas;
    }
}
