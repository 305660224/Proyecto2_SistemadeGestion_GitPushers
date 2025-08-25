/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GestionContratosAlquiler;

import Clientes.Cliente;
import Logico.Vehiculos.Vehiculo;
import Utils.UtilsFecha;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author danny
 */
public class GestionAlquiler {

    private ArrayList<Alquiler> listaAlquileres;

    public GestionAlquiler() {
        this.listaAlquileres = new ArrayList<>();
    }


    public void crearAlquiler(String numeroAlquiler, Cliente cliente, Vehiculo vehiculo,
                              LocalDate fechaInicio, LocalDate fechaFin, double tarifaDiaria) {
        if (cliente == null) {
            throw new IllegalArgumentException("El cliente no existe.");
        }
        if (vehiculo == null) {
            throw new IllegalArgumentException("El vehículo no existe.");
        }
        if (!UtilsFecha.NoFechaFutura(fechaInicio)) {
            throw new IllegalArgumentException("La fecha de inicio no puede estar en el pasado.");
        }
        if (!fechaFin.isAfter(fechaInicio)) {
            throw new IllegalArgumentException("La fecha de fin debe ser posterior a la de inicio.");
        }

        for (Alquiler a : listaAlquileres) {
            if (a.getVehiculo().getPlaca().equals(vehiculo.getPlaca()) &&
                a.getEstado().name().equals("EN_ALQUILER") &&
                UtilsFecha.CalcularEntreFechas(a.getFechaInicio(), a.getFechaFin(), fechaInicio, fechaFin)) {
                throw new IllegalStateException("El vehículo ya tiene un alquiler en esas fechas.");
            }
        }

        Alquiler nuevo = new Alquiler(numeroAlquiler, cliente, vehiculo, fechaInicio, fechaFin, tarifaDiaria);
        listaAlquileres.add(nuevo);
    }

    public void finalizarAlquiler(String numeroAlquiler) {
        Alquiler alquiler = buscarAlquiler(numeroAlquiler);
        if (alquiler == null) {
            throw new IllegalArgumentException("No se encontró el alquiler con número: " + numeroAlquiler);
        }
        alquiler.finalizar();
    }

    public void cancelarAlquiler(String numeroAlquiler) {
        Alquiler alquiler = buscarAlquiler(numeroAlquiler);
        if (alquiler == null) {
            throw new IllegalArgumentException("No se encontró el alquiler con número: " + numeroAlquiler);
        }
        alquiler.cancelar();
    }

    public Alquiler buscarAlquiler(String numeroAlquiler) {
        for (Alquiler a : listaAlquileres) {
            if (a.getNumeroAlquiler().equals(numeroAlquiler)) {
                return a;
            }
        }
        return null;
    }

    public ArrayList<Alquiler> buscarPorCliente(String cedula) {
        ArrayList<Alquiler> resultado = new ArrayList<>();
        for (Alquiler a : listaAlquileres) {
            if (a.getCliente().getCedula().equals(cedula)) {
                resultado.add(a);
            }
        }
        return resultado;
    }

    public ArrayList<Alquiler> buscarPorVehiculo(String placa) {
        ArrayList<Alquiler> resultado = new ArrayList<>();
        for (Alquiler a : listaAlquileres) {
            if (a.getVehiculo().getPlaca().equals(placa)) {
                resultado.add(a);
            }
        }
        return resultado;
    }

    public ArrayList<Alquiler> getListaAlquileres() {
        return listaAlquileres;
    }
    
    
}
