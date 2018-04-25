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
		Libro libro= new Libro("1","java","programacion");
		session.saveOrUpdate(libro);
		transaccion.commit();		
	}

}
