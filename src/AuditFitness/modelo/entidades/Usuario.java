/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package auditfitness.modelo.entidades;

/**
 *
 * @author deana
 */
public abstract class Usuario {
    private UsuarioRole role;
    private String username;
    private String password;
    private String nombre;
    private String identificacion;

    //Constructor
    public Usuario(String username, String password, String nombre, String identificacion, UsuarioRole role) {
        this.username = username;
        this.password = password;
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.role = role;
    }

    // Getters y Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username.trim(); // Trim para limpiar espacios
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password.trim();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre.trim();
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion.trim();
    }

    public UsuarioRole getRole() {
        return role;
    }

    public abstract String toSring();
}
