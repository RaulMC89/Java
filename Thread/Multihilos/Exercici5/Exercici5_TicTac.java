/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exercici5;

/**
 *
 * @author Raul
 */
public class Exercici5_TicTac extends Thread {

    private String text;
    private Exercici5_TicTac filAnterior;

    public Exercici5_TicTac(int n, String text, Exercici5_TicTac filAnterior) {
        this.setName("Fil " + n);
        this.filAnterior = filAnterior;
        this.text = text;
    }

    @Override
    public void run() {
        try {
            if (filAnterior != null) {
                filAnterior.join();
            }
            System.out.println(this.getName() + ": " + text);
            sleep(500);
        } catch (InterruptedException ex) {

        }
    }

}
