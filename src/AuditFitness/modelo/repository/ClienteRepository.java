/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package auditfitness.modelo.repository;

import auditfitness.modelo.entidades.Cliente;
import java.util.List;

/**
 *
 * @author deana
 */
public interface ClienteRepository {
    void guardar (Cliente cliente);
    Cliente buscarPorUsername(String username);
    Cliente buscarPorIdentificacion(String identificacion);
    List<Cliente> listarTodos();
    void eliminar(Cliente cliente);
}
