/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exercicis_21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author mraul
 */
public class Batch_autors {

    public static void main(String[] args) throws SQLException {
        try {
            String host = "localhost";
            String puerto = "3306";
            String database = "biblioteca";
            String user = "root";
            String password = "Tu contraseña";
            Connection con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + puerto + "/" + database + "?user=" + user + "&password=" + password + "");

            Statement st = con.createStatement();
            st.addBatch("insert into autors values (197,'Bartomeu Roig', '1977-11-21', 'espanyola',null)");
            st.addBatch("insert into autors values (199,'Antoni Alorda', '1965-06-30', 'espanyola',null)");
            st.addBatch("insert into autors values (200,'Maria Coll', '1989-02-05', 'espanyola',null)");
            st.executeBatch();

            //Apartado c
            /*st.addBatch("delete from autors where ID_AUT = 197");
            st.addBatch("delete from autors where ID_AUT = 199");
            st.addBatch("delete from autors where ID_AUT = 200;");
            st.executeBatch();*/
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
