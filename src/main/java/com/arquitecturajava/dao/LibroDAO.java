package com.arquitecturajava.dao;

import java.util.List;

import com.arquitecturajava.bean.Libro;



public interface LibroDAO {

	void insertar(Libro libro);

	void salvar(Libro libro);

	Libro buscarPorClave(String isbn);

	List<Libro> buscarTodos();
	
	List<Libro> buscarPorCategoria(String categoria);

	void borrar(Libro libro);

}