package com.arquitecturajava.negocio;

import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.arquitecturajava.dao.CategoriaDAO;
import com.arquitecturajava.dao.DAOAbstractFactory;
import com.arquitecturajava.dao.DAOFactory;
import com.arquitecturajava.dao.LibroDAO;
import com.arquitecturajava.negocio.bean.Categoria;
import com.arquitecturajava.negocio.bean.Libro;


public class ServicioLibrosImpl implements ServicioLibros {
	private DAOFactory factoria = null;
	
	public ServicioLibrosImpl() {
		factoria = DAOAbstractFactory.getInstance();
	}

	@Override
	public void salvarLibro(Libro libro) {
		System.out.println("ServicioLibrosImpl.salvarLibro");
		LibroDAO libroDAO = factoria.getLibroDAO();
		libroDAO.salvar(libro); 
	}

	@Override
	public void borrarLibro(Libro libro) {
		System.out.println("ServicioLibrosImpl.borrarLibro()");
		LibroDAO libroDAO = factoria.getLibroDAO();
		libroDAO.borrar(libro);
	}

	@Override
	public List<Libro> buscarTodosLosLibros() {
		System.out.println("ServicioLibrosImpl.buscarTodosLosLibros()");
		LibroDAO libroDAO = factoria.getLibroDAO();
		List<Libro> libros = libroDAO.buscarTodos();
		return libros;
	}

	@Override
	@Transactional(value=TxType.NEVER)
	public Libro buscarLibroPorclave(String id) {
		System.out.println("ServicioLibrosImpl.buscarLibroPorclave()");
		LibroDAO libroDAO = factoria.getLibroDAO();
		Libro libro = libroDAO.buscarPorClave(id);
		return libro;
	}

	@Override
	public List<Libro> buscarLibrosPorCategoria(String categoria) {
		System.out.println("ServicioLibrosImpl.buscarLibrosPorCategoria()");
		LibroDAO libroDAO = factoria.getLibroDAO();
		List<Libro> libros = libroDAO.buscarPorCategoria(categoria);
		return libros;
	}

	@Override
	@Transactional(value=TxType.NEVER)
	public List<Categoria> buscarCategoriasLibros() {
		System.out.println("ServicioLibrosImpl.buscarCategoriasLibros");
		CategoriaDAO categoriaDAO = factoria.getCategoriaDAO();
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
		LibroDAO libroDAO = factoria.getLibroDAO();
		libroDAO.insertar(libro);
	}

}
