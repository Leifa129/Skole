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
			request.getRequestDispatcher("WEB-INF/paameldingsskjema.jsp").forward(request, response);
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fornavn = request.getParameter("fornavn");
		String etternavn = request.getParameter("etternavn");
		String kjonn = request.getParameter("kjonn");
		String tlf = request.getParameter("mobil");
		HttpSession sesjon = request.getSession(false);
        if (sesjon != null) {
            sesjon.invalidate();
        }
        sesjon = request.getSession(true);
        sesjon.setMaxInactiveInterval(30);
        sesjon.setAttribute("kjonn", kjonn);
		
		if(Validator.gyldigFornavn(fornavn) && Validator.gyldigEtternavn(etternavn) && Validator.gyldigNr(tlf)){
			Deltager d = new Deltager(tlf, fornavn, etternavn, kjonn.charAt(0), false);
			SortertDeltagerliste.leggTil(d);

            sesjon.setAttribute("fornavn", fornavn);
            sesjon.setAttribute("etternavn", etternavn);
            sesjon.setAttribute("mobil", tlf);

			
			response.sendRedirect("PaameldingsBekreftelse");
			
		}
		
		else {
			if(Validator.gyldigFornavn(fornavn))
				sesjon.setAttribute("fornavn", fornavn);
			
			if(Validator.gyldigEtternavn(etternavn))
				sesjon.setAttribute("etternavn", etternavn);
			
			if(Validator.gyldigNr(tlf))
				sesjon.setAttribute("mobil", tlf);
			
		
				
			response.sendRedirect("paameldingmedfeil");
		}
	}

}
