<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
   
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
			<c:forEach var="categoria" items="${listaDeCategorias}">
				<option value="${categoria}">${categoria}</option>
			</c:forEach>
	 	</select>
	 <input type="submit" value="Filtrar">
	 <br></br>
	 
	 <c:forEach var="libro" items="${libros}">
	 	${libro.isbn} - ${libro.titulo} - ${libro.categoria} ->
	 	<a href="BorrarLibro.do?isbn=${libro.isbn}">Borrar</a>
	 	<a href="FormularioEditarLibro.do?isbn=${libro.isbn}">Editar</a>
	 	<br></br>
	 </c:forEach>   
	</form> 
	
	<a href="./FormularioInsertarLibro.do">Insertar Libro</a> 
	</body>
</html>    


