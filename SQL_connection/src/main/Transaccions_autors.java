/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exercicis_21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author mraul
 */
public class Transaccions_autors {

    public static void main(String[] args) throws SQLException {
        String host = "localhost";
        String puerto = "3306";
        String database = "biblioteca";
        String user = "root";
        String password = "Tu contraseña";
        Connection con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + puerto + "/" + database + "?user=" + user + "&password=" + password + "");
//Apartados a, b, c, d, e, f

        con.setAutoCommit(false);

        String actualitzaNom = "insert into autors values (?,?, ?, null,null)";

        PreparedStatement nom = con.prepareStatement(actualitzaNom);

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM biblioteca.autors;");
        int count = 0;
        while (rs.next()) {
            count++;
        }
        System.out.println(count);

        nom.setInt(1, 7550);
        nom.setString(2, "Segio Agustin Parede");
        nom.setString(3, "1998-10-01");

        int n = nom.executeUpdate();

        con.rollback();

        if (rs != null) {
            rs.close();
        }

        ResultSet rss = st.executeQuery("SELECT * FROM biblioteca.autors;");
        int count2 = 0;
        while (rss.next()) {
            count2++;
        }
        System.out.println(count2);

        //Apartado g
        /*
        con.setAutoCommit(false);

        String actualitzaNom = "insert into autors values (?,?, ?, null,null)";

        PreparedStatement nom = con.prepareStatement(actualitzaNom);

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM biblioteca.autors;");
        int count = 0;
        while (rs.next()) {
            count++;
        }
        System.out.println(count);

        nom.setInt(1, 7550);
        nom.setString(2, "Segio Agustin Parede");
        nom.setString(3, "1998-10-01");

        int n = nom.executeUpdate();

        con.commit();

        if (rs != null) {
            rs.close();
        }

        ResultSet rss = st.executeQuery("SELECT * FROM biblioteca.autors;");
        int count2 = 0;
        while (rss.next()) {
            count2++;
        }
        System.out.println(count2);
         */
        //Apartado h
        //Nos voveria al primer insert que nos lo cuenta pero la transaccion sigue abierto por lo que no esta hecha.
        /*
        con.setAutoCommit(false);

        Statement st = con.createStatement();
        st.executeUpdate("insert into autors values (7555,'Marc Santiesteban', '1989-09-06', 'espanyola',null)");

        Savepoint punt1 = con.setSavepoint();

        st.executeUpdate("insert into autors values (7556,'Devon Lopez', '1993-02-26', 'espanyola',null)");

        con.rollback(punt1);

        ResultSet rss = st.executeQuery("SELECT * FROM biblioteca.autors;");

        int count = 0;
        while (rss.next()) {
            count++;
        }
        System.out.println(count);
         */
        if (rss != null) {
            rss.close();
        }
        if (st != null) {
            st.close();
        }
        if (con != null) {
            con.close();
        }
    }

}
