package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import model.Libro;
import model.Tema;

@Named("libroService")
@RequestScoped
public class LibroServiceImpl implements LibroService {

	@Override
	public List<Libro> recuperarLibrosTema(int tema) {
		  String sql_select = "select * from libros.libros where idTema = ?";
	        List<Libro> lista = new ArrayList<>();

	        try (Connection conexion = DatosLocator.getConnection();
	                PreparedStatement prepared_statement = conexion.prepareStatement(sql_select);) {

	            prepared_statement.setInt(1, tema);

	            //Ejecutamos la instrucción
	            ResultSet rs = prepared_statement.executeQuery();

	            //Recorriendo la tabla
	            while (rs.next()) {
	                lista.add(
	                        new Libro(rs.getInt("isbn"),
	                                rs.getString("titulo"),
	                                rs.getString("autor"),
	                                rs.getDouble("precio"),
	                                rs.getInt("paginas"),
	                                rs.getInt("idTema")
	                        ));
	            }
	        } catch (SQLException sqlex) {
	            System.out.println("Error: clase LibrosService , recuperarLibros");
	            sqlex.printStackTrace();
	        }

	        return lista;

	}

	@Override
	public List<Libro> recuperarLibrosTema() {
		 String sql_select = "select * from libros.libros";
	        List<Libro> lista = new ArrayList<>();

	        try (Connection conexion = DatosLocator.getConnection();
	                PreparedStatement prepared_statement = conexion.prepareStatement(sql_select);) {

	            //prepared_statement.setInt(1, tema);

	            //Ejecutamos la instrucción
	            ResultSet rs = prepared_statement.executeQuery();

	            //Recorriendo la tabla
	            while (rs.next()) {
	                lista.add(
	                        new Libro(rs.getInt("isbn"),
	                                rs.getString("titulo"),
	                                rs.getString("autor"),
	                                rs.getDouble("precio"),
	                                rs.getInt("paginas"),
	                                rs.getInt("idTema")
	                        ));
	            }
	        } catch (SQLException sqlex) {
	            System.out.println("Error: clase LibrosService , recuperarLibros");
	            sqlex.printStackTrace();
	        }

	        return lista;

	}

	@Override
	public Libro recuperarLibroConIsbn(int isbn) {
		  String sql_select = "select * from libros.libros where isbn = ?";

	        try (Connection conexion = DatosLocator.getConnection();
	                PreparedStatement prepared_statement = conexion.prepareStatement(sql_select);) {

	            prepared_statement.setInt(1, isbn);

	            //Ejecutamos la instrucción
	            ResultSet rs = prepared_statement.executeQuery();

	            if (rs.next()) {
	            	return new Libro(rs.getInt("isbn"), 
	            			         rs.getString("titulo"),
	            			         rs.getString("autor"),
	            			         rs.getDouble("precio"),
	            			         rs.getInt("paginas"),
	            			         rs.getInt("idTema"));
	            }
	            return null;
	  
	            
	        } catch (SQLException sqlex) {
	            System.out.println("Error: clase LibrosService , recuperarLibroConIsbn");
	            sqlex.printStackTrace();
	            return null;
	        }

	}
	
	
	/*
	 @Override
	    public void nuevosLibros(Libro[] libros) {
	        String sql_alta = "insert into libros.libros(isbn,titulo,autor,precio,paginas,idTema ) values(?,?,?,?,?,?)";

	        
//	        try (Connection conexion = DriverManager.getConnection(cadenaConexion, user, pass); //carga del driver,
	          try (Connection conexion = DatosLocator.getConnection(); 
	                PreparedStatement prepared_statement = conexion.prepareStatement(sql_alta);) {
	            
	                    
	        // Desactivar el auto-commit -> todas las operaciones irán en la misma transacción
	        conexion.setAutoCommit(false);


	            //Sustitución de parámetros
	            for (Libro l : libros) {
	                if (recuperarLibro(l.getIsbn()) != null){
	                    conexion.rollback();
	                    return;
	                }
	                
	                
	                prepared_statement.setInt(1, l.getIsbn());
	                prepared_statement.setString(2, l.getTitulo());
	                prepared_statement.setString(3, l.getAutor());
	                prepared_statement.setDouble(4, l.getPrecio());
	                prepared_statement.setInt(5, l.getPaginas());
	                prepared_statement.setInt(6, l.getIdTema());
	                
	            //Ejecutamos la instrucción
	            prepared_statement.execute();
	            }
	            
	            //Confirmamos la transacción
	            conexion.commit();



	        } catch (SQLException sqlex) {
	            sqlex.printStackTrace();
	            System.out.println("Error: clase LibrosService , método nuevosLibros");

	        }

	    }
	    
 
	    
	     
	    @Override
	    public Libro recuperarLibro(int isbn){
	        
	       //try(Connection cn=DriverManager.getConnection(cadenaConexion,user,pass);)
	       try(Connection cn = DatosLocator.getConnection();){                       
		           
	            String sql="Select * from libros.libros where ";
	            sql+="isbn=?";
	            //creamos consulta preparada:
	            PreparedStatement ps=cn.prepareStatement(sql);
	               //Sustituimos parametros por valores
	               ps.setInt(1, isbn);
	              
	               
	               //ejecutamos
	              ResultSet rs= ps.executeQuery();
	              if(rs.next()){
	            	   return new Libro(rs.getInt("isbn"),
	                        rs.getString("titulo"),
	                        rs.getString("autor"),
	                        rs.getDouble("precio"),
	                        rs.getInt("paginas"),
	                        rs.getInt("idTema"));                  
	              }
	              return null;
	            
	        }  catch (SQLException ex) {
	            ex.printStackTrace();
	            return null;
	        } 
	    }
	    */
}
