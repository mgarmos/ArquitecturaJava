package com.arquitecturajava.aplicacion.controlador.acciones;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajava.dao.CategoriaDAO;
import com.arquitecturajava.dao.hibernate.CategoriaDAOHibernateImpl;
import com.arquitecturajava.negocio.Categoria;

public class FormularioInsertarLibroAccion extends Accion {

	@Override
	public void ejecutar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategoriaDAO categoriaDAO = new CategoriaDAOHibernateImpl();
		List<Categoria> listaCategorias = categoriaDAO.buscarTodasLasCategorias();
		request.setAttribute("listaDeCategorias", listaCategorias);
		RequestDispatcher dispatcher = request.getRequestDispatcher("FormularioInsertarLibro.jsp");
		dispatcher.forward(request, response);
	}

}
