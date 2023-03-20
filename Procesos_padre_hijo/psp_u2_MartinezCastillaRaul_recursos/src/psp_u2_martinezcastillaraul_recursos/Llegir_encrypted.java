package psp_u2_martinezcastillaraul_recursos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author mraul
 */
public class Llegir_encrypted {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader("..\\psp_u2_MartinezCastillaRaul_recursos\\encrypted.txt"));
        String linea;

        while ((linea = br.readLine()) != null) {
            System.out.println(linea);
        }
        br.close();
    }

}
