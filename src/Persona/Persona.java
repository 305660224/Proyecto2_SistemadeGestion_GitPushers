/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persona;

import Utils.UtilsFecha;
import java.time.LocalDate;

/**
 *
 * @author nazar
 */
public class Persona {
    private String cedula;
    private String nombre;
    private LocalDate fechaNacimiento;
    private String telefono ;
    private String correo ;

    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaNacimiento() {
        return  fechaNacimiento;
    }
    
    public int getEdad(){
        return UtilsFecha.calcularEdad(fechaNacimiento);
    }
    
    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setTelefono(String telefono) {
        if(telefono.matches("^\\d{8}$")){
          this.telefono = telefono;
        }
       
    }
     public void setCorreo(String correo) {
        if (correo == null || !correo.matches("^[\\w+.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
         this.correo = correo;
        }
       }

    public Persona(String cedula, String nombre, LocalDate fechaNacimiento, String telefono, String correo) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.correo = correo;
    }
     
     
     
     
     
}
