package hib.no.dat104.oppg1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
//import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.URLDecoder;
import java.net.URLEncoder;
import org.apache.commons.lang3.StringEscapeUtils;
/**
 * Servlet implementation class MeldingServlet
 */

@WebServlet("/meldinger")
public class MeldingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String filsti;
	private ArrayList<Melding> meldinger;
	private int antallMeldinger;
	private long lastModified;
	
	  @Override
	    public void init() throws ServletException {
	        filsti = getServletContext().getInitParameter("filsti");
	        Filbehandling fb = new Filbehandling(filsti);
	        antallMeldinger = Integer.parseInt(getServletContext().getInitParameter("antall"));
	        meldinger = fb.hentAlleMeldinger();
	        lastModified = fb.getLastModified();
	    }
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
	
		String cookie = (String)session.getAttribute("cAvsender");
		if(cookie != null)
			cookie = URLDecoder.decode(cookie, "UTF-8");
		out.println("<!DOCTYPE html>"
		+"<html>"
		+"<head>"
		+"<meta charset=\"ISO-8859-1\">"
		+"<title>Oioi</title>"
		+"</head>"
		+"<body> <h1> MELDINGER </h1>");
		if(meldinger.size() > antallMeldinger){
			for (int i = meldinger.size() - 1; i > meldinger.size() - antallMeldinger - 1; i--) {
				out.println("<b>(#" + (i+1) + ") " + meldinger.get(i).hentDato()
			+ "</b>" + " skrev " + "<b>" + meldinger.get(i).getSender() + ": </b>");
			out.println("<blockquote><p>" + meldinger.get(i).getMelding() + "</p></blockquote> <br>");
			}
		}
		
		else if(meldinger.size() > 0){
			for(Melding m : meldinger){
				out.println("<b>(#" + m.hentMeldId() + ") " + m.hentDato()
						+ "</b>" + " skrev " + "<b>" + m.getSender() + ":</b>");
						out.println("<blockquote>" + m.getMelding() + "</blockquote> <br>");
			}
				
		}
		
		out.println("<form method=\"post\" action=\"\">"
		+"<fieldset>"
		+"<legend>Ny melding</legend>"
		+"<p>Skriv melding: <br><textarea name=\"melding\" style=\"width: 95%; height: 50px; \"></textarea></p>"
		+"<p>Avsender:<br>");
		if(cookie != null && !cookie.trim().equals(""))
		out.println("<input type=\"text\" name=\"avsender\"" 
		+" value=\"" + cookie + "\">");
		else
		out.println("<input type=\"text\" name=\"avsender\">");
		
		out.println("<input type=\"submit\" value=\"Send Melding\"><input type=\"reset\" value=\"Nullstill\"></p>"
				
		+"</fieldset>"
		+"</form>"
		+"</body>"
		+"</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	  @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Date d = new Date();
		String dato = (new DatoTilString()).hentDato(d);
		String avsender = StringEscapeUtils.escapeHtml4(request.getParameter("avsender"));
		String melding = StringEscapeUtils.escapeHtml4(request.getParameter("melding"));
		HttpSession session = request.getSession();
		if(avsender!=null && !avsender.trim().equals("")){
			avsender = URLEncoder.encode(avsender, "UTF-8");
			session.setAttribute("cAvsender", avsender);
		}
		else avsender = (String)session.getAttribute("cAvsender");
		avsender = URLDecoder.decode(avsender, "UTF-8");
		if(avsender != null && !avsender.trim().equals("") && melding != null && !melding.trim().equals("")){
			melding = melding.replaceAll("(\\r\\n)", "<br>");
		synchronized(this){
			Melding m = new Melding(avsender, melding, dato, meldinger.size() + 1);
			Filbehandling fb = new Filbehandling(filsti);
			fb.lagreNyMelding(m);
			lastModified = fb.getLastModified();
			meldinger.add(m);
		}
		}
		response.sendRedirect("meldinger");
	}
	
	public long getLastModified(HttpServletRequest request){
		return lastModified;
	}

}
