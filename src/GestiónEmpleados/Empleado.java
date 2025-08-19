/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GestiónEmpleados;

import Persona.Persona;
import java.time.LocalDate;
import java.time.Period;



/**
 *
 * @author danny
 */
public class Empleado extends Persona {

    private String puesto;
    private double salario;
    
  

    public Empleado(String cedula, String nombre, LocalDate fechaNacimiento,String telefono, String correo, String puesto, double salario) {
                    
        super(cedula, nombre, fechaNacimiento, telefono, correo);

        if (puesto == null || puesto.trim().isEmpty()) {
            throw new IllegalArgumentException(" El puesto no puede estar vacío ");
        }
        
        
        if (salario <= 0) {
            throw new IllegalArgumentException("El salario debe ser mayor a 0.");
        }
        
        if (Period.between(fechaNacimiento, LocalDate.now()).getYears() < 18) {
            throw new IllegalArgumentException("El empleado debe ser mayor de 18 años.");
        }

        this.puesto = puesto.trim();
        this.salario = salario;
    }
    
    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        if (puesto == null || puesto.trim().isEmpty()) {
            throw new IllegalArgumentException("El puesto no puede estar vacío.");
        }
        this.puesto = puesto.trim();
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        if (salario <= 0) {
            throw new IllegalArgumentException("El salario debe ser mayor a 0.");
        }
        this.salario = salario;
    }
}
    

