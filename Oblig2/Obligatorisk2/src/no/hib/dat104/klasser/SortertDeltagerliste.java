package no.hib.dat104.klasser;
import java.util.List;
import java.util.ArrayList;

public class SortertDeltagerliste {
	
	private static List<Deltager> deltagere = new ArrayList<>();
	static {
		deltagere.add(new Deltager("45671234", "Arne", "Arnesen", 'm', false));
		deltagere.add(new Deltager("90122333", "Brit", "Britsen", 'k', true));
		deltagere.add(new Deltager("90144555", "Knut", "Knutsen", 'm', true));
		deltagere.add(new Deltager("90198765", "Lars", "Larssen", 'm', false));
		deltagere.add(new Deltager("90198769", "Olga", "Olgasen", 'k', false));
	}
	
	public static List<Deltager> hentAlle() {
		return deltagere;
	}
	
	public static synchronized void leggTil(Deltager d) {
		deltagere.add(d);
		deltagere = Sortering.sort(deltagere); //compareTo
	}
	
	public static synchronized void registrerBetalingFor(String mobil) {
		int funnetPaa = deltagere.indexOf(new Deltager(mobil));
		if (funnetPaa >= 0) {
			deltagere.get(funnetPaa).setBetalt(true);
		}
	}
	
	public static boolean inneheld(String nummer) {
		return deltagere.contains((new Deltager(nummer)));
	}
	
}