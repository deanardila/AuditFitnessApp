/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AuditFitness.modelo.repository;

import AuditFitness.modelo.entidades.Entrenador;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author deana
 */
public class EntrenadorRepositoryImpl implements EntrenadorRepository{
    private static final String ARCHIVO_ENTRENADORES = "entrenadores.csv";

    @Override
    public List<Entrenador> readEntrenadores() throws IOException {
        List<Entrenador> entrenadores = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO_ENTRENADORES))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 6) {
                    Entrenador entrenador = new Entrenador(data[0], data[1], data[3], data[4],data[5]);
                    entrenadores.add(entrenador);
                }
            }
        }
        return entrenadores;
    }

    @Override
    public void addEntrenador(Entrenador entrenador) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO_ENTRENADORES, true))) {
            bw.write(entrenador.toCSVString());
            bw.newLine();
        }
    }
    @Override
    public boolean entrenadorExiste(String username) throws IOException {
        List<Entrenador> entrenadores = readEntrenadores();
        return entrenadores.stream()
                .anyMatch(entrenador -> entrenador.getUsername().equals(username.trim()));
    }

    @Override
    public Entrenador buscarPorUsername(String username) throws IOException {
        List<Entrenador> entrenadores = readEntrenadores();
        return entrenadores.stream()
                .filter(entrenador-> entrenador.getUsername().equals(username.trim()))
                .findFirst()
                .orElse(null); // Retorna null si no se encuentra
    }
}
