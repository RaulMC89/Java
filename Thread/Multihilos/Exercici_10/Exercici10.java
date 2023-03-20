/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exercici_10;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Raul
 */
public class Exercici10 {

    public static void main(String[] args) throws InterruptedException {
        Semaphore semTic = new Semaphore(1);
        Semaphore semTac = new Semaphore(1);
        Semaphore semToc = new Semaphore(1);

        int numTicTacToc = 3;

        Exercici10_TicTacToc[] fils = new Exercici10_TicTacToc[numTicTacToc * 3];

        for (int i = 0; i < numTicTacToc * 3; i += 3) {
            fils[i] = new Exercici10_TicTacToc("TIC", semTic, semTac);
            fils[i + 1] = new Exercici10_TicTacToc("TAC", semTac, semToc);
            fils[i + 2] = new Exercici10_TicTacToc("TOC", semToc, semTic);
        }

        for (int i = 0; i < numTicTacToc * 3; i++) {
            fils[i].start();
        }

        for (int i = 0; i < numTicTacToc * 3; i++) {
            fils[i].join();
        }
        System.out.println("Programa finalitzat");
    }
}
