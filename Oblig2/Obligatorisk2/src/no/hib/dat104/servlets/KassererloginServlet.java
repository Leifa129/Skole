package no.hib.dat104.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class KassererloginServlet
 */
@WebServlet("/kassererlogin")
public class KassererloginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String passord;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/kassererlogin.jsp").forward(request, response);
	}

	 @Override
     public void init() throws ServletException {
             String parampassord = getServletContext().getInitParameter("passord");
             if (parampassord != null)
                     passord = parampassord;
     }
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("password").equals(passord)){
			HttpSession sesjon = request.getSession(false);
            if (sesjon != null) {
                sesjon.invalidate();
            }
            sesjon = request.getSession(true);
            sesjon.setMaxInactiveInterval(30);

            sesjon.setAttribute("passord", passord);
			
		response.sendRedirect("betalingsoversikt");
		return;
		}
		else {
			response.sendRedirect("kassererloginmedfeil");
			return;
		}
		
	}

}
