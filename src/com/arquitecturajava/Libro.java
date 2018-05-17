package com.arquitecturajava;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.annotations.Table;

@Entity
@Table( appliesTo = "Libro" )
public class Libro {
	private static final Logger log = Logger.getLogger(Libro.class.getPackage().getName());

	public Libro() {
	}

	public Libro(String isbn) {
		super();
		this.isbn = isbn;
	}

	// TODO Habría que parsear las comillas simples
	public Libro(String isbn, String titulo, String categoria) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		this.categoria = categoria;
	}

	private String isbn;
	private String titulo;
	private String categoria;

	
	@Id
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public static Libro buscarPorClave(String isbn) {
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
			Query consulta = session.createQuery("from Libro libro where categoria = :categoria");
			consulta.setString("categoria", categoria);
			lista = consulta.list();
		} finally {
			session.close();
		}
		return lista;
	}

	public static List<String> buscarTodasLasCategorias() {
		log.info("buscarTodasLasCategorias");
		Session session = null;
		List<String> listaDeCategorias = null;
		
		try {
			session = HibernateHelper.getSessionFactory().openSession();
			String consulta = "Select distinct libro.categoria from Libro libro";
			listaDeCategorias = session.createQuery(consulta).list();
		} finally {
			session.close();
		}
		return listaDeCategorias;
	}

	/*
	 * Al consultar en SQLite deja la BBDD en modo SHARED. Al intentar iniciar otra
	 * transacción intenta coger el modo exclusive y falla.
	 */
	public static List<Libro> buscarTodos() {
		log.info("Entrando en BuscatTodos");
		Session session = null;
		List<Libro> lista = null;
		
		try {
			session = HibernateHelper.getSessionFactory().openSession();
			Query consulta = session.createQuery("from Libro libro");
			lista = consulta.list();;
		} finally {
			session.close();
		}

		return lista;
	}

	public void insertar() {
		log.info("Entrando en insertar");
		Session session = null;
		Transaction transaccion = null;
		try {
			session = HibernateHelper.getSessionFactory().openSession();
			
			transaccion = session.beginTransaction();
			session.save(this);
			transaccion.commit();
			
		} catch (Exception e) {
			log.info("-------------> Error: " + e.getMessage() + ". " + e.getCause());
			transaccion.rollback();
		} finally {
			session.close();
		}
		

		
	}

	public void borrar() {
		log.info("Entrando en borrar");
		Session session = null;
		Transaction transaccion = null;
		try {
			session = HibernateHelper.getSessionFactory().openSession();
			
			transaccion = session.beginTransaction();
			session.delete(this);
			transaccion.commit();
		} catch (Exception e) {
			log.info("-------------> Error: " + e.getMessage() + ". " + e.getCause());
			transaccion.rollback();
		} finally {
			session.close();
		}
		
	}

	public void salvar() {
		log.info("Entrando en salvar");
		Session session = null;
		Transaction transaccion = null;
		try {
			session = HibernateHelper.getSessionFactory().openSession();
			//transaccion = session.beginTransaction();
			transaccion = session.beginTransaction();
			session.saveOrUpdate(this);
			transaccion.commit();			
		} catch (Exception e) {
			log.info("-------------> Error: " + e.getMessage() + ". " + e.getCause());
			transaccion.rollback();
		} finally {
			session.close();
		}
		
	}

	@Override
	public String toString() {
		return "Libro [isbn=" + isbn + ", titulo=" + titulo + ", categoria=" + categoria + "]";
	}

}
