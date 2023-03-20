package carrera_coches;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author mraul
 */
public class Inicio_carrera {

    /**
     * Llamamos a la clase Sc para preguntar al usuario y creamos el numero de
     * corredores que son un hilo cada corredos llamamos tambien a la clase
     * Carrera para pintar los hilos, le pasamos los hilos y la carrera para
     * poderla detener la carrera.
     */
    public static void main(String[] args) throws InterruptedException {
        String date = new SimpleDateFormat("EEEE,d MMMM, yyyy.").format(new Date());

        Sc sc = new Sc();
        int num_hilos = sc.getNum_hilos();
        int kilometros = sc.getKilometros();

        for (int i = 0; i < kilometros / 50 + 12; i++) {
            System.out.print("-");
            if (i == (kilometros / 50 + 12) / 2) {
                System.out.print(date);
            }
            if (i == kilometros / 50 + 12 - 1) {
                System.out.print("\n");
            }
        }

        Coche[] hilos = new Coche[num_hilos];

        for (int i = 1; i <= num_hilos; i++) {

            hilos[i - 1] = new Coche(i, kilometros, num_hilos);
        }

        for (int i = 1; i <= num_hilos; i++) {

            hilos[i - 1].start();
        }
        Carrera car = new Carrera(hilos);
        //Menu menu = new Menu(car, hilos);
        car.start();
        //menu.start();
        for (int i = 1; i <= num_hilos; i++) {

            hilos[i - 1].join();
        }
        car.join();
        new Repetir_carrera();
    }

}
