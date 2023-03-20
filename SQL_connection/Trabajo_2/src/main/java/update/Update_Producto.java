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
import java.util.regex.Pattern;

/**
 *
 * @author mraul
 */
public class Update_Producto {

    Scanner sn = new Scanner(System.in);
    Scanner ss = new Scanner(System.in);

    private int id = 0;
    private String nombre = "nombre_producto = '";

    private String precio;
    private String tipo_producto = "tipo_pro = '";
    private int cantidad = 0000;
    private String update;
    private String update1 = "update productos set ";
    private String update2 = "' where id_productos = ";

    public Update_Producto() {
        menu_update();

    }

    private void producto() {
        String date_time = ZonedDateTime.now().format(DateTimeFormatter.ofPattern("yyy-MM-dd HH:mm:ss"));
        ConnexioBD cbd = new ConnexioBD();
        Connection con = cbd.connexioBD();
        try {
            Statement st = con.createStatement();
            st.addBatch(update);
            st.addBatch("update productos set UPDATED_AT = '" + date_time + update2 + id);
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
        System.out.print("Introduce id producto\n-->");
        id = sn.nextInt();
        while (!sortida) {
            System.out.print("""
                           |---------------------------------------|
                           |       MENU ACTUALIZAR PRODUCTO        |
                           |---------------------------------------|
                           | 1 : NOMBRE PRODUCTO                   |
                           | 2 : PRECIO                            |
                           | 3 : TIPO DE PRODUCTO                  |
                           | 4 : CANTIDAD                          |
                           | 5 : ATRAS                             |
                           |---------------------------------------|
                           """);

            try {

                System.out.print("Escribe una de las opciones\n-->");
                opcion = sn.nextInt();

                switch (opcion) {
                    case 1:
                        nombre = "nombre_producto = '";
                        System.out.print("Introduce NOMBRE nuevo-->");
                        nombre += ss.nextLine();
                        update = update1 + nombre + update2 + id;
                        producto();
                        break;
                    case 2:
                        ss.reset();
                        precio = "";
                        System.out.print("Introduce PRECIO nuevo formato 00.00\n-->");
                        precio = ss.nextLine();
                        if (Pattern.matches("^[0-9]{1,3}([.][0-9]{1,2})?$", precio)) {
                            update = update1 + "precio = " + precio + " where id_productos = " + id;
                            producto();
                        } else {
                            System.out.println("Formato incorrecto");
                        }
                        break;
                    case 3:
                        tipo_producto = "tipo_pro = '";
                        System.out.print("Introduce TIPO de producto \"bebida\" o \"comida\"  nuevo\n-->");
                        tipo_producto += ss.nextLine();
                        update = update1 + tipo_producto + update2 + id;
                        producto();
                        break;
                    case 4:
                        cantidad = 0000;
                        System.out.print("Introduce cantidad nuevo\n-->");
                        cantidad += sn.nextInt();
                        update = update1 + "cantidad = " + cantidad + " where id_productos = " + id;
                        producto();
                        break;
                    case 5:
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
