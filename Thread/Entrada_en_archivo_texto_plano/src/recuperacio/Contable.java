/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recuperacio;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mraul
 */
// Extiendo de la clase Thread para crear un hilo
public class Contable extends Thread {

    //objeto leer y escribir
    private Leer_Ecribir_txt objet = new Leer_Ecribir_txt();
    //tres variables para coger el importe
    static int a;
    static int b;
    static int f;

    //le doy un nombre
    public Contable(String nom) {
        this.setName(nom);
    }

    @Override
    public void run() {

        try {
            if (this.getName() == "A") {
                a = objet.leer("A");
                String texto = "S’ha cobrat oficialment: " + a + "€";
                objet.escribir(texto);
            }
            if (this.getName() == "B") {
                b = objet.leer("B");
                String texto = "S’ha cobrat en negre: " + b + "€";
                objet.escribir(texto);
            }
            if (this.getName() == "F") {
                f = objet.leer("F");
                String texto = "Hem pagat: " + f + "€";
                objet.escribir(texto);
                int suma = a + b - f;
                String texto2 = "Els beneficis de l’empresa són:" + suma + "€";
                objet.escribir(texto2);
            }
            int suma = a + b - f;
            if (suma < 0) {
                System.out.println("L’empresa està en nombres vermells!!");
            }
        } catch (IOException ex) {
            Logger.getLogger(Contable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
