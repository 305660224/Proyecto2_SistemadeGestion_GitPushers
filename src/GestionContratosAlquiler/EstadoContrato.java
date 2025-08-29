/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package GestionContratosAlquiler;

/**
 *
 * @author duvan
 */
public enum EstadoContrato {
    Activo("Activo"),
    Finalizado("Finalizado"),
    Cancelado("Cancelado");
    
    private String Estado;

    public String getEstado() {
        return Estado;
    }

    private EstadoContrato(String Estado) {
        this.Estado = Estado;
    }
    
    
}
