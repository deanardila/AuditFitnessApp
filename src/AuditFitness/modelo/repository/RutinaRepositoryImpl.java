/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AuditFitness.modelo.repository;

import AuditFitness.modelo.EjercicioRecord;
import AuditFitness.modelo.entidades.Rutina;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author deana
 */

/**
 * Clase que maneja el almacenamiento y recuperación de rutinas de ejercicio
 * para los clientes del gimnasio. Es como el "sistema de archivos de planes
 * de entrenamiento" que conecta clientes con sus rutinas asignadas.
 */
public class RutinaRepositoryImpl implements RutinaRepository {
 /**
     * Asigna una nueva rutina a un cliente guardándola en el sistema
     * @param rutina Nombre/ID del archivo de rutina (ej: "rutina_cardio")
     * @param clienteId Identificador único del cliente
     */
    public void asignarRutina(String rutina, String clienteId) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/data/rutinas.csv", true))) { // true for append mode
            bw.write(clienteId + "," + rutina); // Guarda la relación cliente-rutina en formato: clienteId,rutina
            bw.newLine();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error al asignar rutina: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    
/**
     * Obtiene la rutina ACTUAL de un cliente específico
     * @param clienteId ID del cliente a buscar
     * @return La rutina más reciente del cliente o null si no tiene
     */
    public Rutina leerRutinaCliente(String clienteId) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/data/rutinas.csv"))) {
            List<Rutina> rutinas = new ArrayList<>();
            String line;

            // Lee todas las rutinas registradas
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 2) {
                    rutinas.add(new Rutina(data[1], data[0]));
                }
            }

            // Filtra solo las rutinas del cliente y obtiene la más reciente
            List<Rutina> clientRutinas = rutinas.stream()
                    .filter(r -> r.getClienteId().equals(clienteId))
                    .toList();
            if (!clientRutinas.isEmpty()) {
                return clientRutinas.get(clientRutinas.size() - 1); 
            }
            return null;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error al leer rutina: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Obtiene los ejercicios detallados de una rutina específica
     * @param rutinaArchivo Nombre del archivo de rutina (sin extensión)
     * @return Lista de ejercicios con sus series y repeticiones
     * @throws IOException Si hay problemas leyendo el archivo
     */
    public List<EjercicioRecord> obtenerEjerciciosRutina(String rutinaArchivo) throws IOException {
         // Validación básica del nombre de archivo
        if (rutinaArchivo == null || rutinaArchivo.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del archivo de rutina no puede estar vacío");
        }

        // Construye la ruta segura al archivo
        Path filePath = Paths.get("src", "data", "rutinas", rutinaArchivo.trim() + ".csv");

        List<EjercicioRecord> ejercicios = new ArrayList<>();
        boolean isFirstLine = true;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath.toFile()))) {
            String line;

            while ((line = br.readLine()) != null) {
                // Omite líneas vacías
                if (line.trim().isEmpty()) {
                    continue;
                }

                // Omite el encabezado si existe
                if (isFirstLine) {
                    isFirstLine = false;
                    if (line.toLowerCase().contains("ejercicio,series,repeticiones")) {
                        continue;
                    }
                }
                // Procesa cada línea de ejercicio
                String[] data = line.split(",");
                if (data.length == 3) {
                    try {
                        String nombreEjercicio = data[0].trim();
                        int series = Integer.parseInt(data[1].trim());
                        String repeticiones = data[2].trim();
                        ejercicios.add(new EjercicioRecord(nombreEjercicio, series, repeticiones));
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null,"Recuento de series no válido en la línea: " +line, "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null,"Línea malformada:" + line, "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        return ejercicios;
    }
}
