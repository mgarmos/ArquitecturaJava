package com.arquitecturajava;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.annotations.Table;

@Entity
@Table( appliesTo = "Categoria" )
public class Categoria {
	private static final Logger log = Logger.getLogger(Libro.class.getPackage().getName());
	
	private Integer id;
	private String descripcion;
	private List<Libro> libros;
	

	public Categoria(Integer id) {
		super();
		this.id = id;
	}

	public Categoria() {
	}
	
	public Categoria(Integer id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
	}


	@Id
	@Column(name="ID", length=5)
	public Integer getId() {
		return id;
	}
	
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	public String getDescripcion() {
		return descripcion;
	}
	
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	@OneToMany
	@JoinColumn(name="categoria")
	public List<Libro> getLibros() {
		return libros;
	}


	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}	
	
	public static List<Categoria> buscarTodasLasCategorias() {
		log.info("buscarTodasLasCategorias");
		Session session = null;
		List<Categoria> listaDeCategorias = null;
		
		try {
			session = HibernateHelper.getSessionFactory().openSession();
			Query consulta = session.createQuery("from Categoria categoria");
			listaDeCategorias = consulta.list();
		} finally {
			session.close();
		}
		return listaDeCategorias;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	

}
