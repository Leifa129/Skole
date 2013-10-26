package dat104.obl3.src_test;

import dat104.obl3.controllers.RegistreringsServlet;
import static org.junit.Assert.*;
import org.junit.Test;

public class RegistreringTest {
	
	/* Må finne en måte å løse testing på mtp at validerBrukernavn/epost sjekker om brukernavnet/eposten 
	 * her i testklassen finnes i databasen... et tenkelig scenario er at noen har registrert seg som feks
	 * "Brukernavn", og vil faile første testen. 
	 */
	
	@Test
	public void gyldigBrukernavnTest() {
		
		assertTrue(RegistreringsServlet.validerBrukernavn("Brukernavn"));
		assertTrue(RegistreringsServlet.validerBrukernavn("BrukerNavn"));
		assertTrue(RegistreringsServlet.validerBrukernavn("BrukerNavn123"));
		assertTrue(RegistreringsServlet.validerBrukernavn("Bruker123Navn123"));

	}
	
	@Test
	public void ugyldigBrukernavnTest() {
		
		assertFalse(RegistreringsServlet.validerBrukernavn(null));
		assertFalse(RegistreringsServlet.validerBrukernavn(""));
		assertFalse(RegistreringsServlet.validerBrukernavn("bruker*navn"));
		assertFalse(RegistreringsServlet.validerBrukernavn("bruker-navn"));
		assertFalse(RegistreringsServlet.validerBrukernavn("bruker*navn"));

		
	}
	
	@Test
	public void gyldigPassordTest() {
		
		assertTrue(RegistreringsServlet.validerPassord("Passord"));
		assertTrue(RegistreringsServlet.validerPassord("PassOrd"));
		assertTrue(RegistreringsServlet.validerPassord("PassOrd1234"));
		assertTrue(RegistreringsServlet.validerPassord("PAss123Ord123"));

	}
	
	@Test
	public void ugyldigPassordTest() {
		
		assertFalse(RegistreringsServlet.validerPassord(null));
		assertFalse(RegistreringsServlet.validerPassord("Pass*ord"));
		assertFalse(RegistreringsServlet.validerPassord("pass-ord"));
		assertFalse(RegistreringsServlet.validerPassord("pass*Ord123"));

		
	}
	
	@Test
	public void gyldigEpostTest() {
		
		assertTrue(RegistreringsServlet.validerEpost("testepost@gmail.com"));
		assertTrue(RegistreringsServlet.validerEpost("TestEpost@gmail.com"));
		assertTrue(RegistreringsServlet.validerEpost("test.Epost@gmail.no"));
		assertTrue(RegistreringsServlet.validerEpost("test-Epost@hotmail.com"));
		assertTrue(RegistreringsServlet.validerEpost("123test.epost@gmail.com"));
		assertTrue(RegistreringsServlet.validerEpost("teste%post@gmail.com"));
		assertTrue(RegistreringsServlet.validerEpost("teste+post@gmail.com"));

		
	}
	
	@Test
	public void ugyldigEpostTest() {
	
		assertFalse(RegistreringsServlet.validerEpost(null));
		assertFalse(RegistreringsServlet.validerEpost("testepost@gmail.com1"));
		assertFalse(RegistreringsServlet.validerEpost("testepost.gmail.com"));
		assertFalse(RegistreringsServlet.validerEpost("testepost@@gmail.com"));
		
		
	}
	
	@Test
	public void gyldigNavnTest() {

		/*
		assertTrue(RegistreringsServlet.validerNavn("Testnavn"));
		assertTrue(RegistreringsServlet.validerNavn("Test-Navn"));
		assertTrue(RegistreringsServlet.validerNavn("Testænavn"));
		assertTrue(RegistreringsServlet.validerNavn("Testæøå-Navn"));
		*/
		assertTrue(RegistreringsServlet.validerNavn("Testnavn Etternavn"));
		assertTrue(RegistreringsServlet.validerNavn("Test-Navn Etternavn"));
		assertTrue(RegistreringsServlet.validerNavn("Testænavn Etteræånavn"));
		assertTrue(RegistreringsServlet.validerNavn("Testæøå-Navn Etternåvn"));



	}
	
	@Test
	public void ugyldigNavnTest() {

		assertFalse(RegistreringsServlet.validerNavn(null));
		assertFalse(RegistreringsServlet.validerNavn("Testnavn"));
		assertFalse(RegistreringsServlet.validerNavn("Test-Navn"));
		assertFalse(RegistreringsServlet.validerNavn("Testænavn"));
		assertFalse(RegistreringsServlet.validerNavn("Testæøå-Navn"));
		assertFalse(RegistreringsServlet.validerNavn("TestNavn"));
		assertFalse(RegistreringsServlet.validerNavn("Test-navn"));
		assertFalse(RegistreringsServlet.validerNavn("TesT-Navn"));
		assertFalse(RegistreringsServlet.validerNavn("Testnavn1"));
		assertFalse(RegistreringsServlet.validerNavn("Test*Navn"));


	}
	
	
	

}
