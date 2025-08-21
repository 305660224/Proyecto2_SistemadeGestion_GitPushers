/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestion_Reservas;

import Clientes.Cliente;
import Lists.List;
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

    @Override
    public boolean añadir(Reservas t) {
        if (t.equals(buscar(t))) {
            return false;
        } else {
            Reserva.add(t);
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
    public boolean Modificar(int ReservaModificada, Vehiculo NuevoVehiculo) {
        for (Reservas Modificar : Reserva) {
            if (Modificar.getIdReserva() == ReservaModificada) {
                Modificar.setVehiculo(NuevoVehiculo);
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
        //Cuando este Contratos de Alquiler(creo)
    }
}
