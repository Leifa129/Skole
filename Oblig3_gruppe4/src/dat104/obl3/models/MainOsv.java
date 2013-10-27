package dat104.obl3.models;
import java.util.List;
import dat104.obl3.controllers.DAO;
public class MainOsv {

	public static void main(String args[]){
		DAO dao = new DAO();
		Spill spill = dao.getSpill(2);
		
	SpillInfo s = new SpillInfo("perri");
	
	spill.leggTilSpiller(s);
	
	List<SpillInfo> spillere = spill.getSpillere();
 
	dao.Oppdater(spill);
		
	}
}
