package com.vipper.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ArranqueAplicacion
 *
 */
@WebListener
public class ArranqueAplicacion implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public ArranqueAplicacion() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	System.out.println("Adi�s...salgo de la aplicaci�n");
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
        //Se programa para cuando arranque la aplicaci�n. Vemos qu� est�
    	//ocurriendo.- El par�metro "oferta" es el que est� en web.xml
    	String jmensaje = sce.getServletContext().getInitParameter("mensaje");
    	System.out.println("mensaje en el Listener --> " + jmensaje);
    	//Recuperar el �mbito de la aplicaci�n
    	ServletContext ap1 = sce.getServletContext();
    	//Guardamos aqu� el mensaje. amensaje es un nombre nuevo de clave
    	//v�lido para todas las sesiones. aoferta es el que usamos en los jsp
    	//en la etiqueta <marquee> hola passa 
    	ap1.setAttribute("amensaje", jmensaje);
    }
	
}
