package service;

import java.util.List;

import model.Tema;

public interface TemaService {
	public List<Tema> recuperarTemas();
	Tema recuperarTemaPorId(int idTema);
}
