/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Exercici9;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Raul
 */
public class Exercici9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {

        System.out.println("Introdueix un text per teclat: ");
        Scanner entradaTeclat = new Scanner(System.in);

        String text = entradaTeclat.nextLine();
        entradaTeclat.close();

        // Declaram els fils i el semàfor compartit entre els fils
        Exercici9_ComptarVocal[] fils = new Exercici9_ComptarVocal[5];
        Semaphore sem = new Semaphore(1);

        fils[0] = new Exercici9_ComptarVocal("aàáAÀÁ", text, "fitxer_vocals.txt", sem);
        fils[1] = new Exercici9_ComptarVocal("eèéEÈÉ", text, "fitxer_vocals.txt", sem);
        fils[2] = new Exercici9_ComptarVocal("iìíIÌÍ", text, "fitxer_vocals.txt", sem);
        fils[3] = new Exercici9_ComptarVocal("oòóOÒÓ", text, "fitxer_vocals.txt", sem);
        fils[4] = new Exercici9_ComptarVocal("uùúUÙÚ", text, "fitxer_vocals.txt", sem);

        // Iniciam l'execució dels fils
        for (int i = 0; i < fils.length; i++) {
            fils[i].start();
            fils[i].join();
        }

        /* Esperam a que tots els fils finalitzin la seva execució per poder mostrar
        el contingut del fitxer */
        for (int i = 0; i < fils.length; i++) {
            fils[i].join();
        }

        System.out.println("\nContingut del fitxer: ");

        try {
            BufferedReader lectorFitxer = new BufferedReader(new FileReader("fitxer_vocals.txt"));

            while (lectorFitxer.ready()) {
                System.out.println(lectorFitxer.readLine());
            }

            lectorFitxer.close();

        } catch (FileNotFoundException ex) {
            System.err.println("ERROR: El fitxer \"fitxer_vocals.txt\" no existeix.");
        } catch (IOException ex) {
            Logger.getLogger(Exercici9.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
