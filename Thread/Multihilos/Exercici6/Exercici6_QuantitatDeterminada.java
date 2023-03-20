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
class Exercici6_QuantitatDeterminada extends Thread {

    private int quantitat;

    Exercici6_QuantitatDeterminada(int quantitat) {
        this.quantitat = quantitat;
    }

    @Override
    public void run() {
        while (quantitat != 0) {
            System.out.println("Fil 1: " + new Random().nextInt(100));
            try {
                sleep(1000);
            } catch (InterruptedException ex) {
                return;
            }
            quantitat--;
        }
    }

}
