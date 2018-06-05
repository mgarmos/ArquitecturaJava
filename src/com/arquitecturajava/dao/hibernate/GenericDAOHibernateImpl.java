package com.arquitecturajava.dao.hibernate;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.arquitecturajava.dao.GenericDAO;

public abstract class GenericDAOHibernateImpl<T, Id extends Serializable> implements GenericDAO<T, Id> {

	private Class<T> claseDePersistencia;
	
	public GenericDAOHibernateImpl() {
		this.claseDePersistencia = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}	

	public void salvar(T objeto) {
		Session session = null;
		Transaction transaccion = null;
		try {
			session = HibernateHelper.getSessionFactory().openSession();
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
			session = HibernateHelper.getSessionFactory().openSession();

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
			session = HibernateHelper.getSessionFactory().openSession();
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

	public T buscarPorClave(Id id) {
		Session session = null;
		T objeto = null;
		try {
			session = HibernateHelper.getSessionFactory().openSession();
			objeto = (T) session.get(claseDePersistencia, id);
		} finally {
			session.close();
		}

		return objeto;
	}
	
	public List<T> buscarTodos() {
		Session session = null;
		List<T> lista = null;
		
		try {
			session = HibernateHelper.getSessionFactory().openSession();
			Query consulta = session.createQuery("from " + claseDePersistencia.getSimpleName() + " o");
			System.out.println("consulta: " + consulta);
			
			lista = consulta.list();
		} finally {
			session.close();
		}

		return lista;
	}	

}
