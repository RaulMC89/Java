/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recuperacio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author mraul
 */
public class Leer_Ecribir_txt {

    public Leer_Ecribir_txt() {

    }
//escribo el archivo

    public void escribir(String texto) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("Sortida.txt"), true));
        bw.write(texto);
        bw.write("\n");
        bw.close();
    }
//leo el archivo

    public int leer(String letra) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader("Entrada.txt"));
        int total = 0;
        while (br.ready()) {

            String datos = br.readLine();
            int cont = 0;
            String[] lista = datos.split(" = ");

            for (String object : datos.split(" = ")) {
                cont++;
                if (object.equalsIgnoreCase(letra)) {
                    total += Integer.parseInt(lista[cont]);
                }

            }

        }
        return total;
    }

}
