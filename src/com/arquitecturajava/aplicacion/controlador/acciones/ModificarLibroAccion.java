package com.arquitecturajava.aplicacion.controlador.acciones;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajava.dao.DAOAbstractFactory;
import com.arquitecturajava.dao.DAOFactory;
import com.arquitecturajava.dao.LibroDAO;
import com.arquitecturajava.negocio.Categoria;
import com.arquitecturajava.negocio.Libro;

public class ModificarLibroAccion extends Accion {

	@Override
	public void ejecutar(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String isbn = request.getParameter("isbn");
		String titulo = request.getParameter("titulo");
		int categoria = Integer.parseInt(request.getParameter("categoria"));
		Libro libro = new Libro(isbn, titulo, new Categoria(categoria));
		DAOFactory factoria = DAOAbstractFactory.getInstance();
		LibroDAO libroDAO = factoria.getLibroDAO();
		libroDAO.salvar(libro);
		response.sendRedirect("MostrarLibros.do");
	}
}
