package dades;

import com.mongodb.Block;
import org.bson.Document;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Aspirant
{
    private String nif;
    private String nom;
    private String llinatges;
    private String codi_postal;

    private Block<Document> block;


    public Aspirant(String nif, String nom, String llinatges, String codi_postal)
    {
        this.nif = nif;
        this.nom = nom;
        this.llinatges = llinatges;
        this.codi_postal = codi_postal;
        this.block = new Block<Document>()
        {
            @Override
            public void apply(Document document)
            {
                System.out.println("Nif: "+nif +" Nom: " + nom + " Cognoms: "+llinatges);
            }
        };
    }


    public Aspirant(){

    }

    public Block<Document> getBlock()
    {
        return block;
    }

    //Insert 5

    public Map<String, Object> toMap(){
        Map<String,Object> hastMap = new LinkedHashMap<String,Object>();
        hastMap.put("nif",nif);
        hastMap.put("nom",nom);
        hastMap.put("llinatges",llinatges);
        hastMap.put("codiPostal",codi_postal);
        return hastMap;
    }

    public Aspirant fromMap(Document doc)
    {
        this.nif = doc.getString("nif");
        this.nom = doc.getString("nom");
        this.llinatges = doc.getString("llinatges");
        this.codi_postal = doc.getString("codiPostal");

        Aspirant asp = new Aspirant(nif,nom,llinatges,codi_postal);

        return asp;
    }


    public String getNif()
    {
        return nif;
    }

    public void setNif(String nif)
    {
        this.nif = nif;
    }

    public String getNom()
    {
        return nom;
    }

    public void setNom(String nom)
    {
        this.nom = nom;
    }

    public String getLlinatges()
    {
        return llinatges;
    }

    public void setLlinatges(String llinatges)
    {
        this.llinatges = llinatges;
    }

    public String getCodi_postal()
    {
        return codi_postal;
    }

    public void setCodi_postal(String codi_postal)
    {
        this.codi_postal = codi_postal;
    }

    @Override
    public String toString()
    {
        return "Aspirant{" +
                "nif='" + nif + '\'' +
                ", nom='" + nom + '\'' +
                ", llinatges='" + llinatges + '\'' +
                ", codi_postal='" + codi_postal + '\'' +
                '}';
    }


}
