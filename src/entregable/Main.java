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

        
        
        //System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8.name()));
        
        Sistema sistema = new Sistema();
        sistema.precargarFichas();
        
        boolean entrar = true;
        int opcion;

        
        Scanner in = new Scanner(System.in);

        
        while(entrar){
            
            System.out.println();
            System.out.println("Opciones: ");
            System.out.println("#---");
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
            System.out.println("#---");
            System.out.println();
            System.out.println("Ingrese el número de la opción deseada: ");
            
            
            //---
            // Manejo de excepciones, por si ingresa otra cosa que no sea uno
            // de esos numeros (letras, palabras, otro numero)
            
            // Revisa si el siguiente dato es un int, sin consumirlo
            boolean esNumero = in.hasNextInt();

            if(esNumero){
                // lee el int
                opcion = in.nextInt();
                // consume el resto de la linea para que no quede pendiente el Scanner
                in.nextLine();
            }
            else{
                in.nextLine();
                // Si se ejecuta esto el programa entra en el switch y en default
                // pq no existe esa opcion
                opcion = -1;
            }
            System.out.println();
            //---
            
            // Según lo que ingresó el usuario, se entra en cada case del switch
            
            switch (opcion) {
                
                //--------------------------------------------------------------
                
                case 0 -> {
                    System.out.println("Ha entrado en la opción terminar.");
                    System.out.println("El programa ha terminado.");
                    entrar = false;
                }
                
                //--------------------------------------------------------------
                
                case 1 -> {
                    System.out.println("Ha entrado en la opción información de autores.\n");
                    System.out.println("#--------------------------------");
                    sistema.mostrarAutores();
                    System.out.println("#--------------------------------");
                }
                
                //--------------------------------------------------------------
                
                case 2 -> {
                    String nombre = "";
                    String direccion;
                    String mail;
                    boolean check = false;
                    
                    // Sistema.registrarDosDiseniadores();
                    
                    System.out.println("Ha entrado en la opción registrar diseñador.\n");
                    System.out.println("Ingrese los datos del diseñador.");
                    while(!check){
                        System.out.println("Nombre: ");
                        nombre = in.nextLine();
                        if (nombre.isEmpty()){
                            System.out.println("El nombre no puede estar vacío. "); 
                        } else if (sistema.existeDiseniador(nombre)) {
                            System.out.println("Ya existe un diseñador con ese nombre.");
                        } else {
                            check = true;
                        }
                    }

                    System.out.println("Dirección: ");
                    direccion = in.nextLine();
                    System.out.println("Mail: ");
                    mail = in.nextLine();

                    sistema.registrarDiseniador(nombre, direccion, mail);
                }
                
                //--------------------------------------------------------------
                
                case 3 -> {
                    
                    String nombre = "";
                    String color = "";
                    String chico = "";
                    String grande = "";
                    boolean check = false;
                    
                    System.out.println("Ha entrado en la opción registrar ficha.\n");
                    System.out.println("Ingrese los datos de la ficha.");
                    
                    while(!check){
                        System.out.println("Nombre de la ficha: ");
                        nombre = in.nextLine(); 
                        if (nombre.isEmpty() || !nombre.equals(nombre.toUpperCase())) {
                            System.out.println("El nombre debe estar en mayúscula.");
                        } else if (sistema.existeFicha(nombre)) {
                            System.out.println("Ya existe una ficha con ese nombre.");
                        } else {
                            check = true;
                        }
                    }
                    
                    check = false;
                    while (!check){
                        System.out.println("Color de la ficha (R, A, B, N, M, V, G, C): ");
                        color = in.nextLine();
                        if (Ficha.colorValido(color)) {
                            check = true;
                        } else {
                            System.out.println("Color inválido.");
                        }
                    }
                    
                    check = false;
                    while (!check){
                        System.out.println("Diseño chico (3x3, 9 caracteres): ");
                        chico = in.nextLine();
                        if (Ficha.chicoValido(chico)) {
                            check = true;
                        } else { 
                            System.out.println("Debe tener exactamente 9 caracteres.");
                        }
                    }
                    
                    check = false;
                    while (!check) {
                        System.out.println("Diseño grande (5x5, 25 caracteres): ");
                        grande = in.nextLine();
                        if (Ficha.grandeValido(grande)) {
                            check = true;
                        } else {
                        System.out.println("Debe tener exactamente 25 caracteres.");
                        }
                    }

                    sistema.registrarFicha(nombre, color, chico, grande);
                }
                
                
                    
                //--------------------------------------------------------------    
                case 4 -> {System.out.println("Ha entrado en la opción creación de mural.\n");
                
                    // Paso los datos asi solo para probar si anda
                    // despues se los ingresa a mano
                    Diseniador d1 = new Diseniador("Ana Lopez", "18 de Julio 1234", "ana@gmail.com");
                    Ficha f0 = sistema.getListaFichas().get(0);
                    Ficha f1 = sistema.getListaFichas().get(1);
                    Ficha f2 = sistema.getListaFichas().get(7);
                    //Ficha f1 = new Ficha("SOL", "M", ".*.***.|.", "..*.. .***. ***** .***. ..*..");
                    //Ficha f2 = new Ficha("CORAZON", "R", ".*.***.*.", " .*. .*. ***** *****  ***   *  ");
                    
                    // Para probar el mural de prueba
                    // Mural miMural = new Mural("Mural de Prueba", d1, "P", f1, f2);
                    
                    // Para probar el mural damero
                    Mural mural2 = new Mural("Artistico", d1, "M", f0, f1, f2);
                    
                    mural2.imprimirChico();
                    mural2.imprimirGrande();
                }
                
                //--------------------------------------------------------------               
                
                case 5 -> System.out.println("Ha entrado en la opción modificar mural.\n");
                
                //--------------------------------------------------------------
                
                case 6 -> System.out.println("Ha entrado en la opción visualizar mural.\n");
                
                //--------------------------------------------------------------
                
                case 7 -> {
                    System.out.println("Ha entrado en la opción Listado de diseñadores.\n");
                    sistema.mostrarListaDiseniadores();
                }
                
                //--------------------------------------------------------------
                
                case 8 -> System.out.println("Ha entrado en la opción comparar similitud de murales.\n");
                
                //--------------------------------------------------------------
                
                case 9 -> {
                    System.out.println("Ha entrado en la opción visualizar todas las fichas.\n");
                    System.out.println("#--------------------------------");
                    for (Ficha f : sistema.getListaFichas()) {
                        System.out.println("");
                        System.out.println("Ficha: " + f.getNombre());
                        System.out.println("Color: " + f.getColor());
                        System.out.println("Tamaño chico: ");
                        System.out.print(f.imprimirFicha(f.getChico(), 3));
                        System.out.println("Tamaño grande: ");
                        System.out.print(f.imprimirFicha(f.getGrande(), 5));
                        System.out.println("");
                        System.out.println("#--------------------------------");
                    }
                }
                
                //--------------------------------------------------------------
                
                default -> System.out.println("Opcion inválida, debe ingresar un número.\n\nIntente nuevamente.");
                
                //--------------------------------------------------------------
            }
        }
        
        in.close();
        
    }
    

}
