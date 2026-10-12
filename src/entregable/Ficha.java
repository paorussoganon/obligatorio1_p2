/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entregable;

/**
 *
 * @author paorg
 */
public class Ficha {
    
    // constantes
    public static final int LADO_CHICO = 3;
    public static final int LADO_GRANDE = 5;
    public static final String COLORES = "RABNMVGC";
    
    // variables de instancia
    private String nombre;
    private String color;
    private String chico;
    private String grande;

    
    // Constructores
    public Ficha(String nombre, String color, String chico, String grande){
        this.setNombre(nombre);
        this.setColor(color);
        this.setChico(chico);
        this.setGrande(grande);
    }

    // Metodo de acceso
    public String getNombre(){
        return nombre;
    }
    
    public String getColor(){
        return color;
    }
    
    public String getChico(){
        return chico;
    }
    
    public String getGrande(){
        return grande;
    }
    
    // Metodos de modificacion
    public void setNombre(String unNombre){
        nombre = unNombre;
    }
    
    public void setColor(String unColor){
        color = unColor;
    }
    
    public void setChico(String unChico){
        chico = unChico;
    }
    
    public void setGrande(String unGrande){
        grande = unGrande;
    }
    
    /*
    // Metodo: para mostrar el dibujo de la ficha
    public void mostrarFichaChica(Ficha ficha){
        
        for(int i = 0; i < ficha.getChico().length(); i++){
            
            if(ficha.getChico().charAt(i) == '.'){
                System.out.println("/n");
            }
            else{
                System.out.println(ficha.getChico().charAt(i));
            }
            
        }
    }
    */
    
    // validadores 
    
    public static boolean colorValido(String color) {
    return color.length() == 1 && "RABNMVGC".contains(color);
    }

    public static boolean chicoValido(String diseno) {
        return diseno.length() == LADO_CHICO * LADO_CHICO;
    }

    public static boolean grandeValido(String diseno) {
        return diseno.length() == LADO_GRANDE * LADO_GRANDE;
    }
    
    // Metodo: imprime por pantalla la ficha
    
    public String imprimirFicha(String cadena, int ancho) {
        String resultado = "";
        for (int i = 0; i < ancho; i++) {
            int inicio = i * ancho;
            resultado += cadena.substring(inicio, inicio + ancho).replace('.', ' ') + "\n";
        }
        return resultado;
    }
    

}

