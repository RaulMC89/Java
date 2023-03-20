/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exercici7;

import Exercici7.Exercici7_FilIndependent;
import Exercici7.Exercici7_FilDependent;
import Exercici7.Exercici7_Temps;
import java.util.Scanner;

/**
 *
 * @author Raul
 */
public class Exercici7 {

    public static void main(String[] args) throws InterruptedException {

        Scanner entradaTeclat = new Scanner(System.in);

        System.out.print("Introdueix el nombre de segons: ");
        int tempsTotal = entradaTeclat.nextInt();
        entradaTeclat.close();

        Exercici7_Temps temps = new Exercici7_Temps(tempsTotal);
        Exercici7_FilIndependent filI = new Exercici7_FilIndependent(temps);
        Exercici7_FilDependent filD = new Exercici7_FilDependent(temps, filI);

        filI.start();
        filD.start();

        //sleep(5000);
        //filI.interrupt();
    }
}
