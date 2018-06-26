package com.arquitecturajava.dao.hibernate;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.arquitecturajava.bean.Categoria;
import com.arquitecturajava.dao.CategoriaDAO;

public class CategoriaDAOHibernateImplTest {
	CategoriaDAO categoriaDAO;

	@Before
	public void setUp() throws Exception {
		categoriaDAO = new CategoriaDAOHibernateImpl();
		assertNotNull(categoriaDAO);
	}


	@Test
	public void testBuscarTodos() {
		List<Categoria> categorias = categoriaDAO.buscarTodos();
		assertNotNull(categorias);
		assertTrue(categorias.size() > 0);
		System.out.println(categorias);
	}

}
