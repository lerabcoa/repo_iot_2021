package model;

public class Tema {
	private int id_tema;
    private String descripcion;
    
    public Tema(){};

    public Tema(int id_tema, String descripcion) {
        this.id_tema = id_tema;
        this.descripcion = descripcion;
    }

    public int getId_tema() {
        return id_tema;
    }

    public void setId_tema(int id_tema) {
        this.id_tema = id_tema;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return descripcion;
    }
    

}
