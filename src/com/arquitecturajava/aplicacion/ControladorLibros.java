package com.arquitecturajava.aplicacion;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajava.Libro;

/**
 * Comunicación entre las distintas páginas
 *
 */
@WebServlet(
		name = "ControladorLibros", 
		description = "Controlador de Libros", 
		urlPatterns = { "/ControladorLibros" }
		)
public class ControladorLibros extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/*
	 * Se encarga de cargar la lista de categorías, la lista de libros y visualizar
	 * llamando MostrarLibros
	 * 
	 * @see
	 * javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = null;

		//delegan en la capa de persistencia y cargan la información que la página
		List<String> listaCategorias = Libro.buscarTodasLasCategorias();
		
		//Por ahora se hace en el jsp hasta se solucione el if por categoria para devolver la lista de libros
		//List<Libro> listaLibros = Libro.buscarTodos();		

		// Se pasa a la request
		//request.setAttribute("listaDeLibros", listaLibros);
		request.setAttribute("listaDeCategorias", listaCategorias);

		// Se redirige a MostrarLibros
		dispatcher = request.getRequestDispatcher("MostrarLibros.jsp");
		dispatcher.forward(request, response);
	}
}