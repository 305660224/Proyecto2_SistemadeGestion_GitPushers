/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clientes;
import Persona.Persona;
import java.time.LocalDate;
/**
 *
 * @author nazar
 */
public class Cliente extends Persona{
     
     private Tipo_licencia_Enum licencia;

    public Tipo_licencia_Enum getLicencia() {
        return licencia;
    }

    public Cliente(Tipo_licencia_Enum licencia, String cedula, String nombre, LocalDate fechaNacimiento, String telefono, String correo) {
        super(cedula, nombre, fechaNacimiento, telefono, correo);
        this.licencia = licencia;
    }
    
}
