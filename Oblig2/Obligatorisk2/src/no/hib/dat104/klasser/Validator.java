package no.hib.dat104.klasser;

public class Validator {
	 public static final String ANY_LETTER = "[a-zA-ZÊ¯Â∆ÿ≈ -]";
	 public static final String ANY_LETTER_NOSPACE = "[a-zA-ZÊ¯Â∆ÿ≈-]";
	    public static final String THREE_TIMES = "{3}";
	    public static final String ZERO_OR_MORE_TIMES = "*";
	    public static final String SIFFER = "[0-9]";
	    public static final String CAPITAL_LETTER = "[A-Z∆ÿ≈]";
	    
	    public static boolean gyldigFornavn(String tekst) {

	        if (tekst == null || tekst.length() < 2 || tekst.length() > 20) {
	            return false;
	        }
	        return tekst.matches("^" + CAPITAL_LETTER + ANY_LETTER + ZERO_OR_MORE_TIMES + "$");
	    }
	    
	    public static boolean gyldigEtternavn(String tekst) {

	        if (tekst == null || tekst.length() < 2 || tekst.length() > 20) {
	            return false;
	        }
	        return tekst.matches("^" + CAPITAL_LETTER + ANY_LETTER_NOSPACE + ZERO_OR_MORE_TIMES + "$");
	    }
	    
	    
	    
	    
	    public static boolean gyldigNr(String tlf){
	    	if (tlf.length() != 8 || tlf == null || SortertDeltagerliste.inneheld(tlf))
	    		return false;
	    	
	    	return tlf.matches("^" + SIFFER + SIFFER + ZERO_OR_MORE_TIMES + "$");
	    }
}
