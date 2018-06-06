package com.arquitecturajava.aplicacion.controlador.acciones;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajava.dao.CategoriaDAO;
import com.arquitecturajava.dao.DAOAbstractFactory;
import com.arquitecturajava.dao.DAOFactory;
import com.arquitecturajava.dao.LibroDAO;
import com.arquitecturajava.dao.hibernate.LibroDAOHibernateImpl;
import com.arquitecturajava.negocio.Categoria;
import com.arquitecturajava.negocio.Libro;

public class MostrarLibrosAccion extends Accion {

	@Override
	public void ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DAOFactory factoria = DAOAbstractFactory.getInstance();

		// delegan en la capa de persistencia y cargan la información que la página
		CategoriaDAO categoriaDAO = factoria.getCategoriaDAO();
		List<Categoria> listaCategorias = categoriaDAO.buscarTodos();
		request.setAttribute("listaDeCategorias", listaCategorias);

		String categoria = request.getParameter("categoria");
		List<Libro> libros = null;

		if (categoria != null && !categoria.equals("")) {
			libros = LibroDAOHibernateImpl.buscarPorCategoria(categoria);
		} else {
			LibroDAO libroDAO = factoria.getLibroDAO();
			libros = libroDAO.buscarTodos();
		}
		request.setAttribute("libros", libros);

		// Se redirige a MostrarLibros
		RequestDispatcher dispatcher = request.getRequestDispatcher("MostrarLibros.jsp");
		dispatcher.forward(request, response);

	}
}
