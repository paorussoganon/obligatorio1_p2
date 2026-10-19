
/*
Información de autores:

Integrante 1: 
Nombre: Salvador Fernandez
Número: 262807

Integrante 2:
Nombre: Paola Russo
Número: 225129
*/

package entregable;

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
            
            resultado += codigoColor();
            resultado += cadena.substring(inicio, inicio + ancho).replace('.', ' ');
            resultado += "\u001B[0m\n";
        }
        
        return resultado;
    }
    

    //--------------------------------------------------------------------------

    public String codigoColor() {

        switch (this.color) {
            case "R": return "\u001B[31m"; // Rojo
            case "A": return "\u001B[34m"; // Azul
            case "V": return "\u001B[32m"; // Verde
            case "G": return "\u001B[35m"; // Magenta
            case "N": return "\u001B[30m"; // Negro
            case "B": return "\u001B[37m"; // Blanco
            case "M": return "\u001B[33m"; // Amarillo
            case "C": return "\u001B[36m"; // Celeste Cyan
            default: return "\u001B[0m";
        }
    }    
    

}

