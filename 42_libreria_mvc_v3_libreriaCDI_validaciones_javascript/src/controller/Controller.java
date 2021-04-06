package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Tema;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		var url="inicio.html";

		var option=request.getParameter("option");
		
		switch(option) {
		case "doAutenticar":
			request.getRequestDispatcher("AutenticarAction").include(request, response);
			
			if ((Boolean)request.getAttribute("clientenoregistrado")) {
				url="error.html";
			}else {

				request.getRequestDispatcher("RecuperarTemasAction").include(request, response);
				url="tematica.jsp";
			}
			break;
			
		case "doAgregar":
			request.getRequestDispatcher("AgregarAction").include(request, response);	
			url="inicio.html";
			break;
			
	
		case "doTemas": 
			request.getRequestDispatcher("RecuperarTemasAction").include(request, response);
			url="tematica.jsp";
			break;
	
	
		case "doLibros":
			request.getRequestDispatcher("RecuperarLibrosTemasAction").include(request, response);
			url="libros.jsp";
			break;
			
		case "doAgregarCarro":
			request.getRequestDispatcher("AgregarCarritoAction").include(request, response);
			
			/*Volvemos a transferir la petición a este controlador de acción para que recupere los libros de nuevo 
			 * y se los pase en un atributo de petición al libros.jsp. 
			 * Como el idTema se pasa por el enlace de "Comprar" seguirá estando disponible como parámetro
			*/
			
			request.getRequestDispatcher("RecuperarLibrosTemasAction").include(request, response);
			url="libros.jsp";
			break;
		
		case "doEliminarCarro":
			request.getRequestDispatcher("EliminarCarritoAction").include(request, response);
			request.getRequestDispatcher("RecuperarLibrosTemasAction").include(request, response);
			url="libros.jsp";
			break;
			
		case "toInicio":
			url="inicio.html";
			break;
			
		case "toRegistro":
			url="registro.html";
			break;	
		}
		
		request.getRequestDispatcher(url).forward(request, response);

	}

}
