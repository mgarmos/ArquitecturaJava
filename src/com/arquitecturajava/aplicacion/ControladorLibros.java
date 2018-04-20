package com.arquitecturajava.aplicacion;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
  name = "ControladorLibros",
  description = "Controlador de Libros",
  urlPatterns = {"/ControladorLibros"}
)
public class ControladorLibros extends HttpServlet {  
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(
      HttpServletRequest request, 
      HttpServletResponse response) throws ServletException, IOException {
  
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<p>Hello World!</p>");
    }
}