package controller;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Tema;
import service.TemaService;

/**
 * Servlet implementation class RecuperarTemasAction
 */
@WebServlet("/RecuperarTemasAction")
public class RecuperarTemasAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

    @Inject
    TemaService service;
    
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//TemaService service = LibrosServiceFactory.getTemaService();
		
		List<Tema> temas = service.recuperarTemas();
		
		request.setAttribute("temas", temas);
	}

}
