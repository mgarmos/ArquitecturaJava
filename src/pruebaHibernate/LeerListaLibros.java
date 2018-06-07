package pruebaHibernate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import com.arquitecturajava.negocio.bean.Categoria;
import com.arquitecturajava.negocio.bean.Libro;



public class LeerListaLibros {
	public static void main(String[] args) {
		String texto = "";
		Reader reader = null;

		Libro libro = null;
		Categoria categoria = null;
		List<Libro> libros = new ArrayList<Libro>();

		try {
			File file = new File("./resources/Libros.txt");
			System.out.println(file.getAbsolutePath());
			System.out.println(file.exists());
			
			reader = new FileReader(file);
			BufferedReader lector = new BufferedReader(reader);

			while ((texto = lector.readLine()) != null) {
				String[] datos = texto.split(",");
				categoria = new Categoria(Integer.parseInt(datos[2]), datos[3]);
				libro = new Libro(datos[0].trim(), datos[1], categoria);
				libros.add(libro);
			}
			lector.close();

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			try {
				
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		}
		
		for (Libro libroleido: libros) {
			System.out.println(libroleido);
		}

	}

}
