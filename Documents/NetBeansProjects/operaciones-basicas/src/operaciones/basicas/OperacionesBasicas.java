/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operaciones.basicas;

import java.util.Scanner;

/**
 *
 * @author MARCIAELIZABETH
 */
public class OperacionesBasicas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner reader = new Scanner(System.in);
        int resultado;
        int numero1 = 0;
        int numero2 = 0;
 
       System.out.println("Introduce el primer número:");			
       numero1 = reader.nextInt();
 
       System.out.println("Introduce el segundo número:");
       numero2 = reader.nextInt();
       resultado = numero1+numero2;
       System.out.println("La suma es " + numero1 + " + " + numero2 + " = " + resultado);
        // TODO code application logic here
    }
    
}
