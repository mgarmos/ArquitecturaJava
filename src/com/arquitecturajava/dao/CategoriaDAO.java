package com.arquitecturajava.dao;

import java.util.List;

import com.arquitecturajava.negocio.bean.Categoria;

public interface CategoriaDAO {
	List<Categoria> buscarTodos();
}