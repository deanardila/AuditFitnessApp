/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package AuditFitness.modelo.repository;

import AuditFitness.modelo.entidades.Administrador;

import java.io.IOException;
import java.util.List;

/**
 *
 * @author deana
 */

/**
 * Interfaz que define las operaciones básicas para guardar y administrar
 * los registros de administradores en el sistema.
 * 
 * Es como el "contrato" que deben cumplir todas las formas de almacenar
 * información de administradores (archivos, bases de datos, etc.).
 */
public interface AdministradorRepository {
    List<Administrador> readAdministradores() throws IOException; // Lee todos los administradores
    void addAdministrador(Administrador administrador) throws IOException; // Agrega un nuevo administrador
    boolean administradorExiste(String username) throws IOException; // Verifica si un administrador existe
    Administrador buscarPorUsername(String username) throws IOException; // Busca administrador por username
}
