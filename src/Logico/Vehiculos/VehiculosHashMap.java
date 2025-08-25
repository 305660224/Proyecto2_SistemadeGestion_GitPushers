
package Logico.Vehiculos;
import java.util.HashMap;

/**
 * 18/08/2125
 * @author dennis
 */
public class VehiculosHashMap {
    HashMap<String,Vehiculo> hashmap;

    //GETS
    public HashMap<String, Vehiculo> getHashmap() {
        return hashmap;
    }

    //CONTRUCTOR
    public VehiculosHashMap(HashMap<String, Vehiculo> hashmap) {
        this.hashmap = hashmap;
    }
    
    public Vehiculo buscar(String placa){  
        return hashmap.get(placa);
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
            
        //regex "^(\\d{6}|[A-Z]{3}-\\d{3})$" placa
    }
}
