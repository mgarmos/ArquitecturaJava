package com.arquitecturajava.dao.hibernate;

import com.arquitecturajava.dao.CategoriaDAO;
import com.arquitecturajava.dao.DAOFactory;
import com.arquitecturajava.dao.LibroDAO;

public class DAOHibernateFactory implements DAOFactory {

	@Override
	public CategoriaDAO getCategoriaDAO() {
		return new CategoriaDAOHibernateImpl();
	}

	@Override
	public LibroDAO getLibroDAO() {
		return new LibroDAOHibernateImpl();
	}

}
