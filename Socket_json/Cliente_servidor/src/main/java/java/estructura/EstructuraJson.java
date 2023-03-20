/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructura;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

/**
 *
 * @author Alumne
 */
public class EstructuraJson implements Serializable {
    String tipo;
    String clase;
    @Expose String id;
    @Expose String nombre;
    @Expose String apellido;

    public EstructuraJson(String tipo, String clase, String id, String nombre, String apellido) {
        this.tipo = tipo;
        this.clase = clase;
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
    }

   public EstructuraJson(String tipo, String clase, String id)
   {
        this.tipo = tipo;
        this.clase = clase;
        this.id = id;
        this.nombre = null;
        this.apellido = null;
   }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "{\n" + "id=" + id + ",\n nombre=" + nombre + ",\n apellido=" + apellido + "\n}\n";
    }
    
    
   
   
}
