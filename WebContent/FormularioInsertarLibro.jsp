<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html> 
<head>
<title>Formulario Libro</title>
<link rel="stylesheet" type="text/css" href="css/formato.css" ></link>
<script type="text/javascript" src="js/validacion.js"></script>
</head>
<body>
<form id="miformulario" action="InsertarLibro.do" onsubmit="return validacion();">
	<fieldset>
		<legend>Formulario alta libro</legend>
		<p>
			<label for="isbn">ISBN:</label>
			<input id= "isbn" type="text" name="isbn" ></input>
		</p>
		<p>
			<label for="titulo">Título:</label>
			<input id= "titulo" type="text" name="titulo" ></input>
		</p>
		<p>
			<label for="categoria">Categoría:</label>
			<select id="categoria" name="categoria">
				<c:forEach var="categoria" items="${listaDeCategorias}">
					<option value="${categoria.id}" >${categoria.descripcion}</option>
				</c:forEach>
			</select>  
		</p>		
		
	</fieldset>
	<input type="submit" value="Insertar"></input>
</form>
</body>
</html>