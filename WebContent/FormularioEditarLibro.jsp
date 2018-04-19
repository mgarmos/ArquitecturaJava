<%@page import="com.aquitecturajava.DataBaseHelper"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.List"%>
<%@ page import="com.aquitecturajava.Libro"%>

<% 
	DataBaseHelper<Libro> helper = new DataBaseHelper<Libro>();
	String isbn = request.getParameter("isbn");
	Libro libro = new Libro(isbn);
	libro = libro.buscarPorClave();
	System.out.println("Libro en jsp: " + libro);
%>
<html>
<head>
<title>Formulario Libro</title>
<link rel="stylesheet" type="text/css" href="css/formato.css" ></link>
<script type="text/javascript" src="js/validacion.js"></script>
</head>
<body>
<form id="miformulario" action="SalvarLibro.jsp" onsubmit="return validacion();">
	<fieldset>
		<legend>Formulario editar libro</legend>
		<p>
			<label for="isbn">ISBN:</label>
			<input id= "isbn" type="text" name="isbn" class="readOnly" value="<%=libro.getIsbn()%>" readonly="readonly"></input>
		</p>
		<p>
			<label for="titulo">Título:</label>
			<input id= "titulo" type="text" name="titulo" value="<%=libro.getTitulo()%>"></input>
		</p>
		<p>
			<label for="categoria">Categoría:</label>
			<select id="categoria" name="categoria">
			
<%

	List<String> categorias = Libro.buscarTodasLasCategorias();
		for(String categoria: categorias) {
			if (libro.getCategoria().equals(categoria)) {
%>
			<option value="<%=categoria %>" selected="selected"><%=categoria %></option>	
<%				
			} else {
%>	
			<option value="<%=categoria %>"><%=categoria %></option>	
<%
			}
		}

%>	
			</select> 
		</p>		
		
	</fieldset>
	<input type="submit" value="Modificar"></input>
</form>
</body>
</html>