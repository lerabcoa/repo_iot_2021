package controller;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Libro;
import service.LibroService;
import service.LibrosServiceFactory;

/**
 * Servlet implementation class AgregarCarritoAction
 */
@WebServlet("/AgregarCarritoAction")
public class AgregarCarritoAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	LibroService service;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		//recuperamos carrito que tenemos en un atributo de sesión
		List<Libro> carrito=(List<Libro>)session.getAttribute("libroscarrito");
		
		//recogemos el parametro con el isbn del libro a añadir
		int isbn = Integer.parseInt(request.getParameter("isbn"));
				
		//LibroService service = LibrosServiceFactory.getLibroService();
		
		//Añadimos libro obtenido al carrito
		carrito.add(service.recuperarLibroConIsbn(isbn));
	}

}
