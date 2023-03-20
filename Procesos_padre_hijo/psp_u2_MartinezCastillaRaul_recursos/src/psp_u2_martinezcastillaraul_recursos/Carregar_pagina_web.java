package psp_u2_martinezcastillaraul_recursos;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

/**
 *
 * @author mraul
 */
public class Carregar_pagina_web {

    public static void main(String[] args) throws Exception {

        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        URL url = new URL(entrada.readLine());
        entrada.close();
        try ( BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()))) {
            String linea;
            while ((linea = in.readLine()) != null) {
                System.out.println(linea);
            }
        }
    }
}
