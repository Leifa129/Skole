package no.hib.dat104.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import no.hib.dat104.klasser.SortertDeltagerliste;
import no.hib.dat104.klasser.Deltager;
/**
 * Servlet implementation class BetalingsOversiktServlet
 */
@WebServlet("/betalingsoversikt")
public class BetalingsOversiktServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession sesjon = request.getSession(false);

	        if (sesjon == null || sesjon.getAttribute("passord") == null) {
	            response.sendRedirect("kassererlogin");
	            return;
	        } else {
	        	request.getRequestDispatcher("WEB-INF/betalingsoversikt.jsp").forward(request, response);
	        }
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		synchronized(SortertDeltagerliste.class) {
			for(Deltager d : SortertDeltagerliste.hentAlle()){
				if(request.getParameter(d.getTlf()) != null){
					d.setBetalt(true);
				response.sendRedirect("betalingsoversikt");
				}
				
			}
		}	
		
	}

}
