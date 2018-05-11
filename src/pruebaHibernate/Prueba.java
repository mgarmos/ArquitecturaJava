package pruebaHibernate;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.arquitecturajava.Libro;

public class Prueba {
	
	private static SessionFactory createSessionFactory() {
		SessionFactory sessionFactory;

		Configuration configuration = new Configuration();
		configuration.configure();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);

		return sessionFactory;
	}

	public static void inserOrUpdate() {
		// Hay que referenciar el classpath a lib para ejecutar el main
		Session session = null;
		Transaction transaccion = null;

		// Lee el fichero de configuración
		SessionFactory factoria = createSessionFactory();

		// Conexión a BBDD
		session = factoria.openSession();

		// Inicia transacción
		transaccion = session.beginTransaction();

		Libro libro = null;
		// Insert or update
		for (int i = 1; i < 12; i++) {
			libro = new Libro(String.valueOf(i+10), "java-0" + i, "programacion");
			session.saveOrUpdate(libro);
			session.flush();
		}

		// Cierra la transaccion
		transaccion.commit();
		session.close();
	}

	public static void delete() {
		Session session = null;
		Transaction transaccion = null;

		// Lee el fichero de configuración
		SessionFactory factoria = createSessionFactory();

		// Conexión a BBDD
		session = factoria.openSession();

		// Inicia transacción
		transaccion = session.beginTransaction();

		Libro libro = null;
		// Delete
		for (int i = 1; i < 12; i++) {
			libro = new Libro(String.valueOf(i));
			session.delete(libro);
		}

		// Cierra la transaccion
		transaccion.commit();
		session.close();
	}

	public static void select() {
		Session session = null;
		try {
			
			// Lee el fichero de configuración
			SessionFactory factoria = createSessionFactory();

			System.out.println("factoria: " + factoria);

			// Conexión a BBDD
			session = factoria.openSession();
			System.out.println("session: " + session);

			Query consulta = session.createQuery("from Libro libro");
			List<Libro> lista = consulta.list();
			for (Libro libro : lista) {
				System.out.println(" isbn: " + libro.getIsbn());
				System.out.println(" título: " + libro.getTitulo());
				System.out.println(" Categoria: " + libro.getCategoria());
				System.out.println("---");
			}
		} catch (HibernateException e) {
			System.out.println(e.getMessage());

		} catch (Error e) {
			System.out.println(e.getMessage() + " Causa: " + e.getCause());
			e.printStackTrace();

		} finally {
			session.close();
		}

	}

	public static void filter(String categoria) {
		Session session = null;
		try {

			// Lee el fichero de configuración
			SessionFactory factoria = createSessionFactory();

			// Conexión a BBDD
			session = factoria.openSession();

			Query consulta = session.createQuery("from Libro libro where libro.categoria=:categoria");
			consulta.setString("categoria", categoria);

			List<Libro> lista = consulta.list();
			for (Libro libro : lista) {
				System.out.println(" isbn: " + libro.getIsbn());
				System.out.println(" título: " + libro.getTitulo());
				System.out.println(" Categoria: " + libro.getCategoria());
				System.out.println("---");
			}
		} catch (HibernateException e) {
			System.out.println(e.getMessage());

		} finally {
			session.close();
		}
	}

	public static void buscarTodasCategorias() {
		Session session = null;
		try {
			// Lee el fichero de configuración
			SessionFactory factoria = createSessionFactory();

			// Conexión a BBDD
			session = factoria.openSession();
			String consulta = "Select distinct libro.categoria from Libro libro";
			List<String> listaDeCategorias = session.createQuery(consulta).list();

			System.out.println("----------listaDeCategorias------: " + listaDeCategorias);
		} catch (HibernateException e) {
			System.out.println(e.getMessage());

		} finally {
			session.close();
		}

	}

	/*
	 * Si se consulta, y despues se iniciia una transazcción se produce el error
	 * java.sql.SQLException: database is locked. Ésto sólo pasa con SQLite
	 * 
	 */
	public static void main(String[] args) {
		select();
		inserOrUpdate();
		select();
		// filter("programacion");
		// buscarTodasCategorias();
		// delete();
		// select();
	}

}
