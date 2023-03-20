/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exercici1;

/**
 *
 * @author Raul
 */
public class Exercici1 {

    public static void main(String[] args) {
        int num_fils = 3;

        // Declaram un array on guardarem les referències de tots els fils
        Exercici1_Thread[] fils = new Exercici1_Thread[num_fils];

        // Declaram els fils
        for (int i = 1; i <= num_fils; i++) {
            fils[i - 1] = new Exercici1_Thread("Fil " + i);
        }

        // Executam els fils
        for (int i = 1; i <= num_fils; i++) {
            fils[i - 1].start();
        }
    }
}
