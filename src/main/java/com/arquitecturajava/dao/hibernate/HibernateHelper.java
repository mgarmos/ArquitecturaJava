package com.arquitecturajava.dao.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Crea la session cargando la configuración del fichero hibernate.cfg.xml 
 */
public class HibernateHelper {

	private static  SessionFactory sessionFactory = buildSessionFactory();

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	private static SessionFactory buildSessionFactory() {
		SessionFactory sessionFactory = null;
		Configuration configuration = new Configuration();
		configuration.configure();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);

		return sessionFactory; 
	}
}
