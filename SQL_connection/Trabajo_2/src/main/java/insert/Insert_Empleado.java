/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package insert;

import connection.ConnexioBD;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author mraul
 */
public class Insert_Empleado {

    Scanner sn = new Scanner(System.in);
    Scanner ss = new Scanner(System.in);

    private String dni;
    private String nom;
    private String apellidos;
    private int anyo;
    private int mes;
    private int dia;
    private int anyo2;
    private int mes2;
    private int dia2;
    private String direccion;
    private int telefono;
    private String tipo;
    ConnexioBD cbd = new ConnexioBD();
    Connection con = cbd.connexioBD();

    public Insert_Empleado() {
        menu();

        insert_empleado();
    }

    private void insert_empleado() {

        String empleado = "insert into empleados (dni, nombre, apellidos, fecha_nacimiento, direccion, telefono, tipo, fecha_alta) VALUES ('" + dni + "','" + nom + "','" + apellidos + "','" + anyo + "-" + mes + "-" + dia + "','" + direccion + "'," + telefono + ",'" + tipo + "','" + anyo2 + "-" + mes2 + "-" + dia2 + "')";

        try {
            if (con != null) {
                Statement st = con.createStatement();

                int filesAfectades = st.executeUpdate(empleado);

                System.out.println("Se ha introducido " + filesAfectades + " fila");

                if (st != null) {
                    st.close();
                }
            }

        } catch (SQLException sqle) {
            System.err.println("Codigo error: " + sqle.getErrorCode() + "\n"
                    + "Mensaje: " + sqle.getMessage() + "\n");
        }

        cbd.tacaConnexioDB();
    }

    private void menu() {
        System.out.print("Introduce DNI sin letra.\n-->");
        dni = ss.nextLine();
        System.out.print("Introduce NOMBRE.\n-->");
        nom = ss.nextLine();
        System.out.print("Introduce APELLIDOS.\n-->");
        apellidos = ss.nextLine();
        System.out.print("Introduce de la FECHA DE NACIMIENTO.\nIntroduce AÑO\n-->");
        anyo = 0000 + sn.nextInt();
        System.out.print("Introduce de la FECHA DE NACIMIENTO.\nIntroduce MES\n-->");
        mes = 00 + sn.nextInt();
        System.out.print("Introduce de la FECHA DE NACIMIENTO.\nIntroduce DIA\n-->");
        dia = 00 + sn.nextInt();
        System.out.print("Introduce DIRECCION.\n-->");
        direccion = ss.nextLine();
        System.out.print("Introduce TELEFONO.\n-->");
        telefono = sn.nextInt();
        System.out.print("Introduce TIPO: \"directivos\", \"encargados\", \"bases\".\n-->");
        tipo = ss.nextLine();
        System.out.print("Introduce de la FECHA DE ALTA.\nIntroduce AÑO\n-->");
        anyo2 = 0000 + sn.nextInt();
        System.out.print("Introduce de la FECHA DE ALTA.\nIntroduce MES\n-->");
        mes2 = 00 + sn.nextInt();
        System.out.print("Introduce de la FECHA DE ALTA.\nIntroduce DIA\n-->");
        dia2 = 00 + sn.nextInt();
    }
}
