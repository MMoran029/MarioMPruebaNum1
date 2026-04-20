/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebanum1;

/**
 *
 * @author mjosu
 */
public class EmailAccount {
    
    String direccion;
    String contrasena;
    String nombre;
    Email[] inbox;
    
    public EmailAccount(String direccion, String contrasena, String nombre){
        this.direccion= direccion;
        this.contrasena= contrasena;
        this.nombre= nombre;
        this.inbox= new Email[100];
    }
    
    public String getDireccion(){
        return direccion;
    }

    public String getContrasena(){
        return contrasena;
    }

    public String getNombre(){
        return nombre;
    }

    public boolean recibirCorreo(Email email){
        for (int i =0; i<inbox.length;i++){
            if (inbox[i] == null) {
                inbox[i] = email;
                return true;
            }
        }
        return false;
    }

    public void mostrarInbox() {
        System.out.println("Cuenta: " + direccion + " | " + nombre);
        int sinLeer = 0;
        int total = 0;
        for (int i = 0; i < inbox.length; i++) {
            if (inbox[i] != null) {
                String estado = inbox[i].getLeido() ? "LEIDO" : "SIN LEER";
                System.out.println(i +" "+ inbox[i].getEmisor() +" "+ inbox[i].getAsunto() +" "+ estado);
                if (!inbox[i].getLeido()) sinLeer++;
                total++;
            }
        }
        System.out.println("Correos sin leer: " + sinLeer);
        System.out.println("Total de correos: " + total);
    }

    public void leerCorreo(int posicion) {
        if (posicion >= 0 && posicion < inbox.length && inbox[posicion] != null) {
            inbox[posicion].imprimir();
            inbox[posicion].marcarComoLeido();
        } else {
            System.out.println("Correo No Existe");
        }
    }

    public void eliminarLeidos() {
        for (int i = 0; i < inbox.length; i++) {
            if (inbox[i] != null && inbox[i].getLeido()) {
                inbox[i] = null;
            }
        }
    }
    
}
