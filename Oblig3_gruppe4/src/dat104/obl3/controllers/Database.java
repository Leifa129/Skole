package dat104.obl3.controllers;

import java.sql.*;

import dat104.obl3.models.*;

public class Database {
	//TODO: hent og sett metoder for det vi trenger tilgang til i databasen.
	
	private Connection connection;
	private String adresse = "jdbc:postgresql://mod250.hib.no:5432/dat104gruppe4", 
					bruker = "dat104gruppe4", 
					passord = "dat104gruppe4";

	public Database() {		
		//Kobler til database
		try {
             Class.forName("org.postgresql.Driver");
             connection = DriverManager.getConnection(adresse, bruker, passord);
             
             //Spesifiserer skjema
             Statement statement = connection.createStatement();
             statement.executeUpdate("SET SCHEMA 'YATZY'");
             statement.close();
        
		} catch (ClassNotFoundException e) {
        	e.printStackTrace();
        } catch (SQLException e) {
        	e.printStackTrace();
        }
	}
	
	/*
	 * 
	 * 
	 * ------------- VALIDERING ------------
	 * 
	 * 
	 */
	
	/**
	 * Metode som returnerer true dersom brukernavnet ikke finnes fra før
	 * @param brukernavn
	 * @return
	 */
	public boolean validerBrukernavn(String brukernavn) {		
		boolean finnesIkke = false;
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT brukernavn FROM bruker WHERE brukernavn='" + brukernavn + "'");		
			finnesIkke = !resultSet.next();//finnesIkke settes til true(!false) dersom brukernavnet ikke finnes
			
			resultSet.close();
			statement.close();	
		} catch(SQLException e) {
			e.printStackTrace();
		
		}	
		return finnesIkke;
	}
	
	/**
	 * Metode som returnerer true dersom eposten ikke finnes fra før.
	 * @param epost
	 * @return
	 */
	public boolean validerEpost(String epost) {		
		boolean finnesIkke = false;
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT epost FROM bruker WHERE epost='" + epost + "'");		
			finnesIkke = !resultSet.next();//finnesIkke settes til true(!false) dersom eposten ikke finnes
			
			resultSet.close();
			statement.close();	
		} catch(SQLException e) {
			e.printStackTrace();
		
		}	
		return finnesIkke;
	}
	
	/**
	 * Metode for å sjekke om brukernavn og passord stemmer overens for login. 
	 * @param brukernavn
	 * @param passord
	 * @return
	 */
	public boolean validerLogin(String brukernavn, String passord) {
		boolean gyldig = false;
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT passord FROM bruker WHERE brukernavn='" + brukernavn + "'");		
			
			if(resultSet.next()) {
				gyldig = passord.equals(resultSet.getString("passord"));
			}
			
			resultSet.close();
			statement.close();	
		} catch(SQLException e) {
			e.printStackTrace();
		}		
		return gyldig;
	}
	
	/*
	 * 
	 * 
	 * ------------- BRUKERHÅNDTERING ------------
	 * 
	 * 
	 */
	
	/**
	 * Metode for å legge til en bruker i databasen.
	 * @param brukernavn
	 * @param navn
	 * @param epost
	 * @param passord
	 */
	public void leggTilBruker(String brukernavn, String navn, String epost, String passord) {
		
		try {
			
			PreparedStatement ps = connection.prepareStatement("INSERT INTO bruker VALUES(?,?,?,?)");
			ps.setString(1, navn);
			ps.setString(2, brukernavn);
			ps.setString(3, epost);
			ps.setString(4, passord);
			ps.execute();
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	/**
	 * Metode for å hente ut en bruker. Returnerer et Bruker-objekt.
	 * @param brukernavn
	 * @return
	 */
	public Bruker hentBruker(String brukernavn) {
		String 	navn = null,
				epost = null,
				passord = null;
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM bruker WHERE brukernavn='" + brukernavn + "'");		
			
			if(resultSet.next()) {
				navn = resultSet.getString("navn");
				epost = resultSet.getString("epost");
				passord = resultSet.getString("passord");
			}
			resultSet.close();
			statement.close();	
			
		} catch(SQLException e) {
			e.printStackTrace();
		}	
		
		if(navn != null) {
			return new Bruker(brukernavn, navn, epost, passord);
		}
		return null;
	}
	
	/**
	 * Metode for å slette bruker. Tar brukernavn som parameter.
	 * @param brukernavn
	 */
	public void slettBruker(String brukernavn) {
		try {
			PreparedStatement slettBruker = connection.prepareStatement("DELETE FROM bruker WHERE brukernavn=?");
			slettBruker.setString(1, brukernavn);	
			slettBruker.executeUpdate();
			slettBruker.close();	
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	/*
	 * 
	 * 
	 * ------------- SPILLHÅNDTERING ------------
	 * 
	 * 
	 */
	
	
	/**
	 * Metode for å opprette et spill i databasen. Tar en tabell med spillere som parameter.
	 * @param spillere
	 * @return
	 */
	public int opprettSpill(Bruker[] spillere) {
		
		int spillid = 1; //må se nærmere på denne
		
		try {
			Statement statement = connection.createStatement();
			for (int i = 0; i < spillere.length; i++){
				statement.executeUpdate("INSERT INTO spill(brukernavn, id) VALUES('" + spillere[i].getBrukernavn() + "','" + spillid +  "')");
			}
			statement.close();

		} catch(SQLException e){
			e.printStackTrace();
		}				
		return spillid;
	}
	
	/**
	 * Metode for å slette et spill. Tar spillID som parameter
	 * @param id
	 */
	public void slettSpill(int id) {
		try {
			PreparedStatement slettSpill = connection.prepareStatement("DELETE FROM spill WHERE id=?");
			slettSpill.setInt(1, id);
			slettSpill.execute();
			slettSpill.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	
	public SpillInfo hentSpill(int id) {
		
		SpillInfo spill = null; //TODO: Må initialiseres med data fra db
		String[] spillere = hentSpillere(id);
		String[][] yatzyTabell = new String[spillere.length][19];
		try {
			Statement statement = connection.createStatement();
			ResultSet resultset = statement.executeQuery("SELECT * FROM spill WHERE id='" + id + "'");
			for (int i = 0 ; i < spillere.length ; i++){
					for (int j = 0 ; j < 19 ; j++) {
					yatzyTabell[i][j] = resultset.getString(j+1);
				}
			}
			
		} catch (SQLException e) {
			
		}
		
		return spill;
		
	
	}
	
	
	/**
	 * Metode for å legge til resultat for kast til en gitt spiller i databasen.
	 * @param id
	 * @param brukernavn
	 * @param felt
	 * @param verdi
	 */
	public void leggTilKast(int id, String brukernavn, String felt, int verdi) {
		try {
			PreparedStatement leggTilKast = connection.prepareStatement("UPDATE spill SET " + felt + "=? WHERE id=? AND brukernavn=?");
			leggTilKast.setInt(1, verdi);
			leggTilKast.setInt(2, id);
			leggTilKast.setString(3, brukernavn);
			leggTilKast.executeUpdate();
			leggTilKast.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	/**
	 * Metode for å hente et felt. Tar spillID og brukernavn som parameter.
	 * @param id
	 * @param brukernavn
	 * @param felt
	 * @return
	 */
	public int hentKast(int id, String brukernavn, String felt) {
		int verdi = -1;
	
		try {
			Statement statement = connection.createStatement();
			ResultSet resultset = statement.executeQuery("SELECT " + felt + "FROM spill WHERE id='" + id + "' AND brukernavn='" + brukernavn + "'");
			if(resultset.next()) {
				verdi = resultset.getInt(felt);
			}
			resultset.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return verdi;
	}
	
	/**
	 * Henter en liste med brukernavn som er med i et gitt spill.
	 * @param id
	 * @return
	 */
	public String[] hentSpillere(int id) {
		String[] spillere = new String[6];
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultset = statement.executeQuery("SELECT brukernavn FROM spill WHERE id='" + id + "'");
			
			for(int i = 0; i<spillere.length; i++) {
				resultset.next();
				spillere[i] = resultset.getString("brukernavn"); 
			}
			
			statement.close();
			resultset.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return spillere;
	}
	
	
	
	public static void main(String[] args) {
		Database database = new Database();		
	
	}
}
