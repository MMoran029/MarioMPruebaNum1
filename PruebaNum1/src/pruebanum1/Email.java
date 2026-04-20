/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebanum1;

/**
 *
 * @author mjosu
 */
public class Email {
    
    String emisor;
    String asunto;
    String contenido;
    boolean leido;
    
    public Email(String emisor, String asunto, String contenido){
        this.emisor= emisor;
        this.asunto= asunto;
        this.contenido= contenido;
        this.leido= false;
        
    }
    
    public String getEmisor(){
        return emisor;
    }
    
    public String getAsunto(){
        return asunto;
    }
    
    public String getContenido(){
        return contenido;
    }

    public boolean getLeido(){
        return leido;
    }

    public void marcarComoLeido(){
        this.leido = true;
    }
    
    public void imprimir(){
        System.out.println("DE: "+emisor);
        System.out.println("ASUNTO: "+asunto);
        System.out.println(contenido);
    }
    
}
