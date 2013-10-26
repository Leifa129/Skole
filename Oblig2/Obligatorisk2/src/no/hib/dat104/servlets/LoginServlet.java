package no.hib.dat104.servlets;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import no.hib.dat104.klasser.SortertDeltagerliste;
/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/mobillogin")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/mobillogin.jsp").forward(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nummer = request.getParameter("mobil");
	if(SortertDeltagerliste.inneheld(nummer)){
		 HttpSession sesjon = request.getSession(false);
         if (sesjon != null) {
             sesjon.invalidate();
         }
         sesjon = request.getSession(true);
         sesjon.setMaxInactiveInterval(30);

         sesjon.setAttribute("mobil", nummer);
	response.sendRedirect("deltagerliste");
	}
	else response.sendRedirect("mobilloginmedfeil");
	}

}
