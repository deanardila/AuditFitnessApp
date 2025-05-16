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
public interface UsuarioRepository {
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

    public List<Usuario> readUsersFromCSV();
}
