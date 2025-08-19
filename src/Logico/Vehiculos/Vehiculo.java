
package Logico.Vehiculos;
import java.time.LocalDate;

/**
 * 18/08/2125
 * @author dennis
 */
public class Vehiculo {
    //ATRIBUTOS
    private String placa;
    private String marca;
    private String modelo;
    private LocalDate año;
    private Categoria categoria;
    private Estado estado;
    //GETS
    public String getPlaca() {
        //regex "^(\\d{6}|[A-Z]{3}-\\d{3})$"
        return placa;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public LocalDate getAño() {
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
    public Vehiculo(String placa, String marca, String modelo, LocalDate año, Categoria categoria) {
        //regex "^(\\d{6}|[A-Z]{3}-\\d{3})$"
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
        this.categoria = categoria;
        this.estado = estado.DISPONIBLE;
    }
    
    //OTROS




        
}
