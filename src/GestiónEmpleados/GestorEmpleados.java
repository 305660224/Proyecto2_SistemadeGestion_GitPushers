/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GestiónEmpleados;

import java.util.ArrayList;

import java.util.Optional;

/**
 *
 * @author danny
 */
public class GestorEmpleados {

    private ArrayList<Empleado> listaEmpleados;

    public GestorEmpleados() {

        listaEmpleados = new ArrayList<>();
    }

    // Agregar empleado
    public boolean agregarEmpleado(Empleado empleado) {
        if (empleado == null) {
            return false;
        }

        if (listaEmpleados == null) {
            listaEmpleados = new ArrayList<>();
        }

        // Validar que no exista otro con la misma cédula
        if (existeEmpleado(empleado.getCedula())) {
            return false;
        }

        listaEmpleados.add(empleado);
        return true;
    }

      // Actualizar teléfono, correo y puesto
    public boolean actualizarEmpleado(String cedula, String nuevoTelefono, String nuevoCorreo, String nuevoPuesto) {
        if (listaEmpleados == null) return false;

        Optional<Empleado> empleadoOpt = buscarPorCedula(cedula);
        if (empleadoOpt.isEmpty()) {
            return false;
        }

        Empleado emp = empleadoOpt.get();

        try {
            if (nuevoTelefono != null && !nuevoTelefono.isEmpty()) {
                emp.setTelefono(nuevoTelefono);
            }

            if (nuevoCorreo != null && !nuevoCorreo.isEmpty()) {
                emp.setCorreo(nuevoCorreo);
            }

            if (nuevoPuesto != null && !nuevoPuesto.trim().isEmpty()) {
                emp.setPuesto(nuevoPuesto);
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Error al actualizar empleado: " + e.getMessage());
            return false;
        }

        return true;
    }

    // Eliminar empleado // sin mods
    public boolean eliminarEmpleado(String cedula) {
        Optional<Empleado> empleadoOpt = buscarPorCedula(cedula);
        if (empleadoOpt.isEmpty()) {
            return false;
        }

        listaEmpleados.remove(empleadoOpt.get());
        return true;
    }

    public Optional<Empleado> buscarPorCedula(String cedula) {
        return listaEmpleados.stream().filter(emp -> emp.getCedula().equalsIgnoreCase(cedula)).findFirst();

    }

    public boolean existeEmpleado(String cedula) {
        return buscarPorCedula(cedula).isPresent();
    }

    // por si se necesita en la GUI
    public ArrayList<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }
}
