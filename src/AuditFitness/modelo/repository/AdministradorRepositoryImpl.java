/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AuditFitness.modelo.repository;
import AuditFitness.modelo.entidades.Administrador;

import java.io.*;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author deana
 */
public class AdministradorRepositoryImpl implements AdministradorRepository {
    private static final String ARCHIVO_ADMINISTRADORES = "administradores.csv";

    @Override
    public List<Administrador> readAdministradores() throws IOException {
        List<Administrador> administradores = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO_ADMINISTRADORES))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 5) {
                    Administrador admin = new Administrador(data[0], data[1], data[3], data[4]);
                    administradores.add(admin);
                }
            }
        }
        return administradores;
    }

    @Override
    public void addAdministrador(Administrador administrador) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO_ADMINISTRADORES, true))) {
            bw.write(administrador.toCSVString());
            bw.newLine();
        }
    }
    @Override
    public boolean administradorExiste(String username) throws IOException {
        List<Administrador> administradores = readAdministradores();
        return administradores.stream()
                .anyMatch(admin -> admin.getUsername().equals(username.trim()));
    }

    @Override
    public Administrador buscarPorUsername(String username) throws IOException {
        List<Administrador> administradores = readAdministradores();
        return administradores.stream()
                .filter(admin -> admin.getUsername().equals(username.trim()))
                .findFirst()
                .orElse(null); // Retorna null si no se encuentra
    }
}
