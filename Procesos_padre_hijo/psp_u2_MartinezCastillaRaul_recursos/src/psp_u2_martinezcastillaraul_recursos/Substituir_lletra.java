/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package psp_u2_martinezcastillaraul_recursos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 *
 * @author mraul
 */
public class Substituir_lletra {

    public static void main(String[] args) throws IOException {
        Runtime r = Runtime.getRuntime();

        String[] comanda = {
            "java",
            "-cp",
            "..\\psp_u2_MartinezCastillaRaul_recursos\\dist\\psp_u2_MartinezCastillaRaul_recursos.jar",
            "psp_u2_martinezcastillaraul_recursos.Carregar_pagina_web"
        };

        Process p = r.exec(comanda);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter entradaProces = new BufferedWriter(new OutputStreamWriter(p.getOutputStream()));
        BufferedReader sortidaProces = new BufferedReader(new InputStreamReader(p.getInputStream()));

        String letras = entrada.readLine();
        String[] separar = letras.split(" ");
        entradaProces.write(separar[0]);
        entradaProces.close();
        String bussus = separar[1];
        char buscar = bussus.charAt(0);
        char buscar2 = bussus.charAt(1);

        entrada.close();
        String linea;
        String linea2 = "";
        while ((linea = sortidaProces.readLine()) != null) {

            for (char c : linea.toCharArray()) {
                if (c == buscar) {
                    linea2 += buscar2;
                } else {
                    linea2 += c;
                }
            }
            linea2 += "\n";
        }

        BufferedWriter bw = new BufferedWriter(new FileWriter("..\\psp_u2_MartinezCastillaRaul_recursos\\encrypted.txt"));
        bw.write(linea2);
        bw.close();
        System.out.println("Arxiu nou creat amb èxit\n");
        System.out.println(linea2);
        sortidaProces.close();
    }

}
