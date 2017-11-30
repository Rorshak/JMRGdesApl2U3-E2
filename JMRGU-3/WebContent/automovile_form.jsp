<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Automovile Form</title>
</head>
<body>
	<form action="AutomovileController">
		<label>Mark:</label><br />
		<input type="text" name="mark" value="${automovile.mark}" /><br />
		
		<label>Model:</label><br />
		<input type="text" name="model" value="${automovile.model}" /><br />
		
		<label>Year:</label><br />
		<input type="number" name="year" value="${automovile.year}" /><br />
		
	
		<br />
		<input type="submit" name="btn_save" value="Save" />	
	</form>
</body>
</html>