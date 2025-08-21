/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Lists;

/**
 *
 * @author Student
 */
public interface List<T> {
    public boolean añadir(T t);
    
    public boolean remover(T t);
    
    public T buscar(Object id);
    
    public void showAll();
}
