package carrera_coches;

import java.util.Scanner;

/**
 * En esta clase que se le pasa a la clase Carrera por parametro para parar o
 * continuarv la carrera usando el metodo scanner.
 */
public class Menu {

    Coche[] coches;

    boolean salir = true;

    public Menu(Coche[] coches) {
        this.coches = coches;
        contSal();
    }

    private void contSal() {
        Scanner sc = new Scanner(System.in);
        String letra = sc.nextLine().toUpperCase();
        while (salir) {
            switch (letra) {
                case "S" -> {
                    opcion1();
                    salir = false;
                }
                case "N" -> {
                    opcion2();
                    salir = false;
                }
                default ->
                    System.out.println("Opcion incorrecta");
            }
        }
    }

    /**
     * Mira los hilo que estan vivos y los hace acabar haciendolos salir del
     * bucle llamando a los metodos setter de la clase Coche y Carrera.
     */
    private void opcion1() {
        for (Coche coche : coches) {
            if (coche.isAlive()) {
                coche.setKilome_recorridos();
                Coche.setSalida(true);
                Carrera.setSalida2(true);
            }
        }
    }

    /**
     * Los saca del bucle de parada y continua la carrera.
     */
    private void opcion2() {
        Carrera.setSalida2(true);
    }
}
