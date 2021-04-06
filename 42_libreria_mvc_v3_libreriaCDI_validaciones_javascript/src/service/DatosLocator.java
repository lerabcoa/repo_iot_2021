package service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DatosLocator {
static DataSource ds;
    
    static {
    	try {
    		// Obtenemos el DatSource y su referencia
			// java:comp/env/ es la entrada al nodo raíz del Sistema de directorios

    		Context ctx=new InitialContext();

			ds=(DataSource)ctx.lookup("java:comp/env/reflibros");
			
		} catch (NamingException e) {
			e.printStackTrace();
		}
    }
    
    public static Connection getConnection() throws SQLException{
    	//Pedir la conexión al DataSource con el método getConnection()
        return ds.getConnection();
    }
	

}
