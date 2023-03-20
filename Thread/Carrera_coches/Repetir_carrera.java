/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carrera_coches;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * En esta clase reinicimamos la calse Inicio_carrera si el usuario quiere
 */
public class Repetir_carrera {

    boolean salir = true;
    private String[] args;

    public Repetir_carrera() {
        acabarReiniciar();
    }

    private void acabarReiniciar() {

        System.out.print("""
                           |---------------------------------------|
                           |     QUIERES REPETIR LA CARRERA?       |
                           |---------------------------------------|
                           | S : PARA INICIAR                      |
                           | N : PARA FINALIZAR                    |
                           |---------------------------------------|
                           """);
        System.out.print("|-->");
        while (salir) {
            Scanner sn = new Scanner(System.in);
            String letra = sn.nextLine().toUpperCase();
            switch (letra) {
                case "S" -> {
                    salir = false;
                    reinicio();
                }
                case "N" -> {
                    salir = false;
                    System.out.println("\nFin de carrera");
                }
                default ->
                    System.out.println("Letra incorrecta.");
            }
        }
    }

    private void reinicio() {
        try {
            Inicio_carrera.main(args);
        } catch (InterruptedException ex) {
            Logger.getLogger(Repetir_carrera.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
