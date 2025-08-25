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
public abstract class Persona {

    private String cedula;
    private String nombre;
    private LocalDate fechaNacimiento;
    private String telefono;
    private String correo;

    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public int getEdad() {
        return UtilsFecha.calcularEdad(fechaNacimiento);
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setTelefono(String telefono) {
        if (telefono == null || !telefono.matches("^\\d{8}$")) {
            throw new IllegalArgumentException("Teléfono inválido, Debe tener 8 dígitos");
        }
        this.telefono = telefono;
    }

    public void setCorreo(String correo) {
        if (correo == null || !correo.matches("^[\\w+.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
            this.correo = correo;
        }
    }

    //validacines D.
    public void setCedula(String cedula) {
        if (cedula == null || !cedula.matches("\\d{9}")) {
            throw new IllegalArgumentException("Cédula inválida. Debe tener 9 dígitos.");
        }
        this.cedula = cedula;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        this.nombre = nombre.trim();
    }



    public Persona(String cedula, String nombre, LocalDate fechaNacimiento, String telefono, String correo) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.correo = correo;
    }

}
