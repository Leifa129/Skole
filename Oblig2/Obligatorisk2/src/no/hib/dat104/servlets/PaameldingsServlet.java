package no.hib.dat104.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import no.hib.dat104.klasser.Deltager;
import no.hib.dat104.klasser.SortertDeltagerliste;
import no.hib.dat104.klasser.Validator;

/**
 * Servlet implementation class PaameldingsServlet
 */
@WebServlet("/paamelding")
public class PaameldingsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fornavnError = "";
		String etternavnError = "";
		String mobilError = "";

        if (request.getParameter("invalidFornavn") != null) {
            fornavnError = "Kan ikke være tom";

        } 
        if (request.getParameter("invalidEtternavn") != null) {
            etternavnError = "Kan ikke være tom";
        }
        if (request.getParameter("invalidMobil") != null) {
            mobilError = "Må være 8 siffer";
        }
 
        
        request.setAttribute("fornavnError", fornavnError);
        request.setAttribute("etternavnError", etternavnError);
        request.setAttribute("mobilError", mobilError);

  	
		request.getRequestDispatcher("WEB-INF/paameldingsskjema.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fornavn = request.getParameter("fornavn");
		String etternavn = request.getParameter("etternavn");
		String kjonn = request.getParameter("kjonn");
		String tlf = request.getParameter("mobil");
		
		
		if(Validator.gyldigString(fornavn) && Validator.gyldigString(etternavn) && Validator.gyldigNr(tlf)){
			Deltager d = new Deltager(tlf, fornavn, etternavn, kjonn.charAt(0), false);
			SortertDeltagerliste.leggTil(d);
			HttpSession sesjon = request.getSession(false);
            if (sesjon != null) {
                sesjon.invalidate();
            }
            sesjon = request.getSession(true);
            sesjon.setMaxInactiveInterval(30);

            sesjon.setAttribute("fornavn", fornavn);
            sesjon.setAttribute("etternavn", etternavn);
            sesjon.setAttribute("kjonn", kjonn);
            sesjon.setAttribute("mobil", tlf);

			
			response.sendRedirect("PaameldingsBekreftelse");
			
		}
		
		else {
			String error = "";
			if(!Validator.gyldigString(fornavn)){
				error += "?invalidFornavn";
			     if(!Validator.gyldigString(etternavn))
				    error += "&invalidEtternavn";
			     if(!Validator.gyldigNr(tlf))
				    error += "&invalidMobil"; 
			}
			
			else if(!Validator.gyldigString(etternavn)){
				error += "?invalidEtternavn";
				  if(!Validator.gyldigNr(tlf))
				     error += "&invalidMobil"; 
			}
			else if(!Validator.gyldigNr(tlf))
			    error += "?invalidMobil"; 
				
			response.sendRedirect("paamelding" + error);
		}
	}

}
