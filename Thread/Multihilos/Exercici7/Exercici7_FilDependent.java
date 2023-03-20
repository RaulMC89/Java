/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exercici7;

/**
 *
 * @author Raul
 */
public class Exercici7_FilDependent extends Thread {

    private Exercici7_Temps temps;
    private Exercici7_FilIndependent fil;
    private int[] tempsMissatges = new int[5];
    private boolean[] missatgeMostrat = {false, false, false, false, false};
    private final String[] missatges = {"Comencem el compte enrere", "Queden 3/4", "Queda la meitat", "Queda 1/4", "TIMEOUT"};

    public Exercici7_FilDependent(Exercici7_Temps temps, Exercici7_FilIndependent fil) {
        this.temps = temps;
        this.fil = fil;

        prepararTempsMissatges();
    }

    @Override
    public void run() {
        while (fil.isAlive()) {
            mostrarMissatge();
            try {
                sleep(900);
            } catch (InterruptedException ex) {
            }
        }
        System.out.println(missatges[4]);
    }

    private void mostrarMissatge() {
        if (!missatgeMostrat[0]) {
            System.out.println(missatges[0]);
            missatgeMostrat[0] = true;
        } else if (!missatgeMostrat[1] && temps.getTempsRestant() == tempsMissatges[1]) {
            System.out.println(missatges[1]);
            missatgeMostrat[1] = true;
        } else if (!missatgeMostrat[2] && temps.getTempsRestant() == tempsMissatges[2]) {
            System.out.println(missatges[2]);
            missatgeMostrat[2] = true;
        } else if (!missatgeMostrat[3] && temps.getTempsRestant() == tempsMissatges[3]) {
            System.out.println(missatges[3]);
            missatgeMostrat[3] = true;
        }
    }

    private void prepararTempsMissatges() {
        tempsMissatges[0] = temps.getTempsTotal();
        tempsMissatges[1] = temps.getTempsRestant() * 3 / 4;
        tempsMissatges[2] = temps.getTempsRestant() / 2;
        tempsMissatges[3] = temps.getTempsRestant() / 4;
    }

}
