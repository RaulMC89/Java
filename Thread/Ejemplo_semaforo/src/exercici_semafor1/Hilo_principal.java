/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercici_semafor1;

import java.util.concurrent.Semaphore;

/**
 *
 * @author mraul
 */
public class Hilo_principal extends Thread {

    public static void main(String[] args) {

        Semaphore sem = new Semaphore(1);
        int num_fils = 100;
        Contador cont = new Contador();
        // Declaram un array on guardarem les referències de tots els fils
        Exercici_semafor1[] fils = new Exercici_semafor1[num_fils];

        // Declaram els fils
        for (int i = 1; i <= num_fils; i++) {
            fils[i - 1] = new Exercici_semafor1("Fil " + i, cont, sem);
        }

        // Executam els fils
        for (int i = 1; i <= num_fils; i++) {

            fils[i - 1].start();
        }
    }
}
