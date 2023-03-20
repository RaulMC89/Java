/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cifp.exercicis;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Yolanda
 */
public class Configmysql {

    public void escriureConfig() {
        // Preparam les propietats amb els valors desitjats
        Properties conf = new Properties();
        conf.setProperty("port", "3306");
        conf.setProperty("socket", "/tmp/mysql.sock");
        conf.setProperty("key_buffer_size", "16M");
        conf.setProperty("max_allowed_packet", "128M");

        FileOutputStream out = null;
        try {
            // Escribim les propietats al fitxer
            out = new FileOutputStream("mysql.conf");
            conf.store(out, "Configuracion mysql");
        } catch (FileNotFoundException ex) {
            System.out.println("Fitxer no trobat.");
        } catch (IOException ex) {
            System.out.println("Error d'entrada i sortida");
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException ex) {
                    System.out.println("Error d'entrada i sortida.");
                }
            }
        }
    }

    public void llegirConfig() {
        // Carregam els valors a un objecte Properties i el mostram per pantalla
        Properties conf = new Properties();
        try {
            conf.load(new FileInputStream("mysql.conf"));
            System.out.println(conf);
        } catch (FileNotFoundException fnfe) {
            System.out.println("Fitxer no trobat.");
        } catch (IOException ioe) {
            System.out.println("Error d'entrada i sortida.");
        }
    }

}
