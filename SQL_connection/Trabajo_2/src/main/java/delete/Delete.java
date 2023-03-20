/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package delete;

import connection.ConnexioBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author mraul
 */
public class Delete {

    Scanner sn = new Scanner(System.in);
    Scanner ss = new Scanner(System.in);
    private int id;
    private String objeto_borrar;

    public Delete() {
        menu_delete();
    }
    ConnexioBD cbd = new ConnexioBD();

    private void delete() {
        Connection con = cbd.connexioBD();
        try {
            PreparedStatement nom = con.prepareStatement(objeto_borrar);
            nom.setInt(1, id);

            int n = nom.executeUpdate();
            System.out.println("Borrado " + n + " usuario/s");

        } catch (SQLException sqle) {
            System.err.println("Codigo error: " + sqle.getErrorCode() + "\n"
                    + "Mensaje: " + sqle.getMessage() + "\n");
        }
        cbd.tacaConnexioDB();
    }

    private void menu_delete() {
        boolean sortida = false;
        int opcion;
        while (!sortida) {
            System.out.print("""
                           |---------------------------------------|
                           |           MENU DE ELIMINAR            |
                           |---------------------------------------|
                           | 1 : ELIMINAR CLIENTES                 |
                           | 2 : ELIMINAR PRODUCTOS                |
                           | 3 : ELIMINAR INGREDIENTE              |
                           | 4 : ATRAS                             |
                           |---------------------------------------|
                           """);

            try {

                System.out.print("Escribe una de las opciones\n-->");
                opcion = sn.nextInt();

                switch (opcion) {
                    case 1:
                        id = 0;
                        objeto_borrar = "";
                        System.out.print("Introduce ID CLIENTE ha borrar\n-->");
                        id += sn.nextInt();
                        objeto_borrar = "delete from clientes where id_clientes = ?";
                        delete();
                        break;
                    case 2:
                        deleter_productos();
                        break;
                    case 3:
                        deleter_ingredientes();
                        break;
                    case 4:
                        sortida = true;
                        sn.reset();
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 4");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
                sn.reset();
            }
        }
    }

    private void deleter_ingredientes() {

        Connection con = cbd.connexioBD();
        try {
            id = 0;
            System.out.print("Introduce ID INGREDIENTE ha borrar-->");
            id += sn.nextInt();
            con.setAutoCommit(false);
            String borrar_ingre = "delete from ingredientes where id_ingredientes = ?";
            String borrar_relacion = "delete from productos_ingredientes where id_ingredientes = ?";

            PreparedStatement nom2 = con.prepareStatement(borrar_relacion);
            PreparedStatement nom = con.prepareStatement(borrar_ingre);

            nom2.setInt(1, id);
            nom.setInt(1, id);

            nom2.executeUpdate();
            nom.executeUpdate();

            Boolean salir = true;
            while (salir) {
                System.out.print("quieres finalizar la transaccion se borraran todas las relaciones\nsi o no-->");
                String decision = ss.nextLine();
                if (decision.equalsIgnoreCase("si")) {
                    con.commit();
                    salir = false;
                }
                if (decision.equalsIgnoreCase("no")) {
                    con.rollback();
                    salir = false;
                }
            }

        } catch (SQLException sqle) {
            System.err.println("Codigo error: " + sqle.getErrorCode() + "\n"
                    + "Mensaje: " + sqle.getMessage() + "\n");
        }
        cbd.tacaConnexioDB();
    }

    private void deleter_productos() {

        Connection con = cbd.connexioBD();
        try {
            id = 0;
            System.out.print("Introduce ID PRODUCTO ha borrar-->");
            id += sn.nextInt();
            con.setAutoCommit(false);
            String borrar_producto = "delete from productos where id_productos = ?";
            String borrar_relacion = "delete from productos_ingredientes where id_productos = ?";
            String borrar_relacion2 = "delete from detalles_pedidos where id_productos = ?";

            PreparedStatement nom3 = con.prepareStatement(borrar_relacion2);
            PreparedStatement nom2 = con.prepareStatement(borrar_relacion);
            PreparedStatement nom = con.prepareStatement(borrar_producto);

            nom2.setInt(1, id);
            nom3.setInt(1, id);

            nom.setInt(1, id);

            nom2.executeUpdate();
            nom3.executeUpdate();
            nom.executeUpdate();

            Boolean salir = true;
            while (salir) {
                System.out.print("quieres finalizar la transaccion se borraran todas las relaciones\nsi o no-->");
                String decision = ss.nextLine();
                if (decision.equalsIgnoreCase("si")) {
                    con.commit();
                    salir = false;
                }
                if (decision.equalsIgnoreCase("no")) {
                    con.rollback();
                    salir = false;
                }
            }

        } catch (SQLException sqle) {
            System.err.println("Codigo error: " + sqle.getErrorCode() + "\n"
                    + "Mensaje: " + sqle.getMessage() + "\n");
        }
        cbd.tacaConnexioDB();
    }

}
