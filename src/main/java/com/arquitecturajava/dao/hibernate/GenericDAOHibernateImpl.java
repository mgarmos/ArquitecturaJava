package com.arquitecturajava.dao.hibernate;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.exception.GenericJDBCException;

import com.arquitecturajava.controlador.ControladorLibros;
import com.arquitecturajava.dao.GenericDAO;

/* Hacer que Session se inyecte mediante Spring:
 * https://docs.spring.io/spring/docs/3.0.x/spring-framework-reference/html/orm.html#orm-session-factory-setup
 */

public abstract class GenericDAOHibernateImpl<T, Id extends Serializable> implements GenericDAO<T, Id> {
	final Logger log = Logger.getLogger(ControladorLibros.class.getPackage().getName());
	
	private Class<T> claseDePersistencia;
	private SessionFactory sessionFactory;


	@SuppressWarnings("unchecked")
	public GenericDAOHibernateImpl() {
		
		//Comento para inyectar con Spring
		//this.sessionFactory = HibernateHelper.getSessionFactory();
		this.claseDePersistencia = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	public void salvar(T objeto) {		

		Session session = null;
		Transaction transaccion = null;
		try {
			session = sessionFactory.openSession();
			transaccion = session.beginTransaction();
			session.saveOrUpdate(objeto);
			transaccion.commit();
		} catch (Exception e) {
			transaccion.rollback();
			throw e;
		} finally {
			session.close();
		}
	}

	public void borrar(T objeto) {
		Session session = null;
		Transaction transaccion = null;
		try {
			session = sessionFactory.openSession();

			transaccion = session.beginTransaction();
			session.delete(objeto);
			transaccion.commit();
		} catch (Exception e) {
			transaccion.rollback();
			throw e;
		} finally {
			session.close();
		}
	}

	public void insertar(T objeto) {
		Session session = null;
		Transaction transaccion = null;
		try {
			session = sessionFactory.openSession();
			transaccion = session.beginTransaction();
			session.save(objeto);
			transaccion.commit();

		} catch (Exception e) {
			transaccion.rollback();
			throw e;
		} finally {
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	public T buscarPorClave(Id id) {
		Session session = null;
		Transaction transaccion = null;
		T objeto = null;
		try {
			session = sessionFactory.openSession();
			transaccion = session.beginTransaction();
			objeto = (T) session.get(claseDePersistencia, id);
			transaccion.commit();
		} catch (Exception e) {
			transaccion.rollback();
			throw e;
		} finally {
			session.close();
		}

		return objeto;
	}

	@SuppressWarnings("unchecked")
	public List<T> buscarTodos() {
		
		
		Session session = null;
		Transaction transaccion = null;
		List<T> lista = null;

		try {
			session = sessionFactory.openSession();
			
			transaccion = session.beginTransaction();
			Query consulta = session.createQuery("from " + claseDePersistencia.getSimpleName() + " o");
			lista = (List<T>) consulta.list();
			transaccion.commit();
		} catch (GenericJDBCException gexc) {
			log.error("---ERROR----" + gexc.getMessage() + ". " + gexc.getCause());
			
		} catch (Exception e) {
			log.error("---ERROR----" + e.getMessage() + ". " + e.getClass().getSimpleName());
			transaccion.rollback();
			throw e;
		} finally {
			session.close();
		}

		return lista;
	}
	
	
	// Metodos de inyección
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
