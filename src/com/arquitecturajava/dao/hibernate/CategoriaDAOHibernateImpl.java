package com.arquitecturajava.dao.hibernate;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

import com.arquitecturajava.dao.CategoriaDAO;
import com.arquitecturajava.dao.HibernateHelper;
import com.arquitecturajava.negocio.Categoria;
import com.arquitecturajava.negocio.Libro;

public class CategoriaDAOHibernateImpl implements CategoriaDAO {
	private static final Logger log = Logger.getLogger(Libro.class.getPackage().getName());

	
	public List<Categoria> buscarTodasLasCategorias() {
		log.info("buscarTodasLasCategorias");
		Session session = null;
		List<Categoria> listaDeCategorias = null;
		
		try {
			session = HibernateHelper.getSessionFactory().openSession();
			Query consulta = session.createQuery("from Categoria categoria");
			listaDeCategorias = consulta.list();
		} finally {
			session.close();
		}
		return listaDeCategorias;
	}
}
