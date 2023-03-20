/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exercici3;

import java.util.Scanner;

/**
 *
 * @author Raul
 */
public class Exercici3 {

    public static void main(String[] args) {

        int num = 600;

        Exercici3 exercici = new Exercici3();

        System.out.println("Quina prova vols executar?\n 1) 2 Fils\n 2) 10 fils\n 3) 1000 fils");

        Scanner entradaTeclat = new Scanner(System.in);

        int opcio = Integer.parseInt(entradaTeclat.nextLine());

        switch (opcio) {
            case 1:
                exercici.prova1(num);
                break;
            case 2:
                exercici.prova2(num);
                break;
            case 3:
                exercici.prova3(num);
                break;
        }

    }

    public void prova1(int num) {

        Exercici3_Factorial f1 = new Exercici3_Factorial("Fil 1", num, Thread.MIN_PRIORITY);
        Exercici3_Factorial f2 = new Exercici3_Factorial("Fil 2", num, Thread.MAX_PRIORITY);

        f1.start();
        f2.start();

    }

    public void prova2(int num) {
        Exercici3_Factorial[] fils = new Exercici3_Factorial[10];

        for (int i = 0; i < 5; i++) {
            fils[i] = new Exercici3_Factorial("Fil " + (i + 1), num, Thread.MIN_PRIORITY);
        }
        for (int i = 5; i < 10; i++) {
            fils[i] = new Exercici3_Factorial("Fil " + (i + 1), num, Thread.MAX_PRIORITY);
        }

        for (int i = 0; i < 10; i++) {
            fils[i].start();
        }
    }

    // He afegit una tercera prova
    public void prova3(int num) {
        Exercici3_Factorial[] fils = new Exercici3_Factorial[900];

        for (int i = 0; i < 301; i++) {
            fils[i] = new Exercici3_Factorial("Fil " + (i + 1), num, Thread.MIN_PRIORITY);
        }
        for (int i = 301; i < 601; i++) {
            fils[i] = new Exercici3_Factorial("Fil " + (i + 1), num, Thread.NORM_PRIORITY);
        }
        for (int i = 601; i < 900; i++) {
            fils[i] = new Exercici3_Factorial("Fil " + (i + 1), num, Thread.MAX_PRIORITY);
        }

        for (int i = 0; i < 900; i++) {
            fils[i].start();
        }
    }
}
