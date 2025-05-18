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

/**
 *
 * @author deana
 */
public class RutinaRepositoryImpl implements RutinaRepository {

    public void asignarRutina(String rutina, String clienteId) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/data/rutinas.csv", true))) { // true for append mode
            bw.write(clienteId + "," + rutina);
            bw.newLine();
        } catch (Exception e) {
            System.err.println("Error al asignar rutina: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public Rutina leerRutinaCliente(String clienteId) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/data/rutinas.csv"))) {
            List<Rutina> rutinas = new ArrayList<>();
            String line;

            // Skip header if exists (your current code skips first line regardless)
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 2) {
                    rutinas.add(new Rutina(data[1], data[0]));
                }
            }

            // Get most recent rutina for the client
            List<Rutina> clientRutinas = rutinas.stream()
                    .filter(r -> r.getClienteId().equals(clienteId))
                    .toList();

            if (!clientRutinas.isEmpty()) {
                return clientRutinas.get(clientRutinas.size() - 1); // Get last one
            }
            return null; // Or throw an exception if preferred

        } catch (Exception e) {
            System.err.println("Error al leer rutina: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public List<EjercicioRecord> obtenerEjerciciosRutina(String rutinaArchivo) throws IOException {
        // Validate input
        if (rutinaArchivo == null || rutinaArchivo.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del archivo de rutina no puede estar vacío");
        }

        // Construct safe file path
        Path filePath = Paths.get("src", "data", "rutinas", rutinaArchivo.trim() + ".csv");

        List<EjercicioRecord> ejercicios = new ArrayList<>();
        boolean isFirstLine = true;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath.toFile()))) {
            String line;

            while ((line = br.readLine()) != null) {
                // Skip empty lines
                if (line.trim().isEmpty()) {
                    continue;
                }

                // Skip header line if it exists
                if (isFirstLine) {
                    isFirstLine = false;
                    if (line.toLowerCase().contains("ejercicio,series,repeticiones")) {
                        continue;
                    }
                }

                String[] data = line.split(",");
                if (data.length == 3) {
                    try {
                        String nombreEjercicio = data[0].trim();
                        int series = Integer.parseInt(data[1].trim());
                        String repeticiones = data[2].trim();

                        ejercicios.add(new EjercicioRecord(nombreEjercicio, series, repeticiones));
                    } catch (NumberFormatException e) {
                        System.err.println("Error parsing series count in line: " + line);
                        // Alternatively: throw new IOException("Invalid series count in line: " + line, e);
                    }
                } else {
                    System.err.println("Skipping malformed line: " + line);
                }
            }
        }

        return ejercicios;
    }
}
