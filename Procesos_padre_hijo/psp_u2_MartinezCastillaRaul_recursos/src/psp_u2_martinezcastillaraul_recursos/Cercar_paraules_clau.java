package psp_u2_martinezcastillaraul_recursos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author mraul
 */
public class Cercar_paraules_clau {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("..\\psp_u2_MartinezCastillaRaul_recursos\\encrypted.txt"));

        String entra = entrada.readLine();
        entrada.close();
        int longitud = entra.length();
        int cont_log = 0;
        String linea;
        String linea2 = "";
        int cont = 0;
        while ((linea = br.readLine()) != null) {
            for (char c : linea.toCharArray()) {
                if (c == entra.charAt(cont_log)) {
                    linea2 += c;
                    cont_log++;
                    if (cont_log == longitud) {
                        if (linea2.equalsIgnoreCase(entra)) {
                            cont++;
                            linea2 = "";
                            cont_log = 0;
                        }
                    }
                } else {
                    cont_log = 0;
                    linea2 = "";
                }
            }
        }
        System.out.println("La palabra: " + entra + ". Existe: " + cont);
        br.close();

    }
}
