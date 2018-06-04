package com.arquitecturajava.dao;

import java.util.List;

import com.arquitecturajava.negocio.Categoria;

public interface CategoriaDAO {
	List<Categoria> buscarTodasLasCategorias();
}