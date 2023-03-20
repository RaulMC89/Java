package cat.spaad.tipusstreams;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;

public class MetodesCharacterStreams {
	
	public void  llegeixCharacters(String origen) {
		try (FileReader in = new FileReader (origen)) 
		{
			System.out.println ("Datos en el archivo: ");
            while (in.ready()){
            	char b =(char)in.read();
            System.out.print(b);	
            }
           
		
		}
		catch (Exception e) {
			e.getStackTrace ();
		}
	}
	
	public void escriuCharacters(String desti, String dades) {
		try(FileWriter out = new FileWriter(desti))
        {
			out.write(dades);
        }
        catch (Exception e)
        {
            e.getStackTrace ();
        }
	}
}
