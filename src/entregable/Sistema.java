/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entregable;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author paorg
 */
public class Sistema {
    
    
    //--------------------------------------------------------------------------
    
    // Para clase Diseniador
    
    // Crea una lista de diseniadores
    private ArrayList<Diseniador> listaDiseniadores = new ArrayList<Diseniador>();
    
    // Metodo: Busca si existe el diseniador con ese nombre
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
    
    // Metodo: Registra un diseniador
    public void registrarDiseniador(String nombre, String direccion, String mail){
        Diseniador diseniador = new Diseniador(nombre, direccion, mail);
        listaDiseniadores.add(diseniador);
    }
    
    //public ArrayList<Diseniador> getDiseniadores(){
    //    return listaDiseniadores;
    //}
    
    // Metodo: Ordena la lista de diseniadores en orden alfabético
    public ArrayList<Diseniador> ordenar(){
        Collections.sort(listaDiseniadores);
        return listaDiseniadores;
    }
    
    // Metodo: Muestra la lista de diseniadores ya ordenada
    public void mostrarListaDiseniadores(){
        ordenar();
        for (int i = 0; i < listaDiseniadores.size(); i++){
            System.out.println(listaDiseniadores.get(i));
        }
    }

    
    /*
    //--------------------------------------------------------------------------
    public static void registrarDosDiseniadores(){
        
        Diseniador d1 = new Diseniador("Salvador", "MontevideoUruguay", "salvador@gmail");
        //Diseniador d1 = new Diseniador(nombre, direccion, mail);
        System.out.println(d1);
        Diseniador d2 = new Diseniador("Paola", "SaltoUruguay", "paola@gmail.com");
        System.out.println(d2);
        
    }
    //--------------------------------------------------------------------------
    */
    
    //--------------------------------------------------------------------------
    // Para clase Ficha
    
    // Crea una lista de fichas
    private ArrayList<Ficha> listaFichas = new ArrayList<Ficha>();
    
    
    // Metodo: Registra una ficha
    public void registrarFicha(String nombre, String color, String chico, String grande){
        Ficha ficha = new Ficha(nombre, color, chico, grande);
        listaFichas.add(ficha);
    }
    
    // Metodo: imprime por pantalla la ficha
    private void imprimirFicha(String cadena, int ancho) {
        for (int i = 0; i < ancho; i++) {
            int inicio = i * ancho;
            System.out.println(cadena.substring(inicio, inicio + ancho).replace('.', ' '));
        }
    }
    
    // Metodo: muestra la lista de fichas con sus atributos
    public void mostrarListaFichas(){
        for (int i = 0; i < listaFichas.size(); i++){
            
            Ficha ficha = listaFichas.get(i);
            
            System.out.println("Ficha: " + ficha.getNombre());
            System.out.println("Color: " + ficha.getColor());
            
            // Imprime la ficha chica
            System.out.println("Tamaño chico: ");
            imprimirFicha(ficha.getChico(), 3);
            
            // Imprime la ficha grande
            System.out.println("Tamaño grande: ");
            imprimirFicha(ficha.getGrande(), 5);
        
        
        }
    }
    
    

        
        
    }
    
    //--------------------------------------------------------------------------
    
    
    
}
