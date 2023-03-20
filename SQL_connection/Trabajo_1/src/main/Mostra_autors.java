/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exercicis_21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author mraul
 */
public class Mostra_autors {

    public static void main(String[] args) {
        try {
            String host = "localhost";
            String puerto = "3306";
            String database = "biblioteca";
            String user = "root";
            String password = "Tu contraseña";
            Connection con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + puerto + "/" + database + "?user=" + user + "&password=" + password + "");

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("Select * from autors");

            while (rs.next()) {

                String ID_AUTOR = rs.getString("ID_AUT");
                String NOM_AUTORS = rs.getString("NOM_AUT");
                String DNAIX_AUT = rs.getString("DNAIX_AUT");
                String FK_NACIONALITAT = rs.getString("FK_NACIONALITAT");
                String IMG_AUTORS = rs.getString("IMG_AUT");

                System.out.printf("%5s %40s %10s %15s %15s\n", ID_AUTOR, NOM_AUTORS, DNAIX_AUT, FK_NACIONALITAT, IMG_AUTORS);
            }

            if (rs != null) {
                rs.close();
            }
            if (st != null) {
                st.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
