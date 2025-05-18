/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AuditFitness.modelo.repository;

import AuditFitness.modelo.entidades.Progreso;
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
public class ProgresoRepositoryImpl {
    private final String ARCHIVO_ASISTENCIA = "src/data/progresos.csv";
    
    public Progreso crear (Progreso progreso){
        try( BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO_ASISTENCIA, true))){
            bw.write(progreso.getClienteId()+ "," + progreso.getPeso() +  "," + progreso.getFecha().toString() );
            bw.newLine();
            
            return progreso;
        } catch(Exception e) {
            System.out.println("No se ha podido crear el progreso");
            return null;
        }
    }
    
    public List<Progreso> listar() {
    List<Progreso> progresos = new ArrayList<>(); // Initialize the list
    try(BufferedReader br = new BufferedReader(new FileReader(ARCHIVO_ASISTENCIA))) {
        String line;
        
        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");
            if (data.length == 3) { // Verify 2 fields
                Progreso progreso = new Progreso(data[0], Double.parseDouble(data[1]), LocalDate.parse(data[2]));
                progresos.add(progreso);
            }
        }
        
        return progresos;
    } catch (Exception e) {
        System.out.println("Error reading file: " + e.getMessage());
        e.printStackTrace(); // Better error handling
        return new ArrayList<>(); // Return empty list instead of null
    }
}
}
