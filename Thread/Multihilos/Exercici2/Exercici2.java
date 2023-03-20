/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exercici2;

/**
 *
 * @author Raul
 */
public class Exercici2 {

    public static void main(String[] args) throws InterruptedException {

        int[] compte = {1000};

        Exercici2_Thread suma = new Exercici2_Thread('s', 0, compte);
        Exercici2_Thread resta = new Exercici2_Thread('r', 0, compte);

        suma.start();
        resta.start();

        Thread.sleep(1500);
        System.out.println("Fil principal: " + compte[0]);
    }
}
