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
/**
 * Implementación concreta del repositorio de clientes que guarda y gestiona
 * los datos en un archivo CSV. Es como el "libro de registro" digital donde
 * se almacena toda la información de los clientes del gimnasio.
 */
public class ClienteRepositoryImpl implements ClienteRepository {
    private final String ARCHIVO_CLIENTES = "src/data/clientes.csv"; // Ubicación del archivo donde se guardan todos los clientes
    
    /**
     * Lee y devuelve TODOS los clientes registrados en el sistema
     * @return Lista completa de clientes
     * @throws IOException Si hay problemas leyendo el archivo
     */
    @Override
    public List<Cliente> readClientes() throws IOException {
        List<Cliente> clientes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO_CLIENTES))) {
            String line;
            boolean isHeader = true; // Bandera para saltar la primera línea (encabezado)

            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue; // Salta la línea de encabezado
                }
                
                String[] data = line.split(","); // Divide la línea por comas
                if (data.length == 4) { // Verifica 4 campos
                    // Crea un nuevo cliente con los datos del archivo
                    Cliente cliente = new Cliente(
                            data[0], // username
                            data[1], // password
                            data[2], // nombre
                            data[3] // identificacion
                    );

                    clientes.add(cliente);
                } else { // Muestra advertencia si una línea tiene formato incorrecto
                     JOptionPane.showMessageDialog(null, "Línea ignorada (formato incorrecto): " + line,"Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        return clientes;
    }

    /**
     * Agrega un NUEVO cliente al final del archivo
     * @param cliente El cliente a registrar
     * @throws IOException Si hay problemas escribiendo en el archivo
     */
    @Override
    public void addCliente(Cliente cliente) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO_CLIENTES, true))) {
            bw.write(cliente.toCSVString());
            bw.newLine(); // Añade salto de línea para el próximo registro
        }
    }

    /**
     * Verifica si un nombre de usuario YA EXISTE en el sistema
     * @param username Nombre de usuario a verificar
     * @return true si existe, false si no existe
     * @throws IOException Si hay problemas leyendo los datos
     */
    @Override
    public boolean clienteExiste(String username) throws IOException {
        List<Cliente> clientes = readClientes();
        return clientes.stream() // Busca coincidencia exacta en nombres de usuario
                .anyMatch(cliente -> cliente.getUsername().equals(username.trim()));
    }

    /**
     * Busca un cliente por su nombre de usuario EXACTO
     * @param username Nombre de usuario a buscar
     * @return El cliente encontrado o null si no existe
     * @throws IOException Si hay problemas leyendo los datos
     */
    @Override
    public Cliente buscarPorUsername(String username) throws IOException {
        List<Cliente> clientes = readClientes();
        return clientes.stream() // Filtra y devuelve el primer cliente que coincida
                .filter(cliente -> cliente.getUsername().equals(username.trim()))
                .findFirst()
                .orElse(null); // Retorna null si no se encuentra
    }

    
    /**
     * ELIMINA un cliente del sistema por su número de identificación
     * @param identificacion Número de identificación del cliente a eliminar
     * @throws IOException Si hay problemas guardando los cambios
     */
    public void deleteCliente(String identificacion) throws IOException {
            // 1. Leer la lista de clientes actual
               List<Cliente> clientes = this.readClientes();

            // 2. Buscar si el cliente existe ANTES de eliminarlo
            boolean clienteExiste = clientes.stream()
                    .anyMatch(cliente -> cliente.getIdentificacion().equals(identificacion));

                 if (!clienteExiste) {
                    JOptionPane.showMessageDialog(null,"No se encontró ningún cliente con la identificación: " + identificacion,"Cliente no encontrado", JOptionPane.WARNING_MESSAGE);
                    return; // Sale del método sin hacer cambios
            }

            // 3. Si el cliente existe, se elimina
            clientes.removeIf(cliente -> cliente.getIdentificacion().equals(identificacion));

            // 4. Guardar los cambios en el archivo
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO_CLIENTES))) {
                bw.write("username,password,nombre,identificacion");
                bw.newLine();
                // Escribe todos los clientes restantes
                for (Cliente cliente : clientes) {
                    bw.write(cliente.toCSVString());
                    bw.newLine();
                }
                JOptionPane.showMessageDialog(null, "Cliente eliminado correctamente.","Éxito",JOptionPane.INFORMATION_MESSAGE);

            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error al guardar los cambios: " + e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
                throw e; // Vuelve a lanzar la excepción para manejarla externamente
                    }
        }
}
