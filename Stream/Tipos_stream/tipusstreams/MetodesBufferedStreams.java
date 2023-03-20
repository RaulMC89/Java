package cat.spaad.tipusstreams;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class MetodesBufferedStreams {
	String[] array = new String[50];
	
	public void  llegeixLinia(String origen) {
		try(BufferedReader br = new BufferedReader (new FileReader (origen))) 
		{
			
			String linea;
			int cont = 0;
			
	        while((linea = br.readLine())!=null)
	        {
	        	array[cont] = linea;
	        	System.out.println(linea);
	        	cont++;
	        }    
		} catch (Exception e) {
			e.getStackTrace ();
		}
	}
	
	public void escriuLinia(String desti, String[] dades) {
		try(BufferedWriter bw = new BufferedWriter (new FileWriter (desti))) 
		{
				for (String string : dades) {
					bw.write(string);
					bw.newLine();
				}
				
		} catch (Exception e) {
			e.getStackTrace ();
		}
		
		
	}

}
