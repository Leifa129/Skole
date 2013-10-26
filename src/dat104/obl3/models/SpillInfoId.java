package dat104.obl3.models;
public class SpillInfoId {
private String brukernavn;
private int id;

public SpillInfoId(){}

public SpillInfoId(int i, String b){
	brukernavn = b;
	id = i;
}

public String getBrukernavn() {
	return brukernavn;
}

public void setBrukernavn(String brukernavn) {
	this.brukernavn = brukernavn;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}


}
