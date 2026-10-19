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

public class Diseniador implements Comparable<Diseniador>{
    
    private int IDDiseniador;
    private String nombre;
    private String mail;
    private String direccion;

    public Diseniador(int IDDiseniador, String nombre, String direccion, String mail){
        this.setIDDiseniador(IDDiseniador);
        this.setNombre(nombre);
        this.setDireccion(direccion);
        this.setMail(mail);
    }

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
        return "ID: " + this.IDDiseniador + ", nombre: " + this.getNombre() + ", dirección: " + this.getDireccion() + ", mail: " + this.getMail();
    }
    
    // Para reescribir el compare to
    @Override
    public int compareTo(Diseniador diseniador2){
        return this.getNombre().compareToIgnoreCase(diseniador2.getNombre());
    }

}