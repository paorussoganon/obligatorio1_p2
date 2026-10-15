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
    private ArrayList<Diseniador> listaDiseniadores;

    public Sistema() {        
        listaDiseniadores = new ArrayList<Diseniador>();
    }
    
    // Metodo: Buscar diseniador por nombre, retorna null si no existe
    public Diseniador buscarDiseniador(String nombre){
        for (Diseniador d : listaDiseniadores){
            if (d.getNombre().equalsIgnoreCase(nombre)){
                return d;
            }
        }
        return null;
    }
    
    // Metodo: Indica si ya existe un diseniador con ese nombre
    public boolean existeDiseniador(String nombre){
        return buscarDiseniador(nombre) != null;
    }
    
    // Metodo: Registra un diseniador
    public void registrarDiseniador(String nombre, String direccion, String mail){
        Diseniador diseniador = new Diseniador(nombre, direccion, mail);
        listaDiseniadores.add(diseniador);
    }
    
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
    
    //--------------------------------------------------------------------------
    // Para clase Ficha
    
    // Crea una lista de fichas
    private ArrayList<Ficha> listaFichas = new ArrayList<Ficha>();
    
    
    // Metodo: Registra una ficha
    public void registrarFicha(String nombre, String color, String chico, String grande){
        Ficha ficha = new Ficha(nombre, color, chico, grande);
        listaFichas.add(ficha);
    }
    
    public ArrayList<Ficha> getListaFichas() {
        return new ArrayList<Ficha>(listaFichas);
    }
    
    // Metodo: Buscar una ficha por nombre, devuelve null si no existe
    public Ficha buscarFicha(String nombre) {
        for (Ficha f : listaFichas) {
            if (f.getNombre().equals(nombre)) {
                return f;
            }
        }
        return null;
    }
    
    // Metodo: Indica si ya existe una ficha con ese nombre
    // devuelve true si la encuentra
    public boolean existeFicha(String nombre) {
        return buscarFicha(nombre) != null;
    }
    
    // Precargar fichas
    public void precargarFichas(){
        registrarFicha("VACIA", "B", ".........", ".........................");
        registrarFicha("SOL", "M", "\\|/-*-/|\\", "..|...\\|/.--*--./|\\...|..");
        registrarFicha("CUADRADO", "N", "+-+|.|+-+", "+---+|...||...||...|+---+");
        registrarFicha("CORAZON", "R", "*.****.*.", "**.************.***...*..");
        registrarFicha("COPA", "C", "\\./.|./_\\", "\\.../.\\./...|....|.../_\\.");
        registrarFicha("ARBOL", "V", ".^.^^^.|.", "..^...^^^.^^^^^..|.../.\\.");
        registrarFicha("GATO", "A", "^.^o.o=^=", "/\\_/\\(o.o).>^<../|\\../.\\.");
        registrarFicha("DIAMANTE", "G", ".*.*.*.*.", "..*...*.*.*...*.*.*...*..");
    }
    
    //--------------------------------------------------------------------------
    // Nombre de autores
    
    public void mostrarAutores(){
        System.out.println("Integrante 1: ");
        System.out.println("Nombre: Salvador Fernandez");
        System.out.println("Número: 262807");
        System.out.println();
        System.out.println("Integrante 2: ");
        System.out.println("Nombre: Paola Russo");
        System.out.println("Número: 225129");
    }
    
    //--------------------------------------------------------------------------
    
    
    
    
    
    
    
}
    
    
    
    
    

