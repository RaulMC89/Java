package raulyagus;

import java.util.Scanner;

public class Menu extends Thread {

    Hilosegundos hilo;

    public Menu(Hilosegundos hilo) {
        this.hilo = hilo;
    }

    private String returnString() {
        Scanner sc = new Scanner(System.in);
        String letra = "";
        if (hilo.isAlive()) {
            sc.reset();
            letra = sc.nextLine();
        } else {
            sc.close();
        }
        return letra;
    }

    @Override
    public void run() {

        System.out.println("""
                           |---------------------------------------|
                           |                 Menu                  |
                           |---------------------------------------|
                           | S : parar                             |
                           | E : reiniciar                         |
                           | A : Añadir 10 s                       |
                           | P : pausar                            |
                           | R : reanudar                          |
                           |---------------------------------------|
                           """);
        while (hilo.isAlive()) {
            switch (returnString().toLowerCase()) {
                case "s" ->
                    opcion1();
                case "e" ->
                    opcion3();
                case "a" ->
                    opcion2();
                case "p" ->
                    opcion4();
                case "r" ->
                    opcion5();
                default ->
                    Menu.interrupted();
            }
        }
    }

    private void opcion1() {
        hilo.interrupt();
    }

    private void opcion2() {
        hilo.set10Time();
    }

    private void opcion3() {
        hilo.setResTime();
    }

    private void opcion4() {
        hilo.setpausar();
    }

    private void opcion5() {
        hilo.setreanudar();
    }
}
