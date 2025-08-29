
package Logico.Vehiculos;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 18/08/2125
 * @author dennis
 */
public class VehiculosHashMap {
    HashMap<String,Vehiculo> hashmap;
    
    private static VehiculosHashMap InstanciaVehiculo;

    public static VehiculosHashMap getInstanciaVehiculo() {
        if(null==InstanciaVehiculo){
            InstanciaVehiculo=new VehiculosHashMap();
        }
        return InstanciaVehiculo;
    }
    
    
    
    //GETS
    public HashMap<String, Vehiculo> getHashmap() {
        return hashmap;
    }

    //CONTRUCTOR
    public VehiculosHashMap() {
        this.hashmap = new HashMap<>();
    }
    
    public Vehiculo buscar(String placa){  
        return hashmap.get(placa);
    }
    
    public boolean anadir(Vehiculo v) {
        if(hashmap.containsKey(v.getPlaca())) return false;
        System.out.println(v.toString());
        hashmap.put(v.getPlaca(), v);
        System.out.println(hashmap);
        return true;
    }

    public boolean remover(Vehiculo v) { //HACER EXEPCION
        if(!hashmap.containsKey(v.getPlaca())||v.getEstado()==Estado.ALQUILADO) 
            return false;
        hashmap.remove(v.getPlaca());
            return true;
    }        
        //regex "^(\\d{6}|[A-Z]{3}-\\d{3})$" placa
        
    public HashSet<String> getMarcas(){
        HashSet<String> set = new HashSet<>();
        for (Vehiculo vehiculo: hashmap.values()){
            set.add(vehiculo.getMarca());
        }
        return set;
    }
}
