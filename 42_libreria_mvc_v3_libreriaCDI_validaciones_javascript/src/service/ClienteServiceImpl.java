package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import model.Cliente;

@Named("clienteService")
@RequestScoped
public class ClienteServiceImpl implements ClienteService {
	

	@Override
	public boolean agregarCliente(Cliente cliente) {
		// conexión con la base de datos
				try (Connection con = DatosLocator.getConnection()) {
					String sql = "insert into libros.clientes(usuario,password,email,telefono) values(?,?,?,?)";
					
					PreparedStatement st = con.prepareStatement(sql);
					
					st.setString(1, cliente.getUsuario());
					st.setString(2, cliente.getPassword());
					st.setString(3, cliente.getEmail());
					st.setInt(4, cliente.getTelefono());
					st.execute();
					
					return true;
				} catch (SQLException e) {
					e.printStackTrace();
					return false;
				}

	}

	@Override
	public Cliente buscarCliente(String usuario, String password) {
		// conexión con la base de datos
		try (Connection con = DatosLocator.getConnection()) {
			String sql = "select * from libros.clientes where usuario = ? and password=?";
			
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, usuario);
			st.setString(2, password);
			
			ResultSet rs = st.executeQuery();
			
			if (rs.next()) {
				return new Cliente(rs.getInt("idCliente"), 
						           rs.getString("usuario"), 
						           rs.getString("password"),
						           rs.getString("email"),
						           rs.getInt("telefono"));
			}
			else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}

}
