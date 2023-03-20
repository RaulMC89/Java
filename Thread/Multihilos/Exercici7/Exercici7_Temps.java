/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exercici7;

/**
 *
 * @author Raul
 */
public class Exercici7_Temps {

    private int tempsTotal;
    private int tempsRestant;

    public Exercici7_Temps(int tempsTotal) {
        this.tempsTotal = tempsTotal;
        this.tempsRestant = tempsTotal;
    }

    public int getTempsTotal() {
        return tempsTotal;
    }

    public int getTempsRestant() {
        return tempsRestant;
    }

    public void setTempsTotal(int tempsTotal) {
        this.tempsTotal = tempsTotal;
    }

    public void setTempsRestant(int tempsRestant) {
        this.tempsRestant = tempsRestant;
    }

    public void decrementarTempsRestant() {
        tempsRestant--;
    }

}
