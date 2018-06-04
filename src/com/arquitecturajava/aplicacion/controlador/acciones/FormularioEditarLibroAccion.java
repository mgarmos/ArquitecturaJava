package com.arquitecturajava.aplicacion.controlador.acciones;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajava.dao.CategoriaDAO;
import com.arquitecturajava.dao.LibroDAO;
import com.arquitecturajava.dao.hibernate.CategoriaDAOHibernateImpl;
import com.arquitecturajava.dao.hibernate.LibroDAOHibernateImpl;
import com.arquitecturajava.negocio.Categoria;
import com.arquitecturajava.negocio.Libro;

public class FormularioEditarLibroAccion extends Accion {

	@Override
	public void ejecutar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Buscar libro por clave
		String isbn = request.getParameter("isbn");
		LibroDAO daoHibernateImpl = new LibroDAOHibernateImpl();
		Libro libro = daoHibernateImpl.buscarPorClave(isbn);
		request.setAttribute("libro", libro);

		// Cargar categorias
		CategoriaDAO categoriaDAO = new CategoriaDAOHibernateImpl();
		List<Categoria> listaCategorias = categoriaDAO.buscarTodasLasCategorias();
		request.setAttribute("listaDeCategorias", listaCategorias);

		RequestDispatcher dispatcher = request.getRequestDispatcher("FormularioEditarLibro.jsp");
		dispatcher.forward(request, response);
	}

}
