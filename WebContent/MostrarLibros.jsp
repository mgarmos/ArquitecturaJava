<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.List"%>
<%@ page import="com.arquitecturajava.Libro"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Formulario Libro</title>
<link rel="stylesheet" type="text/css" href="css/formato.css"></link>
<script type="text/javascript" src="js/validacion.js"></script>
</head>
	<body>
	<form id="miformulario" action="MostrarLibros.do">
		<select id="categoria" name="categoria">
			<option value="">Seleccionar</option>
<%
	System.out.println("listaDeCategorias: " + request.getAttribute("listaDeCategorias"));
	System.out.println("listaDeCategorias: " + request.getAttribute("listaDeCategorias"));

	List<String> categorias = (List<String>)request.getAttribute("listaDeCategorias");
		for(String categoria: categorias) {
%> 
			<option value="<%=categoria %>"><%=categoria %></option>
<% 
		} 
%>	
	 </select>
	 <input type="submit" value="Filtrar">
	 <br></br>   
<%
	List<Libro> libros = (List<Libro>)request.getAttribute("libros");
	for(Libro libro: libros) {
%>	
			<%=libro.getIsbn() %>
			<%=libro.getTitulo() %>
			<%=libro.getCategoria() %>
			<a href="BorrarLibro.do?isbn=<%=libro.getIsbn()%>">Borrar</a>
			<a href="FormularioEditarLibro.do?isbn=<%=libro.getIsbn()%>">Editar</a>
<br></br>
<%
	}
%>    
	</form> 
	
	<a href="./FormularioInsertarLibro.do">Insertar Libro</a> 
	</body>
</html>    


