package com.arquitecturajava.aplicacion.controlador.acciones;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajava.negocio.ServicioLibros;
import com.arquitecturajava.negocio.ServicioLibrosImpl;
import com.arquitecturajava.negocio.bean.Categoria;
import com.arquitecturajava.negocio.bean.Libro;

public class MostrarLibrosAccion extends Accion {

	@Override
	public void ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ServicioLibros servicioLibros = new ServicioLibrosImpl();

		// Cargar categorias
		List<Categoria> listaCategorias = servicioLibros.buscarCategoriasLibros();
		request.setAttribute("listaDeCategorias", listaCategorias);

		String categoria = request.getParameter("categoria");
		List<Libro> libros = null;

		if (categoria != null && !categoria.equals("")) {
			//Buscar libros por categoria
			libros =  servicioLibros.buscarLibrosPorCategoria(categoria);
			
		} else {
			//Buscar todos los libros
			libros =  servicioLibros.buscarTodosLosLibros();
		}
		request.setAttribute("libros", libros);

		// Se redirige a MostrarLibros
		RequestDispatcher dispatcher = request.getRequestDispatcher("MostrarLibros.jsp");
		dispatcher.forward(request, response);

	}
}
