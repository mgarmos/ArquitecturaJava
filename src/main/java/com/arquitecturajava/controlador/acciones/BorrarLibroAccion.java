package com.arquitecturajava.controlador.acciones;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajava.bean.Libro;
import com.arquitecturajava.negocio.ServicioLibros;
import com.arquitecturajava.negocio.ServicioLibrosImpl;

public class BorrarLibroAccion extends Accion {

	@Override
	public void ejecutar(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		ServicioLibros servicioLibros = new ServicioLibrosImpl();
		
		String isbn = request.getParameter("isbn");
		Libro libro = new Libro(isbn);
		
		//Borrar libro
		servicioLibros.borrarLibro(libro);

		response.sendRedirect("MostrarLibros.do");
	}
}
