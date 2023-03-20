/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exercici6;

import java.util.Random;

/**
 *
 * @author Raul
 */
public class Exercici6_MostrarIndeterminada extends Thread {

    Exercici6_QuantitatDeterminada fil;

    public Exercici6_MostrarIndeterminada(Exercici6_QuantitatDeterminada fil) {
        this.fil = fil;
    }

    @Override
    public void run() {
        while (fil.isAlive()) {
            System.out.println("Fil 2: " + new Random().nextInt(100));
            try {
                sleep(1000);
            } catch (InterruptedException ex) {
                return;
            }
        }
    }

}
