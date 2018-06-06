package com.arquitecturajava.aplicacion.controlador.acciones;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajava.dao.DAOAbstractFactory;
import com.arquitecturajava.dao.DAOFactory;
import com.arquitecturajava.negocio.Categoria;

public class FormularioInsertarLibroAccion extends Accion {

	@Override
	public void ejecutar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOFactory factoria = DAOAbstractFactory.getInstance();
		List<Categoria> listaCategorias = factoria.getCategoriaDAO().buscarTodos();
		request.setAttribute("listaDeCategorias", listaCategorias);
		RequestDispatcher dispatcher = request.getRequestDispatcher("FormularioInsertarLibro.jsp");
		dispatcher.forward(request, response);
	}
}
