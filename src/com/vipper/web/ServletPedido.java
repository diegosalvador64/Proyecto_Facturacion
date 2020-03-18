package com.vipper.web;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vipper.modelo.Contratos;
import com.vipper.modelo.ExcepcionUno;
import com.vipper.modelo.Pedidos;
import com.vipper.persistencia.AccesoContratos;
import com.vipper.persistencia.AccesoPedidos;

/**
 * Servlet implementation class ServletPedido
 */
@WebServlet("/servletpedido")
public class ServletPedido extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPedido() {
        super();
        // TODO Auto-generated constructor stub
    }
  
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest r, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//r.setAttribute("mensaje", " ");
		int jopcion = Integer.parseInt(r.getParameter("op"));
		RequestDispatcher rd =  null;
		int jid = 0;
		int numregistros=0;
		HttpSession miSesion = null;
		AccesoPedidos ap1=null;
		Pedidos jPedidos =null;
		switch (jopcion) {
		case 1:
			//Mostrar un Pedido
			//Aquí entrará al pinchar desde la pantalla pedirunpedido, a cuyo usebean se 
			//ha identificado como "p1". Recoge el atributo desde el ámbito ¿Aplicación o sesión?
			jPedidos =  (Pedidos) r.getAttribute("p1"); //hacemos casting
			System.out.println("El idpedido es " + jPedidos.getIdpedido());
			ap1=new AccesoPedidos();
			try {
				jPedidos = ap1.mostrarUnPedido(jPedidos.getIdpedido());
				System.out.println("Un Pedido de la BBDD" + jPedidos.valueof());	
			} 
			catch (ExcepcionUno e) { //Excepción personalizada para cuando no existen registros para el id 
				// TODO Auto-generated catch block
				System.out.println(e.toString());
				r.setAttribute("mensaje", "El Id Pedido " + jPedidos.getIdpedido() + " no existe");
			}
			catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.toString());
			} 
			//Se guarda el pedido con los datos que se obtienen de la BBDD
			//en el ámbito request
			r.setAttribute("p1", jPedidos);
			rd = r.getRequestDispatcher("/mostrarunpedido.jsp");
			rd.forward(r, response);
			break;
			
		case 2:
			//Entra aquí cuando se hace clic en el enlace de mostrartodos de menú de Pedidos
			//Declaramos la variable que es un list de Pedidos
			//Instanciar ArrayList y AccesoContratos
			
			List<Pedidos> pedidosBBDD = null;
			ap1 = new AccesoPedidos();
			try {
				pedidosBBDD = ap1.mostrartodosPedidos();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.toString());
			}
			// Guardar los Pedidos en el ámbito request
			
			r.setAttribute("rtodos", pedidosBBDD);
			
			//Redirigir a la página mostrartodos.jsp
			rd = r.getRequestDispatcher("/mostrartodospedidos.jsp");
			rd.forward(r, response);
			
			break;
			
		case 3:
			//Recogemos los valores del formulario insertarpedido (los valores que vienen en el name)
	        //Instanciamos un objeto de la clase Pedidos, con el constructor adecuado
	        //Los getParameter sólo devuelven String. 
	        //Los parámetros recogidos con getParameter se recogen de los campos name del 
	        //formulario, por lo que deben coincidir al 100% con el nombre ahí almacenado
			//(String descripcion, int id, int idformapago, double total, Date fecha, int idservicios,
			//int idcontrato, double importe_facturado)
			try {
			Pedidos p1 = new Pedidos (r.getParameter("descripcion"), 
									Integer.parseInt(r.getParameter("id")),
									Integer.parseInt(r.getParameter("idformapago")),
									Double.parseDouble(r.getParameter("total")), 
									Date.valueOf(r.getParameter("fecha")),
									Integer.parseInt(r.getParameter("idservicios")),
									Integer.parseInt(r.getParameter("idcontrato")),
									Double.parseDouble(r.getParameter("importe_facturado"))); 
					 
					
				//	(Integer.parseInt(r.getParameter("id")), 
				//	Double.parseDouble(r.getParameter("comision")), 
	        	//	r.getParameter("encargadofacturacion"));  
				ap1 = new AccesoPedidos();
				numregistros = ap1.insertarPedido(p1);
				if (numregistros > 0) {
					System.out.println("Se ha dado de alta el registro en nuestra BBDD ");
				} else {
					System.out.println("¡Ops! Ha habido algún error. Lo sentimos");
				}
				//Redirigir a la página insertarpedido.jsp
				rd = r.getRequestDispatcher("/insertarpedido.jsp");
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
