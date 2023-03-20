package mongodb;

import controlador.ComBBDD;
import dades.Aspirant;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class ProvesIniciacio
{
    public static void main(String[] args)
    {
        ComBBDD comBBDD = new ComBBDD("dbaspirants","aspirantsComplet");

        comBBDD.listaDB();

        comBBDD.listaCollection();

        //Insert 4
        Aspirant aspirant = new Aspirant("43158048C","Raul","Martinez Castilla","07004");
        //comBBDD.insert(aspirant.getNif(),aspirant.getNom(), aspirant.getLlinatges(), aspirant.getCodi_postal());

        //Insert 5 y 6.
        //Aspirant aspirant2 = new Aspirant("66666666D","RUBEN","Martinez Castilla","07400");
        //comBBDD.insertHastMap(aspirant2.toMap());
        //comBBDD.listaTuplas();

        //Consulta 7.
        //ArrayList<Aspirant> aspirants = comBBDD.getAllAspirants();
        //comBBDD.imprimirListAspiran(aspirants);

        //Consulta 8 y 9;
        //comBBDD.getAllBlock();

        //Consulta 10.
        //comBBDD.getAspList2();

        //Consulta 11;
        //comBBDD.getAspList3(30,31);

        //Consulta 12
        //comBBDD.getAllAspirantsZips("07456");

        //Consulta 13
        //comBBDD.getAllAspirantsZipsName("07400","Lidia");

        //Consulta 14
        //List<String> campos = List.of("nom", "llinatges","codiPostal");
        //comBBDD.getProjection(campos);

        //Consulta 15
        //comBBDD.getProjectionOrdenado("nom","des");


        //Consulta 16
        //comBBDD.getCodiPostal("07300");


        //Consulta 17
        //comBBDD.getNomCodiPostal("Miquel","07002");

        //Consulta 18
        //comBBDD.getNoms("Virginia","Magdalena");

        //Consulta 19
        //comBBDD.getExcepNoms("Virginia","Miquel");


        //Consulta 20 opcion Documentos
        //comBBDD.getOrdenadoNomAcending();

        //Consulta 20 opcion objeto Aspirantes
        //comBBDD.getOrdenaAspirantsNomAscending();

        //Consulta 21 opcion 1
        //comBBDD.getOrdenaAspirantsLlinatgeNomAscendig();

        //Consulta 22
        //comBBDD.getOrdenaAspirantsLlinatgeNomAscendigOrderby();

        //Consulta 23
        //comBBDD.getProjectionNomLlinatge();

        //Consulta 24
        //comBBDD.getProjectionNomLlinatgeNoID();

        //Consulta 25
        //comBBDD.getAgregate();

        //Consulta 26
        //comBBDD.getAgregate2();
        //Consulta 27
        comBBDD.insertAgretate(comBBDD.getAgregate2());


        //Consulta 28
        //omBBDD.getFiltraUpdate("nif","14140460F","nom","Virginia");

        //Consulta 29
        //comBBDD.getFiltraUpdate("codiPostal","07301","codiPostal","07301");

        //Consulta 30
        //comBBDD.getDelete("63ee72539add42696453c671");





    }
}