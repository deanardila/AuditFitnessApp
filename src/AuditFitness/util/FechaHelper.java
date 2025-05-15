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
public class FechaHelper {
    private static final String FORMATO_FECHA = "dd-MM-yyyy";
    
    public static String formatFecha(Date fecha){
        if(fecha == null) return "";
        
         SimpleDateFormat formato = new SimpleDateFormat(FORMATO_FECHA);
         String fechaTexto = formato.format(fecha);
         return fechaTexto;
    }
    
    public static Date parsearFecha(String fechaTexto){
        if(fechaTexto ==null || fechaTexto.trim().isEmpty())return null;
         SimpleDateFormat formato = new SimpleDateFormat(FORMATO_FECHA);
        try{
            return formato.parse(fechaTexto);
        }catch(ParseException ex){
            System.err.println("Error al parsear la fecha : "+fechaTexto);
        }
        return null;
    }
}
