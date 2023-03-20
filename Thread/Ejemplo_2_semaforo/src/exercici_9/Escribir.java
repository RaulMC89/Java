/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercici_9;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mraul
 */
public class Escribir {

    public Escribir(String texto) {
        escribir(texto);
    }

    public void escribir(String texto) {

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(new File("./archivo.txt"), true));
            bw.write(texto);
            bw.write("\n");
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(Escribir.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
