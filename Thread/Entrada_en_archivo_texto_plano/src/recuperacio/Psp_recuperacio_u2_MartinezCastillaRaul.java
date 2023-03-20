/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package recuperacio;

/**
 *
 * @author mraul
 */
public class Psp_recuperacio_u2_MartinezCastillaRaul {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        //declaro los tre hilos a, b y f
        Contable a = new Contable("A");
        Contable b = new Contable("B");
        Contable f = new Contable("F");
        //los inicio
        a.start();
        b.start();
        f.start();
        //Hasta que no acaben los hilos no terminara el hilo principal
        a.join();
        b.join();
        f.join();

        System.out.println("Fil [A, B o F] acabat!");

    }

}
