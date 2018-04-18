<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- sentencias de import necesarias para jdbc-->
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.SQLException"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Formulario Libro</title>
<link rel="stylesheet" type="text/css" href="css/formato.css"></link>
<script type="text/javascript" src="js/validacion.js"></script>
</head>
	<body>    
<%
	String DRIVER = "org.sqlite.JDBC";
	String URL = "jdbc:sqlite:D:\\Usuarios\\Magarami\\eclipse-workspace\\ArquitecturaJava\\BBDD\\arquitecturajava.db";


/* 	String isbn = request.getParameter("isbn");
	System.out.println("isbn: " + isbn);
	
	String titulo = request.getParameter("titulo");
	System.out.println("titulo: " + titulo);
	
	String categoria = request.getParameter("categoria");
	System.out.println("categoria: " + categoria); */
	
	//Se carga el driver - Copiado de prueba conexión
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String SQL = "Insert into LIBRO (isbn, titulo, categoria) values (?,?,?)";
	try {
		
		//Cargar el driver
		Class.forName(DRIVER);
		
		
		System.out.println("Antes de abrir la conexion");
		//Crear la conexion
		conn = DriverManager.getConnection(URL);
		pstmt = conn.prepareStatement("Select * from LIBRO");
		rs = pstmt.executeQuery();
		while(rs.next()) {
		%>	
			<%=rs.getString("isbn") %>
			<%=rs.getString("titulo") %>
			<%=rs.getString("categoria") %><br></br>
		<%
		}
		%>
			<a href="./InsertarLibro.jsp">Insertar Libro</a>
		<%
		
		
	} catch (ClassNotFoundException e) {
		System.out.println("No se ha encontrado el driver. " + e.getMessage());
		e.printStackTrace();
	} catch (SQLException sqlex) {
		// TODO: handle exception
		System.out.println("Error al acceder a BBDD. " + sqlex.getMessage() + ". Código de error: " + sqlex.getErrorCode());
		sqlex.printStackTrace();
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println(e.getMessage());
		e.printStackTrace();
	} finally {
		try {
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
%>    
    
	</body>
</html>    


