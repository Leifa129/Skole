<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="UTF-8" %>
<%@ page import="no.hib.dat104.klasser.SortertDeltagerliste"%>
<%@ page import="no.hib.dat104.klasser.Deltager"%>
<% String kjonn;%>
<% String mobilnr = session.getAttribute("mobil").toString(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Deltagerliste</title>
</head>
<body>
<h2>Deltagerliste</h2>
<table border="1">
<tr bgcolor="#cccccc"><th>Kjønn</th><th align="left">Navn</th></tr>
<% for (Deltager d : SortertDeltagerliste.hentAlle()) { %>
<% if(d.getKjonn() == 'm') kjonn = "&#9794;";
else kjonn = "&#9792;"; 
String style = "";
if (d.getTlf().equals(mobilnr)) {
	if (d.harBetalt())
		style = "background-color: green;";
	else
		style = "background-color: red;";
}
%>
<tr style="<%=style %>"><td align="center"><%=kjonn %></td><td><%= d.getForNavn() + " " + d.getEtterNavn() %></td></tr>

<% } %>
<%/*/ <tr bgcolor="#ffaaaa"><td align="center">&#9794;</td><td>Arne Arnesen</td></tr>
<!-- <tr bgcolor="#aaffaa"><td align="center">&#9794;</td><td>Arne Arnesen</td></tr> -->
<tr><td align="center">&#9792;</td><td>Berit Beritsen</td></tr> /*/%>
</table>
<p><a href="ferdig">Ferdig</a></p>
</body>
</html>