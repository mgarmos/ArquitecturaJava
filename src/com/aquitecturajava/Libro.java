package com.aquitecturajava;

import java.util.ArrayList;
import java.util.List;

public class Libro {
	
	public Libro() {}
	
	public Libro(String isbn, String titulo, String categoria) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		this.categoria = categoria;
	}

	private String isbn;
	private String titulo;
	private String categoria;

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public static List<String> buscarTodasLasCategorias() {

		String consultaSQL = "Select distinct categoria from LIBRO";
		DataBaseHelper<String> helper = new DataBaseHelper<String>();
		List<String> resultado = helper.seleccionarRegistros(consultaSQL, String.class);
		return resultado;
	}

	public static List<Libro> buscarTodos() {
		List<Libro> resultado = new ArrayList<Libro>();
		String consultaSQL = "Select * from LIBRO";
		DataBaseHelper<Libro> helper = new DataBaseHelper<Libro>();
		resultado = helper.seleccionarRegistros(consultaSQL, Libro.class);
		return resultado;
	}

	public void insertar(String isbn, String titulo, String categoria) {
		String consultaSQL = "insert into Libro (isbn,titulo,categoria) values";

		// TODO SQLInyection
		consultaSQL += "('" + this.isbn + "','" + this.titulo + "','" + this.categoria + "')";

		DataBaseHelper helper = new DataBaseHelper();
		helper.modificarRegistro(consultaSQL);
	}
	public static void main(String[] args) {
		Libro libro = new Libro();
		
		List<Libro> libros = Libro.buscarTodos();
		for (Libro libroTemp:libros) {
			System.out.println(libroTemp);
		}	
	}

	@Override
	public String toString() {
		return "Libro [isbn=" + isbn + ", titulo=" + titulo + ", categoria=" + categoria + "]";
	}
	
	
	
}
