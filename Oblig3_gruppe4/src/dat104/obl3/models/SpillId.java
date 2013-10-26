package dat104.obl3.models;
import javax.persistence.*;
public class SpillId {
 int id;
String host;

public SpillId(){}

public SpillId(int id, String host){
 this.id = id;
 this.host = host;
}

public void setId(int id){
	this.id = id;
}

public void setHost(String host){
	this.host = host;
}

public int getId(){
	return id;
}

public String getHost(){
	return host;
}
}

