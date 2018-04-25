package com.arquitecturajava.controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.arquitecturajava.aplicacion.controlador.acciones.Accion;

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
		Accion accion = Accion.getAccion(request.getServletPath());
		accion.ejecutar(request, response);

	}
}