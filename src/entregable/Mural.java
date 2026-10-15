/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entregable;
import java.util.Scanner;

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
    Ficha ficha0;
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

    public Ficha getFicha0() {
        return ficha0;
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
    
    public Mural(String unNombre, Diseniador unDiseniador, String unFormato, Ficha unaFicha0, Ficha unaFicha1, Ficha unaFicha2) {
        this.nombre = unNombre;
        this.diseniador = unDiseniador;
        this.formato = unFormato;
        this.ficha0 = unaFicha0;
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
        
        // Recorro toda la matriz,
        // si la posición actual es el i o j correspondiente al borde
        // entonces completo con ficha 1
        // si no es ninguna de esas posiciones, completo con ficha 2.
        // Ojo que al usar <, el borde derecho es j = mat[0].length - 1
        // y el borde de abajo es i = mat.length - 1
        
        for (int i = 0; i < mat.length; i++){
            for (int j = 0; j < mat[0].length; j++){
        
                if (i == 0 || i == mat.length - 1 || j == 0 || j == mat[0].length - 1){
                    
                    mat[i][j] = ficha1;
                }
                else{
                    mat[i][j] = ficha2;
                }
            }
        }
    }
    
    //--------------------------------------------------------------------------
    
    private void generarRandom(){
        
    }
    
    //--------------------------------------------------------------------------
    
    private void generarManual(){
        
        // Metodo para ingresar fichas en el mural, manualmente
        for (int i = 0; i < mat.length; i++){
            for (int j = 0; j < mat[0].length; j++){
                mat[i][j] = ficha0;
            }        
        }
        
        boolean continuar = true;
        Scanner in = new Scanner(System.in);
        
        continuar = true;
        while (continuar){

            // Solicito coordenadas donde quiere ubicar la ficha
            // verificando que no sean invalidas
            System.out.println("Ingrese la coordenada (i, j) en la que desea colocar la ficha:");

            int coordi = -1;
            boolean validai = false;
            while (validai == false){
                System.out.println("i - vertical (de arriba hacia abajo, entre 0 y 9): ");
                coordi = in.nextInt();
                in.nextLine(); // Limpio el buffer
                validai = (coordi >= 0) && (coordi < mat.length);
                if (validai == false){
                    System.out.println("La coordenada i ingresada es incorrecta, inténtelo nuevamente.");
                }
            }

            int coordj = -1;
            boolean validaj = false;
            while (validaj == false){
                System.out.println("j - horizontal (de izquierda a derecha, entre 0 y 11): ");
                coordj = in.nextInt();
                in.nextLine(); // Limpio el buffer
                validaj = (coordj >= 0) && (coordj < mat[0].length);
                if (validaj == false){
                    System.out.println("La coordenada j ingresada es incorrecta, inténtelo nuevamente.");
                }            
            }

            // Solicito que ingrese el numero de ficha,
            // chequeo que el numero sea 1 o 2 previamente
            boolean validonum = false;
            int numeroFicha = -1;
            while (validonum == false){
                System.out.println("Indique cuál ficha de las ingresadas quiere colocar: 1 ó 2?)");
                numeroFicha = in.nextInt();
                in.nextLine(); // Limpio el buffer
                validonum = numeroFicha == 1 || numeroFicha == 2;
                if (validonum == false){
                    System.out.println("El número de ficha ingresada es incorrecto, inténtelo nuevamente.");
                }                
            }

            // Busca la ficha y la inserta en la matriz en las coordenadas indicadas
            Ficha ficha;
            if (numeroFicha == 1){
                mat[coordi][coordj] = ficha1;
                System.out.println("Se colocó la ficha 1 correctamente.");
            }
            else if (numeroFicha == 2){
                mat[coordi][coordj] = ficha2;
                System.out.println("Se colocó la ficha 2 correctamente.");
            }

            boolean validoletra = false;
            String letrayn = "";
            while (validoletra == false){
                System.out.println("Desea continuar ingresando fichas?: (y/n)");
                letrayn = in.nextLine();
                validoletra = letrayn.equalsIgnoreCase("y") || letrayn.equalsIgnoreCase("n");           
                if (validoletra == false){
                    System.out.println("La letra ingresada es incorrecta, inténtelo nuevamente.");
                }            
            }

            System.out.println("Vista previa del mural chico: ");
            imprimirChico();
                    
            // Si el usuario ingresa que no quiere continuar "n", se sale del while
            if (letrayn.equalsIgnoreCase("n")){
                continuar = false;
            }
            
        }
        
    }
        
        
        
    


    
    //--------------------------------------------------------------------------
    
    // Genero una matriz cualquiera para probar
    private void generarPrueba(){
        for (int i = 0; i < mat.length; i++){
            for (int j = 0; j < mat[0].length; j++){
                mat[i][j] = ficha1;
            }
        }
    }
    
    //--------------------------------------------------------------------------
    
    private void guardarRespaldo(){
        
        
    }
    
    //--------------------------------------------------------------------------
    
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
    
    //--------------------------------------------------------------------------

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

    //--------------------------------------------------------------------------
    
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

    //--------------------------------------------------------------------------    

    
    
    
    
}
