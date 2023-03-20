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

public class Select_Clientes {

    Scanner sn = new Scanner(System.in);
    ConnexioBD cbd = new ConnexioBD();
    Connection con = cbd.connexioBD();
    String select = "Select * from clientes";

    public Select_Clientes() {
        menu_clientes();
    }

    private void menu_clientes() {

        boolean sortida = false;
        int opcion;

        while (!sortida) {
            System.out.print("""
                           |---------------------------------------|
                           |       MENU DE LISTA DE CLIENTE/s      |
                           |---------------------------------------|
                           | 1 : LISTA DE TODOS LOS CLIENTES       |
                           | 2 : LISTA DE UN CLIENTE POR DNI       |
                           | 3 : ATRAS                             |
                           |---------------------------------------|
                           """);

            try {

                System.out.print("Escribe una de las opciones\n-->");
                opcion = sn.nextInt();

                switch (opcion) {
                    case 1:
                        select = "Select * from clientes";
                        selectClientes();
                        break;
                    case 2:
                        sn.reset();
                        System.out.print("Introduce DNI de CLIENTE.\n-->");
                        int id = sn.nextInt();
                        select = "Select * from clientes";
                        select += " where dni = " + id;
                        selectClientes();
                        break;
                    case 3:
                        sortida = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 99999999");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
                sn.reset();
            }
        }
    }

    private void selectClientes() {
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(select);
            int rayas = 246;
            System.out.println("*****************\n"
                    + "*   CLIENTE/S   *\n"
                    + "*****************\n");
            while (rs.next()) {

                for (int i = 0; i < rayas; i++) {
                    System.out.print("-");
                }

                int id_cliente = rs.getInt("id_clientes");
                String dni = rs.getString("dni");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");
                Date fecha_nacimiento = rs.getDate("fecha_nacimiento");
                String direccion = rs.getString("direccion");
                int telefono = rs.getInt("telefono");
                String correo_electronico = rs.getString("correo_electronico");

                Date fecha_alta1 = rs.getDate("fecha_alta");
                Time fecha_alta2 = rs.getTime("fecha_alta");
                Date fecha_baja1 = rs.getDate("fecha_baja");
                Time fecha_baja2 = rs.getTime("fecha_baja");
                Date UPDATED_AT1 = rs.getDate("UPDATED_AT");
                Time UPDATED_AT2 = rs.getTime("UPDATED_AT");
                Date CREATED_AT1 = rs.getDate("CREATED_AT");
                Time CREATED_AT2 = rs.getTime("CREATED_AT");

                System.out.printf("\n|%-15s| %-10s | %-10s| %-15s| %-20s| %-25s| %-10s| %-30s| %-21s| %-21s | %-21s | %-21s|\n", "id_cliente", "dni", "nombre", "apellidos", "fecha_nacimiento", "direccion", "telefono", "correo_electronico", "fecha_alta", " fecha_baja", " UPDATED_AT", " CREATED_AT");
                for (int i = 0; i < rayas; i++) {
                    System.out.print("-");
                }
                System.out.printf("\n|%-15d| %-10s | %-10s| %-15s| %-20s| %-25s| %-10d| %-30s| %-10s %-10s| %-10s %-10s | %-10s %-10s| %-10s %-10s |\n", id_cliente, dni, nombre, apellidos, fecha_nacimiento, direccion, telefono, correo_electronico, fecha_alta1, fecha_alta2, fecha_baja1, fecha_baja2, UPDATED_AT1, UPDATED_AT2, CREATED_AT1, CREATED_AT2);

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
            System.err.println("Código de Error: " + sqle.getErrorCode() + "\n"
                    + "Mensaje: " + sqle.getMessage() + "\n");
        }
        cbd.tacaConnexioDB();
    }
}
