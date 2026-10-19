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

import java.util.Scanner;
import java.util.ArrayList;

public class Mural {
    
    String nombre;
    Diseniador diseniador;
    String formato;
    Ficha[][] mat;
    Ficha[][] matRespaldo;
    Ficha ficha0;
    Ficha ficha1;
    Ficha ficha2;
    Sistema sistema;

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

    public Mural(String unNombre, Diseniador unDiseniador, String unFormato,
                    Ficha unaFicha0, Ficha unaFicha1, Ficha unaFicha2,
                    Sistema unSistema, Scanner in) {
        
        this.nombre = unNombre;
        this.diseniador = unDiseniador;
        this.formato = unFormato;
        this.ficha0 = unaFicha0;
        this.ficha1 = unaFicha1;
        this.ficha2 = unaFicha2;
        this.sistema = unSistema;
        
        
        // Creo matriz de 10 filas x 12 columnas
        this.mat = new Ficha[10][12];
        this.matRespaldo = new Ficha[10][12];
        
        // Llamo al metodo que completa la matriz segun la opcion indicada
        this.crearMatriz(in);
        
        // Guardo una copia inicial de respaldo
        this.guardarRespaldo();
    }
    
    
    private void crearMatriz(Scanner in){
        // Llamo al metodo que crea la matriz segun la opcion
        switch (this.formato.toUpperCase()){
            case "D" -> this.generarDamero();
            case "F" -> this.generarFilas();
            case "B" -> this.generarBorde();
            case "R" -> this.generarRandom();
            case "M" -> this.generarManual(in);
        }
        
    }

    // Metodos para crear cada opcion de matriz
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
        
        // Inicialmente se llena todo el mural con fichas vacías
        Ficha fichavacia = sistema.getListaFichas().get(0);
        for (int i = 0; i < mat.length; i++){
            for (int j = 0; j < mat[0].length; j++){
                mat[i][j] = fichavacia;
            }        
        }
        
        // La cantidad de fichas tipo 1 y tipo 2 es aleatoria
        int cantfichas1 = (int)(Math.random() * 120) + 1;
        int cantfichas2 = (int)(Math.random() * 120) + 1;

        int coordi;
        int coordj;
        // Recorre la cantidad de fichas1 que tiene que colocar
        for (int k = 0; k < cantfichas1; k++){
            coordi = (int)(Math.random() * mat.length);
            coordj = (int)(Math.random() * mat[0].length);
            mat[coordi][coordj] = ficha1;
        }
        // Recorre la cantidad de fichas2 que tiene que colocar
        // si está ocupada, no importa, sobreescribe.
        // Elegimos hacerlo así, para que queden igualmente distribuidas
        // las fichas 2, 
        // (sino quedan muchas fichas1 y muy poquitas fichas2)
        for (int k = 0; k < cantfichas2; k++){
            coordi = (int)(Math.random() * mat.length);
            coordj = (int)(Math.random() * mat[0].length);
            mat[coordi][coordj] = ficha2;
        }
    }
    
    //--------------------------------------------------------------------------
    
    private void generarManual(Scanner in){
        
        // Metodo para ingresar fichas en el mural, manualmente
        for (int i = 0; i < mat.length; i++){
            for (int j = 0; j < mat[0].length; j++){
                mat[i][j] = ficha0;
            }        
        }
        
        boolean continuar = true;
        while (continuar){

            // Solicito coordenadas donde quiere ubicar la ficha
            // verificando que no sean invalidas
            System.out.println("Ingresar coordenadas en las que desea colocar la ficha.");

            System.out.println("i - vertical (de arriba hacia abajo, entre 0 y 9): ");
            int coordi = Helper.leerEnteroEnRango(in, 0, mat.length - 1);

            System.out.println("j - horizontal (de izquierda a derecha, entre 0 y 11): ");
            int coordj = Helper.leerEnteroEnRango(in, 0, mat[0].length - 1);

            // Solicito que ingrese el numero de ficha,
            // chequeo que el numero sea 1 o 2 previamente
            System.out.println("Indique cuál ficha de las ingresadas quiere colocar: 1 ó 2?");
            int numeroFicha = Helper.leerEnteroEnRango(in, 1, 2);

            // Busca la ficha y la inserta en la matriz en las coordenadas indicadas
            if (numeroFicha == 1){
                mat[coordi][coordj] = ficha1;
                System.out.println("Se colocó la ficha 1 correctamente.");
            }
            else {
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

    // Caso 5
    private void guardarRespaldo(){
        for (int i = 0; i < mat.length; i++){
            for (int j = 0; j < mat[0].length; j++){
                matRespaldo[i][j] = mat[i][j];
            }
        }
    }
    public void restaurar(){
        for (int i = 0; i < mat.length; i++){
            for (int j = 0; j < mat[0].length; j++){
                mat[i][j] = matRespaldo[i][j];
            }
        }
    }
    
    public void modificarPosicion(int fila, int columna, Ficha nueva){
        mat[fila][columna] = nueva;
    }
    
    public ArrayList<Ficha> fichasUsadas(){
        ArrayList<Ficha> usadas = new ArrayList<>();
        for (int i = 0; i < mat.length; i++){
            for (int j = 0; j < mat[0].length; j++){
                if (!usadas.contains(mat[i][j])){
                    usadas.add(mat[i][j]);
                }
            }
        }
        return usadas;
    }
    
    public void reemplazarFicha(Ficha vieja, Ficha nueva){
        for (int i = 0; i < mat.length; i++){
            for (int j = 0; j < mat[0].length; j++){
                if (mat[i][j] == vieja){
                    mat[i][j] = nueva;
                }
            }
        }
    }
    
    // Caso 8
    private boolean coincideEn(Mural original, int fOrig, int cOrig, int filas, int columnas, int f, int c){
        boolean coincide = true;
        for (int i = 0; i < filas; i++){
            for (int j = 0; j < columnas; j++){
                if (mat[f + i][c + j] != original.mat[fOrig + i][cOrig + j]){
                    coincide = false;
                }
            }
        }
        return coincide;
    }
    
    public int[] buscarArea(Mural original, int fOrig, int cOrig, int filas, int columnas){
        int[] posicion = null;
        for (int f = 0; f <= mat.length - filas; f++){
            for (int c = 0; c <= mat[0].length - columnas; c++){
                if (posicion == null && coincideEn(original, fOrig, cOrig, filas, columnas, f, c)){
                    posicion = new int[]{f + 1, c + 1};
                }
            }
        }
        return posicion;
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
                    
                    String color = mat[i][j].codigoColor();
                    String fragmento = dibujo.substring(inicio, inicio + 3).replace('.', ' ');
                    
                    System.out.print(color + fragmento + "\u001B[0m");
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
                    
                    String color = mat[i][j].codigoColor();
                    String fragmento = dibujo.substring(inicio, inicio + 5).replace('.', ' ');
                    
                    System.out.print(color + fragmento + "\u001B[0m");
                }
                System.out.println();
            }
        }
        System.out.println("");
        System.out.println("#-----------------------------------");
    }   

    //--------------------------------------------------------------------------    

    
    @Override
    public String toString() {
    return "Mural: " + nombre + ", diseñador: " + diseniador.getNombre()
         + ", formato: " + nombreDelFormato(formato);
    }
}