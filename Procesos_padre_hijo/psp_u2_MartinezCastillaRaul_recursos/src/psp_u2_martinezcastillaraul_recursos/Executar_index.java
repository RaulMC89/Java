/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package psp_u2_martinezcastillaraul_recursos;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author mraul
 */
public class Executar_index {

    public static void main(String[] args) {
        String index = "..\\psp_u2_MartinezCastillaRaul_recursos\\index.html";
        try {

            File objetofile = new File(index);
            Desktop.getDesktop().open(objetofile);

        } catch (IOException ex) {

            System.out.println(ex);

        }
    }
}
