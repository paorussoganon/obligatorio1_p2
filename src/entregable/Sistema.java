
package entregable;
import java.util.ArrayList;
import java.util.Collections;


public class Sistema {
    
    public Sistema() {        
        listaDiseniadores = new ArrayList<Diseniador>();
        listaMurales = new ArrayList<Mural>();
    }

    // Para clase Diseniador
    private ArrayList<Diseniador> listaDiseniadores;
    
    // Metodo: Buscar diseniador por nombre, retorna null si no existe
    public Diseniador buscarDiseniador(String nombre){
        for (Diseniador d : listaDiseniadores){
            if (d.getNombre().equalsIgnoreCase(nombre)){
                return d;
            }
        }
        return null;
    }
    
    // Metodo: Buscar diseniador por ID
    public Diseniador buscarDiseniadorPorID(int numero){
        for (Diseniador d : listaDiseniadores){
            if (numero == d.getIDDiseniador()){
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
    public void registrarDiseniador(int IDDiseniador, String nombre, String direccion, String mail){
        Diseniador diseniador = new Diseniador(IDDiseniador, nombre, direccion, mail);
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
    
    // Ultimo ID para helpers 
    private int ultimoIDDiseniador = 0;
    
    public int siguienteIDDiseniador() {
        ultimoIDDiseniador++;
        return ultimoIDDiseniador;
    }
    
    // Para clase Mural
    private ArrayList<Mural> listaMurales;
   
    public void agregarMural(Mural unMural) {
        this.listaMurales.add(unMural);
    }
    
    // Metodo: Muestra la lista de murales de un diseniador
    public void mostrarListaMurales(){
        for (int i = 0; i < listaMurales.size(); i++){
            System.out.println(listaMurales.get(i));
        }
    }
    
    // Metodo: Buscar mural por nombre
    public Mural buscarMuralPorNombre(String nombreMural){
        for (Mural m : listaMurales){
            if (nombreMural.equalsIgnoreCase(m.getNombre())){
                return m;
            }
        }
        return null;
    } 
    
    // Metodo: Indica si ya existe un mural con ese nombre
    public boolean existeMural(String nombreMural){
        return buscarMuralPorNombre(nombreMural) != null;
    }
    
    // Método: Muestra solo los murales de un diseñador específico
    public void mostrarMuralesDeDiseniador(String nombreDiseniador){
        for (Mural m : listaMurales) {
            if (m.getDiseniador().getNombre().equalsIgnoreCase(nombreDiseniador)) {
                System.out.println(m); // O imprime el nombre del mural
            }
        }
    }
    
    public ArrayList<Mural> getListaMurales() {
        return new ArrayList<Mural>(listaMurales);
    }
    
    public ArrayList<Mural> muralesDeDiseniador(Diseniador d) {
        ArrayList<Mural> resultado = new ArrayList<>();
        for (Mural m : listaMurales) {
            if (m.getDiseniador() == d) {
                resultado.add(m);
            }
        }
        return resultado;
    }

    // Para clase Ficha
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

}
    
    
    
    
    

