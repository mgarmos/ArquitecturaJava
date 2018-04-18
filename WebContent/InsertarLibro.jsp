<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- sentencias de import necesarias para jdbc-->
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.SQLException"%>
    
<%
	String DRIVER = "org.sqlite.JDBC";
	String URL = "jdbc:sqlite:D:\\Usuarios\\Magarami\\eclipse-workspace\\ArquitecturaJava\\BBDD\\arquitecturajava.db";


	String isbn = request.getParameter("isbn");
	System.out.println("isbn: " + isbn);
	
	String titulo = request.getParameter("titulo");
	System.out.println("titulo: " + titulo);
	
	String categoria = request.getParameter("categoria");
	System.out.println("categoria: " + categoria);
	
	//Se carga el driver - Copiado de prueba conexión
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	String SQL = "Insert into LIBRO (isbn, titulo, categoria) values (?,?,?)";
	try {
		
		//Cargar el driver
		Class.forName(DRIVER);
		
		
		System.out.println("Antes de abrir la conexion");
		//Crear la conexion
		conn = DriverManager.getConnection(URL);
		pstmt = conn.prepareStatement(SQL);
		System.out.println("SQL: " + SQL);
		
		pstmt.setString(1, isbn);
		pstmt.setString(2, titulo);
		pstmt.setString(3, categoria);
		
		pstmt.executeUpdate();
		System.out.println("Ejecución correcta");
		
		
		
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
    
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Formulario Libro</title>
<link rel="stylesheet" type="text/css" href="css/formato.css"></link>
<script type="text/javascript" src="js/validacion.js"></script>
</head>
	<body>
	<form id="miformulario" action="MostrarLibros.jsp" onsubmit="return validacion();">
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
				<label for="titulo">Categoría:</label>
				<input id= "categoria" type="text" name="categoria" ></input>
			</p>
			
		</fieldset>
		<input type="submit" value="Insertar"></input>
	</form>
	</body>
</html>