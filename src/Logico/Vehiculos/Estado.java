
package Logico.Vehiculos;

/**
 * 18/08/2125
 * @author dennis
 */
public enum Estado {
    DISPONIBLE       (1),
    ALQUILADO        (2),
    MANTENIMIENTO    (3);
    
    private final int estado;

    private Estado(int estado) {
        this.estado = estado;
    }

    public int getestado() {
        return estado;
    }
    
}
