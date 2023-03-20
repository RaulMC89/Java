/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package psp_u2_martinezcastillaraul_recursos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 *
 * @author mraul
 */
public class Analitzar_el_nombre_de_caracters {

    public Analitzar_el_nombre_de_caracters(String sortida) {

    }

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
        String lletra = Character.toString(buscar);
        entrada.close();
        String linea;
        int contador = 0;

        while ((linea = sortidaProces.readLine()) != null) {

            for (char c : linea.toCharArray()) {
                String dos = Character.toString(c);
                if (lletra.equals(dos)) {
                    contador++;
                }
            }
        }
        sortidaProces.close();
        String texto = "El texto tiene " + contador + " " + lletra;
        System.out.println(texto);
    }
}
