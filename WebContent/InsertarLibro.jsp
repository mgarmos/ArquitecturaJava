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
		
		//Redirigir la página
		response.sendRedirect("MostrarLibros.jsp");
		
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
    
    