<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="UTF-8" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%HttpSession sesjon = request.getSession();%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Påmelding</title>
</head>
<body>
<h2>Påmelding</h2>
<form action="paamelding" method="post">
  <fieldset>
    <legend>Personlige data</legend>
    <p>Fornavn: <input type="text" name="fornavn" <%if(sesjon.getAttribute("fornavn") != null){
    	%>value="<%=sesjon.getAttribute("fornavn")%>"<%} %>/>
    <font color="red"><%= request.getAttribute("fornavnError") %></font></p>
    <p>Etternavn: <input type="text" name="etternavn" <%if(sesjon.getAttribute("etternavn") != null){
    	%>value="<%=sesjon.getAttribute("etternavn")%>"<%} %>/>
    <font color="red"><%= request.getAttribute("etternavnError") %></font></p>
    <p>Mobil (8 siffer): <input type="text" name="mobil" <%if(sesjon.getAttribute("mobil") != null){
    	%>value="<%=sesjon.getAttribute("mobil")%>"<%} %>/>
    <font color="red"><%= request.getAttribute("mobilError") %></font></p>
    <p>Kjønn: <input type="radio" name="kjonn" value="mann" checked="checked" />mann
        <input type="radio" name="kjonn" value="kvinne" />kvinne</p>
    <p><input type="submit" value="Meld meg på" /></p>
  </fieldset>
</form>
</body>
</html>