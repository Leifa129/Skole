package hib.no.dat104.oppg1;

public class Melding {
private String sender;
private String melding;
private int meldId;
private String dato;

public Melding(String s, String m, String d, int mI){
	sender = s;
	melding = m;
	dato = d;
	meldId = mI;
}

public void setSender(String s){
	sender = s;
}

public void setMelding(String m){
	melding = m;
}

public void setMeldId(int mI){
	meldId = mI;
}

public void setDato(String d){
	dato = d;
}

public String getSender(){
	return sender;
}

public String getMelding(){
	return melding;
}

public int hentMeldId(){
	return meldId;
}

public String hentDato(){
	return dato;
}
}
