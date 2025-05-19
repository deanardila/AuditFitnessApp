/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AuditFitness.modelo.service;

import AuditFitness.modelo.entidades.Usuario;

/**
 *
 * @author deana
 */

/**
 * Interfaz que define el contrato básico para autenticar usuarios en el sistema.
 * Es como el "protocolo estándar" que deben seguir todos los servicios de autenticación,
 * sin importar si el usuario es cliente, entrenador o administrador.
 */
public interface UsuarioService {
    /**
     * Método para verificar las credenciales de un usuario y permitir su acceso al sistema.
     * @param username Nombre de usuario (ID de acceso)
     * @param password Contraseña del usuario
     * @return El usuario autenticado si las credenciales son correctas, null si no son válidas
     */
    Usuario autenticar(String username, String password);
}
