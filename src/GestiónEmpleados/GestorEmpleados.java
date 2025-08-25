/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GestiónEmpleados;

import Lists.List;
import java.util.ArrayList;

/**
 *
 * @author danny
 */
public class GestorEmpleados implements List<Empleado> {

    ArrayList<Empleado> listaEmpleados = new ArrayList<>();

    public GestorEmpleados() {
        this.listaEmpleados = new ArrayList<>();
    }

    public ArrayList<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }


    @Override
    public boolean añadir(Empleado t) {
        if (empleado == null) {
            return false;
        }

        // Validar que no exista otro con la misma cédula
        for (Empleado emp : listaEmpleados) {
            if (emp.getCedula().equalsIgnoreCase(empleado.getCedula())) {
                return false; // Ya existe
            }
        }

        listaEmpleados.add(empleado);
        return true;
    }

    @Override
    public boolean remover(Empleado t) {
        if (empleado == null) {
            return false;
        }
        return listaEmpleados.remove(empleado);
    }

    @Override
    public Empleado buscar(Object id) {
        if (id instanceof String cedula) {
            for (Empleado emp : listaEmpleados) {
                if (emp.getCedula().equalsIgnoreCase(cedula)) {
                    return emp;
                }
            }
        }
        return null;
    }

    @Override
    public void showAll() {
        if (listaEmpleados.isEmpty()) {
            System.out.println("No hay empleados registrados.");
            return;
        }
        for (Empleado emp : listaEmpleados) {
            System.out.println(emp);
        }
    }

}
