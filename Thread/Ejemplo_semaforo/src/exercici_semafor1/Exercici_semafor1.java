/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exercici_semafor1;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mraul
 */
public class Exercici_semafor1 extends Thread {

    Semaphore sem;
    Contador cont;
    int aux = 0;

    /**
     * @param args the command line arguments
     */
    public Exercici_semafor1(String name, Contador cont, Semaphore sem) {
        this.setName(name);
        this.cont = cont;
        this.sem = sem;
    }

    @Override
    public void run() {

        try {

            sem.acquire();
            aux = cont.getCont();
            aux++;
            cont.setCont(aux);
            System.out.println(this.getName() + "   " + cont.getCont());
            sleep(1000);
            sem.release();

        } catch (InterruptedException ex) {
            Logger.getLogger(Exercici_semafor1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
