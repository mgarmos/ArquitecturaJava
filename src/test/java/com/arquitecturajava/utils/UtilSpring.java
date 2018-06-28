package com.arquitecturajava.utils;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.arquitecturajava.controlador.ControladorLibros;

public class UtilSpring {
	final static Logger log = Logger.getLogger(ControladorLibros.class.getPackage().getName());
	
	public static Object getBean(String nombre) {
		Object bean = null;
		ApplicationContext factoria = new FileSystemXmlApplicationContext("./src/main/resources/applicationContext.xml");
		bean = factoria.getBean(nombre);
		log.debug("Accion-> getBean - Solicitado el bean " + nombre);
		return bean;
	}

}
