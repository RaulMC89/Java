package select;

import connection.ConnexioBD;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Select_Pedidos {

    Scanner sn = new Scanner(System.in);
    ConnexioBD cbd = new ConnexioBD();
    Connection con = cbd.connexioBD();
    String select = "Select * from pedidos";
    int id;

    public Select_Pedidos() {
        menu_pedidos();
    }

    private void menu_pedidos() {

        boolean sortida = false;
        int opcion;

        while (!sortida) {
            System.out.print("""
                           |---------------------------------------|
                           |       MENU DE LISTA DE PEDIDO/s       |
                           |---------------------------------------|
                           | 1 : LISTA DE TODOS LOS PEDIDOS        |
                           | 2 : LISTA DE UN PEDIDOS POR ID        |
                           | 3 : ATRAS                             |
                           |---------------------------------------|
                           """);

            try {

                System.out.print("Escribe una de las opciones\n-->");
                opcion = sn.nextInt();

                switch (opcion) {
                    case 1:
                        select = "Select * from pedidos";
                        selectPedidos();
                        break;
                    case 2:

                        System.out.print("Introduce ID de PEDIDO.\n-->");
                        id = sn.nextInt();
                        select = "Select * from pedidos";
                        select += " where id_pedidos = " + id;
                        selectPedidos();
                        selectDetallesPedido();
                        break;
                    case 3:
                        sortida = true;
                        sn.reset();
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 3");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
                sn.reset();
            }
        }
    }

    private void selectPedidos() {
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(select);
            int rayas = 157;

            System.out.println("****************\n"
                    + "*   PEDIDO/S   *\n"
                    + "****************\n");
            while (rs.next()) {

                for (int i = 0; i < rayas; i++) {
                    System.out.print("-");
                }

                int id_pedidos = rs.getInt("id_pedidos");
                int id_clientes = rs.getInt("id_clientes");
                int id_foma_pago = rs.getInt("id_formas_pagos");
                Date fecha_pedido1 = rs.getDate("fecha_pedido");
                Time fecha_pedido2 = rs.getTime("fecha_pedido");
                Boolean llevar = rs.getBoolean("llevar");
                Boolean estado = rs.getBoolean("estado");

                Date UPDATED_AT1 = rs.getDate("UPDATED_AT");
                Time UPDATED_AT2 = rs.getTime("UPDATED_AT");
                Date CREATED_AT1 = rs.getDate("CREATED_AT");
                Time CREATED_AT2 = rs.getTime("CREATED_AT");
                System.out.printf("\n|%-15s| %-15s | %-15s| %-21s| %-15s| %-15s| %-22s| %-22s|\n", "id_pedidos", "id_clientes", "id_formas_pagos", "fecha_pedido", "llevar", "pagado", "UPDATED_AT", "CREATED_AT");
                for (int i = 0; i < rayas; i++) {
                    System.out.print("-");
                }
                System.out.printf("\n|%-15d| %-15d | %-15d| %-10s %-10s| %-15b| %-15b| %-10s %-10s | %-10s %-10s |\n", id_pedidos, id_clientes, id_foma_pago, fecha_pedido1, fecha_pedido2, llevar, estado, UPDATED_AT1, UPDATED_AT2, CREATED_AT1, CREATED_AT2);

                for (int i = 0; i < rayas; i++) {
                    System.out.print("-");
                }
                System.out.println("\n");
            }

            if (rs != null) {
                rs.close();
            }
            if (st != null) {
                st.close();
            }
        } catch (SQLException sqle) {
            System.err.println("Codigo error: " + sqle.getErrorCode() + "\n"
                    + "Mensaje: " + sqle.getMessage() + "\n");
        }
        cbd.tacaConnexioDB();
    }

    private void selectDetallesPedido() {
        try {
            String select2 = "Select * from detalles_pedidos where id_pedidos = " + id;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(select2);
            int rayas = 160;
            System.out.println("*********************\n"
                    + "* DETALLES PEDIDO   *\n"
                    + "*********************\n");
            while (rs.next()) {

                for (int i = 0; i < rayas; i++) {
                    System.out.print("-");
                }

                int id_pedidos = rs.getInt("id_pedidos");
                int id_productos = rs.getInt("id_productos");
                int cantidad_vendida = rs.getInt("cantidad_vendida");
                String anotacion_cliente = rs.getString("anotacion_cliente");
                System.out.printf("\n|%-15s| %-15s | %-20s| %-100s |\n", "id_pedidos", "id_productos", "cantidad_vendida", "anotacion_cliente");

                for (int i = 0; i < rayas; i++) {
                    System.out.print("-");
                }
                System.out.printf("\n|%-15d| %-15d | %-20d| %-100s |\n", id_pedidos, id_productos, cantidad_vendida, anotacion_cliente);

                for (int i = 0; i < rayas; i++) {
                    System.out.print("-");
                }
                System.out.println("\n");
            }

            if (rs != null) {
                rs.close();
            }
            if (st != null) {
                st.close();
            }
        } catch (SQLException sqle) {
            System.out.println("Mensaje: " + sqle.getMessage() + "\n");
        }
        cbd.tacaConnexioDB();
    }

}
