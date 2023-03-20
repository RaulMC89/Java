package cat.spaad.classes;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/*Hay que tener la libreria JAXB instalada la dependencia en librerias en
* NetBeans o en un projecto maven en el pom.xml
 */
@XmlRootElement(name = "catalog")
@XmlType(propOrder = {"name", "books"})
public class Catalogo {

    private String nombre;
    private ArrayList<Libro> libros = new ArrayList<>();

    public Catalogo() {
    }

    @XmlElement(name = "name")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlElementWrapper(name = "books")
    @XmlElement(name = "book")
    public ArrayList<Libro> getLibros() {
        return libros;
    }

    public void setLibros(ArrayList<Libro> libros) {
        this.libros = libros;
    }
}
