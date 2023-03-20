/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exercici8;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Raul
 */
public class Exercici8_Sumador extends Thread {

    private final int id;
    private final Exercici8_Comptador comptador;
    // El nombre que indicam és el nombre de fils inicial que pot entrar a la zona crítica
    // Si posam new Sempahore(0) vol dir que s'hauria d'alliberar realease() una vegada el semàfor
    // abans que altre fil pugui entrar a la zona crítica
    private static Semaphore semafor = new Semaphore(1);

    public Exercici8_Sumador(int id, Exercici8_Comptador comptador) {
        this.id = id;
        this.comptador = comptador;
    }

    @Override

    public void run() {
        try {
            semafor.acquire();

            // INICI DE LA ZONA CRÍTICA
            int valor = comptador.getNum();
            valor++;
            comptador.setNum(valor);
            System.out.println("Fil " + id + " - Nou valor del comptador: " + comptador.getNum());
            sleep(1000);
            // FINAL DE LA ZONA CRÍTICA

            sleep(1000);

        } catch (InterruptedException e) {
            System.err.println("Interrupció del fil " + id);
            return;
        } finally {
            semafor.release();
        }
    }

    // En aquest exercici només es permet que un fil pugui executar
    // codi de la zona crítica de manera simultània
}
