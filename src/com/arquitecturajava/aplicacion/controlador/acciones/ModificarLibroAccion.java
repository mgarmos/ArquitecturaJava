package com.arquitecturajava.aplicacion.controlador.acciones;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajava.negocio.Categoria;
import com.arquitecturajava.negocio.Libro;

public class ModificarLibroAccion extends Accion {

	@Override
	public void ejecutar(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String isbn = request.getParameter("isbn");
		String titulo = request.getParameter("titulo");
		int categoria = Integer.parseInt(request.getParameter("categoria"));
		Libro libro = new Libro(isbn, titulo, new Categoria(categoria));
		libro.salvar();
		response.sendRedirect("MostrarLibros.do");
	}
}
