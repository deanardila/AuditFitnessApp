/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AuditFitness.modelo.repository;

import AuditFitness.modelo.entidades.Cliente;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author deana
 */
public class ClienteRepositoryImpl implements ClienteRepository {

    private final String ARCHIVO_CLIENTES = "src/data/clientes.csv";
    
    @Override
    public List<Cliente> readClientes() throws IOException {
        List<Cliente> clientes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO_CLIENTES))) {
            String line;
            boolean isHeader = true; // Para saltar la primera línea (encabezado)

            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue; // Saltar la línea de encabezado
                }

                String[] data = line.split(",");
                if (data.length == 4) { // Ahora verifica 4 campos
                    Cliente cliente = new Cliente(
                            data[0], // username
                            data[1], // password
                            data[2], // nombre
                            data[3] // identificacion
                    );

                    clientes.add(cliente);
                } else {
                    System.err.println("Línea ignorada (formato incorrecto): " + line);
                }
            }
        }
        return clientes;
    }

    @Override
    public void addCliente(Cliente cliente) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO_CLIENTES, true))) {
            bw.newLine();
            bw.write(cliente.toCSVString());
            bw.newLine();
        }
    }

    @Override
    public boolean clienteExiste(String username) throws IOException {
        List<Cliente> clientes = readClientes();
        return clientes.stream()
                .anyMatch(cliente -> cliente.getUsername().equals(username.trim()));
    }

    @Override
    public Cliente buscarPorUsername(String username) throws IOException {
        List<Cliente> clientes = readClientes();
        return clientes.stream()
                .filter(cliente -> cliente.getUsername().equals(username.trim()))
                .findFirst()
                .orElse(null); // Retorna null si no se encuentra
    }


    public void deleteCliente(String identificacion) throws IOException {
        // Leer clientes ANTES de abrir el archivo en modo escritura
        List<Cliente> clientes = this.readClientes();

        System.out.println(clientes.size());

        // 1. Eliminar el cliente de la lista en memoria
        clientes.removeIf(cliente
                -> cliente.getIdentificacion().equals(identificacion)
        );

        // 2. Reescribir el archivo solo si se eliminó un cliente
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO_CLIENTES))) { // Sobrescribe el archivo
            bw.write("username,password,nombre,identificacion");
            bw.newLine();
            for (Cliente cliente : clientes) {
                bw.write(cliente.toCSVString());
                bw.newLine();
            }
            System.out.println("Cliente eliminado correctamente.");
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
            throw e; // Relanza la excepción para manejo externo
        }

    }

}
