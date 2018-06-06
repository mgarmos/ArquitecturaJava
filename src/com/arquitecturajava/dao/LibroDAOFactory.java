package com.arquitecturajava.dao;

import com.arquitecturajava.dao.hibernate.LibroDAOHibernateImpl;

/**
 * Decide que tipo de implementación para LibroDAO instancia en base a configuración
 * TODO Debería haber un fichero de configuración
 */
public class LibroDAOFactory {
	public static LibroDAO getInstance() {
		String config = "Hibernate"; //Debería recogerse de un fichero de configuración
		
		LibroDAO dao = null;
		
		if (config.equalsIgnoreCase("Hibernate")) {
			dao = new LibroDAOHibernateImpl();
		}
		return dao;
	}
}
