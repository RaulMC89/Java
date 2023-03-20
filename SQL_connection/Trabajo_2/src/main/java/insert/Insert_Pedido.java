/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package insert;

import connection.ConnexioBD;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author mraul
 */
public class Insert_Pedido {

    Scanner sn = new Scanner(System.in);
    Scanner ss = new Scanner(System.in);

    private int id_cliente;
    private int id_forma_pago;
    private String llevar;
    private String estado;
    private int dni;
    private String select = "Select * from clientes where dni = ";
    ConnexioBD cbd = new ConnexioBD();
    Connection con = cbd.connexioBD();

    public Insert_Pedido() {
        menu();
    }
//Hacemos el insert si tenemos todos los datos

    private void insert_pedido() {

        String pedido = "insert into pedidos (id_clientes, id_formas_pagos, llevar, estado) VALUES (" + id_cliente + "," + id_forma_pago + "," + llevar + "," + estado + ")";

        try {
            if (con != null) {
                Statement st = con.createStatement();

                int filesAfectades = st.executeUpdate(pedido);

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
//Este metodo al añadir un pedido pide el dni y si existe algun usuario con ese
//dni llama al metodo exiteCliente() y si existe nos devuelve el id mediante un select
    //y  nos pedira los siguentes datos.

    private void menu() {
        sn.reset();
        System.out.print("Introduce DNI cliente.\n-->");
        dni = sn.nextInt();
        select += dni;
        exiteCliente(dni);
        if (id_cliente > 0) {
            System.out.print("Introduce ID forma de pago:\n1. Targeta credito.\n2. Targeta debito.\n3. Efectivo.\n-->");
            id_forma_pago = sn.nextInt();
            System.out.print("Introduce para llevar SI o NO.\n-->");

            llevar = ss.nextLine();
            if (llevar.equalsIgnoreCase("si")) {
                llevar = "true";
            } else {
                llevar = "false";
            }
            System.out.print("Introduce estado del pedido pagado SI o NO\n-->");
            estado = ss.nextLine();
            if (estado.equalsIgnoreCase("si")) {
                estado = "true";
            } else {
                estado = "false";
            }
            insert_pedido();
        } else {
            System.out.println("Cliente no existe introduzcalo en el sistema.");
        }
        sn.reset();
        ss.reset();
    }
//Este metodo si existe el dni nos devuelve el id_cliente

    public void exiteCliente(int dni) {
        this.dni = dni;
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(select);

            while (rs.next()) {
                id_cliente = rs.getInt("id_clientes");
                dni = rs.getInt("dni");
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
