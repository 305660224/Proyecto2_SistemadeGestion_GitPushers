/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GestionContratosAlquiler;

import Clientes.Cliente;
import Logico.Vehiculos.Vehiculo;
import Logico.Vehiculos.Estado;
import Utils.UtilsFecha;
import java.time.LocalDate;


/**
 *
 * @author danny
 */
public class Alquiler {

    private String numeroAlquiler;
    private Cliente cliente;
    private Vehiculo vehiculo;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private double monto;
    private Estado estado;

    public Alquiler(String numeroAlquiler, Cliente cliente, Vehiculo vehiculo, LocalDate fechaInicio, LocalDate fechaFin, double monto) {
      if (!UtilsFecha.NoFechaFutura(fechaInicio)) {
            throw new IllegalArgumentException("La fecha de inicio no puede estar en el pasado.");
        }
      if (!fechaFin.isAfter(fechaInicio)) {
            throw new IllegalArgumentException("La fecha de fin debe ser posterior a la fecha de inicio.");
        }
      this.numeroAlquiler = numeroAlquiler;
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.monto = calcularMonto(tarifaDiaria);// nose el pq diablos me tira la senal de q hay algo mal .-. 
        this.estado = Estado.ALQUILADO;
        this.vehiculo.setEstado(Estado.ALQUILADO);
      
    }
    
    private double calcularMonto(double tarifaDiaria) {
        long dias = fechaInicio.until(fechaFin).getDays();
        if (dias <= 0) {
            throw new IllegalArgumentException("El período de alquiler debe ser de al menos 1 día.");
        }
        return tarifaDiaria * dias;
    }
    
      // Finalizar alquiler
    public void finalizar() {
        if (estado != Estado.ALQUILADO  ) {
            throw new IllegalStateException("Solo un alquiler activo puede finalizarse.");
        }
        this.estado = Estado.DISPONIBLE;
        this.vehiculo.setEstado(Estado.DISPONIBLE);
    }
    
    public void cancelar() {
        if (estado == Estado.DISPONIBLE) {
            throw new IllegalStateException("No se puede cancelar un alquiler ya finalizado.");
        }
        this.estado = Estado.DISPONIBLE;
        this.vehiculo.setEstado(Estado.DISPONIBLE);
    }

    public String getNumeroAlquiler() {
        return numeroAlquiler;
    }

    public Cliente getCliente() {
        return cliente;
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

    public double getMonto() {
        return monto;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setNumeroAlquiler(String numeroAlquiler) {
        this.numeroAlquiler = numeroAlquiler;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }



    
}
