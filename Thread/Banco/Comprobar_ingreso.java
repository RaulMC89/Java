/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercici2;

/**
 *
 * @author mraul
 */
public class Comprobar_ingreso {

    private Banco bc;
    private int ingre;
    private String hilo;

    public Comprobar_ingreso(String hilo, int ingre, Banco bc) {
        this.hilo = hilo;
        this.ingre = ingre;
        this.bc = bc;
        ingreso();
    }

    private void ingreso() {
        int num = bc.getNum();

        if (ingre > 0) {

            int total = num + ingre;
            bc.setNum(total);
            System.out.println(hilo + " + " + ingre + "-> ingressos " + total + "€");

        } else {
            int total = num + ingre;
            bc.setNum(total);
            System.out.println(hilo + " " + ingre + "-> ingressos " + total + "€");
            if (bc.getNum() < 0) {
                System.out.println("BANCA ROTA");
            }
        }

    }

}
