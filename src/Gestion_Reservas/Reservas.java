/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestion_Reservas;

import Clientes.Cliente;
import Clientes.ClienteArrayList;
import Logico.Vehiculos.Estado;
import Logico.Vehiculos.Vehiculo;
import Logico.Vehiculos.VehiculosHashMap;
import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author duvan
 */
public class Reservas {

    private int idReserva;
    private Cliente cliente;
    private Vehiculo vehiculo;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    public int getIdReserva() {
        return idReserva;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Reservas(int idReserva/*Tal vez cambia después de duda con el profe(si es automaticamente generado o no)*/, Cliente cliente, Vehiculo vehiculo, LocalDate fechaInicio, LocalDate fechaFin) {
        this.idReserva = idReserva;
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public boolean verf_Cedula(ClienteArrayList ClienteLista) {
        return cliente.equals(ClienteLista.buscar(cliente));
    }

    public boolean verf_Vehiculo(VehiculosHashMap VehiculosLista) {
        return vehiculo.equals(VehiculosLista.buscar(vehiculo.getPlaca()));

    }

    public boolean NoMenorHoy() {
        return fechaInicio.isBefore(LocalDate.now());
    }

    public boolean FinNoAntesInicio() {
        return fechaFin.isBefore(fechaInicio);
    }

    public boolean NoMas30Dias() {
        return 30 < Period.between(fechaInicio, fechaFin).getDays();
    }

    public boolean ValidarDispoVehiculo() {
        return vehiculo.getEstado() == Estado.DISPONIBLE;
    }
}
