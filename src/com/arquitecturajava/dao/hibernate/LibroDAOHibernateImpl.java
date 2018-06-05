package com.arquitecturajava.dao.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.arquitecturajava.dao.LibroDAO;
import com.arquitecturajava.negocio.Libro;

public class LibroDAOHibernateImpl extends GenericDAOHibernateImpl<Libro, String> implements LibroDAO {
	
	public static List<Libro> buscarPorCategoria(String categoria) {
		Session session = null;
		List<Libro> lista = null;
				
		try {
			session = HibernateHelper.getSessionFactory().openSession();
			Query consulta = session.createQuery("from Libro libro inner join fetch libro.categoria where categoria = :categoria");
			consulta.setString("categoria", categoria);
			lista = consulta.list();
		} finally {
			session.close();
		}
		return lista;
	}
	
	/**
	 * Se sobrescribe el método para optimizar la consulta
	 */
	@Override
	public List<Libro> buscarTodos() {
		Session session = null;
		List<Libro> lista = null;
		
		try {
			session = HibernateHelper.getSessionFactory().openSession();
			Query consulta = session.createQuery("from Libro libro inner join fetch libro.categoria");
			lista = consulta.list();
		} finally {
			session.close();
		}

		return lista;
}
	

}
