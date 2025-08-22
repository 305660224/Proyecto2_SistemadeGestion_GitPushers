/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package Clientes;

/**
 *
 * @author nazar
 */
public enum Tipo_licencia_Enum {
    
    
    // Motocicletas
    A1("Motocicletas hasta 125cc"),
    A2("Motocicletas hasta 500cc"),
    A3("Motocicletas de cualquier cilindraje"),
    // Vehículos livianos y carga
    B1("Vehículos livianos hasta 4000kg"),
    B2("Vehículos de carga hasta 8000kg"),
    B3("Vehículos de carga mayor a 8000kg"),
    // Profesionales
    C1("Autobuses y microbuses"),
    C2("Taxis"),
    C3("Tráilers y cabezales"),
    // Especiales
    D1("Tractores agrícolas y de obras"),
    D2("Maquinaria de construcción"),
    D3("Transporte especial de maquinaria"),
    // Exclusiva
    E("Todo tipo de vehículos ");
    private final String Tipo_licencia_Enum;

    
     Tipo_licencia_Enum (String Tipo_licencia_Enum) {
        this.Tipo_licencia_Enum = Tipo_licencia_Enum;
    }
     public String getTipo_licencia_Enum() {
        return Tipo_licencia_Enum;
    }
     

}
