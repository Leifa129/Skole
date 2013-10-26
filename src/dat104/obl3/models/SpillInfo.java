package dat104.obl3.models;
import javax.persistence.*;

@Entity @IdClass(SpillInfoId.class) @Table(name="spilldata")
public class SpillInfo {
	
	@Id @Column(name="spill_id")
	int id;
	
	@Id @Column(name="bruker_id")
	private String brukernavn;
	
	
	
	private int enere;
	private int toere;
	private int treere;
	private int firere;
	private int femere;
	private int seksere;
	private int sum;
	private int bonus;
	private int ettpar;
	private int topar;
	private int trelike;
	private int firelike;
	private int litenstraight;
	private int storstraight;
	private int hus;
	private int sjanse;
	private int yatzy;
	private int totalt;
	
	
	/*
	 *  Standard konstruktør for JPA
	 */
	
	public SpillInfo(){}
	
	
	public SpillInfo(String brukernavn) {
		this.brukernavn = brukernavn;
	}
	
	
	
	public int getId(){
		return id;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public String getBrukernavn(){
		return brukernavn;
	}


	public int getEnere() {
		return enere;
	}


	public void setEnere(int enere) {
		this.enere = enere;
	}


	public int getToere() {
		return toere;
	}


	public void setToere(int toere) {
		this.toere = toere;
	}


	public int getTreere() {
		return treere;
	}


	public void setTreere(int treere) {
		this.treere = treere;
	}


	public int getFirere() {
		return firere;
	}


	public void setFirere(int firere) {
		this.firere = firere;
	}


	public int getFemere() {
		return femere;
	}


	public void setFemere(int femere) {
		this.femere = femere;
	}


	public int getSeksere() {
		return seksere;
	}


	public void setSeksere(int seksere) {
		this.seksere = seksere;
	}


	public int getSum() {
		return sum;
	}


	public void setSum(int sum) {
		this.sum = sum;
	}


	public int getBonus() {
		return bonus;
	}


	public void setBonus(int bonus) {
		this.bonus = bonus;
	}


	public int getEttpar() {
		return ettpar;
	}


	public void setEttpar(int ettpar) {
		this.ettpar = ettpar;
	}


	public int getTopar() {
		return topar;
	}


	public void setTopar(int topar) {
		this.topar = topar;
	}


	public int getTrelike() {
		return trelike;
	}


	public void setTrelike(int trelike) {
		this.trelike = trelike;
	}


	public int getFirelike() {
		return firelike;
	}


	public void setFirelike(int firelike) {
		this.firelike = firelike;
	}


	public int getStorstraight() {
		return storstraight;
	}


	public void setStorstraight(int storstraight) {
		this.storstraight = storstraight;
	}


	public int getLitenstraight() {
		return litenstraight;
	}


	public void setLitenstraight(int litenstraight) {
		this.litenstraight = litenstraight;
	}


	public int getHus() {
		return hus;
	}


	public void setHus(int hus) {
		this.hus = hus;
	}


	public int getSjanse() {
		return sjanse;
	}


	public void setSjanse(int sjanse) {
		this.sjanse = sjanse;
	}


	public int getYatzy() {
		return yatzy;
	}


	public void setYatzy(int yatzy) {
		this.yatzy = yatzy;
	}


	public int getTotalt() {
		return totalt;
	}


	public void setTotalt(int totalt) {
		this.totalt = totalt;
	}
}
