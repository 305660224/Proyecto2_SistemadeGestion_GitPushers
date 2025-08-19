
package Logico.Vehiculos;

/**
 * 18/08/2125
 * @author dennis
 */
public enum Categoria {
    SUV      (1),
    SEDAN    (2),
    COUPE    (3),
    COMPACTO (4),
    PICKUP   (5);
    
    private final int categoria;

    private Categoria(int categoria) {
        this.categoria = categoria;
    }

    public int getcategoria() {
        return categoria;
    }
    
}
