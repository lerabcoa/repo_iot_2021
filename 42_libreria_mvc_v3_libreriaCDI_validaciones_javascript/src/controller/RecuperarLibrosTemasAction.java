package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Libro;
import service.LibroService;
import service.LibrosServiceFactory;
import service.TemaService;

/**
 * Servlet implementation class RecuperarLibrosTemasAction
 */
@WebServlet("/RecuperarLibrosTemasAction")
public class RecuperarLibrosTemasAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

    @Inject
    LibroService servicel;
    
    @Inject
    TemaService servicet;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		int idtema= Integer.parseInt(request.getParameter("idTema"));
		
		//LibroService servicel = LibrosServiceFactory.getLibroService();

		//TemaService servicet = LibrosServiceFactory.getTemaService();
		
		List<Libro> librostema = new ArrayList<>();
		
		
	
		//si idTema es 0 es que ha elegido todos
		 if(idtema==0){
			librostema=servicel.recuperarLibrosTema();
						 
		} else{
			librostema=servicel.recuperarLibrosTema(idtema);
		}
		 
		
		 request.setAttribute("librostema", librostema);
		
		//Esto se hace para que en la página de libros se pueda saber que nombre de tema se seleccionó
		if (idtema > 0) {
			request.setAttribute("descripciontema",servicet.recuperarTemaPorId(idtema).getDescripcion());
			
		} else {
			request.setAttribute("descripciontema", "Todos");
		}
	}

}
