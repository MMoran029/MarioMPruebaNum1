/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebanum1;

import java.util.Scanner;

/**
 *
 * @author mjosu
 */
public class JavaLook {
    
    static EmailAccount[] cuentas = new EmailAccount[100];
    static EmailAccount activa = null;
    static Scanner cc = new Scanner(System.in);

    public static void main(String[] args) {
        while (menuInicial());
    }

    static boolean menuInicial() {
        System.out.println("=== MENU INICIAL ===");
        System.out.println("1. Login");
        System.out.println("2. Crear cuenta");
        System.out.println("0. Salir");
        System.out.print("Opcion: ");
        switch (Integer.parseInt(cc.nextLine())) {
            case 1: login(); break;
            case 2: crearCuenta(); break;
            case 0: return false;
        }
        if (activa != null) menuPrincipal();
        return true;
    }

    static void login() {
        System.out.print("Correo: "); 
        String d = cc.nextLine();
        System.out.print("Contrasena: "); 
        String c = cc.nextLine();
        for (EmailAccount e : cuentas)
            if (e != null && e.getDireccion().equals(d) && e.getContrasena().equals(c)) {
                activa = e;
                System.out.println("Bienvenido, " + e.getNombre());
                return;
            }
        System.out.println("Credenciales incorrectas.");
    }

    static void crearCuenta() {
        System.out.print("Correo: "); 
        String d = cc.nextLine();
        for (EmailAccount e : cuentas)
            if (e != null && e.getDireccion().equals(d)){ 
                System.out.println("Correo ya registrado."); 
                return; 
            }
        System.out.print("Nombre: "); 
        String n = cc.nextLine();
        System.out.print("Contrasena: "); 
        String c = cc.nextLine();
        for (int i = 0; i < cuentas.length; i++)
            if (cuentas[i] == null) { 
                cuentas[i] = activa = new EmailAccount(d, c, n); 
                System.out.println("Cuenta creada. Bienvenido, " + n); 
                return; 
            }
        System.out.println("No hay espacio.");
    }

    static void menuPrincipal() {
        while (true) {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1. Ver inbox");
            System.out.println("2. Mandar correo");
            System.out.println("3. Leer correo");
            System.out.println("4. Limpiar inbox");
            System.out.println("5. Cerrar sesion");
            System.out.print("Opcion: ");
            switch (Integer.parseInt(cc.nextLine())) {
                case 1: 
                    activa.mostrarInbox(); 
                    break;
                case 2: 
                    mandarCorreo(); 
                    break;
                case 3: 
                    System.out.print("Posicion: "); 
                    activa.leerCorreo(Integer.parseInt(cc.nextLine())); 
                    break;
                case 4: 
                    activa.eliminarLeidos(); 
                    System.out.println("Inbox limpiado."); 
                    break;
                case 5: 
                    activa = null; 
                    System.out.println("Sesion cerrada."); 
                    return;
            }
        }
    }

    static void mandarCorreo(){
        System.out.print("Destinatario: "); 
        String d = cc.nextLine();
        for (EmailAccount e : cuentas)
            if (e != null && e.getDireccion().equals(d)){
                System.out.print("Asunto: "); String a = cc.nextLine();
                System.out.print("Contenido: "); String c = cc.nextLine();
                System.out.println(e.recibirCorreo(new Email(activa.getDireccion(), a, c)) ? "Correo enviado." : "Inbox lleno.");
                return;
            }
        System.out.println("Destinatario no encontrado.");
    }
}
