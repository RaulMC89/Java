/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cifp.exercicis;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Yolanda
 */
public class PropietatsSistema {

    public void escriure_propietats() {

        // Obtenim les propietats del sistema i les guardam en forma de cadena de caràcters
        String json_content = "{"
                + "\"jre_dir\": " + "\"" + System.getProperty("java.home") + "\""
                + ", \"os_name_version\": " + "\"" + System.getProperty("os.name") + " " +System.getProperty("os.version") + "\""
                + ", \"file_separator\": " + "\"" + System.getProperty("path.separator") + "\""
                + ", \"user_name\": " + "\"" + System.getProperty("user.home") + "\""
                + ", \"filesystem_separator\": " + "\"" + System.getProperty("line.separator") + "\""
                + "}";
        
        System.out.println(json_content);
        
        // Escribim la cadena de caràcters al fitxer corresponent.
        try (FileWriter writer = new FileWriter(new File("propietats_del_sistema.json"))) {
            writer.write(json_content);
        } catch (IOException ex) {
            System.out.println("Error d'entrada i sortida.");
        }

    }

}
