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

import com.vipper.modelo.Contratos;
import com.vipper.modelo.ExcepcionUno;
import com.vipper.persistencia.AccesoContratos;

/**
 * Servlet implementation class ServletContrato
 */
@WebServlet("/servletcontrato")
public class ServletContrato extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletContrato() {
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
		AccesoContratos ac1=null;
		Contratos jContratos =null;
		switch (jopcion) {
		case 1:
			//Mostrar un Contrato
			//Aquí entrará al pinchar desde la pantalla pedirunContratos, a cuyo usebean se 
			//ha identificado como "s1". Recoge el atributo desde el ámbito ¿Aplicación o sesión?
			jContratos =  (Contratos) r.getAttribute("c1"); //hacemos casting
			ac1=new AccesoContratos();
			try {
				jContratos = ac1.mostrarUnContrato(jContratos.getIdcontrato());
				System.out.println("Un Contrato de la BBDD" + jContratos.valueOf());
			} 
			catch (ExcepcionUno e) {//Excepción personalizada para cuando no existen registros para el id 
				// TODO Auto-generated catch block
				System.out.println(e.toString());
				r.setAttribute("mensaje", "El Id Contrato " + jContratos.getIdcontrato() + " no existe");
			}
			catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.toString());
			} 
			//Se guarda el producto con los datos que se obtienen de la BBDD
			//en el ámbito request
			r.setAttribute("c1", jContratos);
			rd = r.getRequestDispatcher("/mostraruncontrato.jsp");
			rd.forward(r, response);
			break;
			
		case 2:
			//Entra aquí cuando se hace clic en el enlace de mostrartodos de menú de Contratoss
			//Declaramos la variable que es un list de Contratoss
			//Instanciar ArrayList y AccesoContratos
			
			List<Contratos> contratosBBDD = null;
			ac1 = new AccesoContratos();
			try {
				contratosBBDD = ac1.mostrartodosContratos();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.toString());
			}
			// Guardar los Contratoss en el ámbito request
			
			r.setAttribute("rtodos", contratosBBDD);
			
			//Redirigir a la página mostrartodos.jsp
			rd = r.getRequestDispatcher("/mostrartodoscontratos.jsp");
			rd.forward(r, response);
			
			break;
			
		case 3:
			//Recogemos los valores del formulario insertarContratos (los valores que vienen en el name)
	        //Instanciamos un objeto de la clase Contratos, con el constructor adecuado
	        //Los getParameter sólo devuelven String. 
	        //Los parámetros recogidos con getParameter se recogen de los campos name del 
	        //formulario, por lo que deben coincidir al 100% con el nombre ahí almacenado
			//String descripcion, double coste, int id, double iva
			try {
			Contratos c1 = new Contratos
					(Integer.parseInt(r.getParameter("id")), 
					Double.parseDouble(r.getParameter("comision")), 
	        		r.getParameter("encargadofacturacion"));  
				ac1 = new AccesoContratos();
				numregistros = ac1.insertarContrato(c1);
				if (numregistros > 0) {
					System.out.println("Se ha dado de alta el registro en nuestra BBDD ");
				} else {
					System.out.println("¡Ops! Ha habido algún error. Lo sentimos");
				}
				//Redirigir a la página insertarContratos.jsp
				rd = r.getRequestDispatcher("/insertarcontrato.jsp");
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
