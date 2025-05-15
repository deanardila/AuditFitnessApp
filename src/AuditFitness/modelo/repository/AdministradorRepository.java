/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package AuditFitness.modelo.repository;

import Auditfitness.modelo.entidades.Administrador;

/**
 *
 * @author deana
 */
public interface AdministradorRepository {
    void guardar(Administrador admin);
    Administrador buscarPorUsername(String username);
}
