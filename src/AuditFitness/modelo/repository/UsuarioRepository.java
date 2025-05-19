/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package AuditFitness.modelo.repository;

import AuditFitness.modelo.entidades.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 *
 * @author deana
 */
/**
 * Interfaz que define las operaciones básicas para gestionar usuarios en el sistema,
 * organizados por su tipo (rol). Es como el "contrato principal" que establece cómo
 * deben manejarse los diferentes tipos de usuarios (clientes, entrenadores, administradores).
 */
public interface UsuarioRepository {
    // Mapa que define qué archivo CSV corresponde a cada tipo de usuario
    // Es como el "índice de archivadores" que indica dónde se guarda cada cosa:
    // - Administradores -> administradores.csv
    // - Clientes -> clientes.csv
    // - Entrenadores -> entrenadores.csv
    final Map<UsuarioRole, String> archivosCSV = Map.of(
            UsuarioRole.ADMINISTRADOR, "administradores.csv",
            UsuarioRole.CLIENTE,"clientes.csv",
            UsuarioRole.ENTRENADOR,"entrenadores.csv"
    );

    // Leer todos los usuarios de un archivo según su rol
   List<Usuario> readUsuarioByRole(UsuarioRole role);

    // Guardar usuario en su archivo correspondiente
    void addUsuario(Usuario usuario) throws IOException;

    // Metodo auxiliar para verificar si el usuario existe
    boolean usuarioExiste(String username, UsuarioRole role);
    
    /**
     * Obtiene TODOS los usuarios del sistema (sin importar su tipo)
     * @return Lista completa de todos los usuarios registrados
     */
    public List<Usuario> readUsersFromCSV();
}
