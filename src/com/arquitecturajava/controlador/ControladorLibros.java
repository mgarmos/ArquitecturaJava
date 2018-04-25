package com.arquitecturajava.controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.arquitecturajava.aplicacion.controlador.acciones.Accion;
import com.arquitecturajava.aplicacion.controlador.acciones.BorrarLibroAccion;
import com.arquitecturajava.aplicacion.controlador.acciones.FormularioEditarLibroAccion;
import com.arquitecturajava.aplicacion.controlador.acciones.FormularioInsertarLibroAccion;
import com.arquitecturajava.aplicacion.controlador.acciones.InsertarLibroAccion;
import com.arquitecturajava.aplicacion.controlador.acciones.ModificarLibroAccion;
import com.arquitecturajava.aplicacion.controlador.acciones.MostrarLibrosAccion;

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

		log.info("petición: " + request.getServletPath());
		
		Accion accion = null;		
		if (request.getServletPath().equals("/MostrarLibros.do")) {
			accion = new MostrarLibrosAccion();

		} else if (request.getServletPath().equals("/FormularioInsertarLibro.do")) {
			accion = new FormularioInsertarLibroAccion();

		} else if (request.getServletPath().equals("/FormularioEditarLibro.do")) {
			accion = new FormularioEditarLibroAccion();

		} else if (request.getServletPath().equals("/insertarLibro.do")) {
			accion = new InsertarLibroAccion();

		} else if (request.getServletPath().equals("/BorrarLibro.do")) {
			accion = new BorrarLibroAccion();

		} else if (request.getServletPath().equals("/SalvarLibro.do")) {
			accion = new ModificarLibroAccion();

		}
		accion.ejecutar(request, response);
	}
}