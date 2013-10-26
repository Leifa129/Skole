package dat104.obl3.models;
import javax.persistence.*;
import java.util.List;

@Entity
public class Spill {
	@Id
	private int id;
	private String host;
	@Column(name="antallspillere")
	private int antallDeltagere;
	
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
	
	
	
	/*  
	 * Legger til spiller og setter spill_id for spillinfo
	 * */
	public void leggTilSpiller(SpillInfo s){
		s.setId(id);
		spillere.add(s);
	}
	
}
