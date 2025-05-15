/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AuditFitness.modelo.service;

import AuditFitness.modelo.entidades.Administrador;
import AuditFitness.modelo.entidades.Cliente;
import AuditFitness.modelo.repository.AdministradorRepository;
import AuditFitness.modelo.repository.ClienteRepository;

import java.util.List;

/**
 *
 * @author deana
 */
public class ClienteService {
    private final ClienteRepository clienteRepository;

    // Inyección de dependencia (requiere ClienteRepository)
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    /**
     * Registra un nuevo cliente después de validar los datos.
     * @param cliente El cliente a registrar.
     * @throws IllegalArgumentException Si los datos son inválidos o el cliente ya existe.
     */
    public void registrarCliente(Cliente cliente) {
        validarDatosCliente(cliente);

        if (clienteRepository.buscarPorUsername(cliente.getUsername()) != null) {
            throw new IllegalArgumentException("El nombre de usuario ya está registrado.");
        }

        if (clienteRepository.buscarPorIdentificacion(cliente.getIdentificacion()) != null) {
            throw new IllegalArgumentException("La identificación ya está registrada.");
        }

        clienteRepository.guardar(cliente);
    }

    /**
     * Valida los campos obligatorios del cliente.
     */
    private void validarDatosCliente(Cliente cliente) {
        if (cliente.getUsername() == null || cliente.getUsername().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre de usuario es requerido.");
        }

        if (cliente.getPassword() == null || cliente.getPassword().trim().isEmpty()) {
            throw new IllegalArgumentException("La contraseña es requerida.");
        }

        if (cliente.getNombre() == null || cliente.getNombre().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre es requerido.");
        }

        if (cliente.getIdentificacion() == null || cliente.getIdentificacion().trim().isEmpty()) {
            throw new IllegalArgumentException("La identificación es requerida.");
        }
    }

    /**
     * Obtiene todos los clientes registrados.
     */
    public List<Cliente> listarClientes() {
        return clienteRepository.listarTodos();
    }

    /**
     * Elimina un cliente por su identificación.
     */
    public void eliminarCliente(String identificacion) {
        Cliente cliente = clienteRepository.buscarPorIdentificacion(identificacion);
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente no encontrado.");
        }
        clienteRepository.eliminar(cliente);
    }

    /**
     * Busca un cliente por username.
     */
    public Cliente buscarPorUsername(String username) {
        return clienteRepository.buscarPorUsername(username);
    }
}

