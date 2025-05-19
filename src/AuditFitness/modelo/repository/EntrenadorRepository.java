/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package AuditFitness.modelo.repository;

import AuditFitness.modelo.entidades.Entrenador;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author deana
 */
/**
 * Interfaz que define las operaciones básicas para gestionar entrenadores en el sistema.
 * Es como el "contrato" que especifica todas las funciones necesarias para manejar
 * la información de los entrenadores del gimnasio.
 */
public interface EntrenadorRepository {
    List<Entrenador> readEntrenadores() throws IOException; // Lee todos los entrenadores
    void addEntrenador(Entrenador entrenadorr) throws IOException; // Agrega un nuevo entrenador
    boolean entrenadorExiste(String username) throws IOException; // Verifica si un entrenador existe
    Entrenador buscarPorUsername(String username) throws IOException; // Busca entrenador por username
}
