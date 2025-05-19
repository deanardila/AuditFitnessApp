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

/**
 * Interfaz que define las operaciones básicas para gestionar entrenadores en el sistema.
 * Es como el "contrato" que especifica todas las funciones necesarias para manejar
 * la información de los entrenadores del gimnasio.
 */
public class EntrenadorRepositoryImpl implements EntrenadorRepository{
    /**
     * Obtiene TODOS los entrenadores registrados en el sistema
     * @return Lista completa de entrenadores
     * @throws IOException Si hay problemas accediendo a los datos
     */
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

        /**
     * Registra un NUEVO entrenador en el sistema
     * @param entrenador El entrenador a agregar
     * @throws IOException Si hay problemas guardando los datos
     */
    @Override
    public void addEntrenador(Entrenador entrenador) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO_ENTRENADORES, true))) {
            bw.write(entrenador.toCSVString());
            bw.newLine();
        }
    }
    
    /**
     * Verifica si un nombre de usuario de entrenador YA EXISTE
     * @param username Nombre de usuario a verificar
     * @return true si existe, false si no
     * @throws IOException Si hay problemas leyendo los datos
     */
    @Override
    public boolean entrenadorExiste(String username) throws IOException {
        List<Entrenador> entrenadores = readEntrenadores();
        return entrenadores.stream()
                .anyMatch(entrenador -> entrenador.getUsername().equals(username.trim()));
    }

    /**
     * Busca un entrenador por su nombre de usuario EXACTO
     * @param username Nombre de usuario a buscar
     * @return El entrenador encontrado o null si no existe
     * @throws IOException Si hay problemas accediendo a los datos
     */
    @Override
    public Entrenador buscarPorUsername(String username) throws IOException {
        List<Entrenador> entrenadores = readEntrenadores();
        return entrenadores.stream()
                .filter(entrenador-> entrenador.getUsername().equals(username.trim()))
                .findFirst()
                .orElse(null); // Retorna null si no se encuentra
    }
    /**
     * Elimina un entrenador del sistema por su identificación
     * @param identificacion ID del entrenador a eliminar
     * @throws IOException Si hay problemas guardando los cambios
     */
    public void deleteEntrenador(String identificacion) throws IOException {
            // 1. Leer la lista de clientes actual
               List<Entrenador> entrenadores = this.readEntrenadores();

            // 2. Buscar si el cliente existe ANTES de eliminarlo
            boolean entrenadorExiste = entrenadores.stream()
                    .anyMatch(entrenador -> entrenador.getIdentificacion().equals(identificacion));

                 if (!entrenadorExiste) {  // Verificar si existe antes de eliminar
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
