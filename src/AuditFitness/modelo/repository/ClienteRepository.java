/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package AuditFitness.modelo.repository;

import AuditFitness.modelo.entidades.Cliente;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author deana
 */
public interface ClienteRepository {
    List<Cliente> readClientes() throws IOException; // Lee todos los clientes
    void addCliente(Cliente cliente) throws IOException; // Agrega un nuevo cliente
    boolean clienteExiste(String username) throws IOException; // Verifica si un cliente existe
    Cliente buscarPorUsername(String username) throws IOException; // Busca cliente por username
}
