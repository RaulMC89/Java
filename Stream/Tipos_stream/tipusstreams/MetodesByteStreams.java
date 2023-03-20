package cat.spaad.tipusstreams;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;

public class MetodesByteStreams {
	
	public void llegeixBytes(String origen){
        try(FileInputStream in = new FileInputStream (origen))
        {
            System.out.println ("Datos en el archivo: ");
            int c;
            while ((c = in.read()) != -1){
            	byte b =(byte)c;
            System.out.println(b);	
            }
        }
        catch (Exception e)
        {
            e.getStackTrace ();
        }
    }
	
	public void escriuBytes(String desti, byte[] dades)
	{
		try(FileOutputStream out = new FileOutputStream(desti))
        {
			out.write(dades);
        }
        catch (Exception e)
        {
            e.getStackTrace ();
        }
	}

}
