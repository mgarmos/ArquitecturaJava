package com.arquitecturajava.aplicacion.controlador.acciones;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajava.negocio.Libro;

public class BorrarLibroAccion extends Accion {

	@Override
	public void ejecutar(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String isbn = request.getParameter("isbn");
		Libro libro = new Libro(isbn);
		libro.borrar();
		response.sendRedirect("MostrarLibros.do");
	}
}
