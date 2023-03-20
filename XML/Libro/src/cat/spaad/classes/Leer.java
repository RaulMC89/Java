package cat.spaad.classes;

import java.io.File;
import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/*Hay que tener la libreria JAXB instalada la dependencia en librerias en
* NetBeans o en un projecto maven en el pom.xml
 */
public class Leer {

    public Leer() {
        leer();
    }

    private void leer() {

        try {
            JAXBContext context = JAXBContext.newInstance(Catalogo.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            Catalogo catalogo = (Catalogo) unmarshaller.unmarshal(new File("books.xml"));
            System.out.println(catalogo.getNombre());

            ArrayList<Libro> libros = catalogo.getLibros();

            for (Libro res : libros) {
                System.out.println(res.getId() + res.getAutor() + res.getTitulo() + res.getGenero() + res.getPrecio() + res.getFecha_de_publicacion() + res.getDescripcion());
            }

        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }

    }

}
