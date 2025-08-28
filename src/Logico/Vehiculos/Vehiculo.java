
package Logico.Vehiculos;
import java.time.Year;
//import java.util.regex.*;

/**
 * 18/08/2125
 * @author dennis
 */
public class Vehiculo {
    //ATRIBUTOS
    private String placa;
    private String marca;
    private String modelo;
    private Year año;
    private Categoria categoria;
    private Estado estado;
    
    //GETS
    public String getPlaca() {
        return placa;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public Year getAño() {
        return año;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Estado getEstado() {
        return estado;
    }
    
    //SETS

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    
    //CONSTRUCTOR
    public Vehiculo(String placa, String marca, String modelo, Year año, Categoria categoria) {
        if (placa.toUpperCase().matches("^(?:\\d{3}-\\d{3}|[A-Z]{3}-\\d{3})$")) { //CORREGIR          
        this.placa = placa.toUpperCase();
        }
        this.marca = marca;
        this.modelo = modelo;
        if (año.isBefore(Year.now())) {            
        this.año = año;
        }
        this.categoria = categoria;
        this.estado = estado.DISPONIBLE;
    }
    
    //OTROS

    @Override
    public String toString() {
        return "Vehiculo{" + "placa=" + placa + ", marca=" + marca + ", modelo=" + modelo + ", a\u00f1o=" + año + ", categoria=" + categoria + ", estado=" + estado + '}';
    }




        
}
