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
            System.out.println("Ingrese la letra correspondiente al formato de Mural que desea dibujar:");
            System.out.println("D - Damero / F - Filas / B - Borde Exterior / R - Random / M - Manual");
            
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
    
    
    
    
    
    
    
    
}
    

