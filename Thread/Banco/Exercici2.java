/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercici2;

import java.util.Scanner;

/**
 *
 * @author mraul
 */
public class Exercici2 {

    public static void main(String[] args) throws InterruptedException {
        Banco bc = new Banco();
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce numero de clientes");
        int clients = sc.nextInt();

        Compres[] fils = new Compres[clients];

        for (int i = 0; i < fils.length; i++) {
            fils[i] = new Compres("Client " + i + ":", bc);
        }

        for (int i = 1; i < fils.length; i++) {
            fils[i].start();
        }
        for (int i = 1; i <= fils.length; i++) {

            fils[i - 1].join();
        }
        int banco = bc.getNum();
        System.out.println("Ingresos finals " + banco + "€");
        System.out.println("TENDA TANCADA");
        sc.close();

    }

}
