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
    	System.out.println("Adiós...salgo de la aplicación");
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
        //Se programa para cuando arranque la aplicación. Vemos qué está
    	//ocurriendo.- El parámetro "oferta" es el que está en web.xml
    	String jmensaje = sce.getServletContext().getInitParameter("mensaje");
    	System.out.println("mensaje en el Listener --> " + jmensaje);
    	//Recuperar el ámbito de la aplicación
    	ServletContext ap1 = sce.getServletContext();
    	//Guardamos aquí el mensaje. amensaje es un nombre nuevo de clave
    	//válido para todas las sesiones. aoferta es el que usamos en los jsp
    	//en la etiqueta <marquee> hola passa 
    	ap1.setAttribute("amensaje", jmensaje);
    }
	
}
