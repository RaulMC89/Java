package cat.spaad.tipusstreams;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import cat.spaad.ajudes.Inicis;

public class MetodesObjectStreams {
	
	

	public void escriuObjecte(String desti, Inicis ini) {
		try(ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream(desti)))
	    {
	        ous.writeObject(ini);
	    }catch (IOException e)
	    {
	        System.out.println(e.getMessage());
	    }	
	}
	
	public void llegeixObjecte(String origen)
    {
        try(ObjectInputStream ois =new ObjectInputStream(new FileInputStream(origen)))
        {
            Inicis obj = (Inicis) ois.readObject();
            System.out.print(obj);
        }catch (Exception c)
        {
            System.out.println(c.getMessage());
        }
    }
}
