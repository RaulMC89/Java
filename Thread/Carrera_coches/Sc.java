/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carrera_coches;

import java.util.Scanner;

/**
 * Esta clase pregunta al asuario el numero de coches y los kilometros a
 * recorrer usando el metodo scanner
 */
public class Sc {

    private int num_hilos = 0;
    private int kilometros = 0;
    Scanner sc = new Scanner(System.in);

    public int getNum_hilos() {
        return num_hilos;
    }

    public int getKilometros() {
        return kilometros;
    }

    public Sc() {
        sc();
    }

    private void sc() {

        boolean salida = true;
        while (salida) {
            System.out.print("Introduce numero de coches mayor a 9:\n-->");
            num_hilos = sc.nextInt();
            System.out.print("Introduce numero de kilometro mayor o igual a 1000:\n-->");
            kilometros = sc.nextInt();
            if (num_hilos > 9 && kilometros >= 1000) {
                salida = false;

            } else {
                if (num_hilos < 9) {
                    System.out.println("Numero de coches incorrecto ha de ser mayor de 1");
                }
                if (kilometros < 1000) {
                    System.out.println("Numero de kilometros incorrecto ha de ser mayor o igual a 1000");
                }
            }
        }

    }
}
