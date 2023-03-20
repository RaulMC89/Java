/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carrera_coches;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * En esta clase calculamos mediante un random la velocidad que sera entre 60 y
 * 140 y calcula la distancia recorrida luego con un contador statico cuando
 * pasan tres por la meta los demas entran en un bucle hasta que el usuario
 * decida si continuar o no.
 */
public class Coche extends Thread {

    private final int kilometros;
    private int velocidad = 100;
    private int kilome_recorridos = 0;
    private String plus = " ";

    long inicio = System.currentTimeMillis();
    static boolean salida = true;
    static int contSalida = 0;
    static int contadorPlus = 0;
    private int num = 0;
    private int coches = 0;

    public Coche(int num, int kilometro, int coches) {
        this.num = num;
        this.kilometros = kilometro;
        this.coches = coches;

    }

    @Override
    public void run() {

//Cuando cada coche pase por meta saldra del bucle
        while (kilome_recorridos < kilometros / 50) {
            try {
                sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Coche.class.getName()).log(Level.SEVERE, null, ex);
            }
            //Numero random entre el -5 y 5
            velocidad += (int) (Math.random() * (-5 - 5 + 1) + 4);
            if (kilome_recorridos < kilometros / 50) {
                contadorPlus++;
                if (contadorPlus >= coches) {
                    velocidad += 20;
                    plus = "PLUS VELOCIDAD";
                    contadorPlus = 0;
                } else {
                    plus = " ";
                }
            }

            //si la velocidad es de menos de 60 se asigna a la variable velocidad 60
            //se calcula quilometros recorrido y se suma a la variable kilometros recorridos
            if (velocidad < 60) {
                velocidad = 60;
                kilome_recorridos += velocidad / 50;
                if (kilome_recorridos > kilometros / 50) {
                    kilome_recorridos = kilometros / 50;
                }
            }
            //lo mismo que antes pero mas de 140 se settea a 140
            if (velocidad > 140) {
                velocidad = 140;
                kilome_recorridos += velocidad / 50;
                if (kilome_recorridos > kilometros / 50) {
                    kilome_recorridos = kilometros / 50;
                }
            }
            //si esta entre 60 y 140 esta bien
            if (velocidad >= 60 && velocidad <= 140) {
                kilome_recorridos += velocidad / 50;
                if (kilome_recorridos > kilometros / 50) {
                    kilome_recorridos = kilometros / 50;
                }
            }
            //si los kilometros recorridos son menor que la distancia hasta la meta pasa.
            while (!salida) {

                try {
                    sleep(500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Coche.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            if (kilome_recorridos == kilometros / 50) {
                contSalida++;
                if (contSalida == 3) {
                    salida = false;
                }
            }

        }

    }

    public int getNum() {
        return num;
    }

    public String getPlus() {
        return plus;
    }

    public int getKilometros() {
        return kilometros;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public int getKilome_recorridos() {
        return kilome_recorridos;
    }

    public void setKilome_recorridos() {
        this.kilome_recorridos = this.kilometros;
    }

    public static boolean isSalida() {
        return salida;
    }

    public static void setSalida(boolean salida) {
        Coche.salida = salida;
    }

    public String calcularTiempo() { //Método para saber la hora

        long fin = System.currentTimeMillis();
        double tiempo = (double) ((fin - inicio) / 1000);
        return "Tiempo en llegar a la meta: " + tiempo + " segundos";
    }
}
