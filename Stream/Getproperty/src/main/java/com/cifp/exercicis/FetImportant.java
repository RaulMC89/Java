/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cifp.exercicis;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Yolanda
 */
public class FetImportant {

    private Scanner scanner = null;

    public FetImportant() {
        scanner = new Scanner(System.in);
    }

    public void obtenirFetImportant() {
        int any = -1;

        // Obtenim l'any introduit per teclat
        while (any == -1) {
            System.out.println("Introdueix un dels seguents anys (1886, 1928 i 1969):");
            any = scanner.nextInt();
            if (any != 1886 && any != 1928 && any != 1969) {
                System.out.println("Any introduit incorrecte");
                any = -1;
            }
        }

        BufferedReader buffer = null;

        try {
            // Mostram el contingut del fitxer corresponent
            buffer = new BufferedReader(new FileReader(new File(any + ".txt")));
            String linia;
            while ((linia = buffer.readLine()) != null) {
                System.out.println(linia);
            }

        } catch (FileNotFoundException fnfe) {
            System.out.println("Fitxer no trobat");
        } catch (IOException ioe) {
            System.out.println("Error d'entrada i sortida");
        } finally {
            if (buffer != null)
                try {
                buffer.close();
            } catch (IOException ex) {
                System.out.println("Error d'entrada i sortida");
            }
        }
    }

}
