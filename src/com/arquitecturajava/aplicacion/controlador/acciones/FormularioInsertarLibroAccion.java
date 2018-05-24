package com.arquitecturajava.aplicacion.controlador.acciones;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajava.Categoria;
import com.arquitecturajava.Libro;

public class FormularioInsertarLibroAccion extends Accion {

	@Override
	public void ejecutar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Categoria> listaCategorias = Categoria.buscarTodasLasCategorias();
		request.setAttribute("listaDeCategorias", listaCategorias);
		RequestDispatcher dispatcher = request.getRequestDispatcher("FormularioInsertarLibro.jsp");
		dispatcher.forward(request, response);
	}

}
