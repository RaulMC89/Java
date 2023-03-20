/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package update;

import connection.ConnexioBD;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author mraul
 */
public class Update_Cliente {

    Scanner sn = new Scanner(System.in);
    Scanner ss = new Scanner(System.in);

    private int id = 0;
    private String dni = "dni = '";
    private String nom = "nombre = '";
    private String apellidos = "apellidos = '";
    private int anyo = 0000;
    private int mes = 00;
    private int dia = 00;
    private String direccion = "direccion = '";
    private int telefono = 000000000;
    private String correo_electronico = "correo_electronico = '";
    private String update;
    private String update1 = "update clientes set ";
    private String update2 = "' where id_clientes = ";

    public Update_Cliente() {
        menu_update();

    }

    private void cliente() {
        String date_time = ZonedDateTime.now().format(DateTimeFormatter.ofPattern("yyy-MM-dd HH:mm:ss"));
        ConnexioBD cbd = new ConnexioBD();
        Connection con = cbd.connexioBD();
        try {
            Statement st = con.createStatement();
            st.addBatch(update);
            st.addBatch("update clientes set UPDATED_AT = '" + date_time + update2 + id);
            st.executeBatch();
            if (st != null) {
                st.close();
            }
        } catch (SQLException sqle) {
            System.err.println("Codigo error: " + sqle.getErrorCode() + "\n"
                    + "Mensaje: " + sqle.getMessage() + "\n");
        }
        cbd.tacaConnexioDB();
    }

    private void menu_update() {
        boolean sortida = false;
        int opcion;
        System.out.print("Introduce id usuario\n-->");
        id = sn.nextInt();
        while (!sortida) {
            System.out.print("""
                           |---------------------------------------|
                           |       MENU ACTUALIZAR CLIENTE        |
                           |---------------------------------------|
                           | 1 : DNI                               |
                           | 2 : NOMBRE                            |
                           | 3 : APELLIDOS                         |
                           | 4 : FECHA DE NACIMIENTO               |
                           | 5 : DIRECCION                         |
                           | 6 : TELEFONO                          |
                           | 7 : CORREO ELECTRONICO                |
                           | 8 : ATRAS                             |
                           |---------------------------------------|
                           """);

            try {

                System.out.print("Escribe una de las opciones\n-->");
                opcion = sn.nextInt();

                switch (opcion) {
                    case 1:
                        dni = "dni = '";
                        System.out.print("Introduce DNI nuevo-->");
                        dni += ss.nextLine();
                        update = update1 + dni + update2 + id;
                        cliente();
                        break;
                    case 2:
                        nom = "nombre = '";
                        System.out.print("Introduce NOMBRE nuevo-->");
                        nom += ss.nextLine();
                        update = update1 + nom + update2 + id;
                        cliente();
                        break;
                    case 3:
                        apellidos = "apellidos = '";
                        System.out.print("Introduce APELLIDOS nuevo\n-->");
                        apellidos += ss.nextLine();
                        update = update1 + apellidos + update2 + id;
                        cliente();
                        break;
                    case 4:
                        dia = 00;
                        mes = 00;
                        anyo = 0000;
                        System.out.print("Introduce AÑO nuevo\n-->");
                        anyo += sn.nextInt();
                        System.out.print("Introduce MES nuevo\n-->");
                        mes += sn.nextInt();
                        System.out.print("Introduce DIA nuevo\n-->");
                        dia += sn.nextInt();
                        update = update1 + "fecha_nacimiento = '" + anyo + "-" + mes + "-" + dia + update2 + id;
                        cliente();
                        break;
                    case 5:
                        direccion = "direccion = '";
                        System.out.print("Introduce DIRECCION nuevo\n-->");
                        direccion += ss.nextLine();
                        update = update1 + direccion + update2 + id;
                        cliente();
                        break;
                    case 6:
                        telefono = 000000000;
                        System.out.print("Introduce TELEFONO nuevo\n-->");
                        telefono += sn.nextInt();
                        update = update1 + "telefono = " + telefono + " where id_clientes = " + id;
                        cliente();
                        break;
                    case 7:
                        correo_electronico = "correo_electronico = '";
                        System.out.print("Introduce CORREO ELECTRONICO nuevo\n-->");
                        correo_electronico += ss.nextLine();
                        update = update1 + correo_electronico + update2 + id;
                        cliente();
                        break;
                    case 8:
                        sortida = true;
                        sn.reset();
                        ss.reset();
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 8");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
                sn.reset();
            }
        }
    }
}
