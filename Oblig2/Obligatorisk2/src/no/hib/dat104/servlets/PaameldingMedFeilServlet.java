package no.hib.dat104.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class PaameldingMedFeilServlet
 */
@WebServlet("/paameldingmedfeil")
public class PaameldingMedFeilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fornavnError = "";
		String etternavnError = "";
		String mobilError = "";
		HttpSession sesjon = request.getSession(false);

        if (sesjon.getAttribute("fornavn") == null) {
            fornavnError = "Kan ikke være tom";

        } 
        if (sesjon.getAttribute("etternavn") == null) {
            etternavnError = "Kan ikke være tom";
        }
        if (sesjon.getAttribute("mobil") == null) {
            mobilError = "Må være 8 siffer";
        }
 
        
        request.setAttribute("fornavnError", fornavnError);
        request.setAttribute("etternavnError", etternavnError);
        request.setAttribute("mobilError", mobilError);
        request.getRequestDispatcher("WEB-INF/paameldingmedfeil.jsp").forward(request, response);
        
        
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
