package no.hib.dat104.junit;

import static org.junit.Assert.*;

import org.junit.Test;
import no.hib.dat104.klasser.Validator;

public class testValidator {
	
	@Test
	public void testGyldigFornavn() {
		assertEquals(false, Validator.gyldigFornavn("O"));
		assertEquals(false, Validator.gyldigFornavn("Olanordolanordnolanordolanord"));
		assertEquals(false, Validator.gyldigFornavn(""));
		assertEquals(false, Validator.gyldigFornavn("ola"));
		assertEquals(false, Validator.gyldigFornavn("ol a"));
		assertEquals(true, Validator.gyldigFornavn("Ola-Nord"));
	}

	@Test
	public void testGyldigEtternavn() {
		assertEquals(false, Validator.gyldigEtternavn("N"));
		assertEquals(false, Validator.gyldigEtternavn("Nordmannnordmannnordmann"));
		assertEquals(false, Validator.gyldigEtternavn(""));
		assertEquals(false, Validator.gyldigEtternavn("nordmann"));
		assertEquals(false, Validator.gyldigEtternavn("nord mann"));
		assertEquals(true, Validator.gyldigFornavn("Nordmann"));
	}

	@Test
	public void testGyldigNr() {
		assertEquals(false, Validator.gyldigNr("1234567"));
		assertEquals(false, Validator.gyldigNr("123456789"));
		assertEquals(false, Validator.gyldigNr("abcdefgh"));
		assertEquals(true, Validator.gyldigNr("12345678"));
	}

}
