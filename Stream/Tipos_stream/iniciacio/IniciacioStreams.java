package cat.spaad.iniciacio;

import cat.spaad.ajudes.Inicis;
import cat.spaad.tipusstreams.MetodesBufferedStreams;
import cat.spaad.tipusstreams.MetodesByteStreams;
import cat.spaad.tipusstreams.MetodesCharacterStreams;
import cat.spaad.tipusstreams.MetodesDataStreams;
import cat.spaad.tipusstreams.MetodesObjectStreams;

public class IniciacioStreams {
	
	public IniciacioStreams()
	{
		provesObjecte();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new IniciacioStreams();
	}
	
	private void provesByte()
    {
        MetodesByteStreams mbs = new MetodesByteStreams();
        mbs.llegeixBytes("Bones.txt");
        byte[] textBytes = ("Benvinguts al món dels stream bytes".getBytes());
        mbs.escriuBytes("proves.txt", textBytes);
    }
	
	private void provesCharacter() {
		MetodesCharacterStreams mcs = new MetodesCharacterStreams();
		mcs.llegeixCharacters("Dias.txt");
		mcs.escriuCharacters("proves.txt", "Hola que tal como estas");
	}
	
	private void provesBuffered() {
		MetodesBufferedStreams mbss = new MetodesBufferedStreams();
		mbss.llegeixLinia("Bones.txt");
		String dades[] = {"Pruevas buffered", "Hola que tal", "Adios"};
		mbss.escriuLinia("prove.txt",dades);
	}
	
	private void provesData() {
		MetodesDataStreams mdt = new MetodesDataStreams();
		double dades[] = {80.37,97.99,289.989,7476.9868};
		mdt.escriuArray("datos.txt", dades);
		mdt.llegeixArray("datos.txt");
	}
	
	private void provesObjecte() {
		Inicis ini1 = new Inicis(20, "Raul Martinez Castilla");
		MetodesObjectStreams mos = new MetodesObjectStreams();
		mos.escriuObjecte("objetos.bin", ini1);
		mos.llegeixObjecte("objetos.bin");
		
	}
}
