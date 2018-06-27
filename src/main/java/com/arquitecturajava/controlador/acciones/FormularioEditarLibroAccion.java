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

public class FormularioEditarLibroAccion extends Accion {

	@Override
	public void ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Se delega la responsabilidad de instanciar el objeto en Spring
		// ServicioLibros servicioLibros = new ServicioLibrosImpl();
		ServicioLibros servicioLibros = (ServicioLibros) getBean("servicioLibros");

		// Buscar libro por clave
		String isbn = request.getParameter("isbn");
		Libro libro = servicioLibros.buscarLibroPorclave(isbn);
		request.setAttribute("libro", libro);

		// Cargar categorias
		List<Categoria> listaCategorias = servicioLibros.buscarCategoriasLibros();
		request.setAttribute("listaDeCategorias", listaCategorias);

		RequestDispatcher dispatcher = request.getRequestDispatcher("FormularioEditarLibro.jsp");
		dispatcher.forward(request, response);
	}

}
