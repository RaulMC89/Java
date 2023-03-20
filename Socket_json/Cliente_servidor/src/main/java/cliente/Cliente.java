package cliente;

import java.exercici_2.User;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

    public static BufferedReader getStream(InputStream is) {
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader bfr = new BufferedReader(isr);
        return bfr;
    }

    public static User conexion(User objeto) {
        try {
            Socket clientSocket = new Socket();
            InetSocketAddress addr = new InetSocketAddress("localhost", 55555);
            clientSocket.connect(addr);
            ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());
            oos.writeObject(objeto);
            oos.flush();
            BufferedReader bfr = Cliente.getStream(clientSocket.getInputStream());
            System.out.println("El resultado fue: " + bfr.readLine());
            clientSocket.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return objeto;
    }

    public static void main(String[] args) {

        Scanner sr = new Scanner(System.in);
        Scanner src = new Scanner(System.in);
        User objeto;
        int id;
        String nombre;
        String apellido;
        boolean bien = true;
        while (bien) {
            System.out.print(
                    """
                            INTRODUCE
                            - Insert
                            - Select
                            - Delete
                            --->
                            """
            );
            String mensaje = src.nextLine();
            switch (mensaje) {
                case "insert":
                    System.out.println("Introduce una id: ");
                    id = sr.nextInt();
                    System.out.println("Introduce un nombre: ");
                    nombre = src.nextLine();
                    System.out.println("Introduce un apellido:");
                    apellido = src.nextLine();
                    objeto = new User("insert", id, nombre, apellido);
                    conexion(objeto);

                    break;
                case "select":
                    System.out.println("Introduce una id: ");
                    id = sr.nextInt();
                    objeto = new User("select", id);
                    conexion(objeto);
                    break;
                case "delete":
                    System.out.println("Introduce una id: ");
                    id = sr.nextInt();
                    objeto = new User("delete", id);
                    conexion(objeto);
                    break;
                case "exit":
                    System.exit(0);
                default:
                    System.out.println("Petición invalida");
            }

        }

    }

}
