package com.arquitecturajava.aplicacion.controlador.acciones;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Accion {

	public abstract void ejecutar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	
	public static Accion getAccion(String peticion) {
		Accion accion = null;
		
		if (peticion.equals("/MostrarLibros.do")) {
			accion = new MostrarLibrosAccion();

		} else if (peticion.equals("/FormularioInsertarLibro.do")) {
			accion = new FormularioInsertarLibroAccion();

		} else if (peticion.equals("/FormularioEditarLibro.do")) {
			accion = new FormularioEditarLibroAccion();

		} else if (peticion.equals("/insertarLibro.do")) {
			accion = new InsertarLibroAccion();

		} else if (peticion.equals("/BorrarLibro.do")) {
			accion = new BorrarLibroAccion();

		} else if (peticion.equals("/SalvarLibro.do")) {
			accion = new ModificarLibroAccion();
		}		
		
		return accion;
	}

}
