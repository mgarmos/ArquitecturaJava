<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.List"%>
<%@ page import="com.arquitecturajava.Libro"%>


<html>
<head>
<title>Formulario Libro</title>
<link rel="stylesheet" type="text/css" href="css/formato.css" ></link>
<script type="text/javascript" src="js/validacion.js"></script>
</head>
<body>
<form id="miformulario" action="insertarLibro.do" onsubmit="return validacion();">
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
			
<%

	List<String> categorias = Libro.buscarTodasLasCategorias();
		for(String categoria: categorias) {
%>	
			<option value="<%=categoria %>"><%=categoria %></option>	
<% 		} %>	
			</select> 
		</p>		
		
	</fieldset>
	<input type="submit" value="Insertar"></input>
</form>
</body>
</html>