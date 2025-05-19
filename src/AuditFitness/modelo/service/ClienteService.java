/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AuditFitness.modelo.service;

import AuditFitness.modelo.entidades.Cliente;
import AuditFitness.modelo.repository.ClienteRepository;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


/**
 *
 * @author deana
 */

/**
 * Clase que maneja todas las operaciones relacionadas con clientes en el sistema.
 * Actúa como el "asistente de recepción" que gestiona el registro, búsqueda
 * y autenticación de los clientes del gimnasio.
 */
public class ClienteService {
     private final ClienteRepository clienteRepository; // Conexión con el archivo donde se guardan los clientes
    private static final String RUTA_CLIENTES_CSV = "src/data/clientes.csv"; // Ubicación del archivo CSV con datos de clientes
    
    /**
     * Constructor que recibe el repositorio de clientes.
     * @param clienteRepository El "archivador" donde están guardados los clientes
     */
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    /**
     * Verifica las credenciales de un cliente para permitir su acceso.
     * @param username Nombre de usuario proporcionado
     * @param password Contraseña proporcionada
     * @return El cliente autenticado si es correcto, null si no
     * @throws IllegalArgumentException Si faltan username o password
     */
    public Cliente autenticar(String username, String password){
        // Validar que se ingresaron ambos datos
       if (username == null || username.trim().isEmpty() || password == null || password.trim().isEmpty()){
           throw new IllegalArgumentException("Username y password son requeridos");
       }
       try {
           // Buscar el cliente por su nombre de usuario
           Cliente cliente = clienteRepository.buscarPorUsername(username.trim());
           // Verificar si la contraseña coincide
           if (cliente != null && cliente.getPassword().equals(password.trim())) {
               return cliente; //Autenticacion exitosa
           }
       } catch (IOException e) {
           e.printStackTrace(); // Problemas al leer los datos
            }
           return null; //Credenciales invalidas
    }
    
    /**
     * Busca un cliente por su número de identificación único.
     * @param Identificacion Número de identificación a buscar
     * @return El cliente encontrado o null si no existe
     */
    public Cliente buscarClientePorIdentificacion(String Identificacion) {
        try (BufferedReader br = new BufferedReader(new FileReader(RUTA_CLIENTES_CSV))) {
            String linea;
            // Leer línea por línea del archivo
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(","); // Separar los datos por comas
                String username = datos[0];
                String password = datos[1];
                String nombre = datos[2];
                String identificacion = datos[3];
                // Verificar si la identificacion coincide
                if (identificacion.equals(Identificacion)) {
                    return new Cliente(username, password, nombre, identificacion); // Retornar el cliente encontrado
                }
            }
        } catch (IOException e) { // Error al leer el archivo
            e.printStackTrace();
        }
        return null; // Retornar null si no se encuentra el cliente
    }
    
    /**
     * Registra un nuevo cliente en el sistema.
     * @param cliente El cliente a registrar
     * @return true si se registró correctamente, false si ya existía
     */
    public boolean registrarCliente(Cliente cliente) {
    try {
        // Verificar si el cliente ya está registrado
        if (buscarClientePorIdentificacion(cliente.getIdentificacion()) != null) {
            return false; // Cliente ya existe
        }
        
       // Escribir los datos del nuevo cliente en el archivo
        FileWriter writer = new FileWriter("clientes.csv", true);
        writer.append(cliente.toCSVString() + "\n");
        writer.close();
        
        return true; // Registro exitoso
    } catch (IOException e) {
        e.printStackTrace(); // Error al guardar
        return false;
        }
    }
}

