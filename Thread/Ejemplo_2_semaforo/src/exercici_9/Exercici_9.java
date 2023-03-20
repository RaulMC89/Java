/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exercici_9;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author mraul
 */
public class Exercici_9 {

    public static void main(String[] args) throws InterruptedException, FileNotFoundException, IOException {
        int num_fils = 20;
        Escribir esc = null;
        char[] vocal = {'a', 'á', 'à', 'A', 'e', 'é', 'è', 'E', 'i', 'í', 'ì', 'I', 'o', 'Ó', 'Ò', 'O', 'u', 'Ú', 'Ù', 'U'};
        Hilo_1[] fils = new Hilo_1[num_fils];

        // Declaram els fils
        for (int i = 1; i <= num_fils; i++) {
            fils[i - 1] = new Hilo_1("Fil " + i, Semaforo.sem, vocal[i - 1], esc);
        }

        // Executam els fils
        for (int i = 1; i <= num_fils; i++) {

            fils[i - 1].start();
        }

        for (int i = 1; i <= num_fils; i++) {

            fils[i - 1].join();
        }
        BufferedReader br = new BufferedReader(new FileReader("./archivo.txt"));

        while (br.ready()) {
            System.out.println(br.readLine());

        }
        br.close();
    }

}
