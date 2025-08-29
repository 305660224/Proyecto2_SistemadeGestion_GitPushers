/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clientes;

import Lists.List;
import Utils.UtilsFecha;
import java.util.ArrayList;
import Gestion_Reservas.GestionReserva;

/**
 *
 * @author nazar
 */
public class ClienteArrayList implements List<Cliente> {

    ArrayList<Cliente> losClientes = new ArrayList<>();

    private static ClienteArrayList instanciaClientes;

    public static ClienteArrayList getInstanciaClientes() {
        if (null == instanciaClientes) {
            instanciaClientes = new ClienteArrayList();
        }
        return instanciaClientes;
    }

    public ClienteArrayList() {
        this.losClientes = new ArrayList<>();//Se inicializa
    }

    public ArrayList< Cliente> getlosClientes() {
        return losClientes;
    }

    @Override
    public boolean añadir(Cliente t) {
        // Validar edad 
        if (UtilsFecha.calcularEdad(t.getFechaNacimiento()) < 18) {
            return false; // No cumple edad mínima, no se agrega
        }

        // Validar cédula única
        for (Cliente cli : losClientes) {
            if (cli.getCedula().equals(t.getCedula())) {
                return false;
            }
        }

        // Valida la licencia
        if (t.getLicencia() == null) {
            return false; // No tiene 
        }

        losClientes.add(t);
        return true; // se agrega el cliente, si no es un cliente repetido
    }

    @Override
    public boolean remover(Cliente t) {
        return false;
    }

    @Override
    public Cliente buscar(Object id) {
        // Busca al cliente por su cedula
        for (Cliente cli : losClientes) {
            if (cli.getCedula().equals(id.toString())) {
                return cli;
            }
        }
        return null; // Si no lo encuentra
    }
    
    public Cliente buscarXcedula(String cedula) {
        // Busca al cliente por su cedula
    for (Cliente cli : losClientes) {
        if (cli.getCedula().equals(cedula)) {
            return cli;
        }
    }
        return null; // Si no lo encuentra
    }

    @Override
    public void showAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public boolean eliminarCliente(Cliente t, GestionReserva gestionReserva)
            throws ClienteReservaException, ClienteNoEncontradoException {

        // Revisar si el cliente tiene reservas activas
        if (gestionReserva.buscarXCliente(t) != null) {
            throw new ClienteReservaException("El cliente tiene reservas activas y no puede ser eliminado.");
        }

        // Intentar eliminarlo
        boolean eliminado = losClientes.removeIf(cli -> cli.getCedula().equals(t.getCedula()));

        if (!eliminado) {
            throw new ClienteNoEncontradoException("El cliente con cédula " + t.getCedula() + " no existe en la lista.");
        }

        return true; // si lo eliminó con éxito
    }

    public boolean actualizarCliente(String cedula, String telefono, String correo, Tipo_licencia_Enum licencia) {
        Cliente cli = buscar(cedula);
        if (cli != null) {
            cli.setTelefono(telefono);
            cli.setCorreo(correo);
            cli.setLicencia(licencia);
            return true;
        }
        return false;
    }

    public Iterable<Cliente> getClientes() {
        return losClientes;
    }

}
