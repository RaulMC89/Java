package Cuenta_atras;

import java.util.Scanner;

public class Cuenta_atras {

    public static void main(String[] args) {

        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Introduce numero de segundos a de ser mayor de 25:\n-->");

            int numeroAtras = sc.nextInt();

            Hilosegundos h = new Hilosegundos(numeroAtras);
            Menu m = new Menu(h);
            h.start();
            m.start();

            h.join();

            System.out.println("Programa finalizado");
        } catch (InterruptedException ex) {
            java.util.logging.Logger.getLogger(Cuenta_atras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

    }
}
