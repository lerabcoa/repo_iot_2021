package controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cliente;
import service.ClienteService;
import service.LibrosServiceFactory;

/**
 * Servlet implementation class AgregarAction
 */
@WebServlet("/AgregarAction")
public class AgregarAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	ClienteService service;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cliente cliente=new Cliente(0,request.getParameter("usuario"),
				request.getParameter("password"),
				request.getParameter("email"),
				Integer.parseInt(request.getParameter("telefono")));
		
				
		//ClienteService service = LibrosServiceFactory.getClienteService();

		service.agregarCliente(cliente);
	}

}
