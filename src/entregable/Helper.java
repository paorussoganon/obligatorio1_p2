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

public class Helper {

    // Método para validar que el formato ingresado sea una de las opciones válidas

    
    public static String leeFormatoValido(Scanner in) {
        
        String formato = "";
        boolean valido = false;
        
        while (valido == false) {
            formato = in.nextLine();
            
            // Verifico si coincide con alguna opción válida
            if (formato.equalsIgnoreCase("D") || 
                formato.equalsIgnoreCase("F") || 
                formato.equalsIgnoreCase("B") || 
                formato.equalsIgnoreCase("R") || 
                formato.equalsIgnoreCase("M")){
                valido = true;
            }
            else {
                System.out.println("Opción inválida. Inténtelo nuevamente.\n");
            }
        }
        
        return formato.toUpperCase();
    }
    
    
    // Método para pedir y validar un nombre de mural único
    public static String leerNombreMuralUnico(Scanner in, Sistema sistema) {
        String nombre = "";
        boolean valido = false;
        
        while (!valido) {
            nombre = in.nextLine().trim();
            
            if (nombre.isEmpty()) {
                System.out.println("Ingresó un nombre vacío, intente de nuevo.");
            } else if (sistema.existeMural(nombre)) {
                System.out.println("Ya existe un mural con ese nombre. Ingrese uno diferente.");
            } else {
                valido = true;
            }
        }
        
        System.out.println("Ha ingresado el nombre correctamente.");
        return nombre;
    }
    
    
    public static void limpiarPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void pausar(Scanner in) {
        System.out.println("\nPresione Enter para continuar...");
        in.nextLine();
    }
    
    
    public static int leerEnteroEnRango(Scanner in, int min, int max) {
        while (true) {
            String linea = in.nextLine().trim();
            try {
                int n = Integer.parseInt(linea);
                if (n >= min && n <= max) {
                    return n;
                }
            } catch (NumberFormatException e) {
            }
            System.out.println("Ingrese un número entre " + min + " y " + max + ".");
        }
    }
    
    // Helpers de diseniador
    
    public static Diseniador leerDiseniadorORegistrar(Scanner in, Sistema sistema) {
        Diseniador diseniador = null;
        boolean cancelar = false;

        while (diseniador == null && !cancelar) {
            System.out.println("Ingrese el nombre del diseñador del mural: ");
            String nombre = in.nextLine().trim();
            diseniador = sistema.buscarDiseniador(nombre);

            if (diseniador == null) {
                System.out.println("No existe. ¿Desea registrarlo? (y/n)");
                String respuesta = in.nextLine().trim();
                if (respuesta.equalsIgnoreCase("y") && !nombre.isEmpty()) {
                    System.out.println("Dirección: ");
                    String direccion = in.nextLine();
                    System.out.println("Mail: ");
                    String mail = in.nextLine();
                    sistema.registrarDiseniador(sistema.siguienteIDDiseniador(), nombre, direccion, mail);
                    diseniador = sistema.buscarDiseniador(nombre);
                } else {
                    cancelar = true;
                }
            }
        }
        return diseniador;
    }
    
    
    public static Diseniador registrarDiseniadorConNombre(Scanner in, Sistema sistema, String nombre) {
        System.out.println("Dirección: ");
        String direccion = in.nextLine();
        System.out.println("Mail: ");
        String mail = in.nextLine();
        sistema.registrarDiseniador(sistema.siguienteIDDiseniador(), nombre, direccion, mail);
        return sistema.buscarDiseniador(nombre);
    }

    public static String leerNombreDiseniadorUnico(Scanner in, Sistema sistema) {
        String nombre = "";
        boolean valido = false;
        while (!valido) {
            System.out.println("Nombre: ");
            nombre = in.nextLine().trim();
            if (nombre.isEmpty()) {
                System.out.println("El nombre no puede estar vacío.");
            } else if (sistema.existeDiseniador(nombre)) {
                System.out.println("Ya existe un diseñador con ese nombre.");
            } else {
                valido = true;
            }
        }
        return nombre;
    }
    
    // Helpers de mural
    
    // Comparar mural (caso 8)
    public static void compararSimilitudMurales(Scanner in, Sistema sistema) {
        ArrayList<Mural> murales = sistema.getListaMurales();

        if (murales.size() < 2) {
            System.out.println("Se necesitan al menos 2 murales para comparar.");
        } else {
            Mural original = elegirMural(in, murales);
            int maxFilas = original.getMat().length;
            int maxColumnas = original.getMat()[0].length;

            System.out.println("Fila inicial (1 a " + maxFilas + "): ");
            int fila = leerEnteroEnRango(in, 1, maxFilas);
            System.out.println("Columna inicial (1 a " + maxColumnas + "): ");
            int columna = leerEnteroEnRango(in, 1, maxColumnas);

            System.out.println("Cantidad de filas (1 a " + (maxFilas - fila + 1) + "): ");
            int filas = leerEnteroEnRango(in, 1, maxFilas - fila + 1);
            System.out.println("Cantidad de columnas (1 a " + (maxColumnas - columna + 1) + "): ");
            int columnas = leerEnteroEnRango(in, 1, maxColumnas - columna + 1);

            boolean hayCoincidencias = false;
            for (Mural m : murales) {
                if (m != original) {
                    int[] posicion = m.buscarArea(original, fila - 1, columna - 1, filas, columnas);
                    if (posicion != null) {
                        hayCoincidencias = true;
                        System.out.println(" El mural " + m.getNombre() + " del diseñador " + m.getDiseniador().getNombre() 
                                + " coincide en: fila " + posicion[0] + " y columna " + posicion[1]);
                    }
                }
            }

            if (!hayCoincidencias) {
                System.out.println("Ningún otro mural contiene esa área.");
            }
        }
    }
    
    // Caso 6
    public static void visualizarMural(Scanner in, Mural mural) {
        String formato = "";
        boolean valido = false;
        while (!valido) {
            System.out.println("Formato a visualizar (C)hico o (G)rande: ");
            formato = in.nextLine().trim().toUpperCase();
            valido = formato.equals("C") || formato.equals("G");
            if (!valido) {
                System.out.println("Opción inválida.");
            }
        }

        boolean salir = false;
        while (!salir) {
            if (formato.equals("C")) {
                mural.imprimirChico();
            } else {
                mural.imprimirGrande();
            }

            String entrada = "";
            boolean entradaValida = false;
            while (!entradaValida) {
                System.out.println("ENTER para alternar el tamaño o S para salir: ");
                entrada = in.nextLine().trim();
                entradaValida = entrada.isEmpty() || entrada.equalsIgnoreCase("S");
                if (!entradaValida) {
                    System.out.println("Opción inválida.");
                }
            }

            if (entrada.equalsIgnoreCase("S")) {
                salir = true;
            } else if (formato.equals("C")) {
                formato = "G";
            } else {
                formato = "C";
            }
        }
    }
    
    // Caso 5
    public static Mural elegirMural(Scanner in, ArrayList<Mural> murales) {
        for (int i = 0; i < murales.size(); i++) {
            System.out.println((i + 1) + " - " + murales.get(i));
        }
        System.out.println("Elija un mural: ");
        int num = leerEnteroEnRango(in, 1, murales.size());
        return murales.get(num - 1);
    }

    public static Ficha elegirFicha(Scanner in, ArrayList<Ficha> fichas) {
        for (int i = 0; i < fichas.size(); i++) {
            System.out.println((i + 1) + " - " + fichas.get(i).getNombre());
        }
        System.out.println("Elija una ficha: ");
        int num = leerEnteroEnRango(in, 1, fichas.size());
        return fichas.get(num - 1);
    }

    public static void submenuModificarMural(Scanner in, Sistema sistema, Mural mural) {
        boolean volver = false;
        while (!volver) {
            System.out.println("\nModificar mural: " + mural.getNombre());
            System.out.println("0 - Volver al menú anterior.");
            System.out.println("1 - Modificar posición.");
            System.out.println("2 - Modificar ficha.");
            System.out.println("3 - Restaurar.");
            System.out.println("Ingrese una opción: ");
            int opcion = leerEnteroEnRango(in, 0, 3);

            switch (opcion) {
                case 0 -> volver = true;

                case 1 -> {
                    System.out.println("Fila (1 a " + mural.getMat().length + "): ");
                    int fila = leerEnteroEnRango(in, 1, mural.getMat().length);
                    System.out.println("Columna (1 a " + mural.getMat()[0].length + "): ");
                    int columna = leerEnteroEnRango(in, 1, mural.getMat()[0].length);
                    Ficha nueva = elegirFicha(in, sistema.getListaFichas());
                    mural.modificarPosicion(fila - 1, columna - 1, nueva);
                    mural.imprimirChico();
                    mural.imprimirGrande();
                }

                case 2 -> {
                    System.out.println("Fichas del mural:");
                    Ficha vieja = elegirFicha(in, mural.fichasUsadas());
                    System.out.println("Fichas registradas:");
                    Ficha nueva = elegirFicha(in, sistema.getListaFichas());
                    mural.reemplazarFicha(vieja, nueva);
                    mural.imprimirChico();
                    mural.imprimirGrande();
                }

                case 3 -> {
                    mural.restaurar();
                    mural.imprimirChico();
                    mural.imprimirGrande();
                }
            }
        }
    }
}