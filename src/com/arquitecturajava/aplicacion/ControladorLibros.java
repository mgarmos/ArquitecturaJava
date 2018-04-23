package com.arquitecturajava.aplicacion;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.arquitecturajava.Libro;

/**
 * Comunicación entre las distintas páginas
 *
 */
@WebServlet(name = "ControladorLibros", description = "Controlador de Libros", urlPatterns = { "*.do" })
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
		final Logger log = Logger.getLogger(ControladorLibros.class.getPackage().getName());

		RequestDispatcher dispatcher = null;
		log.info("petición: " + request.getServletPath());

		if (request.getServletPath().equals("/MostrarLibros.do")) {
			// delegan en la capa de persistencia y cargan la información que la página
			List<String> listaCategorias = Libro.buscarTodasLasCategorias();

			// Por ahora se hace en el jsp hasta se solucione el if por categoria para
			// devolver la lista de libros
			// List<Libro> listaLibros = Libro.buscarTodos();

			// Se pasa a la request
			// request.setAttribute("listaDeLibros", listaLibros);
			request.setAttribute("listaDeCategorias", listaCategorias);

			// Se redirige a MostrarLibros
			dispatcher = request.getRequestDispatcher("MostrarLibros.jsp");
			dispatcher.forward(request, response);

		} else if (request.getServletPath().equals("/FormularioInsertarLibro.do")) {
			List<String> listaCategorias = Libro.buscarTodasLasCategorias();
			request.setAttribute("listaDeCategorias", listaCategorias);
			dispatcher = request.getRequestDispatcher("FormularioInsertarLibro.jsp");
			dispatcher.forward(request, response);

		}  else if (request.getServletPath().equals("/FormularioEditarLibro.do")) {
			
			//Buscar libro por clave
			String isbn = request.getParameter("isbn");
			Libro libro = new Libro(isbn);
			libro = libro.buscarPorClave();
			request.setAttribute("libro", libro);
			
			//Cargar categorias
			List<String> categorias = Libro.buscarTodasLasCategorias();
			List<String> listaCategorias = Libro.buscarTodasLasCategorias();
			request.setAttribute("listaDeCategorias", listaCategorias);
			
			dispatcher = request.getRequestDispatcher("FormularioEditarLibro.jsp");
			dispatcher.forward(request, response);

		} else if (request.getServletPath().equals("/insertarLibro.do")) {
			log.info("..doy de alta el libro desde el servlet");
			String isbn = request.getParameter("isbn");
			String titulo = request.getParameter("titulo");
			String categoria = request.getParameter("categoria");
			Libro libro = new Libro(isbn, titulo, categoria);
			libro.insertar();
			//dispatcher = request.getRequestDispatcher("MostrarLibros.do");
			response.sendRedirect("MostrarLibros.do");
			
		} else if (request.getServletPath().equals("/BorrarLibro.do")) {
			String isbn = request.getParameter("isbn");
			Libro libro = new Libro(isbn);
			log.info("... borrando libro: " + libro.getIsbn());
			libro.borrar();
			response.sendRedirect("MostrarLibros.do");
			
		}  else if (request.getServletPath().equals("/SalvarLibro.do")) {
			String isbn = request.getParameter("isbn");
			String titulo = request.getParameter("titulo");
			String categoria = request.getParameter("categoria");
			
			Libro libro = new Libro(isbn, titulo, categoria); 
			libro.salvar();
			response.sendRedirect("MostrarLibros.do");
		}	
	}
}