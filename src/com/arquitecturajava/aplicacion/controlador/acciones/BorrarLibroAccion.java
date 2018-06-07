package com.arquitecturajava.aplicacion.controlador.acciones;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajava.negocio.ServicioLibros;
import com.arquitecturajava.negocio.ServicioLibrosImpl;
import com.arquitecturajava.negocio.bean.Libro;

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
