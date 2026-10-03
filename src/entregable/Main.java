/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package entregable;

import java.util.Scanner;
//import java.io.PrintStream;
//import java.nio.charset.StandardCharsets;

/**
 *
 * @author paorg
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8.name()));

        
        boolean entrar = true;
        int opcion;
        Scanner in = new Scanner(System.in);
        
        while(entrar){
            
            System.out.println();
            System.out.println("Opciones: ");
            System.out.println("---------");
            System.out.println("0 - Terminar.");
            System.out.println("1 - Informacion de autores del obligatorio.");
            System.out.println("2 - Registrar diseñador.");
            System.out.println("3 - Registrar ficha.");        
            System.out.println("4 - Creación del mural.");
            System.out.println("5 - Modificar mural.");
            System.out.println("6 - Visualizar mural.");
            System.out.println("7 - Listado de diseñadores.");
            System.out.println("8 - Comparar similitud de murales.");
            System.out.println("9 - Visualizar todas las fichas.");
            System.out.println("---------");
            System.out.println();
            System.out.println("Ingrese el número de la opción deseada: ");
            System.out.println();

            opcion = in.nextInt();

            switch (opcion) {
                case 0 -> {
                    System.out.println("El programa ha terminado.");
                    entrar = false;
                }
                
                case 1 -> {
                    System.out.println("Opcion 1 anda");
                }
                
                case 2 -> {
                    System.out.println("Opcion 2 anda");
                    registrarDiseniador();
                }
                
                case 3 -> System.out.println("Opcion 3 anda");
                case 4 -> System.out.println("Opcion 4 anda");
                case 5 -> System.out.println("Opcion 5 anda");
                case 6 -> System.out.println("Opcion 6 anda");
                case 7 -> System.out.println("Opcion 7 anda");
                case 8 -> System.out.println("Opcion 8 anda");
                case 9 -> System.out.println("Opcion 9 anda");
                
                default -> System.out.println("Opcion inválida, ingrese otro número");
                
            }
        }
        
        in.close();
        
    }
    

}
