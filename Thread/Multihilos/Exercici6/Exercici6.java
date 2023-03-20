/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exercici6;

import static java.lang.Thread.sleep;
import java.util.Scanner;

/**
 *
 * @author Raul
 */
public class Exercici6 {

    public static void main(String[] args) throws InterruptedException {

        Scanner entradaTeclat = new Scanner(System.in);

        System.out.println("Introdueix la quantitat de nombres aleatoris: ");
        int quantitat = entradaTeclat.nextInt();
        entradaTeclat.close();

        Exercici6_QuantitatDeterminada fil1 = new Exercici6_QuantitatDeterminada(quantitat);
        Exercici6_MostrarIndeterminada fil2 = new Exercici6_MostrarIndeterminada(fil1);

        fil1.start();
        fil2.start();

        sleep(1000);

        fil1.interrupt();

        fil2.join();

        System.out.println("Programa finalitzat.");
    }
}
