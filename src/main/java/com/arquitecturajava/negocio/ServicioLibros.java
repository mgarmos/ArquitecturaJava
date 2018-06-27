package com.arquitecturajava.negocio;

import java.util.List;

import com.arquitecturajava.bean.Categoria;
import com.arquitecturajava.bean.Libro;
import com.arquitecturajava.dao.CategoriaDAO;
import com.arquitecturajava.dao.LibroDAO;



/**
 * Define los métodos de negocio asociados con la funcionalidad de Libro
 */
public interface ServicioLibros {
	
	//Inyección de dependencias
	LibroDAO getLibroDAO();
	void setLibroDAO(LibroDAO libroDAO);
	
	CategoriaDAO getCategoriaDAO();
	void setCategoriaDAO(CategoriaDAO categoriaDAO);	
	
	//Métodos de negocio
	void salvarLibro(Libro libro);
	void insertarLibro(Libro libro);
	void borrarLibro(Libro libro);
	List<Libro> buscarTodosLosLibros();
	Libro buscarLibroPorclave(String id);
	List<Libro> buscarLibrosPorCategoria(String categoria);
	List<Categoria> buscarCategoriasLibros();
	Categoria buscarCategoriaPorClave(int categoria);
}
