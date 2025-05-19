/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AuditFitness.modelo.repository;
import AuditFitness.modelo.entidades.Administrador;

import java.io.*;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author deana
 */

/**
 * Implementación concreta que guarda y administra los datos de administradores
 * en un archivo CSV.
 * 
 * Es como el "archivador físico" donde se guardan todas las fichas
 * de los administradores del gimnasio, pero en formato digital.
 */
public class AdministradorRepositoryImpl implements AdministradorRepository {
    private static final String ARCHIVO_ADMINISTRADORES = "administradores.csv"; // Nombre del archivo donde se guardan todos los administradores

    /**
     * Lee TODOS los administradores registrados en el archivo
     * @return Lista completa de administradores
     * @throws IOException Si el archivo está dañado o no se puede leer
     */
    @Override
    public List<Administrador> readAdministradores() throws IOException {
        List<Administrador> administradores = new ArrayList<>();
        // Abre el archivo para lectura
        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO_ADMINISTRADORES))) {
            String line;
            while ((line = br.readLine()) != null) { // Lee línea por línea
                String[] data = line.split(","); // Separa los datos por comas
                if (data.length == 5) { // Verifica que tenga todos los campos
                    Administrador admin = new Administrador(data[0], data[1], data[3], data[4]); // Crea un objeto Administrador con los datos leídos
                    administradores.add(admin);
                }
            }
        }
        return administradores;
    }

    /**
     * Agrega un NUEVO administrador al final del archivo
     * @param administrador El administrador a registrar
     * @throws IOException Si no se puede escribir en el archivo
     */
    @Override
    public void addAdministrador(Administrador administrador) throws IOException {
        // Abre el archivo en modo "añadir" (no borra lo existente)
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO_ADMINISTRADORES, true))) {
            bw.write(administrador.toCSVString()); // Escribe los datos en formato CSV
            bw.newLine(); // Salto de línea para el próximo registro
        }
    }
    
    /**
     * Verifica si un nombre de usuario YA ESTÁ REGISTRADO
     * @param username Nombre de usuario a buscar
     * @return true si existe, false si no
     * @throws IOException Si hay problemas leyendo el archivo
     */
    @Override
    public boolean administradorExiste(String username) throws IOException {
        List<Administrador> administradores = readAdministradores();
        return administradores.stream() // Busca coincidencia exacta en los nombres de usuario
                .anyMatch(admin -> admin.getUsername().equals(username.trim()));
    }

    /**
     * Busca un administrador por su nombre de usuario EXACTO
     * @param username Nombre de usuario a buscar
     * @return El Administrador encontrado o NULL si no existe
     * @throws IOException Si hay problemas leyendo el archivo
     */
    @Override
    public Administrador buscarPorUsername(String username) throws IOException {
        List<Administrador> administradores = readAdministradores();
        return administradores.stream() // Filtra y devuelve el primero que coincida
                .filter(admin -> admin.getUsername().equals(username.trim()))
                .findFirst()
                .orElse(null); // Retorna null si no se encuentra
    }
}
