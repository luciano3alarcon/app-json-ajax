<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Json Ajax Schulung</title>
</head>
<body>

	<h2>Sie sind nicht eingeloggt! Loggen Sie sich ein :-)</h2>

<!-- Method muss Post sein. Method = Get wird login und Password in der URL angezeigt. -->
	<form action="ServletAuthentifizierung" method="post" >
<!-- 		unsichtbares Feld -->
	<input readonly="readonly" type="hidden" id="url" name="url" value="<%= request.getParameter("url")%>" >

		<table>
			<tr>
				<td>Username</td>
				<td><input type="text" id="username" name="username"></td>
			</tr>

			<tr>
				<td>Passwort</td>
				<td><input type="password"  id="passwort" name="passwort"></td>
			</tr>

			<tr>
				<td>Send</td>
				<td><input type="submit" id="einloggen" name="einloggen" value="einloggen"></td>
			</tr>


		</table>

	</form>

</body>
</html>