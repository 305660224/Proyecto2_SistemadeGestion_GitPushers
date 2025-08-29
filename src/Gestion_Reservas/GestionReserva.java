/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestion_Reservas;

import Clientes.Cliente;
import GestionContratosAlquiler.Alquiler;
import GestionContratosAlquiler.GestionAlquiler;
import Lists.List;
import Logico.Vehiculos.Categoria;
import Logico.Vehiculos.Estado;
import Logico.Vehiculos.Vehiculo;
import Utils.UtilsFecha;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Student
 */
public class GestionReserva implements List<Reservas> {

    Queue<Reservas> Reserva = new LinkedList<>();
    private GestionAlquiler gesAlquiler;

    private static GestionReserva InstanciaReserva;

    public static GestionReserva getInstanciaReserva() {
        if (InstanciaReserva == null) {
            InstanciaReserva = new GestionReserva();
        }
        return InstanciaReserva;
    }

    //GETS Y CONSTRUCTORES
    public Queue<Reservas> getReserva() {
        return Reserva;
    }

    public GestionAlquiler getGesAlquiler() {
        return gesAlquiler;
    }

    public GestionReserva() {
        this.gesAlquiler = GestionAlquiler.getInstanciaAlquiler();
    }

    //METODOS GENERICOS
    @Override
    public boolean añadir(Reservas t) {
        if (t.equals(buscar(t))) {
            return false;
        } else {
            Reserva.add(t);
            t.Ordenar((GestionReserva) Reserva);
            return true;
        }
    }

    @Override
    public boolean remover(Reservas t) {
        if (t.equals(buscar(t))) {
            Reserva.remove(t);
            return true;
        }
        return false;
    }

    @Override
    public Reservas buscar(Object id) {//Por id de reserva
        for (Reservas t : Reserva) {
            if (id.equals(t)) {
                return Reserva.element();
            }
        }
        return null;
    }

    //METODOS PERSONALES
    public Reservas buscarXFechas(LocalDate FechaIniBuscar, LocalDate FechaFinBuscar) {
        for (Reservas reservaBusFecha : Reserva) {
            if (reservaBusFecha.getFechaInicio() == FechaIniBuscar && reservaBusFecha.getFechaFin() == FechaFinBuscar) {
                return reservaBusFecha;
            }
        }
        return null;
    }

    public Reservas buscarXCliente(Cliente cliente) {
        for (Reservas reservaBusCliente : Reserva) {
            if (reservaBusCliente.getCliente() == cliente) {
                return reservaBusCliente;
            }
        }
        return null;
    }

    @Override
    public void showAll() {

    }

    //Se modifica con el numero de id de reserva que se va a cambiar y el vehiculo que se va a cambiar
    public boolean Modificar(int ReservaModificada, Categoria NuevoVehiculo) {
        for (Reservas Modificar : Reserva) {
            if (Modificar.getIdReserva() == ReservaModificada) {
                Modificar.getVehiculo().setCategoria(NuevoVehiculo);
                return true;
            }
        }
        return false;
    }

    public boolean NoReservaActiva(Reservas reserva1) {//Es para ver si no se entrelazan esas fechas y meter la reserva si la fecha no se entrelazan
        for (Reservas reserva2 : Reserva) {
            if (UtilsFecha.CalcularEntreFechas(reserva1.getFechaInicio(), reserva1.getFechaFin(), reserva2.getFechaInicio(), reserva2.getFechaFin())) {
                return true;
            }
        }
        return false;
    }

    public boolean CancelarReserva(Reservas cancelarReser) {
        if (buscar(cancelarReser) == cancelarReser) {
            if (cancelarReser.getFechaInicio().isAfter(LocalDate.now())) {
                remover(cancelarReser);
            }
        }
        return false;
    }

    public boolean ConfirmarReserva() {
        if (Reserva.isEmpty()) {
            return false;
        }

        Reservas ReservaTemp = Reserva.peek();

        if (ReservaTemp.ValidarDispoVehiculo()) {
            return false;
        }

        ReservaTemp.getVehiculo().setEstado(Estado.ALQUILADO);

        Alquiler NuevoAlquiler = new Alquiler(String.valueOf(gesAlquiler.getListaAlquileres().size() + 1), ReservaTemp.getCliente(), ReservaTemp.getVehiculo(), ReservaTemp.getFechaInicio(), ReservaTemp.getFechaFin());

        gesAlquiler.añadir(NuevoAlquiler);
        return true;
    }
}

