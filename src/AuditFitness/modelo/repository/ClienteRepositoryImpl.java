/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AuditFitness.modelo.repository;

import AuditFitness.modelo.entidades.Cliente;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author deana
 */
public class ClienteRepositoryImpl implements ClienteRepository {
    private final String ARCHIVO_CLIENTES = "clientes.csv";

    @Override
    public List<Cliente> readClientes() throws IOException {
        List<Cliente> clientes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO_CLIENTES))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 5) {
                    Cliente cliente = new Cliente(data[0], data[1], data[3], data[4]);
                    clientes.add(cliente);
                }
            }
        }
        return clientes;
    }
    
    @Override
    public void addCliente(Cliente cliente) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO_CLIENTES, true))) {
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

}

