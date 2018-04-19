package com.aquitecturajava;

import java.util.ArrayList;
import java.util.List;

public class Libro {
	
	public Libro() {}
	
		
	public Libro(String isbn) {
		super();
		this.isbn = isbn;
	}


	//TODO Habría que parsear las comillas simples
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
	
	public Libro buscarPorClave() {
		String consultaSQL = "Select * from LIBRO where isbn = '" + this.isbn +"'";
		DataBaseHelper<Libro> helper = new DataBaseHelper<Libro>();
		List<Libro> resultado = helper.seleccionarRegistros(consultaSQL, Libro.class);
		return resultado.get(0);
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

	public void insertar() {
		String consultaSQL = "insert into Libro (isbn,titulo,categoria) values";

		// TODO SQLInyection
		consultaSQL += "('" + this.isbn + "','" + this.titulo + "','" + this.categoria + "')";

		DataBaseHelper<Libro> helper = new DataBaseHelper<Libro>();
		helper.modificarRegistro(consultaSQL);
	}
	
	public void borrar() {
		System.out.println("Libro->borrar() - isbn: " + this.isbn);
		String consultaSQL = "delete from Libro where isbn = '" + this.isbn + "'";
		DataBaseHelper<Libro> helper = new DataBaseHelper<Libro>();
		helper.modificarRegistro(consultaSQL);		
	}
	
	public void salvar() {
		String consultaSQL = "update Libro set titulo ='" + this.titulo + "', categoria =  '" + this.categoria + "' ";
		consultaSQL += " where isbn = '"  + this.isbn + "'";
		
		DataBaseHelper<Libro> helper = new DataBaseHelper<Libro>();
		helper.modificarRegistro(consultaSQL);	
	}
	
	public static List<Libro> buscarPorCategoria (String categoria) {
		List<Libro> resultado = new ArrayList<Libro>();
		String consultaSQL = "Select * from LIBRO where categoria = '" + categoria + "'";
		DataBaseHelper<Libro> helper = new DataBaseHelper<Libro>();
		resultado = helper.seleccionarRegistros(consultaSQL, Libro.class);
		return resultado;
	}
	
	

	@Override
	public String toString() {
		return "Libro [isbn=" + isbn + ", titulo=" + titulo + ", categoria=" + categoria + "]";
	}
	
	public static void main(String[] args) {
//		Libro libro = new Libro("1","2","Maths");
//		libro.insertar();
//		libro = new Libro("11","2","Sound");
//		libro.insertar();
		
		Libro libro = new Libro("2","b","Sound");
		libro.salvar();
	}
	
}
