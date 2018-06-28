package com.arquitecturajava.negocio;

import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.apache.log4j.Logger;

import com.arquitecturajava.bean.Categoria;
import com.arquitecturajava.bean.Libro;
import com.arquitecturajava.controlador.ControladorLibros;
import com.arquitecturajava.dao.CategoriaDAO;
import com.arquitecturajava.dao.LibroDAO;


public class ServicioLibrosImpl implements ServicioLibros {
	final Logger log = Logger.getLogger(ControladorLibros.class.getPackage().getName());
	
	private LibroDAO libroDAO;
	private CategoriaDAO categoriaDAO;
	

	@Override
	public void salvarLibro(Libro libro) {
		log.debug("ServicioLibrosImpl.salvarLibro");
		libroDAO.salvar(libro); 
	}

	@Override
	public void borrarLibro(Libro libro) {
		log.debug("ServicioLibrosImpl.borrarLibro()");
		libroDAO.borrar(libro);
	}

	@Override
	public List<Libro> buscarTodosLosLibros() {
		log.debug("ServicioLibrosImpl.buscarTodosLosLibros()");
		List<Libro> libros = libroDAO.buscarTodos();
		return libros;
	}

	@Override
	@Transactional(value=TxType.NEVER)
	public Libro buscarLibroPorclave(String id) {
		log.debug("ServicioLibrosImpl.buscarLibroPorclave()");
		Libro libro = libroDAO.buscarPorClave(id);
		return libro;
	}

	@Override
	public List<Libro> buscarLibrosPorCategoria(String categoria) {
		log.debug("ServicioLibrosImpl.buscarLibrosPorCategoria()");
		List<Libro> libros = libroDAO.buscarPorCategoria(categoria);
		return libros;
	}

	@Override
	@Transactional(value=TxType.NEVER)
	public List<Categoria> buscarCategoriasLibros() {
		log.debug("ServicioLibrosImpl.buscarCategoriasLibros");
		List<Categoria> listaCategorias = categoriaDAO.buscarTodos();
		return listaCategorias;
	}

	@Override
	public Categoria buscarCategoriaPorClave(int categoria) {
		log.debug("ServicioLibrosImpl.buscarCategoriasLibros()");
		return null;
	}

	@Override
	public void insertarLibro(Libro libro) {
		log.debug("ServicioLibrosImpl.insertarLibro()");
		libroDAO.insertar(libro);
	}
	
	@Override
	public LibroDAO getLibroDAO() {
		return libroDAO;
	}

	@Override
	public void setLibroDAO(LibroDAO libroDAO) {
		this.libroDAO = libroDAO;
	}

	@Override
	public CategoriaDAO getCategoriaDAO() {
		return categoriaDAO;
	}
	
	@Override
	public void setCategoriaDAO(CategoriaDAO categoriaDAO) {
		this.categoriaDAO = categoriaDAO;
	}	

}
