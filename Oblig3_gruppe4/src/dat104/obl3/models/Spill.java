package dat104.obl3.models;
import javax.persistence.*;
import java.util.List;

@Entity
public class Spill {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String host;
	@Column(name="antallspillere")
	private int antallDeltagere;
	@OneToOne
	@JoinColumn(name = "aktivbruker", referencedColumnName = "brukernavn") // må ha med name, default blir ikke aktivbruker..
	private Bruker aktivbruker;
	private int aktivrute;
	@OneToMany
	@JoinColumn(name = "spill_id", referencedColumnName = "id") 
	private List<SpillInfo> spillere;
	
	
	/*
	 *  Standard konstruktør for JPA
	 */
	
	public Spill(){}
	
	public Spill(int id, String host, int antallDeltagere) {
		this.id = id;
		this.host = host;
		this.antallDeltagere = antallDeltagere;
	}

	public int getId() {
		return id;
	}

	public String getHost() {
		return host;
	}

	public int getAntallDeltagere() {
		return antallDeltagere;
	}
	
	public List<SpillInfo> getSpillere(){
		return spillere;
	}
	
	public int getAktivRute() {
		return aktivrute;
	}

	public Bruker getAktivBruker() {
		return aktivbruker;
	}
	
	public void setAktivBruker(Bruker bruker) {
		aktivbruker = bruker;
	}
	
	public void setAktivRute(int rute) {
		aktivrute = rute;
	}
	
	public void setAntallDeltagere(int antall) {
		antallDeltagere = antall;
	}
	
	public void setHost(String host) {
		this.host = host;
	}
	
	/*  
	 * Legger til spiller og setter spill_id for spillinfo
	 * */
	public void leggTilSpiller(SpillInfo s){
		s.setId(id);
		spillere.add(s);
	}
	
}
