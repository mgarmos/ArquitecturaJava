package mgr;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PruebaConexion {
	private static final String DRIVER = "org.sqlite.JDBC";
	private static final String URL = "jdbc:sqlite:D:\\Usuarios\\Magarami\\eclipse-workspace\\ArquitecturaJava\\BBDD\\arquitecturajava.db";
	
	public static void main(String[] args) {
		//select();
		//insert("2","Pepe", "Art");
		select();
	}
	
	public static void select() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			//Cargar el driver
			Class.forName(DRIVER);
			
			
			System.out.println("Antes de abrir la conexion");
			//Crear la conexion
			conn = DriverManager.getConnection(URL);
			pstmt = conn.prepareStatement("Select * from LIBRO");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println("isbn: " + rs.getString("isbn"));
				System.out.println("titulo: " + rs.getString("titulo"));
				System.out.println("categoria: " + rs.getString("categoria"));
			}

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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	//PEndiente de implementar
	public static void insert(String isbn, String titulo, String categoria) {
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
			System.out.println();
			
			pstmt.setString(1, isbn);
			pstmt.setString(2, titulo);
			pstmt.setString(3, categoria);
			
			pstmt.executeUpdate();

			
			
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}	

}
