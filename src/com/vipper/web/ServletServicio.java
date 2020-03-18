package com.vipper.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vipper.modelo.ExcepcionUno;
import com.vipper.modelo.Servicio;
import com.vipper.modelo.Servicio;
import com.vipper.persistencia.AccesoFacturacion;
import com.vipper.persistencia.AccesoServicio;

/**
 * Servlet implementation class ServletServicio
 */
@WebServlet("/servletservicio")
public class ServletServicio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletServicio() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest r, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int jopcion = Integer.parseInt(r.getParameter("op"));
		RequestDispatcher rd =  null;
		int jid = 0;
		int numregistros=0;
		HttpSession miSesion = null;
		AccesoServicio as1=null;
		Servicio jservicio =null;
		switch (jopcion) {
		case 1:
			//Mostrar un servicio
			//Aquí entrará al pinchar desde la pantalla pedirunservicio, a cuyo usebean se 
			//ha identificado como "s1". Recoge el atributo desde el ámbito ¿Aplicación o sesión?
			jservicio =  (Servicio) r.getAttribute("s1"); //hacemos casting
			
			as1=new AccesoServicio();
			try {
				jservicio = as1.mostrarUnServicio(jservicio.getIdservicios());
				System.out.println("Un servicio de la BBDD" + jservicio.valueOf());
			} 
			catch (ExcepcionUno e) { //Excepción personalizada para cuando no existen registros para el id 
				// TODO Auto-generated catch block
				System.out.println(e.toString());
				r.setAttribute("mensaje", "El Id Servicio " + jservicio.getIdservicios() + " no existe");
			}	
			catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.toString());
			}
			//Se guarda el producto con los datos que se obtienen de la BBDD
			//en el ámbito request
			r.setAttribute("s1", jservicio);
			rd = r.getRequestDispatcher("/mostrarunservicio.jsp");
			rd.forward(r, response);
			break;
			
		case 2:
			//Entra aquí cuando se hace clic en el enlace de mostrartodos de menú de Servicios
			//Declaramos la variable que es un list de servicios
			//Instanciar ArrayList y AccesoServicio
			
			List<Servicio> serviciosBBDD = null;
			as1 = new AccesoServicio();
			try {
				serviciosBBDD = as1.mostrartodosservicios();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.toString());
			}
			// Guardar los servicios en el ámbito request
			
			r.setAttribute("rtodos", serviciosBBDD);
			
			//Redirigir a la página mostrartodos.jsp
			rd = r.getRequestDispatcher("/mostrartodosservicios.jsp");
			rd.forward(r, response);
			
			break;
			
		case 3:
			//Recogemos los valores del formulario insertarservicio (los valores que vienen en el name)
	        //Instanciamos un objeto de la clase Servicio, con el constructor adecuado
	        //Los getParameter sólo devuelven String. 
	        //Los parámetros recogidos con getParameter se recogen de los campos name del 
	        //formulario, por lo que deben coincidir al 100% con el nombre ahí almacenado
			//String descripcion, double coste, int id, double iva
			try {
			Servicio s1 = new Servicio
					(r.getParameter("descripcion"), 
					Double.parseDouble(r.getParameter("coste")), 
	        		Integer.parseInt(r.getParameter("id")), 
	        		Double.parseDouble(r.getParameter("iva")));  
				as1 = new AccesoServicio();
				numregistros = as1.insertarServicio(s1);
				if (numregistros > 0) {
					System.out.println("Se ha dado de alta el registro en nuestra BBDD ");
				} else {
					System.out.println("¡Ops! Ha habido algún error. Lo sentimos");
				}
				//Redirigir a la página insertarservicio.jsp
				rd = r.getRequestDispatcher("/insertarservicio.jsp");
				r.setAttribute("mensaje", "Su alta ha sido exitosa");
				rd.forward(r, response);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.toString());
			}
			
			break;
		 default:
			 break;
		}
	}

}
