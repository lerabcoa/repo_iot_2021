package service;

import model.Cliente;

public interface ClienteService {
	public boolean agregarCliente(Cliente cliente);
	
	public Cliente buscarCliente(String usuario, String email);

}
