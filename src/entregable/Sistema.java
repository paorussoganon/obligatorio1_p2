/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entregable;
import java.util.ArrayList;

/**
 *
 * @author paorg
 */
public class Sistema {
    
    private ArrayList<Diseniador> listaDiseniadores = new ArrayList<Diseniador>();
    
    public boolean existeDiseniador(String nombre){
        // Chequea si el disenador ya esta en la lista o no
        boolean existe = false;
        
        for (Diseniador d: listaDiseniadores){
            if(d.getNombre().equals(nombre)){
                existe = true;
            }
            else{
                existe = false;
            }
        }
        return existe;
    }
    
    public void registrarDiseniador(String nombre, String direccion, String mail){
        Diseniador diseniador = new Diseniador(nombre, direccion, mail);
        listaDiseniadores.add(diseniador);
    }
    
    public ArrayList<Diseniador> getDiseniadores(){
        return listaDiseniadores;
    }
    
    
    
    
    //--------------------------------------------------------------------------
    public static void registrarDosDiseniadores(){
        
        Diseniador d1 = new Diseniador("Salvador", "MontevideoUruguay", "salvador@gmail");
        //Diseniador d1 = new Diseniador(nombre, direccion, mail);
        System.out.println(d1);
        Diseniador d2 = new Diseniador("Paola", "SaltoUruguay", "paola@gmail.com");
        System.out.println(d2);
        
    }
    //--------------------------------------------------------------------------
        
    
    
}
