/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exercici2;

/**
 *
 * @author Raul
 */
public class Exercici2_Thread extends Thread {

    private char suma_o_resta;
    private int compte[];
    private int registre;

    public Exercici2_Thread(char suma_o_resta, int num, int[] compte) {
        this.setName("" + suma_o_resta);
        this.suma_o_resta = suma_o_resta;
        this.compte = compte;
    }

    @Override
    public void run() {

        System.out.println(this.getName() + "=> compte: " + compte[0]);

        if (suma_o_resta == 's') {
            registre = compte[0] + 10;
        } else {
            registre = compte[0] - 10;
        }
        System.out.println(this.getName() + "=> registre: " + registre);

        compte[0] = registre;

        System.out.println(this.getName() + "=> compte: " + compte[0]);
    }
}
