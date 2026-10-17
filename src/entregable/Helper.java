
package entregable;
import java.util.Scanner;

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
}