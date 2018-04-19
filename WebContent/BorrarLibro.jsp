<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="com.aquitecturajava.Libro"%>
    
<%

	String isbn = request.getParameter("isbn");
	
	Libro libro = new Libro(isbn);
	System.out.println("... borrando libro: " + libro.getIsbn());
	libro.borrar();
	
	//Redirigir la página
	response.sendRedirect("MostrarLibros.jsp");	
%>    
    