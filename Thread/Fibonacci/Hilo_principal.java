/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fibonacci;

/**
 *
 * @author mraul
 */
public class Hilo_principal extends Thread {

    public static void main(String[] args) {
        Fibonacci hilo_1 = new Fibonacci(1000000);

        hilo_1.start();
        System.out.println("Fil executant-se.");
    }

}
