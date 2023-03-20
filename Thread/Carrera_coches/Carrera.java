/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carrera_coches;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * En esta clase pintamos las posiciones en cada momento que esta cada coche y
 * pintamos un menu para cuando lleguen los tres primeros y esta clase entra en
 * un bucle hasta que el usuario decida si continuar o no, al final pintamos el
 * podio.
 */
public class Carrera extends Thread {

    private int kilometros;
    private int velocidad;
    private int kilome_recorridos;
    private String coche = "#";
    private int num;
    private boolean salida = true;
    private static boolean salida2 = true;
    private String plus = " ";
    Coche[] hilos;
    ArrayList<Podio> podio = new ArrayList<>();
    ArrayList<Integer> meta = new ArrayList<>();

    public Carrera(Coche[] hilos) {
        this.hilos = hilos;
    }

    @Override
    public void run() {
        while (salida) {
            try {
                sleep(900);
            } catch (InterruptedException ex) {
                Logger.getLogger(Carrera.class.getName()).log(Level.SEVERE, null, ex);
            }

            for (Coche hilo : hilos) {

                kilome_recorridos = hilo.getKilome_recorridos();
                kilometros = hilo.getKilometros();
                velocidad = hilo.getVelocidad();

                num = hilo.getNum();
                System.out.println("");
                for (int i = 0; i <= 10; i++) {
                    System.out.print(" ");
                }

                for (int i = 0; i < kilometros / 50; i++) {
                    System.out.print('-');
                }
                System.out.println("");
                //System.out.print("Coche " + (num + 00) + " :");
                System.out.format("%s %2d %s", "Coche", num, ":|");
                for (int i = 0; i <= kilometros / 50; i++) {

                    if (i == kilome_recorridos) {
                        System.out.print(coche);
                    } else {
                        System.out.print(" ");
                    }

                    if (!hilo.isAlive() && i == kilometros / 50) {

                        if (!meta.contains(hilo.getNum())) {
                            Podio po = new Podio(hilo.getNum(), hilo.calcularTiempo());
                            podio.add(po);
                            if (podio.size() == 3) {
                                salida2 = false;
                            }
                        }
                        meta.add(hilo.getNum());

                    }
                }
                if (hilo.isAlive()) {
                    plus = hilo.getPlus();
                } else {
                    plus = " ";
                }
                System.out.printf("%s %3d %s %s\n", " Velocidad: ", velocidad, " Km/h", plus);

            }
            System.out.println("");
            if (salida2 == false) {
                System.out.print("""
                           |---------------------------------------|
                           |     QUIERES PARAR LA CARRERA?         |
                           |---------------------------------------|
                           | S : PARA PARAR                        |
                           | N : PARA CONTINUAR                    |
                           |---------------------------------------|
                           """);
                System.out.print("|-->");
                new Menu(hilos);

            }

            while (!salida2) {

                try {
                    sleep(500);
                } catch (InterruptedException ex) {
                    System.out.println(" ");
                }
            }

            for (int i = 0; i <= kilometros / 50 + 33; i++) {
                System.out.print('*');
                if (i == kilometros / 50 + 33) {
                    System.out.println("\n");

                }
            }

            finalCarrera();
        }
        podio();
    }

    private void finalCarrera() {
        int contador = 0;
        for (int i = 0; i < hilos.length; i++) {
            if (!hilos[i].isAlive()) {
                contador++;
            } else {
                contador = 0;
            }
            if (contador == hilos.length) {
                salida = false;
            }
        }

    }

    private void podio() {
        for (Podio podio1 : podio) {
            System.out.printf("%s %6d %s\n", "Coche: ", podio1.getNum(), podio1.getTiempo());
        }
    }

    public static void setSalida2(boolean salida2) {
        Carrera.salida2 = salida2;
        Coche.setSalida(salida2);
    }

}
