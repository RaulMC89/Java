/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exercici5;

/**
 *
 * @author Raul
 */
public class Exercici5 {

    public static void main(String[] args) throws InterruptedException {

        int num_tictac = 10;

        Exercici5_TicTac[] fils = new Exercici5_TicTac[num_tictac * 2];

        for (int i = 0; i < fils.length; i++) {
            nouFil(fils, i);
        }

        for (int i = 0; i < fils.length; i++) {
            fils[i].start();
        }
    }

    private static void nouFil(Exercici5_TicTac[] fils, int n) {

        Exercici5_TicTac filAnterior = null;
        String missatge;

        if (n % 2 == 0) {
            missatge = "Tic";
        } else {
            missatge = "Tac";
        }

        if (n != 0) {
            filAnterior = fils[n - 1];
        }

        fils[n] = new Exercici5_TicTac(n, missatge, filAnterior);
    }

}
