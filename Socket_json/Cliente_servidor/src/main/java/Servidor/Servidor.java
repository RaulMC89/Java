package Servidor;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.exercici_2.User;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Servidor {

    static boolean exit = false;
    static ArrayList<User> users = new ArrayList<>();

    public static User conexionservidor() {
        User input = new User("insert", 1, "Raul", "Martinez");
        users.add(input);
        try {
            final int bindPort = 55555;
            ServerSocket serverSocket = new ServerSocket(bindPort);
            Socket server = serverSocket.accept();
            ObjectInputStream is = new ObjectInputStream(server.getInputStream());
            input = (User) is.readObject();
            if (input.getTipo().equals("insert")) {

                int cont = 0;

                for (User e : users) {
                    Boolean existe = e.getId() == input.getId();
                    if (existe == true) {
                        cont++;
                    }
                }
                if (cont == 0) {
                    users.add(input);
                    OutputStream os = server.getOutputStream();
                    PrintWriter pw = new PrintWriter(os);

                    pw.write("Se ha introducido Usuario: " + input.getId() + " " + input.getName() + "\n");
                    pw.flush();
                    pw.close();
                } else {
                    OutputStream os = server.getOutputStream();
                    PrintWriter pw = new PrintWriter(os);

                    pw.write("No se ha introducido Usuario ya existe id: " + input.getId() + "\n");
                    pw.flush();
                    pw.close();
                }
            }
            if (input.getTipo().equalsIgnoreCase("select")) {

                User user = null;

                for (User e : users) {
                    Boolean existe = e.getId() == input.getId();
                    if (existe == true) {
                        user = e;
                    }
                }
                if (user != null) {
                    OutputStream os = server.getOutputStream();
                    PrintWriter pw = new PrintWriter(os);

                    pw.write("Id: " + user.getId() + ". Nom: " + user.getName() + ". Cognom: " + user.getCognom() + "\n");
                    pw.flush();
                    pw.close();
                } else {
                    OutputStream os = server.getOutputStream();
                    PrintWriter pw = new PrintWriter(os);

                    pw.write("No existe Usuario con id: " + input.getId() + "\n");
                    pw.flush();
                    pw.close();
                }
            }

            if (input.getTipo().equalsIgnoreCase("delete")) {
                User user = null;

                for (User e : users) {
                    Boolean existe = e.getId() == input.getId();
                    if (existe == true) {
                        user = e;
                    }
                }
                if (user != null) {
                    users.remove(user);
                    OutputStream os = server.getOutputStream();
                    PrintWriter pw = new PrintWriter(os);

                    pw.write("Se ha Borrado Usuario: " + input.getId() + "\n");
                    pw.flush();
                    pw.close();
                } else {
                    OutputStream os = server.getOutputStream();
                    PrintWriter pw = new PrintWriter(os);

                    pw.write("No existe Usuario con id: " + input.getId() + "\n");
                    pw.flush();
                    pw.close();
                }
            }

            serverSocket.close();
            server.close();
            is.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return input;
    }

    public static void vaciarArchivo(File archivo) {
        try ( FileOutputStream fos = new FileOutputStream(archivo, false)) {
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        //leerJson();
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        boolean exit = false;
        File base = new File("./datos.json");
        FileWriter fw = new FileWriter(base, true);

        User user = new User("insert", 2, "Raul", "Martinez");
        users.add(user);

        while (!exit) {
            try {
                User input = conexionservidor();

                if (user.getTipo().equals("insert")) {
                    System.out.println("Insert solicitado");
                    vaciarArchivo(base);
                    gson.toJson(users, fw);
                    fw.flush();
                }
                if (input.getTipo().equals("delete")) {
                    System.out.println("Delete solicitado");
                    vaciarArchivo(base);
                    gson.toJson(users, fw);
                    fw.flush();
                }
                if (input.getTipo().equals("select")) {
                    System.out.println("select solicitado");

                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
