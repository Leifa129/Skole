package hib.no.dat104.oppg1;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Filbehandling {
	private String filsti;
	private long lastModified;
	
	public Filbehandling(String f){
		filsti = f;
	}
	
	public void lagreNyMelding(Melding nyMelding) throws IOException{
		 PrintWriter x = new PrintWriter(new FileWriter(filsti, true));
		 x.println(meldingEncode(nyMelding));
		 x.close();
		 lastModified = System.currentTimeMillis();
		}
	
	public ArrayList<Melding> hentAlleMeldinger() {
		ArrayList<Melding> meldinger = new ArrayList<Melding>();
		try {
			File f = new File(filsti);
			
			if (f.exists()) {
				lastModified = f.lastModified();
				Scanner x = new Scanner(f);
				while(x.hasNextLine()){
					meldinger.add(meldingDecode(x.nextLine()));
				}
				x.close();
			}
			else
				lastModified = System.currentTimeMillis();
		}
		catch(Exception e){
			
		}
		return meldinger;
	}
	
	private String meldingEncode(Melding m){
		return m.hentMeldId() + "|" + m.hentDato() + "|" + m.getSender() + "|" + m.getMelding();
	}
	
	private Melding meldingDecode(String s){
		String[] temp = s.split("\\|");
		return (new Melding(temp[2], temp[3], temp[1], Integer.parseInt(temp[0])));
	}

	public long getLastModified() {
		return lastModified;
	}

}
