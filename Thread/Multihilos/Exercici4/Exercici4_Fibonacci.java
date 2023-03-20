package Exercici4;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Raul
 */
public class Exercici4_Fibonacci extends Thread {

    private int n;

    public Exercici4_Fibonacci(int n) {
        this.n = n;
    }

    @Override
    public void run() {
        System.out.println("Fil executant-se.");

        int num1 = 0, num2 = 1, aux;

        for (int i = 1; i <= n; i++) {
            try {
                System.out.println(num2);
                aux = num2;
                num2 += num1;
                num1 = aux;
                Thread.sleep(200);
            } catch (InterruptedException ex) {
                System.out.println("Fil interromput.");
                return;
            }
        }
        System.out.println("Fil finalitzat correctament.");
    }

}
