package com.arquitecturajava.controlador.acciones;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajava.bean.Categoria;
import com.arquitecturajava.bean.Libro;
import com.arquitecturajava.negocio.ServicioLibros;

public class ModificarLibroAccion extends Accion {

	@Override
	public void ejecutar(HttpServletRequest request, HttpServletResponse response) throws IOException {

		// Se delega la responsabilidad de instanciar el objeto en Spring
		// ServicioLibros servicioLibros = new ServicioLibrosImpl();
		ServicioLibros servicioLibros = (ServicioLibros) getBean("servicioLibros");

		String isbn = request.getParameter("isbn");
		String titulo = request.getParameter("titulo");
		int categoria = Integer.parseInt(request.getParameter("categoria"));
		Libro libro = new Libro(isbn, titulo, new Categoria(categoria));

		// Insertar libro
		servicioLibros.salvarLibro(libro);

		response.sendRedirect("MostrarLibros.do");
	}
}
