package com.arquitecturajava.aplicacion.controlador.acciones;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajava.negocio.ServicioLibros;
import com.arquitecturajava.negocio.ServicioLibrosImpl;
import com.arquitecturajava.negocio.bean.Categoria;
import com.arquitecturajava.negocio.bean.Libro;

public class InsertarLibroAccion extends Accion {

	@Override
	public void ejecutar(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		ServicioLibros servicioLibros = new ServicioLibrosImpl();
		
		String isbn = request.getParameter("isbn");
		String titulo = request.getParameter("titulo");
		int categoria = Integer.parseInt(request.getParameter("categoria"));
		Libro libro = new Libro(isbn, titulo, new Categoria(categoria));
		
		//Alta de libro
		servicioLibros.insertarLibro(libro);

		response.sendRedirect("MostrarLibros.do");
	}
}
