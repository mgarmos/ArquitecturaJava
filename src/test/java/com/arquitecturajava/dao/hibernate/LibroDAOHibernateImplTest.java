package com.arquitecturajava.dao.hibernate;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.arquitecturajava.bean.Categoria;
import com.arquitecturajava.bean.Libro;
import com.arquitecturajava.dao.LibroDAO;
import com.arquitecturajava.utils.UtilSpring;

public class LibroDAOHibernateImplTest {
	
	//Instancia directamente la implementacion de hibernate para LibroDAO
	private LibroDAO libroDAO;
	
	@Before
	public void setUp() throws Exception {
		//Se instancia meediante Spring
		libroDAO = (LibroDAO) UtilSpring.getBean("libroDAO");
		assertNotNull(libroDAO);
		System.out.println("libroDAO: " + libroDAO);
	}
	
	
	@Test
	public void testBuscarPorCategoria() {
		String idCategoria = "1";		
		List<Libro> libros = libroDAO.buscarPorCategoria(idCategoria);
		assertNotNull(libros);
		assertTrue(libros.size() > 0);
		System.out.println(libros);
	}

	@Test
	public void testBuscarTodos() {
		List<Libro> libros = libroDAO.buscarTodos();
		assertNotNull(libros);
		assertTrue(libros.size() > 0);
		System.out.println(libros);
	}

	@Test
	public void testSalvar() {
		String isbn = "3";		
		Libro libro = libroDAO.buscarPorClave(isbn);
		libro.setTitulo("La espera");
		libro.setCategoria(new Categoria(2));		
		libroDAO.salvar(libro); //TODO debería devolver un entero
	}

	@Test
	public void testBorrar() {
		libroDAO.borrar(new Libro("10")); //TODO debería devolver un entero
	}

	
	public void testInsertar() {
		fail("Not yet implemented");
	}

	@Test
	public void testBuscarPorClave() {
		String isbn = "1";
		Libro libro = libroDAO.buscarPorClave(isbn);
		assertNotNull(libro);
		assertTrue(libro.getIsbn().equals(isbn));
		System.out.println(libro);
	}
}
