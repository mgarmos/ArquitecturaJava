package com.arquitecturajava.dao.hibernate;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.arquitecturajava.dao.HibernateHelper;
import com.arquitecturajava.dao.LibroDAO;
import com.arquitecturajava.negocio.Libro;

public class LibroDAOHibernateImpl implements LibroDAO {
	private static final Logger log = Logger.getLogger(Libro.class.getPackage().getName());

	/* (non-Javadoc)
	 * @see com.arquitecturajava.dao.hibernate.LibroDAO#insertar(com.arquitecturajava.negocio.Libro)
	 */
	@Override
	public void insertar(Libro libro) {
		log.info("Entrando en insertar");
		Session session = null;
		Transaction transaccion = null;
		try {
			session = HibernateHelper.getSessionFactory().openSession();
			
			transaccion = session.beginTransaction();
			session.save(libro);
			transaccion.commit();
			
		} catch (Exception e) {
			log.info("-------------> Error: " + e.getMessage() + ". " + e.getCause());
			transaccion.rollback();
		} finally {
			session.close();
		}
	}
	
	/* (non-Javadoc)
	 * @see com.arquitecturajava.dao.hibernate.LibroDAO#salvar(com.arquitecturajava.negocio.Libro)
	 */
	@Override
	public void salvar(Libro libro) {
		log.info("Entrando en salvar");
		Session session = null;
		Transaction transaccion = null;
		try {
			session = HibernateHelper.getSessionFactory().openSession();
			//transaccion = session.beginTransaction();
			transaccion = session.beginTransaction();
			session.saveOrUpdate(libro);
			transaccion.commit();			
		} catch (Exception e) {
			log.info("-------------> Error: " + e.getMessage() + ". " + e.getCause());
			transaccion.rollback();
		} finally {
			session.close();
		}
	}	
	
	/* (non-Javadoc)
	 * @see com.arquitecturajava.dao.hibernate.LibroDAO#buscarPorClave(java.lang.String)
	 */
	@Override
	public Libro buscarPorClave(String isbn) {
		log.info("Entrando en buscarPorClave");
		Session session = null;
		Libro libro = null;
		try {
			session = HibernateHelper.getSessionFactory().openSession();
			libro = (Libro) session.get(Libro.class, isbn);		
		} finally {
			session.close();
		}

		return libro;
	}

	public static List<Libro> buscarPorCategoria(String categoria) {
		log.info("Entrando en buscarPorCategoria");
		Session session = null;
		List<Libro> lista = null;
				
		try {
			session = HibernateHelper.getSessionFactory().openSession();
			//Query consulta = session.createQuery("from Libro libro where categoria = :categoria");
			Query consulta = session.createQuery("from Libro libro inner join fetch libro.categoria where categoria = :categoria");
			consulta.setString("categoria", categoria);
			lista = consulta.list();
		} finally {
			session.close();
		}
		return lista;
	}



	/*
	 * Al consultar en SQLite deja la BBDD en modo SHARED. Al intentar iniciar otra
	 * transacción intenta coger el modo exclusive y falla.
	 */
	/* (non-Javadoc)
	 * @see com.arquitecturajava.dao.hibernate.LibroDAO#buscarTodos()
	 */
	@Override
	public List<Libro> buscarTodos() {
		log.info("Entrando en BuscatTodos");
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


	/* (non-Javadoc)
	 * @see com.arquitecturajava.dao.hibernate.LibroDAO#borrar(com.arquitecturajava.negocio.Libro)
	 */
	@Override
	public void borrar(Libro libro) {
		log.info("Entrando en borrar");
		Session session = null;
		Transaction transaccion = null;
		try {
			session = HibernateHelper.getSessionFactory().openSession();
			
			transaccion = session.beginTransaction();
			session.delete(libro);
			transaccion.commit();
		} catch (Exception e) {
			log.info("-------------> Error: " + e.getMessage() + ". " + e.getCause());
			transaccion.rollback();
		} finally {
			session.close();
		}		
	}	
}
