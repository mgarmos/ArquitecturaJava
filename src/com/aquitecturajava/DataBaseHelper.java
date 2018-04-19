package com.aquitecturajava;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DataBaseHelper<T> {
	private static final String DRIVER = "org.sqlite.JDBC";
	private static final String URL = "jdbc:sqlite:D:\\Usuarios\\Magarami\\eclipse-workspace\\ArquitecturaJava\\BBDD\\arquitecturajava.db";
	
	
	public int modificarRegistro(String consultaSQL) throws DataBaseException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int filasAfectadas = 0;
		
		try {
			Class.forName(DRIVER);
			
			System.out.println("Antes de abrir la conexion");
			//Crear la conexion
			conn = DriverManager.getConnection(URL);
			
			System.out.println("consultaSQL: " + consultaSQL);
			pstmt = conn.prepareStatement(consultaSQL);
			
			filasAfectadas = pstmt.executeUpdate();
			System.out.println("Ejecución correcta: " + filasAfectadas);		
			
		} catch (ClassNotFoundException e) {
			System.out.println("No se ha encontrado el driver. " + e.getMessage());
			throw new DataBaseException("No se ha encontrado el driver", e);
			
		} catch (SQLException sqlex) {
			System.out.println("Error al acceder a BBDD. " + sqlex.getMessage() + ". Código de error: " + sqlex.getErrorCode());
			throw new DataBaseException("Error al acceder a BBDD", sqlex);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new DataBaseException("Error de SQL");
			
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return filasAfectadas;
	}
	
	@SuppressWarnings("unchecked")
	public List<T> seleccionarRegistros(String consultaSQL, Class clase) throws DataBaseException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<T> resultado = new ArrayList<T>();
		try {
			//Cargar el driver
			Class.forName(DRIVER);			
			
			
			//Crear la conexion
			conn = DriverManager.getConnection(URL);
			pstmt = conn.prepareStatement(consultaSQL);
			System.out.println("seleccionarRegistros() - consultaSQL: " + consultaSQL);
			rs = pstmt.executeQuery();
			System.out.println("seleccionarRegistros() - Ejecución correcta");
			
			while (rs.next()) {
				//Tengo que instanciar un objeto (Class.forname()
				T objeto = (T) Class.forName(clase.getName()).newInstance();
				
				//.. y acceder a sus setters mediante Method[]
				Method[] metodos = objeto.getClass().getMethods();
				
				//Busco los setters
				for (int i=0; i< metodos.length;i++) {
					
					String metodo = metodos[i].getName();
					if (metodo.startsWith("set")) {
						//Ahora hay que casar cada método con su campo (Por nombre)
						metodos[i].invoke(objeto, rs.getString(metodo.substring(3)));
					}
					
					// Si se le llama con un String
					if(objeto.getClass().getName().equals("java.lang.String")) {
						objeto = (T)rs.getString(1);
					}
				}
				//Se añade el objeto a la lista
				resultado.add(objeto);
				
			}

		} catch (ClassNotFoundException e) {
			System.out.println("No se ha encontrado el driver. " + e.getMessage());
			throw new DataBaseException("No se ha encontrado el driver", e);
		} catch (SQLException sqlex) {
			System.out.println("Error al acceder a BBDD. " + sqlex.getMessage() + ". Código de error: " + sqlex.getErrorCode());
			throw new DataBaseException("Error al acceder a BBDD", sqlex);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new DataBaseException("Error de SQL", e);
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
		
		return resultado;
	}
	
	
}
