/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AuditFitness.modelo.repository;

import AuditFitness.modelo.entidades.Asistencia;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author deana
 */
public class AsistenciaRepositoryImpl {
    private final String ARCHIVO_ASISTENCIA = "src/data/asistencias.csv";
    
    public Asistencia crear (Asistencia asistencia){
        try( BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO_ASISTENCIA, true))){
            bw.write(asistencia.getUsernameCliente() + "," + asistencia.getFecha().toString());
            bw.newLine();
            
            return asistencia;
        } catch(Exception e) {
            System.out.println("No se ha podido crear la asistencia");
            return null;
        }
    }
    
    public List<Asistencia> listar() {
    List<Asistencia> asistencias = new ArrayList<>(); // Initialize the list
    try(BufferedReader br = new BufferedReader(new FileReader(ARCHIVO_ASISTENCIA))) {
        String line;
        
        br.readLine(); // Skip header line
        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");
            if (data.length == 2) { // Verify 2 fields
                Asistencia asistencia = new Asistencia(data[0], LocalDate.parse(data[1]));
                asistencias.add(asistencia);
            }
        }
        
        return asistencias;
    } catch (Exception e) {
        System.out.println("Error reading file: " + e.getMessage());
        e.printStackTrace(); // Better error handling
        return new ArrayList<>(); // Return empty list instead of null
    }
}
}
