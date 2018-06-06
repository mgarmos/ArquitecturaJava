package com.arquitecturajava.dao;

import com.arquitecturajava.dao.hibernate.DAOHibernateFactory;

//Dependiendo de la configuración devuelve una factoria u otra
public abstract class DAOAbstractFactory {

	public static DAOFactory getInstance() {
		String config = "Hibernate"; //Debería recogerse de un fichero de configuración
		
		DAOFactory daoFactory = null;
		
		if (config.equalsIgnoreCase("Hibernate")) {
			daoFactory = new DAOHibernateFactory();
		}
		return daoFactory;
	}

}
