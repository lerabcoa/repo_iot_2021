package service;

public class LibrosServiceFactory {
	public static ClienteService getClienteService() {
		return new ClienteServiceImpl();	
	}
	
	public static TemaService getTemaService() {
		return new TemaServiceImpl();	
	}
	
	public static LibroService getLibroService() {
		return new LibroServiceImpl();	
	}



}
