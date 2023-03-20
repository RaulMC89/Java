/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exercici9;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Raul
 */
public class Exercici9_ComptarVocal extends Thread {

    private String vocal;
    private String text;
    private String ruta;
    private Semaphore sem;

    public Exercici9_ComptarVocal(String vocal, String text, String ruta, Semaphore sem) {
        this.vocal = vocal;
        this.text = text;
        this.ruta = ruta;
        this.sem = sem;
    }

    @Override
    public void run() {

        // Comptam el nombre de vocals que es troben al text
        int comptador = 0;
        for (int i = 0; i < text.length(); i++) {
            if (vocal.contains("" + text.charAt(i))) {
                comptador++;
            }
        }

        try {
            sem.acquire(); // Si ja hi ha un fil executant el codi

            // ZONA CRÍTICA: escribim al fitxer la quantitat trobada
            BufferedWriter escriptor = new BufferedWriter(new FileWriter(ruta, true));

            escriptor.write("vocal " + vocal.charAt(3) + ": " + comptador);
            escriptor.newLine();

            escriptor.close();
            // FINAL DE LA ZONA CRÍTICA

        } catch (IOException ex) {
            Logger.getLogger(Exercici9_ComptarVocal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Exercici9_ComptarVocal.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            sem.release();
        }
    }

}
