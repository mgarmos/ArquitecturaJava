package com.arquitecturajava.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Interfaz de tipo genérico que define las operaciones comunes de los DAO's
 *
 */
public interface GenericDAO<T, Id extends Serializable> {
	void salvar(T objeto);
	void borrar(T objeto);
	void insertar(T objeto);
	T buscarPorClave(Id id);
	List<T> buscarTodos();
}
