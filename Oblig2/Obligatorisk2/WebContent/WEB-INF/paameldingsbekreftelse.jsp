<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Påmeldingsbekreftelse</title>
</head>
<body>
<h2>Påmeldingsbekreftelse</h2>
<p>Påmeldingen er mottatt for</p>
<p>&nbsp;&nbsp;&nbsp;<%=session.getAttribute("fornavn")  %><br/>
&nbsp;&nbsp;&nbsp;<%=session.getAttribute("etternavn")%><br/>
&nbsp;&nbsp;&nbsp;<%=session.getAttribute("mobil")%><br/>
&nbsp;&nbsp;&nbsp;<%=session.getAttribute("kjonn")%></p>
<p><b>NB! Husk å betale til kassereren før festen!</b></p>
<a href="DeltagerListe">Gå til deltagerlisten</a>
</body>
</html>