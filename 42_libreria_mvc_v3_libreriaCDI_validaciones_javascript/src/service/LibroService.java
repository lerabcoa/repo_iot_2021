package service;

import java.util.List;

import model.Libro;

public interface LibroService {
    public List<Libro> recuperarLibrosTema(int tema);
    
    public List<Libro> recuperarLibrosTema();
    
    public Libro recuperarLibroConIsbn(int isbn);
    
    
    
    //public void nuevosLibros(Libro[] libros);

    //public Libro recuperarLibro(int isbn);

}
