package com.arquitecturajava.controlador.acciones;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Accion {

	public abstract void ejecutar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	
	public static Accion getAccion(String peticion) {
		
		Accion accion = null;
		
		//TODO No debería estar puesto a fuego
		String className = "com.arquitecturajava.controlador.acciones." + peticion.substring(1,peticion.length()-3) + "Accion";
		
		try {
			accion = (Accion)Class.forName(className).newInstance();
		} catch (InstantiationException e ) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("No se ha encontraado la clase: " + e.getLocalizedMessage());
			e.printStackTrace();
		}
				
		
		return accion;
	}

}
