<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Kasserer login</title>
</head>
<body>
<h2>Kasserer login</h2>
<form action="kassererlogin" method="post">
  <fieldset>
    <legend>Kasserer login</legend>
    <p>Passord: <input type="password" name="password" value="" />
    <font color="red">Feil passord</font></p>
    <p><input type="submit" value="Logg inn" /></p>
  </fieldset>
</form>

</body>
</html>