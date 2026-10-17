/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entregable;

/**
 *
 * @author paorg
 */
public class Diseniador implements Comparable<Diseniador>{
    
    
    
    // variables de instancia
    private int IDDiseniador;
    private String nombre;
    private String mail;
    private String direccion;

    
    // Constructores
    public Diseniador(int IDDiseniador, String nombre, String direccion, String mail){
        this.setIDDiseniador(IDDiseniador);
        this.setNombre(nombre);
        this.setDireccion(direccion);
        this.setMail(mail);
    }
    
    
    
    // Metodo de acceso
    
    public int getIDDiseniador(){
        return IDDiseniador;
    }

    public String getNombre() {
        return nombre;
    }
    
    public String getMail(){
        return mail;
    }
    
    public String getDireccion(){
        return direccion;
    }

    public void setIDDiseniador(int unIDDiseniador) {
        this.IDDiseniador = unIDDiseniador;
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
        return "Diseñador: ID: " + this.IDDiseniador + ", nombre: " + this.getNombre() + ", dirección: " + this.getDireccion() + ", mail:" + this.getMail();
    }
    
    // Para reescribir el compare to
    @Override
    public int compareTo(Diseniador diseniador2){
        return this.getNombre().compareToIgnoreCase(diseniador2.getNombre());
    }
    
    
    
}
