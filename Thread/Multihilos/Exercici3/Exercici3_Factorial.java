/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exercici3;

import java.math.BigInteger;

/**
 *
 * @author Raul
 */
public class Exercici3_Factorial extends Thread {

    private int num;

    public Exercici3_Factorial(String nom, int num, int prioritat) {
        this.setName(nom);
        this.num = num;
        this.setPriority(prioritat);
    }

    @Override
    public void run() {
        BigInteger resultat = BigInteger.valueOf(1);

        for (int i = num; i > 0; i--) {
            resultat = resultat.multiply(BigInteger.valueOf(i));
        }

        System.out.println(this.getName() + " - Prioritat " + this.getPriority() + ": " + resultat);
    }
}
