/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GestionContratosAlquiler;

import Clientes.Cliente;
import Logico.Vehiculos.Vehiculo;
import Logico.Vehiculos.Estado;
import java.time.Period;
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
    private EstadoContrato estado;

    public Alquiler(String numeroAlquiler, Cliente cliente, Vehiculo vehiculo, LocalDate fechaInicio, LocalDate fechaFin) { // para solucionar el error lo que hice fue cambiar de parametro monto a por tarifaDiaria asi el error se va   
      this.numeroAlquiler = numeroAlquiler;
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        if(fechaInicio.isAfter(LocalDate.now())){
            this.fechaInicio = fechaInicio;
        }else{
            throw new IllegalArgumentException("La fecha de inicio no puede estar en el pasado.");
        }
        if(fechaFin.isAfter(fechaInicio)){
            this.fechaFin = fechaFin;
        }else{
            throw new IllegalArgumentException("La fecha de fin debe ser posterior a la fecha de inicio.");
        }
        this.monto = 35*Period.between(fechaInicio, fechaFin).getDays();   // nose el pq diablos me tira la senal de q hay algo mal .-. 
        this.estado = EstadoContrato.Activo;
        this.vehiculo.setEstado(Estado.ALQUILADO);
      
    }
    
    public void finalizar() {
        if (estado != EstadoContrato.Activo  ) {
            throw new IllegalStateException("Solo un alquiler activo puede finalizarse.");
        }
        this.estado = EstadoContrato.Finalizado;
        this.vehiculo.setEstado(Estado.DISPONIBLE);
    }
    
    public void cancelar() {
        if (estado == EstadoContrato.Finalizado || estado == EstadoContrato.Cancelado) {
            throw new IllegalStateException("No se puede cancelar un alquiler ya finalizado.");
        }
        this.estado = EstadoContrato.Cancelado;
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

    public EstadoContrato getEstado() {
        return estado;
    }  

    @Override
    public String toString() {
        return "Alquiler{" + "numeroAlquiler=" + numeroAlquiler + ", cliente=" + cliente + ", vehiculo=" + vehiculo + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", monto=" + monto + ", estado=" + estado + '}';
    }
    
    
}
