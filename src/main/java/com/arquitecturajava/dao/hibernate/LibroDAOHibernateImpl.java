package com.arquitecturajava.dao.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.arquitecturajava.bean.Libro;
import com.arquitecturajava.dao.LibroDAO;

public class LibroDAOHibernateImpl extends GenericDAOHibernateImpl<Libro, String> implements LibroDAO {

	@SuppressWarnings("unchecked")
	public List<Libro> buscarPorCategoria(String categoria) {
		Session session = null;
		Transaction transaccion = null;
		List<Libro> lista = null;

		try {
			session = HibernateHelper.getSessionFactory().openSession();
			transaccion = session.beginTransaction();
			Query consulta = session
					.createQuery("from Libro libro inner join fetch libro.categoria where categoria = :categoria");
			consulta.setString("categoria", categoria);
			lista = (List<Libro>)consulta.list();
			transaccion.commit();
		} catch (Exception e) {
			transaccion.rollback();
			throw e;			
		} finally {
			session.close();
		}
		return lista;
	}

	/**
	 * Se sobrescribe el método para optimizar la consulta
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Libro> buscarTodos() {
		Session session = null;
		Transaction transaccion = null;
		List<Libro> lista = null;

		try {
			session = HibernateHelper.getSessionFactory().openSession();
			transaccion = session.beginTransaction();
			Query consulta = session.createQuery("from Libro libro inner join fetch libro.categoria");
			lista = (List<Libro>)consulta.list();
			transaccion.commit();
		} catch (Exception e) {
			transaccion.rollback();
			throw e;			
		} finally {
			session.close();
		}

		return lista;
	}

}
