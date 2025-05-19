/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package AuditFitness.modelo;

/**
 *
 * @author deana
 */
/**
 * Clase especial que representa un ejercicio en una rutina de entrenamiento.
 * Es como la "ficha técnica" de cada ejercicio que contiene:
 * - Qué ejercicio hacer
 * - Cuántas series completar
 * - Cuántas repeticiones por serie
 * 
 * Los records son inmutables (sus datos no cambian después de crearse)
 */
public record EjercicioRecord(String ejercicio, int series, String repeticiones) {
}
