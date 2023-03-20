package psp_u2_MartinezCastillaRaul;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author mraul
 */
public class Programa {

    Scanner sn = new Scanner(System.in);
    String url;

    public Programa() throws IOException {
        boolean salida = true;
        while (salida) {
            System.out.print("Introduir una url.\nIntroduce X para salir.\n-->");
            url = sn.next();
            if (urlValidator(url) || url.equalsIgnoreCase("x")) {
                if (url.equalsIgnoreCase("x")) {
                    salida = false;
                } else {
                    menu();
                    salida = false;
                }
            } else {
                System.out.print("La url " + url + " no es valida");
            }

        }

    }

    public static void main(String[] args) throws IOException {
        new Programa();
    }

    private void menu() throws IOException {

        boolean sortida = false;
        int opcion;

        while (!sortida) {

            System.out.println("1. Carregar pàgina Web");
            System.out.println("2. Analitzar el nombre de caràcters");
            System.out.println("3. Substituir lletra");
            System.out.println("4. Llegir encrypted.txt");
            System.out.println("5. Cercar paraules clau");
            System.out.println("6. Crear arxiu index.html");
            System.out.println("7. Ejecutar arxiu index.html");
            System.out.println("8. Sortida");

            try {

                System.out.print("Escribe una de las opciones\n-->");
                opcion = sn.nextInt();

                switch (opcion) {
                    case 1:
                        carregar_pagina_Web();
                        break;
                    case 2:
                        Analitzar_el_nombre_de_caràcters();
                        break;
                    case 3:
                        Substituir_lletra();
                        break;
                    case 4:
                        Llegir_encrypter();
                        break;
                    case 5:
                        Cercar_paraules_clau();
                        break;
                    case 6:
                        Crear_arxiu_index();
                        break;
                    case 7:
                        Executar_index();
                        break;
                    case 8:
                        sortida = true;
                        sn.close();
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

    private void carregar_pagina_Web() throws IOException {

        // Validar una URL
        Runtime r = Runtime.getRuntime();

        String[] comanda = {
            "java",
            "-cp",
            "C:\\Users\\mraul\\OneDrive\\Documentos\\NetBeansProjects\\psp_u2_MartinezCastillaRaul_recursos\\dist\\psp_u2_MartinezCastillaRaul_recursos.jar",
            "psp_u2_martinezcastillaraul_recursos.Carregar_pagina_web"
        };

        Process p = r.exec(comanda);

        BufferedWriter entradaProces = new BufferedWriter(new OutputStreamWriter(p.getOutputStream()));
        BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));

        entradaProces.write(url);
        entradaProces.close();

        String linea;
        while ((linea = in.readLine()) != null) {
            System.out.println(linea);
        }
        in.close();

    }

    private void Analitzar_el_nombre_de_caràcters() throws IOException {
        Runtime r = Runtime.getRuntime();

        String[] comanda = {
            "java",
            "-cp",
            "C:\\Users\\mraul\\OneDrive\\Documentos\\NetBeansProjects\\psp_u2_MartinezCastillaRaul_recursos\\dist\\psp_u2_MartinezCastillaRaul_recursos.jar",
            "psp_u2_martinezcastillaraul_recursos.Analitzar_el_nombre_de_caracters"
        };

        Process p = r.exec(comanda);
        BufferedWriter entradaProces = new BufferedWriter(new OutputStreamWriter(p.getOutputStream()));
        BufferedReader sortidaProces = new BufferedReader(new InputStreamReader(p.getInputStream()));

        sn.reset();
        String caracteres = "";
        caracteres += url + " ";
        System.out.print("Introduir un caracter.\n-->");
        char sortida = sn.next().charAt(0);
        caracteres += Character.toString(sortida);

        entradaProces.write(caracteres);

        entradaProces.close();

        System.out.println(sortidaProces.readLine());
        sortidaProces.close();
    }

    private void Substituir_lletra() throws IOException {
        Runtime r = Runtime.getRuntime();

        String[] comanda = {
            "java",
            "-cp",
            "C:\\Users\\mraul\\OneDrive\\Documentos\\NetBeansProjects\\psp_u2_MartinezCastillaRaul_recursos\\dist\\psp_u2_MartinezCastillaRaul_recursos.jar",
            "psp_u2_martinezcastillaraul_recursos.Substituir_lletra"
        };

        Process p = r.exec(comanda);
        BufferedWriter entradaProces = new BufferedWriter(new OutputStreamWriter(p.getOutputStream()));
        BufferedReader sortidaProces = new BufferedReader(new InputStreamReader(p.getInputStream()));

        sn.reset();
        String caracteres = "";
        caracteres += url + " ";
        System.out.print("Introduir un caracter a sustitui.\n-->");
        char sortida = sn.next().charAt(0);
        String ent = Character.toString(sortida);
        caracteres += ent;
        System.out.print("Introduir el caracter por cual vols sustitui.\n-->");
        char sortida2 = sn.next().charAt(0);
        String ent2 = Character.toString(sortida2);
        caracteres += ent2;

        entradaProces.write(caracteres);

        entradaProces.close();

        String linea;
        while ((linea = sortidaProces.readLine()) != null) {
            System.out.println(linea);
        }
        sortidaProces.close();

    }

    private void Llegir_encrypter() throws IOException {
        Runtime r = Runtime.getRuntime();

        String[] comanda = {
            "java",
            "-cp",
            "C:\\Users\\mraul\\OneDrive\\Documentos\\NetBeansProjects\\psp_u2_MartinezCastillaRaul_recursos\\dist\\psp_u2_MartinezCastillaRaul_recursos.jar",
            "psp_u2_martinezcastillaraul_recursos.Llegir_encrypted"
        };

        Process p = r.exec(comanda);
        BufferedReader sortidaProces = new BufferedReader(new InputStreamReader(p.getInputStream()));

        String linea;
        while ((linea = sortidaProces.readLine()) != null) {
            System.out.println(linea);
        }
        sortidaProces.close();

    }

    private void Cercar_paraules_clau() throws IOException {
        Runtime r = Runtime.getRuntime();

        String[] comanda = {
            "java",
            "-cp",
            "C:\\Users\\mraul\\OneDrive\\Documentos\\NetBeansProjects\\psp_u2_MartinezCastillaRaul_recursos\\dist\\psp_u2_MartinezCastillaRaul_recursos.jar",
            "psp_u2_martinezcastillaraul_recursos.Cercar_paraules_clau"
        };

        Process p = r.exec(comanda);
        BufferedWriter entradaProces = new BufferedWriter(new OutputStreamWriter(p.getOutputStream()));
        BufferedReader sortidaProces = new BufferedReader(new InputStreamReader(p.getInputStream()));

        sn.reset();
        System.out.print("Introdui una paraula\n-->");
        String sortida = sn.next();
        String[] separar = sortida.split(" ");

        entradaProces.write(separar[0]);

        entradaProces.close();

        System.out.println("\n" + sortidaProces.readLine() + "\n");
        sortidaProces.close();
    }

    private void Crear_arxiu_index() throws IOException {
        File file = new File("..\\psp_u2_MartinezCastillaRaul_recursos\\encrypted.txt");
        if (file.exists()) {
            Runtime r = Runtime.getRuntime();

            String[] comanda = {
                "java",
                "-cp",
                "C:\\Users\\mraul\\OneDrive\\Documentos\\NetBeansProjects\\psp_u2_MartinezCastillaRaul_recursos\\dist\\psp_u2_MartinezCastillaRaul_recursos.jar",
                "psp_u2_martinezcastillaraul_recursos.Crear_arxiu_index"
            };

            Process p = r.exec(comanda);
            BufferedReader sortidaProces = new BufferedReader(new InputStreamReader(p.getInputStream()));

            String linea;
            while ((linea = sortidaProces.readLine()) != null) {
                System.out.println(linea);
            }
            sortidaProces.close();
        } else {
            System.out.println("Prime realitzar l’opció 3.\n"
                    + "Seguidament realitzarà la l’opció 6\n");
        }
    }

    private void Executar_index() throws IOException {
        File file = new File("..\\psp_u2_MartinezCastillaRaul_recursos\\encrypted.txt");
        if (file.exists()) {
            Runtime r = Runtime.getRuntime();

            String[] comanda = {
                "java",
                "-cp",
                "C:\\Users\\mraul\\OneDrive\\Documentos\\NetBeansProjects\\psp_u2_MartinezCastillaRaul_recursos\\dist\\psp_u2_MartinezCastillaRaul_recursos.jar",
                "psp_u2_martinezcastillaraul_recursos.Executar_index"
            };

            Process p = r.exec(comanda);
            BufferedReader sortidaProces = new BufferedReader(new InputStreamReader(p.getInputStream()));

            sortidaProces.close();
        } else {
            System.out.println("Prime realitzar l’opció 6.\n"
                    + "Seguidament realitzarà la l’opció 7\n");
        }
    }

    private static final String URL_REGEX
            = "^((((https?|ftps?|gopher|telnet|nntp)://)|(mailto:|news:))"
            + "(%[0-9A-Fa-f]{2}|[-()_.!~*';/?:@&=+$,A-Za-z0-9])+)"
            + "([).!';/?:,][[:blank:]])?$";

    private static final Pattern URL_PATTERN = Pattern.compile(URL_REGEX);

    public static boolean urlValidator(String url) {
        if (url == null) {
            return false;
        }

        Matcher matcher = URL_PATTERN.matcher(url);
        return matcher.matches();
    }

}
