package dat104.obl3.models;
import javax.persistence.*;
import java.util.List;

@Entity
public class Bruker {
	
	@Id
	private String brukernavn;
	private String navn;
	private String epost;
	private String passord;
	
	/*
	 *  Standard konstruktør for JPA
	 */
	public Bruker(){}
	
	public Bruker(String brukernavn, String navn, String epost, String passord) {
		this.brukernavn = brukernavn;
		this.navn = navn;
		this.epost = epost;
		this.passord = passord;
	}

	public String getBrukernavn() {
		return brukernavn;
	}
	
	public String getNavn() {
		return navn;
	}

	public String getEpost() {
		return epost;
	}

	public String getPassord() {
		return passord;
	}
	
	public void setBrukerNavn(String brukernavn){
		this.brukernavn = brukernavn;
	}
	
	public void setNavn(String navn){
		this.navn = navn;
	}
	
	public void setEpost(String epost){
		this.epost = epost;
	}

	public void setPassord(String passord){
		this.passord = passord;
	}
}
