package com.arquitecturajava.dao;

import java.util.List;

import com.arquitecturajava.negocio.Libro;

public interface LibroDAO {

	void insertar(Libro libro);

	void salvar(Libro libro);

	Libro buscarPorClave(String isbn);

	/*
	 * Al consultar en SQLite deja la BBDD en modo SHARED. Al intentar iniciar otra
	 * transacción intenta coger el modo exclusive y falla.
	 */
	List<Libro> buscarTodos();

	void borrar(Libro libro);

}