<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Automovil list</title>
</head>
<body>
<table border="1">
		<tr>
			<th>
			  <form action="AutomovilController">
			  		<input type="submit" name="btn_new"
			  		value="New "/>
			  </form>
			  <a href="AutomovilReport">Print report</a>
			</th>
			<td>IdAutomovil</td>
			<td>Marca</td>
			<td>Modelo</td>
			<td>Year</td>
			
			
		</tr>
		 <c:forEach var="automovil" items="${automovils}">
		 	 <tr>
		 	 	<td>
		 	 		<form action="AutomovilController">
		 	 			<input type="hidden" name="id" value="${automovil.id}">
		 	 			<input type="submit" name="btn_edit" value="Edit"/>
		 	 			 <input type="submit" name="btn_delete" value="Delete"/>
		 	 		</form>
		 	 	</td>
		 	 	<td>${automovil.id}</td>
		 	 	<td>${automovil.marca}</td>
		 	 	<td>${automovil.modelo}</td>
		 	 	<td>${automovil.year}</td>
		 	 	
		 	 </tr>	
		 </c:forEach>
	</table>
</body>
</html>