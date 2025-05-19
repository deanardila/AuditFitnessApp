/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AuditFitness.modelo.repository;

import AuditFitness.modelo.entidades.Entrenador;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author deana
 */
public class EntrenadorRepositoryImpl implements EntrenadorRepository{
    private static final String ARCHIVO_ENTRENADORES = "src/data/entrenadores.csv";

    @Override
    public List<Entrenador> readEntrenadores() throws IOException {
        List<Entrenador> entrenadores = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO_ENTRENADORES))) {
            String line;
            boolean isHeader = true; // Para saltar la primera línea (encabezado)
            
           while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue; // Saltar la línea de encabezado
                }

                String[] data = line.split(",");
                if (data.length == 4) { // Ahora verifica 4 campos
                    Entrenador entrenador = new Entrenador(
                            data[0], // username
                            data[1], // password
                            data[2], // nombre
                            data[3] // identificacion
                    );

                    entrenadores.add(entrenador);
                } else {
                    JOptionPane.showMessageDialog(null, "Línea ignorada (formato incorrecto): " + line,"Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        return entrenadores;
    }

    @Override
    public void addEntrenador(Entrenador entrenador) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO_ENTRENADORES, true))) {
            bw.write(entrenador.toCSVString());
            bw.newLine();
        }
    }
    
    @Override
    public boolean entrenadorExiste(String username) throws IOException {
        List<Entrenador> entrenadores = readEntrenadores();
        return entrenadores.stream()
                .anyMatch(entrenador -> entrenador.getUsername().equals(username.trim()));
    }

    @Override
    public Entrenador buscarPorUsername(String username) throws IOException {
        List<Entrenador> entrenadores = readEntrenadores();
        return entrenadores.stream()
                .filter(entrenador-> entrenador.getUsername().equals(username.trim()))
                .findFirst()
                .orElse(null); // Retorna null si no se encuentra
    }
    
    public void deleteEntrenador(String identificacion) throws IOException {
            // 1. Leer la lista de clientes actual
               List<Entrenador> entrenadores = this.readEntrenadores();

            // 2. Buscar si el cliente existe ANTES de eliminarlo
            boolean entrenadorExiste = entrenadores.stream()
                    .anyMatch(entrenador -> entrenador.getIdentificacion().equals(identificacion));

                 if (!entrenadorExiste) {
                    JOptionPane.showMessageDialog(
                        null,
                        "No se encontró ningún entrenador con la identificación: " + identificacion,"Entrenador no encontrado",JOptionPane.WARNING_MESSAGE);
                    return; // Sale del método sin hacer cambios
            }
                 
            // 3. Si el cliente existe, lo eliminamos
            entrenadores.removeIf(entrenador -> entrenador.getIdentificacion().equals(identificacion));

            // 4. Guardar los cambios en el archivo
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO_ENTRENADORES))) {
                bw.write("username,password,nombre,identificacion");
                bw.newLine();
                for (Entrenador entrenador : entrenadores) {
                    bw.write(entrenador.toCSVString());
                    bw.newLine();
                }
                JOptionPane.showMessageDialog(null, "Entrenador desactivado correctamente.","Éxito",JOptionPane.INFORMATION_MESSAGE);

            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error al guardar los cambios: " + e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
                throw e; // Relanza la excepción para manejo externo
                    }
         }
}
