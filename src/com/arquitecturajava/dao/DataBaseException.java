package com.arquitecturajava.dao;

public class DataBaseException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public DataBaseException() {
		super();
	}

	public DataBaseException(String mensaje) {
		super(mensaje);
	}

	public DataBaseException(Throwable causa) {
		super(causa);
	}

	public DataBaseException(String mensaje, Throwable causa) {
		super(mensaje, causa);
	}

}
