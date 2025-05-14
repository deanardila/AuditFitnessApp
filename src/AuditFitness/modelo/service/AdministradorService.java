/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package auditfitness.modelo.service;

import auditfitness.modelo.entidades.Administrador;
import auditfitness.modelo.repository.AdministradorRepository;

/**
 *
 * @author deana
 */
public class AdministradorService {
    private final AdministradorRepository repository;

    //Inyeccion de dependencia por constructor
    public AdministradorService(AdministradorRepository repository){
        this.repository = repository;
    }

    public Administrador autenticar(String username, String password){
       if (username == null || username.trim().isEmpty() || password == null || password.trim().isEmpty()){
           throw new IllegalArgumentException("Username y password son requeridos");
       }
        Administrador admin = repository.buscarPorUsername(username.trim());
       if (admin != null && admin.getPassword().equals(password.trim())){
           return admin; //Autenticacion exitosa
       }
       return null; //Credenciales invalidas
    }
}
