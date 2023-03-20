/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercici2;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mraul
 */
public class Compres extends Thread {

    static Semaphore sem = new Semaphore(1);
    private Banco bc;
    private int dinero = 0;
    private int probabilidad = 0;
    private Comprobar_ingreso ci;

    public Compres(String nom, Banco bc) {
        this.setName(nom);
        this.bc = bc;
    }

    @Override
    public void run() {

        try {

            dinero = (int) (Math.random() * (1 - 100 + 1) + 99);
            probabilidad = (int) (Math.random() * (1 - 100 + 1) + 99);

            sem.acquire();
            if (bc.getNum() >= 0) {
                if (probabilidad > 90) {
                    ci = new Comprobar_ingreso(this.getName(), dinero, bc);
                    sleep(20);
                } else {
                    ci = new Comprobar_ingreso(this.getName(), -dinero, bc);
                    sleep(20);
                }
            }

            sem.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(Compres.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
