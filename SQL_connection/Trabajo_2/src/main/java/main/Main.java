/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import delete.Delete;
import insert.Insert_Cliente;
import insert.Insert_Empleado;
import insert.Insert_Pedido;
import java.util.InputMismatchException;
import java.util.Scanner;
import select.Select_Clientes;
import select.Select_Empleados;
import select.Select_Pedidos;
import update.Update_Cliente;
import update.Update_Empleado;
import update.Update_Producto;

/**
 *
 * @author mraul
 */
public class Main {

    Scanner sn = new Scanner(System.in);

    public Main() {
        try {
            menu_principal();
        } catch (Exception e) {
            System.out.println("Salida del menu correcta");
        }

    }

    public static void main(String[] args) {
        new Main();
    }

    private void menu_principal() {

        boolean sortida = false;
        int opcion;

        while (!sortida) {
            System.out.print("""
                           |---------------------------------------|
                           |           MENU PRINCIPAL              |
                           |---------------------------------------|
                           | 1 : LISTAS                            |
                           | 2 : AÑADIR                            |
                           | 3 : ACTUALIZAR                        |
                           | 4 : ELIMINAR                          |
                           | 5 : SALIR                             |
                           |---------------------------------------|
                           """);
            try {

                System.out.print("Escribe una de las opciones\n-->");
                opcion = sn.nextInt();

                switch (opcion) {
                    case 1:

                        menu_Selects();
                        break;
                    case 2:
                        menu_Insert();
                        break;
                    case 3:
                        menu_update();
                        break;
                    case 4:

                        new Delete();
                        break;
                    case 5:
                        sortida = true;
                        sn.close();
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 5");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
                sn.reset();
            }
        }
    }

    private void menu_Selects() {
        boolean sortida = false;
        int opcion;

        while (!sortida) {
            System.out.print("""
                           |---------------------------------------|
                           |           MENU DE LISTAS              |
                           |---------------------------------------|
                           | 1 : CLIENTES                          |
                           | 2 : EMPLEADOS                         |
                           | 3 : PEDIDOS                           |
                           | 4 : ATRAS                             |
                           |---------------------------------------|
                           """);

            try {

                System.out.print("Escribe una de las opciones\n-->");
                opcion = sn.nextInt();

                switch (opcion) {
                    case 1:
                        new Select_Clientes();
                        break;
                    case 2:
                        new Select_Empleados();
                        break;
                    case 3:
                        new Select_Pedidos();
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

    private void menu_Insert() {
        boolean sortida = false;
        int opcion;

        while (!sortida) {

            System.out.print("""
                           |---------------------------------------|
                           |           MENU DE AÑADIR              |
                           |---------------------------------------|
                           | 1 : CLIENTES                          |
                           | 2 : EMPLEADOS                         |
                           | 3 : PEDIDOS                           |
                           | 4 : ATRAS                             |
                           |---------------------------------------|
                           """);

            try {

                System.out.print("Escribe una de las opciones\n-->");
                opcion = sn.nextInt();

                switch (opcion) {
                    case 1:
                        new Insert_Cliente();
                        break;
                    case 2:
                        new Insert_Empleado();
                        break;
                    case 3:
                        new Insert_Pedido();
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

    private void menu_update() {
        boolean sortida = false;
        int opcion;

        while (!sortida) {

            System.out.print("""
                           |---------------------------------------|
                           |           MENU DE ACTUALIZAR          |
                           |---------------------------------------|
                           | 1 : CLIENTES                          |
                           | 2 : EMPLEADOS                         |
                           | 3 : PRODUCTOS                         |
                           | 4 : ATRAS                             |
                           |---------------------------------------|
                           """);

            try {

                System.out.print("Escribe una de las opciones\n-->");
                opcion = sn.nextInt();

                switch (opcion) {
                    case 1:
                        new Update_Cliente();
                        break;
                    case 2:
                        new Update_Empleado();
                        break;
                    case 3:
                        new Update_Producto();

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

}
