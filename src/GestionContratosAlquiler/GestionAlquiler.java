/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GestionContratosAlquiler;

import Lists.List;
import java.util.ArrayList;

/**
 *
 * @author danny
 */
public class GestionAlquiler implements List<Alquiler> {

    ArrayList<Alquiler> listaAlquileres = new ArrayList<>();

    public GestionAlquiler() {
        this.listaAlquileres = new ArrayList<>();
    }

    public ArrayList<Alquiler> getListaAlquileres() {
        return listaAlquileres;
    }

    @Override
    public boolean añadir(Alquiler t) {
        if (alquiler == null) {
            return false;
        }

        // Verificar que no exista otro con el mismo número de alquiler
        for (Alquiler a : listaAlquileres) {
            if (a.getNumeroAlquiler().equalsIgnoreCase(alquiler.getNumeroAlquiler())) {
                return false;
            }
        }

        listaAlquileres.add(alquiler);
        return true;
    }

    @Override
    public boolean remover(Alquiler t) {
        if (alquiler == null) {
            return false;
        }
        return listaAlquileres.remove(alquiler);
    }

    @Override
    public Alquiler buscar(Object id) {
        if (id instanceof String numeroAlquiler) {
            for (Alquiler a : listaAlquileres) {
                if (a.getNumeroAlquiler().equalsIgnoreCase(numeroAlquiler)) {
                    return a;
                }
            }
        }
        return null;
    }

    @Override
    public void showAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
