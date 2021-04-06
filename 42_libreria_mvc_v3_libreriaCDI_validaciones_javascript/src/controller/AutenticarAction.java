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
 * Servlet implementation class AutenticarAction
 */
@WebServlet("/AutenticarAction")
public class AutenticarAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

    @Inject
    ClienteService service;
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usuario = request.getParameter("usuario");
		String password = request.getParameter("password");
		
		//ClienteService service = LibrosServiceFactory.getClienteService();
		Cliente cliente = service.buscarCliente(usuario, password); 
		
		if (cliente == null) {
			request.setAttribute("clientenoregistrado", true);
		} else {
			request.setAttribute("clientenoregistrado", false);
		}	
	}

}
