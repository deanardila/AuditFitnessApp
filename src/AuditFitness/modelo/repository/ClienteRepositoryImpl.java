/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AuditFitness.modelo.repository;

import AuditFitness.modelo.entidades.Administrador;
import AuditFitness.modelo.entidades.Cliente;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author deana
 */
public class ClienteRepositoryImpl implements ClienteRepository {
    private final String CSV_FILE = "src/data/clientes.csv";

    @Override
    public void guardar(Cliente cliente) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CSV_FILE, true))) {
            File file = new File(CSV_FILE);

            // Escribir cabecera si el archivo está vacío o no existe
            if (!file.exists() || file.length() == 0) {
                writer.write("username,password,nombre,identificacion");
            } else file.length();
            {
                writer.newLine();
            }

            String linea = String.join(",",
                    cliente.getUsername(),
                    cliente.getPassword(),
                    cliente.getNombre(),
                    cliente.getIdentificacion()
            );
            writer.write(linea);
        } catch (IOException e) {
            throw new RuntimeException("Error al guardar administrador: " + e.getMessage());
        }
    }
    @Override
    public Cliente buscarPorUsername(String username){
        return buscarEnCSV(0,username.trim()); // columna 0 = username
    }

    @Override
    public Cliente buscarPorIdentificacion(String username){
        return buscarEnCSV(3,username.trim()); // columna 3 = identificacion
    }

    private Cliente buscarEnCSV(int columna, String valor){
        try (BufferedReader br = new BufferedReader(new FileReader(CSV_FILE))) {
            String linea;
            boolean primeraLinea = true;

            while ((linea = br.readLine()) != null) {
                if (primeraLinea) {
                    primeraLinea = false; // Saltar cabecera
                    continue;
                }

                String[] datos = linea.split(",");
                if (datos[columna].trim().equals(valor)) {
                    return new Cliente(
                            datos[0], // username
                            datos[1], // password
                            datos[2], // nombre
                            datos[3]  // identificacion
                    );
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Error al leer el archivo CSV: " + e.getMessage());
        }
        return null;
    }
    @Override
    public List<Cliente> listarTodos() {
        List<Cliente> clientes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(CSV_FILE))) {
            String linea;
            boolean primeraLinea = true;

            while ((linea = br.readLine()) != null) {
                if (primeraLinea) {
                    primeraLinea = false;
                    continue;
                }

                String[] datos = linea.split(",");
                clientes.add(new Cliente(
                        datos[0], datos[1], datos[2], datos[3]
                ));
            }
        } catch (IOException e) {
            throw new RuntimeException("Error al listar clientes: " + e.getMessage());
        }
        return clientes;
    }
    @Override
    public void eliminar(Cliente cliente) {
        List<Cliente> clientes = listarTodos();
        clientes.removeIf(c -> c.getIdentificacion().equals(cliente.getIdentificacion()));

        // Reescribir el archivo completo sin el cliente eliminado
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CSV_FILE))) {
            writer.write("username,password,nombre,identificacion");
            for (Cliente c : clientes) {
                writer.newLine();
                writer.write(String.join(",",
                        c.getUsername(),
                        c.getPassword(),
                        c.getNombre(),
                        c.getIdentificacion()
                ));
            }
        } catch (IOException e) {
            throw new RuntimeException("Error al eliminar cliente: " + e.getMessage());
        }
    }

}

