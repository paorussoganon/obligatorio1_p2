/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entregable;

/**
 *
 * @author paorg
 */
public class Diseniador {
    
    
    // variables de instancia
    private String nombre;
    private String mail;
    private String direccion;
    
    // Constructores
    public Diseniador(String nombre, String mail, String direccion){
        this.setNombre(nombre);
        this.setMail(mail);
        this.setDireccion(direccion);
    }
    
    
    
    // Metodo de acceso
    public String getNombre(){
        return nombre;
    }
    
    public String getMail(){
        return mail;
    }
    
    public String getDireccion(){
        return direccion;
    }    
    
    // Metodo de modificacion
    public void setNombre(String unNombre){
        nombre = unNombre;
    }
    
    public void setMail(String unMail){
        mail = unMail;
    }
    
    public void setDireccion(String unaDireccion){
        direccion = unaDireccion;
    }
    
    // Para imprimir
    @Override
    public String toString(){
        return "Diseñador: " + this.getNombre() + ", " + this.getDireccion() + ", " + this.getMail();
    }
    
    
}
