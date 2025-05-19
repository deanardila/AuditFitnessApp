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
import javax.swing.JOptionPane;

/**
 *
 * @author deana
 */
/**
 * Clase que maneja el almacenamiento y recuperación de los registros de progreso
 * de los clientes en un archivo CSV. Es como el "cuaderno de evolución" donde
 * se apuntan los cambios de peso y condición física de los miembros del gimnasio.
 */
public class ProgresoRepositoryImpl {
    private final String ARCHIVO_ASISTENCIA = "src/data/progresos.csv"; // Ubicación del archivo donde se guardan todos los progresos
    
     /**
     * Registra un NUEVO progreso en el sistema
     * @param progreso Contiene: ID cliente, peso y fecha
     * @return El mismo progreso si se guardó correctamente, null si hubo error
     */
    public Progreso crear (Progreso progreso){
        try( BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO_ASISTENCIA, true))){
            
            // Escribe los datos en formato: clienteId,peso,fecha
            bw.write(progreso.getClienteId()+ "," + progreso.getPeso() +  "," + progreso.getFecha().toString() );
            bw.newLine();
            return progreso;
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null,"No se ha podido crear el progreso", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return null;
        }
    }
    
    /**
     * Obtiene TODOS los registros de progreso guardados
     * @return Lista completa de progresos (vacía si hay error)
     */
    public List<Progreso> listar() {
    List<Progreso> progresos = new ArrayList<>(); // Inicializa la lista 
    try(BufferedReader br = new BufferedReader(new FileReader(ARCHIVO_ASISTENCIA))) {
        String line;
        br.readLine(); // Salta la primera línea (encabezados)
        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");
            if (data.length == 3) { // Verifica que tenga los 3 campos
                // Crea objeto Progreso desde los datos del archivo
                Progreso progreso = new Progreso(data[0], // ID cliente
                        Double.parseDouble(data[1]), // peso (convertido a número)
                        LocalDate.parse(data[2])); // fecha (convertida a fecha)
                
                progresos.add(progreso);
            }
        }
        
        return progresos; // Devuelve lista vacía si hay error
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null,"Error al leer el archivo: " + e.getMessage(), "Advertencia", JOptionPane.WARNING_MESSAGE);
        e.printStackTrace(); 
        return new ArrayList<>(); 
        }
    }
}
