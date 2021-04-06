package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import model.Tema;

@Named("temaService")
@RequestScoped

public class TemaServiceImpl implements TemaService{

	@Override
	public List<Tema> recuperarTemas() {
	        String sql_select = "select * from libros.temas";
	        List<Tema> lista = new ArrayList<>();

	        //try (Connection conexion = DriverManager.getConnection(cadenaConexion, user, pass);
	        try (Connection conexion = DatosLocator.getConnection();        
	                PreparedStatement prepared_statement = conexion.prepareStatement(sql_select);) {

	            //Ejecutamos la instrucción
	            ResultSet rs = prepared_statement.executeQuery();

	            //Recorriendo la tabla
	            while (rs.next()) {
	                lista.add(new Tema(rs.getInt("idTema"), rs.getString("tema")));
	            }
	        } catch (SQLException sqlex) {
	            System.out.println("Error: clase LibrosService , recuperarTemas");
	            sqlex.printStackTrace();
	        }

	        return lista;

	}

	@Override
	public Tema recuperarTemaPorId(int idTema) {
		Tema tema=null;
        
        try(Connection cn=DatosLocator.getConnection()) {                       
            String sql="select * from temas where idTema=?";
            
            PreparedStatement st=cn.prepareStatement(sql);
            
            st.setInt(1, idTema);
            
            ResultSet rs=st.executeQuery();            
            
            if(rs.next()){
                tema=new Tema(rs.getInt("idTema"),rs.getString("tema"));
            }
        }  catch (SQLException ex) {
            ex.printStackTrace();
        }   
        return tema;

	}

}
