package cat.spaad.classes;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/*Hay que tener la libreria JAXB instalada la dependencia en librerias en
* NetBeans o en un projecto maven en el pom.xml
 */
@XmlRootElement(name = "book")
@XmlType(propOrder = {"id", "author", "title", "genre", "price", "publish_date", "description"})
public class Libro {

    private String id;
    private String autor;
    private String titulo;
    private String genero;
    private String precio;
    private String fecha_de_publicacion;
    private String descripcion;

    public Libro() {

    }

    @XmlAttribute(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @XmlElement(name = "author")
    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @XmlElement(name = "title")
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @XmlElement(name = "genre")
    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @XmlElement(name = "price")
    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    @XmlElement(name = "publish_date")
    public String getFecha_de_publicacion() {
        return fecha_de_publicacion;
    }

    public void setFecha_de_publicacion(String fecha_de_publicacion) {
        this.fecha_de_publicacion = fecha_de_publicacion;
    }

    @XmlElement(name = "description")
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
