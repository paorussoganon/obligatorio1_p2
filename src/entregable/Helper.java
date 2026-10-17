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
    
    
    
    
    
}
    

