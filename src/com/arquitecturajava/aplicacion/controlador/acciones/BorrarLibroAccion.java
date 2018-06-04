package com.arquitecturajava.aplicacion.controlador.acciones;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajava.dao.LibroDAO;
import com.arquitecturajava.dao.hibernate.LibroDAOHibernateImpl;
import com.arquitecturajava.negocio.Libro;

public class BorrarLibroAccion extends Accion {

	@Override
	public void ejecutar(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String isbn = request.getParameter("isbn");
		Libro libro = new Libro(isbn);
		LibroDAO libroDAO = new LibroDAOHibernateImpl();
		libroDAO.borrar(libro);
		response.sendRedirect("MostrarLibros.do");
	}
}
