/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AuditFitness.modelo.repository;

import AuditFitness.modelo.entidades.Cliente;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

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
                     JOptionPane.showMessageDialog(null, "Línea ignorada (formato incorrecto): " + line,"Error", JOptionPane.ERROR_MESSAGE);
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


    public void deleteCliente(String identificacion) throws IOException {
            // 1. Leer la lista de clientes actual
               List<Cliente> clientes = this.readClientes();

            // 2. Buscar si el cliente existe ANTES de eliminarlo
            boolean clienteExiste = clientes.stream()
                    .anyMatch(cliente -> cliente.getIdentificacion().equals(identificacion));

                 if (!clienteExiste) {
                    JOptionPane.showMessageDialog(
                        null,
                        "No se encontró ningún cliente con la identificación: " + identificacion,
                        "Cliente no encontrado",
                        JOptionPane.WARNING_MESSAGE
                    );
                    return; // Sale del método sin hacer cambios
            }

            // 3. Si el cliente existe, lo eliminamos
            clientes.removeIf(cliente -> cliente.getIdentificacion().equals(identificacion));

            // 4. Guardar los cambios en el archivo
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO_CLIENTES))) {
                bw.write("username,password,nombre,identificacion");
                bw.newLine();
                for (Cliente cliente : clientes) {
                    bw.write(cliente.toCSVString());
                    bw.newLine();
                }
                JOptionPane.showMessageDialog(null, "Cliente eliminado correctamente.","Éxito",JOptionPane.INFORMATION_MESSAGE);

            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error al guardar los cambios: " + e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
                throw e; // Relanza la excepción para manejo externo
                    }
        }
}
