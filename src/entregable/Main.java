
package entregable;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        sistema.precargarFichas();
        
        boolean entrar = true;
        int opcion;
        int IDDiseniador = 0;

        Scanner in = new Scanner(System.in);

        while(entrar){
            Helper.limpiarPantalla();
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
            
            boolean esNumero = in.hasNextInt();

            if(esNumero){
                opcion = in.nextInt();
                in.nextLine();
            }
            else{
                in.nextLine();
                opcion = -1;
            }
            System.out.println();
            
            switch (opcion) {

                case 0 -> {
                    System.out.println("Ha entrado en la opción terminar.");
                    System.out.println("El programa ha terminado.");
                    entrar = false;
                }

                case 1 -> {
                    System.out.println("Ha entrado en la opción información de autores.\n");
                    System.out.println("#--------------------------------");
                    sistema.mostrarAutores();
                    System.out.println("#--------------------------------");
                }
                
                case 2 -> {
                    System.out.println("Ha entrado en la opción registrar diseñador.\n");
                    System.out.println("Ingrese los datos del diseñador.");
                    String nombre = Helper.leerNombreDiseniadorUnico(in, sistema);
                    Helper.registrarDiseniadorConNombre(in, sistema, nombre);
                }

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
                
                
                case 4 -> {System.out.println("Ha entrado en la opción creación de mural.\n");

                    Ficha f0 = sistema.getListaFichas().get(0);

                    // Pido un nombre unico para el mural
                    System.out.println("Ingrese un nombre para el mural: ");
                    String nombreMural = Helper.leerNombreMuralUnico(in, sistema);

                    Diseniador diseniadorEncontrado = Helper.leerDiseniadorORegistrar(in, sistema);
                    
                    if (diseniadorEncontrado != null) {

                        // Elijo formato y fichas
                        System.out.println("Ingrese la letra correspondiente al formato de Mural que desea dibujar:");
                        System.out.println("D-Damero/ F-Filas/ B-Borde Exterior/ R-Random/ M-Manual)");
                        String formato = Helper.leeFormatoValido(in);

                        int cantidadFichas = sistema.getListaFichas().size() - 1;
                        System.out.println("Ingrese la ficha 1 que desea usar: (numero entre 1 y " + cantidadFichas + ")");
                        int numficha1 = Helper.leerEnteroEnRango(in, 1, cantidadFichas);
                        System.out.println("Ha ingresado la ficha 1 correctamente.");

                        System.out.println("Ingrese la ficha 2 que desea usar: (numero entre 1 y " + cantidadFichas + ")");
                        int numficha2 = Helper.leerEnteroEnRango(in, 1, cantidadFichas);
                        System.out.println("Ha ingresado la ficha 2 correctamente.");

                        Ficha f1 = sistema.getListaFichas().get(numficha1);
                        Ficha f2 = sistema.getListaFichas().get(numficha2);

                        // Se crea el mural
                        Mural mural = new Mural(nombreMural, diseniadorEncontrado, formato, f0, f1, f2, sistema, in);
                        sistema.agregarMural(mural);
                        mural.imprimirChico();
                        mural.imprimirGrande();
                    }
                    

                }
                
                case 5 -> {
                    System.out.println("Ha entrado en la opción modificar mural.\n");
                    ArrayList<Mural> murales = sistema.getListaMurales();
                    if (murales.isEmpty()) {
                        System.out.println("No hay murales creados.");
                    } else {
                        Mural mural = Helper.elegirMural(in, murales);
                        Helper.submenuModificarMural(in, sistema, mural);
                    }
                }
                
                case 6 -> {
                    System.out.println("Ha entrado en la opción visualizar mural.\n");
                    
                    sistema.mostrarListaDiseniadores();
                    System.out.println("Elija un diseñador de la lista ingresando el número de ID: ");
                    int idIngresado = Helper.leerEnteroEnRango(in, 1, Integer.MAX_VALUE);
                    Diseniador diseniador = sistema.buscarDiseniadorPorID(idIngresado);
                    
                    if (diseniador == null) {
                        System.out.println("No existe un diseñador con ese ID.");
                    } else {
                        ArrayList<Mural> murales = sistema.muralesDeDiseniador(diseniador);
                        if (murales.isEmpty()) {
                            System.out.println("Ese diseñador no tiene murales.");
                        } else {
                            System.out.println("Lista de murales creados por el diseñador: ");
                            for (int i = 0; i < murales.size(); i++) {
                                System.out.println((i + 1) + " - " + murales.get(i));
                            }
                            System.out.println("Elegir un mural: ingrese el número de mural: ");
                            int num = Helper.leerEnteroEnRango(in, 1, murales.size());
                            murales.get(num - 1).imprimirChico();
                            murales.get(num - 1).imprimirGrande();
                        }
                    }
                }

                case 7 -> {
                    System.out.println("Ha entrado en la opción Listado de diseñadores.\n");
                    sistema.mostrarListaDiseniadores();
                }
                
                case 8 -> {
                    System.out.println("Ha entrado en la opción comparar similitud de murales.\n");
                    Helper.compararSimilitudMurales(in, sistema);
                }
                
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

                default -> System.out.println("Opcion inválida, debe ingresar un número.\n\nIntente nuevamente.");
            }
            
            if (entrar) {
                Helper.pausar(in);
            }
        }
        in.close();
    }
}
