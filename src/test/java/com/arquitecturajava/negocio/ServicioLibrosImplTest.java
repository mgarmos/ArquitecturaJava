package com.arquitecturajava.negocio;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.arquitecturajava.bean.Categoria;
import com.arquitecturajava.bean.Libro;
import com.arquitecturajava.utils.UtilSpring;

public class ServicioLibrosImplTest {
	//ServicioLibros servicioLibros = new ServicioLibrosImpl();
	ServicioLibros servicioLibros = (ServicioLibros)UtilSpring.getBean("servicioLibros");
	

	@Before
	public void setUp() throws Exception {
		servicioLibros = (ServicioLibros)UtilSpring.getBean("servicioLibros");
		assertNotNull(servicioLibros);
	}
	
	@Test
	public void testSalvarLibro() {
		String isbn = "3";		
		Libro libro = servicioLibros.buscarLibroPorclave(isbn);
		libro.setTitulo("La espera");
		libro.setCategoria(new Categoria(2));		
		servicioLibros.salvarLibro(libro); //TODO debería devolver un entero
	}

	@Test
	public void testBorrarLibro() {
		Libro libro = servicioLibros.buscarLibroPorclave("11");
		servicioLibros.borrarLibro(libro);
	}

	@Test
	public void testBuscarTodosLosLibros() {
		List<Libro> libros = servicioLibros.buscarTodosLosLibros();
		assertNotNull(libros);
		assertTrue(libros.size() > 0);
	}

	@Test
	public void testBuscarLibroPorclave() {
		Libro libro = servicioLibros.buscarLibroPorclave("1");
		assertNotNull(libro);
		assertTrue(libro.getIsbn().equals("1"));
	}

	@Test
	public void testBuscarLibrosPorCategoria() {
		String idCategoria = "1";	
		List<Libro> libros = servicioLibros.buscarLibrosPorCategoria(idCategoria);
		assertNotNull(libros);
		assertTrue(libros.size() > 0);
	}

	@Test
	public void testBuscarCategoriasLibros() {
		List<Categoria> categorias = servicioLibros.buscarCategoriasLibros();
		assertNotNull(categorias);
		assertTrue(categorias.size() > 0);
	}


	@Test
	public void testInsertarLibro() {
		Libro libro = new Libro("11", "La insoportable levedad del ser", new Categoria(1));
		servicioLibros.insertarLibro(libro);
	}

}
