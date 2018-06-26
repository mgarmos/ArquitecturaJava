package com.arquitecturajava.dao;

/**
 * Define tantos métodos de acceso a datos como clases de negocio hay en el modelo
 */
public interface DAOFactory {
	CategoriaDAO getCategoriaDAO();
	LibroDAO getLibroDAO();

}
