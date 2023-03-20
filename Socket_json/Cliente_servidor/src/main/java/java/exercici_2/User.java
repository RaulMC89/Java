package java.exercici_2;

import com.google.gson.annotations.Expose;
import java.io.Serializable;
import java.util.ArrayList;

public class User extends ArrayList<User> implements Serializable {

    String tipo;
    private @Expose
    int id;
    private @Expose
    String name;
    private @Expose
    String cognom;

    public User(String tipo, int id, String name, String cognom) {
        this.tipo = tipo;
        this.id = id;
        this.name = name;
        this.cognom = cognom;
    }

    public User(int id, String name, String cognom) {
        this.id = id;
        this.name = name;
        this.cognom = cognom;
    }

    public User(String tipo, int id) {
        this.tipo = tipo;
        this.id = id;
        this.name = null;
        this.cognom = null;
    }

    public String getTipo() {
        return tipo;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCognom() {
        return cognom;
    }

    @Override
    public String toString() {
        return "User{"
                + "tipo='" + tipo + '\''
                + ", id=" + id
                + ", name='" + name + '\''
                + ", cognom='" + cognom + '\''
                + '}';
    }
}
