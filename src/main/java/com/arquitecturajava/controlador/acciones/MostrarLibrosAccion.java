package com.arquitecturajava.controlador.acciones;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajava.bean.Categoria;
import com.arquitecturajava.bean.Libro;
import com.arquitecturajava.negocio.ServicioLibros;

public class MostrarLibrosAccion extends Accion {

	@Override
	public void ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Se delega la responsabilidad de instanciar el objeto en Spring
		// ServicioLibros servicioLibros = new ServicioLibrosImpl();
		ServicioLibros servicioLibros = (ServicioLibros) getBean("servicioLibros");

		// Cargar categorias
		List<Categoria> listaCategorias = servicioLibros.buscarCategoriasLibros();
		request.setAttribute("listaDeCategorias", listaCategorias);

		String categoria = request.getParameter("categoria");
		List<Libro> libros = null;

		if (categoria != null && !categoria.equals("")) {
			// Buscar libros por categoria
			libros = servicioLibros.buscarLibrosPorCategoria(categoria);

		} else {
			// Buscar todos los libros
			libros = servicioLibros.buscarTodosLosLibros();
		}
		request.setAttribute("libros", libros);

		// Se redirige a MostrarLibros
		RequestDispatcher dispatcher = request.getRequestDispatcher("MostrarLibros.jsp");
		dispatcher.forward(request, response);

	}
}
