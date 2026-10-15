/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entregable;

/**
 *
 * @author paorg
 */
public class Helper {
    
    
    
    // Método validar si la coord está dentro de los limites de la matriz
    public static boolean esCoordenadaiValida(int coordi, Ficha[][] mat) {
            boolean valida = (coordi >= 0) && (coordi < mat.length);
        return valida;
    }

    // Método validar si la coord está dentro de los limites de la matriz
    public static boolean esCoordenadajValida(int coordj, Ficha[][] mat) {
            boolean valida = (coordj >= 0) && (coordj < mat[0].length);
        return valida;
    }
    
    

    
}
