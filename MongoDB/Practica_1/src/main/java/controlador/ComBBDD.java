package controlador;

import com.mongodb.Block;
import com.mongodb.client.*;
import com.mongodb.client.model.Projections;
import dades.Aspirant;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import java.util.*;

import static com.mongodb.client.model.Accumulators.sum;
import static com.mongodb.client.model.Aggregates.*;
import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Indexes.ascending;
import static com.mongodb.client.model.Indexes.descending;
import static com.mongodb.client.model.Projections.*;
import static com.mongodb.client.model.Sorts.orderBy;
import static com.mongodb.client.model.Updates.set;

public class ComBBDD
{
    private MongoClient client;
    private MongoDatabase db;
    private MongoCollection collection;
    private String collectio;
    private MongoCursor<Document> cursor;
    private MongoIterable<String> result;

    private MongoCollection<org.bson.Document> tuplas;



    public ComBBDD(String base_de_dades, String collection)
    {
        this.client = MongoClients.create();
        this.db = client.getDatabase(base_de_dades);
        this.collection = db.getCollection(collection);
        this.collectio = collection;
    }

    public void print(MongoCursor<Document> cursor)
    {
        try
        {
            while (cursor.hasNext())
            {
                System.out.println(cursor.next().toJson());
            }
        }finally
        {
            cursor.close();
        }
    }
    public void listaDB()
    {
        result = client.listDatabaseNames();

        System.out.println("llita de db:");
        for (String s: result)
        {
            System.out.println(s);
        }

        System.out.println("---------------------------------");
    }
    public void listaCollection()
    {
        System.out.println("col.lections de le db:");
        result = db.listCollectionNames();
        for (String s: result)
        {
            System.out.println(s);
        }

        System.out.println("-----------------------");
    }
    public  void listaTuplas(){
        tuplas = db.getCollection(collectio);
        MongoCursor<Document> cursor;
        cursor = tuplas.find().iterator();

        print(cursor);
        System.out.println("------------------------");
    }

    //Insert 3
    public void insert(String nif,String nom, String llinatges,String codiPostal)
    {
        Document productes = new Document("nif",nif)
                .append("nom",nom)
                .append("llinatges", llinatges)
                .append("codiPostal", codiPostal);

        collection.insertOne(productes);
    }

    //Consulta 5 y 6
    public void insertHastMap(Map<String, Object> as)
    {
        Document productes = new Document("nif",as.get("nif"))
                .append("nom",as.get("nom"))
                .append("llinatges", as.get("llinatges"))
                .append("codiPostal", as.get("codiPostal"));

        collection.insertOne(productes);
    }

    //Consulta 7
    public ArrayList<Aspirant> getAllAspirants()
    {
        ArrayList<Aspirant> aspList = new ArrayList<>();
        tuplas = db.getCollection(collectio);
        MongoCursor<Document> cursor;
        cursor = tuplas.find().iterator();

        try
        {
            while (cursor.hasNext())
            {
                Document as = cursor.next();
                Aspirant aspirant = new Aspirant();
                aspirant.fromMap(as);
                aspList.add(aspirant);
            }
        }finally
        {
            cursor.close();
        }
        return aspList;
    }

    public void imprimirListAspiran(ArrayList<Aspirant> aspirants)
    {
        for (Aspirant a: aspirants)
        {
            System.out.println(a);
        }
        System.out.println("--------------------------------------");
    }

    //Consulta 8 y 9
    public  void  getAllBlock(){
        ArrayList<Aspirant> aspirants;
        aspirants = getAllAspirants();

        for (Aspirant a: aspirants)
        {
            Block<Document> block = a.getBlock();
            block.apply(new Document());
        }
    }

    //Consulta 10
    public void getAspList2()
    {
        List<Document> aspList2 = new ArrayList<>();
        tuplas = db.getCollection(collection.toString());
        MongoCursor<Document> cursor;
        cursor = tuplas.find().iterator();

        try
        {
            while (cursor.hasNext())
            {
                Document as = cursor.next();
                aspList2.add(as);

            }
        }finally
        {
            cursor.close();
        }
        for (Document d:aspList2 )
        {
            System.out.println(d);
        }
        System.out.println("------------------------");
    }

    //Consulta 11
    public void getAspList3(int inici, int fi)
    {
        List<Document> aspList3 = new ArrayList<>();
        tuplas = db.getCollection(collectio);
        MongoCursor<Document> cursor;
        cursor = tuplas.find().iterator();
        int cont = 0;
        int cont1 = 0;

        try
        {
            while (cursor.hasNext())
            {
                cont++;
                if (cont >= inici && cont <= fi)
                {
                    Document as = cursor.next();
                    cont1++;
                    aspList3.add(as);
                }
            }
        }finally
        {
            cursor.close();
        }
        System.out.println("------------------------ contador documentos = " + cont);

    }

    //Consulta 12
    public ArrayList<Aspirant> getAllAspirantsZips(String codiPostal)
    {
        ArrayList<Aspirant> aspList = new ArrayList<>();
        tuplas = db.getCollection(collectio);
        MongoCursor<Document> cursor;
        cursor = tuplas.find().iterator();

        try
        {
            while (cursor.hasNext())
            {
                Document as = cursor.next();
                Aspirant aspirant = new Aspirant();
                aspirant.fromMap(as);

                if (aspirant.getCodi_postal().equals(codiPostal))
                {
                    aspList.add(aspirant);
                }
            }
        }finally
        {
            cursor.close();
        }
        return aspList;
    }
    //Consulta 13
    public void getAllAspirantsZipsName(String codiPostal,String name)
    {
        tuplas = db.getCollection(collectio);
        MongoCursor<Document> cursor;
        cursor = tuplas.find(or(eq("codiPostal",codiPostal),eq("nom",name))).iterator();


        try
        {
            while (cursor.hasNext())
            {
                System.out.println(cursor.next().toJson());
            }
        }finally
        {
            cursor.close();
        }
    }
    //Consulta 14
    public ArrayList<Document> getProjection(List<String> lista)
    {

        System.out.println("------------------------");

        ArrayList<Document> aspList = new ArrayList<>();
        tuplas = db.getCollection(collectio);
        Bson projecction = fields(
                include(lista),
                excludeId()
        );

        cursor = tuplas.find().projection(projecction).iterator();
        try
        {
            while (cursor.hasNext())
            {
                Document as = cursor.next();
                aspList.add(as);

            }
        }finally
        {
            cursor.close();
        }

        return aspList;
    }

    //Consulta 15
    public ArrayList<Document> getProjectionOrdenado(String campo,String asc_o_des)
    {



        ArrayList<Document> aspList = new ArrayList<>();
        tuplas = db.getCollection(collectio);
        Bson projecction = fields(
                include("nom", "llinatges","codiPostal"),
                excludeId()
        );

        Bson ordenacio = null;
        if (asc_o_des.equals("asc"))
        {
            ordenacio = descending(campo);
        }
        if (asc_o_des.equals("des")){
            ordenacio = ascending(campo);
        }



        cursor = tuplas.find().projection(projecction).sort(ordenacio).iterator();
        try
        {
            while (cursor.hasNext())
            {
                Document as = cursor.next();
                aspList.add(as);

            }
        }finally
        {
            cursor.close();
        }
        System.out.println("------------------------");
        return aspList;
    }

    //Consulta 16
    public ArrayList<Document> getCodiPostal(String codi_postal)
    {

        System.out.println("------------------------");

        ArrayList<Document> aspList = new ArrayList<>();
        tuplas = db.getCollection(collectio);
        Bson filtre = eq("codiPostal",codi_postal);

        cursor = tuplas.find(filtre).iterator();
        try
        {
            while (cursor.hasNext())
            {
                Document as = cursor.next();
                aspList.add(as);

            }
        }finally
        {
            cursor.close();
        }

        return aspList;
    }

    //Consulta 17
    public void getNomCodiPostal(String nom, String codi_postal)
    {

        System.out.println("------------------------");

        ArrayList<Document> aspList = new ArrayList<>();
        tuplas = db.getCollection(collectio);
        Bson filtre = and(eq("nom",nom),
                eq("codiPostal",codi_postal));

        cursor = tuplas.find(filtre).iterator();
        try
        {
            while (cursor.hasNext())
            {
                System.out.println(cursor.next().toJson());
            }
        }finally
        {
            cursor.close();
        }

    }

    //Consulta 18
    public void getNoms(String nom1, String nom2)
    {

        System.out.println("------------------------");

        ArrayList<Document> aspList = new ArrayList<>();
        tuplas = db.getCollection(collectio);
        Bson filtre = or(eq("nom",nom1),
                eq("nom",nom2));

        cursor = tuplas.find(filtre).iterator();
        try
        {
            while (cursor.hasNext())
            {
                System.out.println(cursor.next().toJson());
            }
        }finally
        {
            cursor.close();
        }
    }

    //Consulta 19
    public void getExcepNoms(String nom1, String nom2)
    {

        System.out.println("------------------------");

        ArrayList<Document> aspList = new ArrayList<>();

        tuplas = db.getCollection(collectio);
        Bson filtre = nor(eq("nom",nom1),
                eq("nom",nom2));

        cursor = tuplas.find(filtre).iterator();
        try
        {
            while (cursor.hasNext())
            {
                System.out.println(cursor.next().toJson());

            }
        }finally
        {
            cursor.close();
        }

    }

    //Consulta 20 opcion 1
    public void getOrdenadoNomAcending()
    {
        ArrayList<Document> aspList = new ArrayList<>();
        tuplas = db.getCollection(collectio);

        Bson ordenacio = ascending("nom");

        cursor = tuplas.find().sort(ordenacio).iterator();
        try
        {
            while (cursor.hasNext())
            {
                System.out.println(cursor.next().toJson());

            }
        }finally
        {
            cursor.close();
        }
        System.out.println("------------------------");
    }

    //Consulta opcion 2
    public void getOrdenaAspirantsNomAscending()
    {
        ArrayList<Aspirant> aspList = new ArrayList<>();
        tuplas = db.getCollection(collectio);
        MongoCursor<Document> cursor;

        Bson ordenacio = ascending("nom");

        cursor = tuplas.find().sort(ordenacio).iterator();

        try
        {
            while (cursor.hasNext())
            {
                Document as = cursor.next();
                Aspirant aspirant = new Aspirant();
                aspirant.fromMap(as);

                aspList.add(aspirant);

            }
            for (Aspirant a: aspList)
            {
                System.out.println(a);
            }
        }finally
        {
            cursor.close();
        }

        for (Aspirant as: aspList)
        {
            System.out.println(as);
        }
    }

    //Consulta 21
    public void getOrdenaAspirantsLlinatgeNomAscendig()
    {
        ArrayList<Aspirant> aspList = new ArrayList<>();
        tuplas = db.getCollection(collectio);
        MongoCursor<Document> cursor;

        Bson ordenacio = ascending("llinatges","nom");

        cursor = tuplas.find().sort(ordenacio).iterator();

        try
        {
            while (cursor.hasNext())
            {
                Document as = cursor.next();
                Aspirant aspirant = new Aspirant();
                aspirant.fromMap(as);

                aspList.add(aspirant);

            }
        }finally
        {
            cursor.close();
        }

        for (Aspirant as: aspList)
        {
            System.out.println(as);
        }
    }

    //Consulta 22
    public void getOrdenaAspirantsLlinatgeNomAscendigOrderby()
    {
        ArrayList<Aspirant> aspList = new ArrayList<>();
        tuplas = db.getCollection(collectio);
        MongoCursor<Document> cursor;

        Bson ordenacio = orderBy(ascending("llinatges","nom"));

        cursor = tuplas.find().sort(ordenacio).iterator();

        try
        {
            while (cursor.hasNext())
            {
                Document as = cursor.next();
                Aspirant aspirant = new Aspirant();
                aspirant.fromMap(as);

                aspList.add(aspirant);

            }
        }finally
        {
            cursor.close();
        }

        for (Aspirant as: aspList)
        {
            System.out.println(as);
        }
    }

    //Consulta 23
    public ArrayList<Document> getProjectionNomLlinatge()
    {
        ArrayList<Document> aspList = new ArrayList<>();
        tuplas = db.getCollection(collectio);
        Bson projecction = fields(
                include("nom", "llinatges")
        );

        cursor = tuplas.find().projection(projecction).iterator();
        try
        {
            while (cursor.hasNext())
            {
                Document as = cursor.next();
                aspList.add(as);

            }
        }finally
        {
            cursor.close();
        }
        for (Document as: aspList)
        {
            System.out.println(as);
        }
        System.out.println("------------------------");
        return aspList;
    }
    //Consulta 24
    public ArrayList<Document> getProjectionNomLlinatgeNoID()
    {



        ArrayList<Document> aspList = new ArrayList<>();
        tuplas = db.getCollection(collectio);
        Bson projecction = fields(
                include("nom", "llinatges"),
                excludeId()
        );

        cursor = tuplas.find().projection(projecction).iterator();
        try
        {
            while (cursor.hasNext())
            {
                Document as = cursor.next();
                aspList.add(as);

            }
        }finally
        {
            cursor.close();
        }
        for (Document as: aspList)
        {
            System.out.println(as);
        }
        System.out.println("------------------------");
        return aspList;
    }
    //Consulta 25
    public List<Document> getAgregate()
    {
        List<Document> lista2 = new ArrayList<>();
        tuplas = db.getCollection(collectio);

        List<Bson> llista=new ArrayList<>();
        llista.add(unwind("$preferencies"));

        llista.add(group("$nif", sum("preferencies",1 )));
        llista.add(fields(include("nom")));
        llista.add(sort(ascending("_id")));

        this.collection.aggregate(llista).into(lista2);

        for (Document d:lista2)
        {
            System.out.println(d);
        }

        return lista2;
    }


    //Consulta 26
    public List<Document> getAgregate2()
    {
        List<Document> lista2 = new ArrayList<>();
        tuplas = db.getCollection(collectio);

        List<Bson> llista=new ArrayList<>();
        llista.add(unwind("$preferencies"));
        llista.add(group("$preferencies.centre"));
        llista.add(sort(ascending("_id")));

        this.collection.aggregate(llista).into(lista2);

        for (Document d:lista2)
        {
            System.out.println(d);
        }

        return lista2;
    }
    //Consulta 27
    public void insertAgretate(List<Document> doc){
        String centros = "CentresUnics";
        db.createCollection("CentresUnics");
        collection = db.getCollection(centros);


        collection.insertMany(doc);
    }
    //Consulta 28 y 29
    public void getFiltraUpdate(String nom_filtro,String valo_filtro,String nom_camp_modifica,String nom_valo_modifica)
    {

        System.out.println("------------------------");

        ArrayList<Document> aspList = new ArrayList<>();
        tuplas = db.getCollection(collectio);
        Bson filtre = eq(nom_filtro,valo_filtro);


        Bson update = set(nom_camp_modifica,nom_valo_modifica);

        tuplas.updateMany(filtre,update);

        cursor = tuplas.find(filtre).iterator();
        try
        {
            while (cursor.hasNext())
            {
                System.out.println(cursor.next().toJson());
            }
        }finally
        {
            cursor.close();
        }

    }

    //Consulta 30
    public void getDelete(String id)
    {

        System.out.println("------------------------");

        ArrayList<Document> aspList = new ArrayList<>();
        tuplas = db.getCollection(collectio);

        ObjectId ids = new ObjectId(id);
        Bson filtre = eq("_id",ids);

        tuplas.deleteOne(filtre);

        cursor = tuplas.find(filtre).iterator();
        try
        {
            while (cursor.hasNext())
            {
                System.out.println(cursor.next().toJson());

            }
        }finally
        {
            cursor.close();
        }
    }

}

