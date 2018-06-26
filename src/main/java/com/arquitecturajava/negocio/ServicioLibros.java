package com.arquitecturajava.negocio;

import java.util.List;

import com.arquitecturajava.bean.Categoria;
import com.arquitecturajava.bean.Libro;



/**
 * Define los métodos de negocio asociados con la funcionalidad de Libro
 */
public interface ServicioLibros {
	void salvarLibro(Libro libro);
	void insertarLibro(Libro libro);
	void borrarLibro(Libro libro);
	List<Libro> buscarTodosLosLibros();
	Libro buscarLibroPorclave(String id);
	List<Libro> buscarLibrosPorCategoria(String categoria);
	List<Categoria> buscarCategoriasLibros();
	Categoria buscarCategoriaPorClave(int categoria);
}
