<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="UTF-8" %>
<%@ page import="no.hib.dat104.klasser.SortertDeltagerliste"%>
<%@ page import="no.hib.dat104.klasser.Deltager"%>
<% String betaling;%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Betalingsoversikt</title>
</head>
<body>
<h2>Betalingsoversikt</h2>
<form>
<table border="1">
<tr bgcolor="#cccccc"><th align="left">Navn</th><th>Mobil</th><th>Betalingsstatus</th></tr>
<% for (Deltager d : SortertDeltagerliste.hentAlle()) { %>
<% if(d.harBetalt() == true) betaling = "Betaling mottatt";
else betaling = "<input type=\"submit\" name=\"" + d.getTlf() + "\" value=\"Registrer betaling\" />"; %>
<tr><td><%=d.getForNavn() +  " " + d.getEtterNavn() %></td><td><%=d.getTlf() %></td><td align="center"><%=betaling %></td></tr>

<% } %>

</table>
</form>
<p><a href="kassererlogin">Ferdig</a></p>
</body>
</html>