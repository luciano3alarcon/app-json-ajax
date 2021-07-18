<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<title>1. Capture Exceptions</title>
</head>
<body>
	<table>
		<td>NAVEGATION</td>
		<td><a href="index.jsp"></a>home</td>
	</table>

	<h2>1. Capture Exceptions</h2>
	<h3>Hier werden Inhalte mittels JQuery abgefangen.</h3>
	<input type="text" value="Eingabe" id="Eingabe">
	<input type="button" onclick="checkException();"
		value="Check Exception">

</body>

<script>
	function checkException() {
		var printEingabe = $('#Eingabe').val();

		$.ajax({
			method : "POST",
			url : "captureExceptions", //kommt aus einem Servlet
			data : { eingabeParam : printEingabe}
		})
		.done(function(response) {  //alway fängt den Return ab. 
			alert("sucess: " +response);
		})
		.fail(function(xhr, status, errorThrown ){
			alert("error: " + xhr.responseText); 
		});

	}
</script>



</html>


