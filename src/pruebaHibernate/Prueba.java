package pruebaHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.arquitecturajava.Libro;

public class Prueba {

	public static void main(String[] args) {
		// Hay que referenciar el classpath a lib para ejecutar el main
		Session session = null;
		Transaction transaccion = null;

		SessionFactory factoria = new Configuration().configure().buildSessionFactory();
		session = factoria.openSession();
		transaccion = session.beginTransaction();
		Libro libro = null;

		//Insert or update
		for (int i = 1; i < 12; i++) {
			libro = new Libro(String.valueOf(i), "java2" + i, "programacion");
			session.saveOrUpdate(libro);
			//session.flush();
		}

		// Delete
//		for (int i = 1; i < 12; i++) {
//			libro = new Libro(String.valueOf(i));
//			session.delete(libro);
//			session.flush();
//		}

		transaccion.commit();
	}

}
