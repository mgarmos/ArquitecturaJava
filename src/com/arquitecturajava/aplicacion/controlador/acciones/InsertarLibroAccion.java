package com.arquitecturajava.aplicacion.controlador.acciones;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajava.dao.LibroDAO;
import com.arquitecturajava.dao.LibroDAOFactory;
import com.arquitecturajava.negocio.Categoria;
import com.arquitecturajava.negocio.Libro;

public class InsertarLibroAccion extends Accion {

	@Override
	public void ejecutar(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String isbn = request.getParameter("isbn");
		String titulo = request.getParameter("titulo");
		int categoria = Integer.parseInt(request.getParameter("categoria"));
		Libro libro = new Libro(isbn, titulo, new Categoria(categoria));
		LibroDAO libroDAO = LibroDAOFactory.getInstance();
		libroDAO.insertar(libro);
		response.sendRedirect("MostrarLibros.do");
	}
}
