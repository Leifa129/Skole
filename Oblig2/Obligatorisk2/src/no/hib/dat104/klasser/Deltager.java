package no.hib.dat104.klasser;

public class Deltager {
private String tlf;
private String forNavn;
private String etterNavn;
private char kjonn;
private boolean betalt;

public Deltager(String mob){
	tlf = mob;
}


public Deltager(String t, String f, String e, char k, boolean b){
	tlf = t;
	forNavn = f;
	etterNavn = e;
	kjonn = k;
	betalt = b;
}

public String getTlf() {
	return tlf;
}
public void setTlf(String tlf) {
	this.tlf = tlf;
}
public String getEtterNavn() {
	return etterNavn;
}
public void setEtterNavn(String etterNavn) {
	this.etterNavn = etterNavn;
}
public char getKjonn() {
	return kjonn;
}
public void setKjonn(char kjonn) {
	this.kjonn = kjonn;
}
public String getForNavn() {
	return forNavn;
}
public void setForNavn(String forNavn) {
	this.forNavn = forNavn;
}
public boolean harBetalt() {
	return betalt;
}
public void setBetalt(boolean betalt) {
	this.betalt = betalt;
}

public boolean equals(Object other){
    boolean result;
    if((other == null) || (getClass() != other.getClass())){
        result = false;
    } 
    else{
        Deltager d = (Deltager)other;
        result = tlf.equals(d.tlf);
    }

    return result;
} 


}
