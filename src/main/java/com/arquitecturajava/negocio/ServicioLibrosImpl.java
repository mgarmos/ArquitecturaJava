package com.arquitecturajava.negocio;

import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.arquitecturajava.bean.Categoria;
import com.arquitecturajava.bean.Libro;
import com.arquitecturajava.dao.CategoriaDAO;
import com.arquitecturajava.dao.LibroDAO;


public class ServicioLibrosImpl implements ServicioLibros {
	
	private LibroDAO libroDAO;
	private CategoriaDAO categoriaDAO;
	
	
	public ServicioLibrosImpl() {
		ClassPathXmlApplicationContext factoria = new ClassPathXmlApplicationContext("contextoAplicacion.xml");
		libroDAO = (LibroDAO)factoria.getBean("libroDAO");
		categoriaDAO = (CategoriaDAO)factoria.getBean("categoriaDAO");
	}

	@Override
	public void salvarLibro(Libro libro) {
		System.out.println("ServicioLibrosImpl.salvarLibro");
		libroDAO.salvar(libro); 
	}

	@Override
	public void borrarLibro(Libro libro) {
		System.out.println("ServicioLibrosImpl.borrarLibro()");
		libroDAO.borrar(libro);
	}

	@Override
	public List<Libro> buscarTodosLosLibros() {
		System.out.println("ServicioLibrosImpl.buscarTodosLosLibros()");
		List<Libro> libros = libroDAO.buscarTodos();
		return libros;
	}

	@Override
	@Transactional(value=TxType.NEVER)
	public Libro buscarLibroPorclave(String id) {
		System.out.println("ServicioLibrosImpl.buscarLibroPorclave()");
		Libro libro = libroDAO.buscarPorClave(id);
		return libro;
	}

	@Override
	public List<Libro> buscarLibrosPorCategoria(String categoria) {
		System.out.println("ServicioLibrosImpl.buscarLibrosPorCategoria()");
		List<Libro> libros = libroDAO.buscarPorCategoria(categoria);
		return libros;
	}

	@Override
	@Transactional(value=TxType.NEVER)
	public List<Categoria> buscarCategoriasLibros() {
		System.out.println("ServicioLibrosImpl.buscarCategoriasLibros");
		List<Categoria> listaCategorias = categoriaDAO.buscarTodos();
		return listaCategorias;
	}

	@Override
	public Categoria buscarCategoriaPorClave(int categoria) {
		System.out.println("ServicioLibrosImpl.buscarCategoriasLibros()");
		return null;
	}

	@Override
	public void insertarLibro(Libro libro) {
		System.out.println("ServicioLibrosImpl.insertarLibro()");
		libroDAO.insertar(libro);
	}

}
