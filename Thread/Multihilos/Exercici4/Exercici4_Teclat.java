/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exercici4;

import java.util.Scanner;

/**
 *
 * @author Yolanda
 */
public class Exercici4_Teclat extends Thread {

    private Exercici4_Fibonacci filFibonacci;
    
    public Exercici4_Teclat(Exercici4_Fibonacci filFibonacci) {
        this.filFibonacci = filFibonacci;
    }

    @Override
    public void run() {
        Scanner teclat = new Scanner(System.in);

        try {
            while (filFibonacci.isAlive()) {
                String entrada = teclat.nextLine();
                if (entrada.equals("exit")) {
                    filFibonacci.interrupt();
                }
                sleep(1);
            }
        } catch (InterruptedException e){
            return;
        } finally {
            teclat.close();
        }
        
    }
}
