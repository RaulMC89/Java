/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carrera_coches;

/**
 * Esta clase un opjeto podio coge el numero y el tiempo.
 */
public class Podio {

    private int num = 0;
    private String tiempo;

    public Podio(int num, String tiempo) {
        this.num = num;
        this.tiempo = tiempo;
    }

    public int getNum() {
        return num;
    }

    public String getTiempo() {
        return tiempo;
    }

}
