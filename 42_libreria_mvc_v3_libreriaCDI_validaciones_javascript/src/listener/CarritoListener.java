package listener;

import java.util.ArrayList;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import model.Libro;

/**
 * Application Lifecycle Listener implementation class InicializadorAtributos
 *
 */
@WebListener
public class CarritoListener implements ServletRequestListener, HttpSessionListener {

    public void sessionCreated(HttpSessionEvent se)  { 
    	se.getSession().setAttribute("libroscarrito", new ArrayList<Libro>());
    }


    public void requestDestroyed(ServletRequestEvent sre)  { 
         // TODO Auto-generated method stub
    }

}
