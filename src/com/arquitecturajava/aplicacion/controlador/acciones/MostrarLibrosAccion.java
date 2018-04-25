package com.arquitecturajava.aplicacion.controlador.acciones;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajava.Libro;

public class MostrarLibrosAccion extends Accion {

	@Override
	public void ejecutar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// delegan en la capa de persistencia y cargan la información que la página
		List<String> listaCategorias = Libro.buscarTodasLasCategorias();
		request.setAttribute("listaDeCategorias", listaCategorias);

		String categoria = request.getParameter("categoria");
		List<Libro> libros = null;

		if (categoria != null && !categoria.equals("")) {
			libros = Libro.buscarPorCategoria(categoria);
		} else {
			libros = Libro.buscarTodos();
		}
		request.setAttribute("libros", libros);

		// Se redirige a MostrarLibros
		RequestDispatcher dispatcher = request.getRequestDispatcher("MostrarLibros.jsp");
		dispatcher.forward(request, response);
	}
}
