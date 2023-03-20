/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package psp_u2_martinezcastillaraul_recursos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author mraul
 */
public class Crear_arxiu_index {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader("..\\psp_u2_MartinezCastillaRaul_recursos\\encrypted.txt"));

        String entra = "<body";
        String salida = "</body>";

        int longitud = entra.length();
        int longitud2 = salida.length();
        int cont_log = 0;
        int cont_log2 = 0;
        String linea;
        String linea2 = "";
        String linea3 = "";
        String linea4 = "";
        String salto = "";
        String fin = "";
        while ((linea = br.readLine()) != null) {
            for (char c : linea.toCharArray()) {
                if (c == entra.charAt(cont_log)) {
                    linea2 += c;
                    cont_log++;
                    if (cont_log == longitud) {
                        linea3 = linea2;
                        c = ' ';
                        linea2 = "";
                        cont_log = 0;
                        fin += entra;
                    }
                } else {
                    cont_log = 0;
                    linea2 = "";
                }
                if (linea3.equalsIgnoreCase(entra)) {
                    fin += c;
                    salto = "\n";
                }
                if (c == salida.charAt(cont_log2)) {
                    linea4 += c;
                    cont_log2++;
                    if (cont_log2 == longitud2) {
                        if (linea4.equalsIgnoreCase(salida)) {
                            linea3 = linea4;
                            linea4 = "";
                            cont_log2 = 0;
                        }
                    }
                } else {
                    cont_log2 = 0;
                    linea4 = "";
                }
            }
            fin += salto;
        }
        BufferedWriter bw = new BufferedWriter(new FileWriter("..\\psp_u2_MartinezCastillaRaul_recursos\\index.html"));
        bw.write(fin);
        bw.close();
        System.out.println(fin);
        br.close();
    }

}
