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
import javax.swing.JOptionPane;

/**
 *
 * @author deana
 */

/**
 * Clase que maneja el almacenamiento y recuperación de registros de asistencia
 * en un archivo CSV. Es como el "libro de registros" donde se anota quién
 * vino al gimnasio y cuándo.
 */
public class AsistenciaRepositoryImpl {
    private final String ARCHIVO_ASISTENCIA = "src/data/asistencias.csv"; // Ubicación del archivo donde se guardan todas las asistencias
    
    /**
     * Registra una nueva asistencia en el sistema
     * @param asistencia El objeto con los datos de asistencia a guardar
     * @return La misma asistencia si se guardó correctamente, null si hubo error
     */
    public Asistencia crear (Asistencia asistencia){
        try( BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO_ASISTENCIA, true))){ 
            bw.write(asistencia.getUsernameCliente() + "," + asistencia.getFecha().toString()); // Escribe los datos en formato: username,fecha
            bw.newLine(); // Agrega salto de línea para el próximo registro
            
            JOptionPane.showMessageDialog(null, "Asistencia registrada exitosamente. ","Éxito",JOptionPane.INFORMATION_MESSAGE);
            return asistencia; // Devuelve la asistencia creada
            
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null,"Error al registrar asistencia:" + e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            return null; // Indica que hubo un error
        }
    }
    
    /**
     * Obtiene TODOS los registros de asistencia guardados
     * @return Lista de todas las asistencias registradas
     */
    public List<Asistencia> listar() {
    List<Asistencia> asistencias = new ArrayList<>();
    try(BufferedReader br = new BufferedReader(new FileReader(ARCHIVO_ASISTENCIA))) {
        String line;
        
        br.readLine(); // Salta la primera línea (encabezados)
        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");
            if (data.length == 2) { // Verifica que tenga los 2 campos necesarios
                Asistencia asistencia = new Asistencia(data[0], LocalDate.parse(data[1])); // Crea objeto Asistencia desde los datos del archivo
                asistencias.add(asistencia);
            }
        }
        
        return asistencias;
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null,"Error al leer archivo:" + e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        e.printStackTrace(); // Muestra detalles del error
        return new ArrayList<>();// Devuelve lista vacía para evitar nulls
        }
    }
}
