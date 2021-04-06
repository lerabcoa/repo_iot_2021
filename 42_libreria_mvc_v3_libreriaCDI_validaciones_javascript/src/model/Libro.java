package model;

public class Libro {
	private int isbn;
	private String titulo;
	private String autor;
	private int idTema;
	private double precio;
	private int paginas;
	
	public Libro() {};
	
	public Libro(int isbn, String titulo, String autor, double precio, int paginas, int idTema) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		this.autor = autor;
		this.idTema = idTema;
		this.precio = precio;
		this.paginas = paginas;
	}
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public int getIdTema() {
		return idTema;
	}
	public void setIdTema(int idTema) {
		this.idTema = idTema;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getPaginas() {
		return paginas;
	}
	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}
	
}
