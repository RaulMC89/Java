/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercici_9;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mraul
 */
public class Hilo_1 extends Thread {

    Semaphore sem;
    char vocal;
    Escribir escribir;

    public Hilo_1(String name, Semaphore sem, char vocal, Escribir escribir) {
        this.setName(name);
        this.sem = sem;
        this.vocal = vocal;
        this.escribir = (Escribir) escribir;
    }

    @Override
    public void run() {

        try {

            sem.acquire();
            int cont = 0;

            String texto = "hola, com estas tu por esto andenes eèééèéè aáàáàáàáàá òóòóòóòóòóò  uúúúúùùùùùúúúù íííííìììììíií´´i hola hielo hervido murcielago?";
            for (int i = 0; i < texto.length(); i++) {
                if (texto.charAt(i) == vocal) {
                    cont++;
                }
            }
            String texto2 = "Vocal " + vocal + " : " + cont;
            escribir = new Escribir(texto2);
            cont = 0;
            sem.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(Hilo_1.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
