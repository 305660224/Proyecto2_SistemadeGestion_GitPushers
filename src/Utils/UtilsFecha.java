/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author nazar
 */
public class UtilsFecha {
        public static int calcularEdad(LocalDate fecha){
        return Period.between(fecha, LocalDate.now()).getYears();
    }
    
    public static boolean NoFechaFutura(LocalDate fecha){
        return !fecha.isAfter(LocalDate.now());
    }
    
    public static boolean esMayordeEdad(LocalDate fecha){
        return calcularEdad(fecha)>=18;
    }
    
    public static LocalDate toLocalDate(String fecha){
        return LocalDate.parse(fecha, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
    
    public static String toString(LocalDate fecha){
        return fecha.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}
