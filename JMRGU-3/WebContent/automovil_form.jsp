<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Automovil Form</title>
</head>
<body>
	<form action="AutomovilController">
		<label>Marca:</label><br />
		<input type="text" name="marca" value="${automovil.marca}" /><br />
		
		<label>Modelo:</label><br />
		<input type="text" name="modelo" value="${automovil.modelo}" /><br />
		
		<label>Year:</label><br />
		<input type="number" name="year" value="${automovil.year}" /><br />
		
	
		<br />
		<input type="submit" name="btn_save" value="Save" />	
	</form>
</body>
</html>