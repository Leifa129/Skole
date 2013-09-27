package no.hib.dat104.klasser;

public class Validator {
	 public static final String ANY_LETTER = "[a-zA-ZÊ¯Â∆ÿ≈]";
	    public static final String ANY_LETTER_OR_DIGIT = "[a-zA-ZÊ¯Â∆ÿ≈0-9]";
	    public static final String THREE_TIMES = "{3}";
	    public static final String ZERO_OR_MORE_TIMES = "*";
	    public static final String SIFFER = "[0-9]";
	   
	    public static boolean gyldigString(String tekst) {

	        if (tekst == null) {
	            return false;
	        }
	        return tekst.matches("^" + ANY_LETTER 
	                + ANY_LETTER_OR_DIGIT + THREE_TIMES 
	                + ANY_LETTER_OR_DIGIT + ZERO_OR_MORE_TIMES + "$");
	    }
	    
	    
	    public static boolean gyldigNr(String tlf){
	    	if (tlf.length() != 8 || tlf == null)
	    		return false;
	    	
	    	return tlf.matches("^" + SIFFER + THREE_TIMES + ANY_LETTER_OR_DIGIT
	    			+ SIFFER + ZERO_OR_MORE_TIMES + "$");
	    }
}
