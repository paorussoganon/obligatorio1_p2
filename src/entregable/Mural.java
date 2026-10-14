/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entregable;

/**
 *
 * @author paorg
 */
public class Mural {
    
    String nombre;
    Diseniador diseniador;
    String formato;
    Ficha[][] mat;
    Ficha[][] matRespaldo;
    Ficha ficha1;
    Ficha ficha2;
    
    
    //--------------------------------------------------------------------------
    // Getters, para poder acceder desde afuera a leer los atributos

    public String getNombre() {
        return nombre;
    }

    public Diseniador getDiseniador() {
        return diseniador;
    }

    public String getFormato() {
        return formato;
    }

    public Ficha[][] getMat() {
        return mat;
    }

    public Ficha getFicha1() {
        return ficha1;
    }

    public Ficha getFicha2() {
        return ficha2;
    }
    //--------------------------------------------------------------------------
    
    // Setters: no se ponen, pq no se quiere que se puedan modificar los
    // atrubitos desde afuera
    
    //--------------------------------------------------------------------------

    // Constructores
    
    public Mural(String unNombre, Diseniador unDiseniador, String unFormato, Ficha unaFicha1, Ficha unaFicha2) {
        this.nombre = unNombre;
        this.diseniador = unDiseniador;
        this.formato = unFormato;
        this.ficha1 = unaFicha1;
        this.ficha2 = unaFicha2;
        
        // Creo matriz de 10 filas x 12 columnas
        this.mat = new Ficha[10][12];
        this.matRespaldo = new Ficha[10][12];
        
        // Llamo al metodo que completa la matriz segun la opcion indicada
        this.crearMatriz();
        
        // Guardo una copia inicial de respaldo
        this.guardarRespaldo();
    }
    
    
    private void crearMatriz(){
        // Llamo al metodo que crea la matriz segun la opcion
        switch (this.formato.toUpperCase()){
            case "D" -> this.generarDamero();
            case "F" -> this.generarFilas();
            case "B" -> this.generarBorde();
            case "R" -> this.generarRandom();
            case "M" -> this.generarManual();
            case "P" -> this.generarPrueba();
        }
        
    }
    
    //--------------------------------------------------------------------------
    
    // Metodos para crear cada opcion de matriz
    
    //--------------------------------------------------------------------------
    
    private void generarDamero(){
        
        // Recorro todas las posiciones ij de la matriz
        
        // Si i es par (i = 0, 2, 4...)
        // asigno la ficha 1 a las j pares
        // y la ficha 2 a las j impares
        
        // Si i es impar (i = 1, 3, 5...)
        // asigno al reves, la ficha 2 a las j pares
        // la ficha 1 a las j impares
        
        for (int i = 0; i < mat.length; i++){
            for (int j = 0; j < mat[0].length; j++){
                
                if (i % 2 == 0){
                    if (j % 2 == 0){
                        mat[i][j] = ficha1;
                    }
                    else{
                        mat[i][j] = ficha2;
                    }
                }
                
                
                else{
                    if (j % 2 == 0){
                        mat[i][j] = ficha2;
                    }
                    else{
                        mat[i][j] = ficha1;
                    }
                }
            }
        }
        
    }
    
    //--------------------------------------------------------------------------
    
    private void generarFilas(){
        
        // Recorro toda la matriz
        // si i es par, asigno la ficha 1
        // si i es impar, asigno la ficha 2        
        
        for (int i = 0; i < mat.length; i++){
            for (int j = 0; j < mat[0].length; j++){
                if (i % 2 == 0){
                    mat[i][j] = ficha1;
                }
                else{
                    mat[i][j] = ficha2;
                }
            }
        }
        
    }
    
    //--------------------------------------------------------------------------
    
    private void generarBorde(){
        
    }
    
    private void generarRandom(){
        
    }
    
    private void generarManual(){
                
    }
    
    // Genero una matriz cualquiera para probar
    private void generarPrueba(){
        for (int i = 0; i < mat.length; i++){
            for (int j = 0; j < mat[0].length; j++){
                mat[i][j] = ficha1;
            }
        }
    }
    
    private void guardarRespaldo(){
        
        
    }
    
    private String nombreDelFormato(String formato){
        String nombreFormato = "";
        switch (formato.toUpperCase()){
            case "D" -> nombreFormato = "Damero";
            case "F" -> nombreFormato = "Filas";
            case "B" -> nombreFormato = "Borde exterior";
            case "R" -> nombreFormato = "Random";
            case "M" -> nombreFormato = "Manual";
            case "P" -> nombreFormato = "Prueba";
        }
        return nombreFormato;
    }

    public void imprimirChico() {
        System.out.println("#-----------------------------------");
        System.out.println("");
        System.out.println("Mural tamaño chico, " + "formato: " + nombreDelFormato(formato));
        System.out.println("");
        
        // Este procedimiento imprime cualquier mural chico
        
        // Comienza por la primera fila i = 0,
        // con k recorre la primera ficha (versión tamaño chico, y recorta los primeros 3 caracteres
        // con j, recorre todas las posiciones de columna de la matriz,
        // y repite el procedimiento con cada ficha
        // con eso imprime toda la primera fila
        // luego hace un salto de linea,
        // y pasa a la segunda fila i = 1, para repetir el procedimiento
        // Asi completa todo el mural
        
        for (int i = 0; i < 10; i++) {
            for (int k = 0; k < 3; k++) {
                for (int j = 0; j < 12; j++) {
                    
                    String dibujo = mat[i][j].getChico();
                    int inicio = k * 3;

                    System.out.print(
                        dibujo.substring(inicio, inicio + 3).replace('.', ' ')
                    );
                }
                System.out.println();
            }
        }
        System.out.println("");
    }

    
    
    
     public void imprimirGrande() {
        System.out.println("#-----------------------------------");
        System.out.println("");
        System.out.println("Mural tamaño grande, " + "formato: " + nombreDelFormato(formato));
        System.out.println("");
        
        // Este procedimiento imprime cualquier mural grande        
        // Idem al imprimirChico, pero usando la ficha de tamaño grande.
        
        for (int i = 0; i < 10; i++) {
            for (int k = 0; k < 5; k++) {
                for (int j = 0; j < 12; j++) {
                    
                    String dibujo = mat[i][j].getGrande();
                    int inicio = k * 5;

                    System.out.print(
                        dibujo.substring(inicio, inicio + 5).replace('.', ' ')
                    );
                }
                System.out.println();
            }
        }
        System.out.println("");
        System.out.println("#-----------------------------------");
    }   


        

    
    
    
    
}
