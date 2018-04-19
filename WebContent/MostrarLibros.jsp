<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.List"%>
<%@ page import="com.aquitecturajava.Libro"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Formulario Libro</title>
<link rel="stylesheet" type="text/css" href="css/formato.css"></link>
<script type="text/javascript" src="js/validacion.js"></script>
</head>
	<body>
	<form id="miformulario" action="MostrarLibros.jsp">
		<select id="categoria" name="categoria">
			<option value="">Seleccionar</option>
<%
	List<String> categorias = Libro.buscarTodasLasCategorias();
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

	String categoria = request.getParameter("categoria");
	List<Libro> libros = null;

	if (categoria != null && !categoria.equals("")) {
		libros = Libro.buscarPorCategoria(categoria);
	} else {
		libros = Libro.buscarTodos();	
	}
	for(Libro libro: libros) {
%>	
			<%=libro.getIsbn() %>
			<%=libro.getTitulo() %>
			<%=libro.getCategoria() %>
			<a href="BorrarLibro.jsp?isbn=<%=libro.getIsbn()%>">Borrar</a>
			<a href="FormularioEditarLibro.jsp?isbn=<%=libro.getIsbn()%>">Editar</a>
<br></br>
<%
	}
%>    
	</form> 
	
	<a href="./FormularioInsertarLibro.jsp">Insertar Libro</a> 
	</body>
</html>    


