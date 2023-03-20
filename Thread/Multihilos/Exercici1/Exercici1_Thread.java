/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exercici1;

import java.util.Random;

/**
 *
 * @author Raul
 */
public class Exercici1_Thread extends Thread {

    public Exercici1_Thread(String nom) {
        this.setName(nom);
    }

    @Override
    public void run() {
        System.out.println(this.getName() + ": iniciat");

        // Generam i mostram el valor al·leatori
        Random r = new Random();
        int num = r.nextInt(100) + 1;
        System.out.println(this.getName() + ": valor " + num);

        System.out.println(this.getName() + ": finalitzat");
    }
}
