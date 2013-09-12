package hib.no.dat104.oppg1;
import java.util.Date;
import java.util.Locale;
import java.text.DateFormat;

public class DatoTilString {

public String hentDato(Date d){
	   String ds = DateFormat.getDateInstance(DateFormat.LONG,
	new Locale("no", "NO")).format(d);
	   String ts =  DateFormat.getTimeInstance(DateFormat.LONG,
	new Locale("no", "NO")).format(d);
	String[] temp = ts.split("CEST");
	    return ds + " " + temp[0];
	
}


	
}
