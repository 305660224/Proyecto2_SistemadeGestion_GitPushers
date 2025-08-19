
package Logico.Vehiculos;
import java.util.HashMap;

/**
 * 18/08/2125
 * @author dennis
 */
public class VehiculosHashMap {
    HashMap<String,Vehiculo> hashmap;

    public HashMap<String, Vehiculo> getHashmap() {
        return hashmap;
    }

    public VehiculosHashMap(HashMap<String, Vehiculo> hashmap) {
        this.hashmap = hashmap;
    }
    
    public boolean anadir(Vehiculo v) {
        if(hashmap.containsKey(v.getPlaca())) 
            return false;
        hashmap.put(v.getPlaca(), v);
        return true;
    }

    public boolean remover(Vehiculo v) { //HACER EXEPCION
        if(!hashmap.containsKey(v.getPlaca())||v.getEstado()==Estado.ALQUILADO) 
            return false;
        hashmap.remove(v.getPlaca());
        return true;
        
        //METODO BUSCAR
        //regex "^(\\d{6}|[A-Z]{3}-\\d{3})$" placa
    }
}
