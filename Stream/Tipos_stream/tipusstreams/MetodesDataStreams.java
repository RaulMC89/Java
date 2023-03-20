package cat.spaad.tipusstreams;

import java.awt.Container;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MetodesDataStreams {
	
	public void escriuArray(String desti, double[] dades) {
		try (DataOutputStream out = new DataOutputStream (new BufferedOutputStream (new FileOutputStream (desti)))) 
		{
			out.writeDouble(dades.length);;
			for (int i = 0; i < dades.length; i ++) {
				out.writeDouble(dades[i]);
				}
			
		} catch (Exception e) {
			e.getStackTrace ();
		}
		
	}
	
	public double[] llegeixArray(String origen) {
		double[] dato = new double[10];
		try(DataInputStream in = new DataInputStream (new BufferedInputStream (new FileInputStream (origen)))) 
		{
			double dat = 0.0;
			int cont = 0;
			while (true) {
				dat = in.readDouble();
				dato[cont] = dat;
				System.out.format("Numero %f\n", dat);
				cont++;
				}
		} catch (Exception e) {
			e.getStackTrace ();
		}
		return dato;
	}
}
