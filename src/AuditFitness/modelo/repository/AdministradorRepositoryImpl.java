/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AuditFitness.modelo.repository;
import Auditfitness.modelo.entidades.Administrador;
import Auditfitness.modelo.entidades.UsuarioRole;

import java.io.*;
import java.io.FileWriter;

/**
 *
 * @author deana
 */
public class AdministradorRepositoryImpl implements AdministradorRepository {
    private final String CSV_FILE = "src/data/administradores.csv";

    @Override
    public void guardar(Administrador admin) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CSV_FILE, true))) {
            File file = new File(CSV_FILE);

            // Escribir cabecera si el archivo está vacío o no existe
            if (!file.exists() || file.length() == 0) {
                writer.write("username,password,nombre,identificacion,Rol");
            } else file.length();
            {
                writer.newLine();
            }

            String linea = String.join(",",
                    admin.getUsername(),
                    admin.getPassword(),
                    admin.getNombre(),
                    admin.getIdentificacion(),
                    admin.getRole().toString()
            );
            writer.write(linea);
        } catch (IOException e) {
            throw new RuntimeException("Error al guardar administrador: " + e.getMessage());
        }
    }

    @Override
    public Administrador buscarPorUsername(String username){
        try (BufferedReader br = new BufferedReader(new FileReader(CSV_FILE))) {
            String linea;
            while ((linea = br.readLine()) != null){
                String[] datos = linea.split(",");
                if (datos[0].equals(username.trim())){
                    return new Administrador(
                            datos[0], //Username
                            datos[1], //Password
                            datos[2], //Nombre
                            datos[3] //Identificación
                    );
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null; //No encontrado
    }
}
