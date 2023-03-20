/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exercici4;

/**
 *
 * @author Raul
 */
public class Exercici4 {

    public static void main(String[] args) throws InterruptedException {

        Exercici4_Fibonacci fil = new Exercici4_Fibonacci(30);
        Exercici4_Teclat filTeclat = new Exercici4_Teclat(fil);
        fil.start();
        filTeclat.start();

        fil.join();
        filTeclat.interrupt();

        System.out.println("Programa finalitzat.");
    }
}
