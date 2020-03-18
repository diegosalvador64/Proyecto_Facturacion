package com.vipper.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vipper.modelo.ExcepcionUno;
import com.vipper.modelo.FormasPago;
import com.vipper.persistencia.AccesoFormasPago;

/**
 * Servlet implementation class ServletFormasPago
 */
@WebServlet("/servletformaspago")
public class ServletFormasPago extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletFormasPago() {
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
				AccesoFormasPago afp1=null;
				FormasPago jFormasPago =null;
				switch (jopcion) {
				case 1:
					//Mostrar una Forma de Pago
					//Aquí entrará al pinchar desde la pantalla pedirunaformapago, a cuyo usebean se 
					//ha identificado como "fp1". Recoge el atributo desde el ámbito ¿Aplicación o sesión?
					jFormasPago =  (FormasPago) r.getAttribute("fp1"); //hacemos casting
										
					afp1=new AccesoFormasPago();
					
					try {
						jFormasPago = afp1.mostrarunaFormaPago(jFormasPago.getIdformapago());
					} 
					catch (ExcepcionUno e) {//Excepción personalizada para cuando no existen registros para el id 
						// TODO Auto-generated catch block
						System.out.println(e.toString());
						r.setAttribute("mensaje", "El Id Forma de Pago " + jFormasPago.getIdformapago() + " no existe");
					}
					catch (ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						System.out.println(e.toString());
					} 
					//Se guarda el producto con los datos que se obtienen de la BBDD
					//en el ámbito request
					r.setAttribute("fp1", jFormasPago);
					rd = r.getRequestDispatcher("/mostrarunaformapago.jsp");
					rd.forward(r, response);
					break;
					
				case 2:
					//Entra aquí cuando se hace clic en el enlace de mostrartodos de menú de Formas Pago
					//Declaramos la variable que es un list de Formas Pago
					//Instanciar ArrayList y AccesoFormasPago
					
					List<FormasPago> formaspagoBBDD = null;
					afp1 = new AccesoFormasPago();
					try {
						formaspagoBBDD = afp1.mostrartodasFormasPago();
					} catch (ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						System.out.println(e.toString());
					}
					// Guardar los Contratoss en el ámbito request
					
					r.setAttribute("rtodos", formaspagoBBDD);
					
					//Redirigir a la página mostrartodos.jsp
					rd = r.getRequestDispatcher("/mostrartodasformaspago.jsp");
					rd.forward(r, response);
					
					break;
					
				case 3:
					//Recogemos los valores del formulario insertarformapago (los valores que vienen en el name)
			        //Instanciamos un objeto de la clase FormasPago, con el constructor adecuado
			        //Los getParameter sólo devuelven String. 
			        //Los parámetros recogidos con getParameter se recogen de los campos name del 
			        //formulario, por lo que deben coincidir al 100% con el nombre ahí almacenado
					//String descripcion, valor double
					try {
						FormasPago fp1 = new FormasPago
							(r.getParameter("descripcion"),
							Double.parseDouble(r.getParameter("valor")));  
						afp1 = new AccesoFormasPago();
						numregistros = afp1.insertarFormaPago(fp1);
						if (numregistros > 0) {
							System.out.println("Se ha dado de alta el registro en nuestra BBDD ");
							r.setAttribute("mensaje", "Su alta ha sido exitosa");
						} else {
							System.out.println("¡Ops! Ha habido algún error. Lo sentimos");
							r.setAttribute("mensaje", "Error en la inserción");
						}
						//Redirigir a la página insertarformapago.jsp
						rd = r.getRequestDispatcher("/insertarformapago.jsp");
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
