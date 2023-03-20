/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exercici7;

/**
 *
 * @author Raul
 */
public class Exercici7_FilIndependent extends Thread {

    private Exercici7_Temps temps;

    public Exercici7_FilIndependent(Exercici7_Temps temps) {
        this.temps = temps;
    }

    @Override
    public void run() {
        try {
            while (temps.getTempsRestant() != 0) {
                sleep(1000);
                temps.decrementarTempsRestant();
                System.out.println(temps.getTempsRestant());
            }
        } catch (InterruptedException ex) {
            return;
        }

    }

}
