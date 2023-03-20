/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exercicis_21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author mraul
 */
public class SentenciesPreparades_autors {

    public static void main(String[] args) throws SQLException {
        String host = "localhost";
        String puerto = "3306";
        String database = "biblioteca";
        String user = "root";
        String password = "Tu contraseña";
        Connection con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + puerto + "/" + database + "?user=" + user + "&password=" + password + "");

        String actualitzaNom = "update autors set NOM_AUT = ? set where ID_AUT = ?";

        PreparedStatement nom = con.prepareStatement(actualitzaNom);
        nom.setString(1, "Pere Company");
        nom.setInt(2, 197);

        int n = nom.executeUpdate();

        System.out.println(n);

        if (con != null) {
            con.close();
        }
    }
}
