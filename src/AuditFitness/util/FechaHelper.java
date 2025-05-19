/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AuditFitness.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author deana
 */

/**
 * Clase auxiliar para manejar formatos de fechas en la aplicación.
 * Es como el "traductor de fechas" que convierte entre:
 * - Fechas como objetos Date (que entiende Java)
 * - Fechas como texto (que entienden las personas)
 */
public class FechaHelper {
    private static final String FORMATO_FECHA = "dd-MM-yyyy"; // El formato de fecha que usaremos en toda la aplicación (día-mes-año)
    
    /**
     * Convierte una fecha Date a texto legible.
     * @param fecha La fecha como objeto Date
     * @return La fecha como texto (ej: "15-11-2023") o cadena vacía si es null
     */
    public static String formatFecha(Date fecha){
        if(fecha == null) return ""; // Si no hay fecha, devuelve vacío
        
         SimpleDateFormat formato = new SimpleDateFormat(FORMATO_FECHA); // Crea el formateador con nuestro formato estándar
         String fechaTexto = formato.format(fecha); // Convierte la fecha a texto
         return fechaTexto;
    }
    
    /**
     * Convierte texto de fecha a objeto Date.
     * @param fechaTexto La fecha como texto (ej: "15-11-2023")
     * @return La fecha como objeto Date o null si el texto es inválido
     */
    public static Date parsearFecha(String fechaTexto){
        if(fechaTexto ==null || fechaTexto.trim().isEmpty())return null;
         SimpleDateFormat formato = new SimpleDateFormat(FORMATO_FECHA); // Crea el formateador con nuestro formato estándar
        try{
            return formato.parse(fechaTexto);  // Intenta convertir el texto a fecha
        }catch(ParseException ex){
            // Si falla, muestra error en consola
            System.err.println("Error al parsear la fecha : "+fechaTexto);
        }
        return null;
    }
}
