package com.arquitecturajava.dao;

import com.arquitecturajava.dao.hibernate.CategoriaDAOHibernateImpl;

/**
 * Decide que tipo de implementación para LCategoriaDAO instancia en base a configuración
 * TODO Debería haber un fichero de configuración
 */
public class CategoriaDAOFactory {
	
	public static CategoriaDAO getInstance() {
		String config = "Hibernate"; //Debería recogerse de un fichero de configuración
		
		CategoriaDAO dao = null;
		
		if (config.equalsIgnoreCase("Hibernate")) {
			dao = new CategoriaDAOHibernateImpl();
		}
		return dao;
	}
}

