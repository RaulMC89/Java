/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exercici_10;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Raul
 */
public class Exercici10_TicTacToc extends Thread {

    private String missatge;
    private Semaphore semaforAnt;
    private Semaphore semaforPost;

    public Exercici10_TicTacToc(String missatge, Semaphore semaforAnt, Semaphore semaforPost) {
        this.missatge = missatge;
        this.semaforAnt = semaforAnt;
        this.semaforPost = semaforPost;
    }

    @Override
    public void run() {
        try {
            semaforAnt.acquire();
            System.out.println(missatge);
            sleep(1000);
            semaforPost.release();

        } catch (InterruptedException ex) {
        }
    }
}
