package com.vipper.web;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vipper.modelo.ExcepcionUno;
import com.vipper.modelo.Factura;
import com.vipper.modelo.Pedidos;
import com.vipper.persistencia.AccesoFactura;
import com.vipper.persistencia.AccesoPedidos;

/**
 * Servlet implementation class ServletFacturas
 */
@WebServlet("/servletfacturas")
public class ServletFacturas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletFacturas() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest r, HttpServletResponse response) throws ServletException, IOException {
		int jopcion = Integer.parseInt(r.getParameter("op"));
		RequestDispatcher rd =  null;
		int jid = 0;
		int numregistros=0;
		HttpSession miSesion = null;
		AccesoFactura af1=null;
		Factura jFactura =null;
		LocalDate hoy = LocalDate.now();
		switch (jopcion) {
					
		case 1:
			//Entra aquí cuando se hace clic en el enlace de Actualización batch de menú de Facturas
			//Declaramos la variable que es un list de Facturas
			//Instanciar ArrayList y AccesoContratos
			
			List<Factura> facturaBBDD = null;
			af1 = new AccesoFactura();
			
			try {
				af1.actualizarFacturas(hoy);//Actualizo las columnas que quiera. Para la fecha de hoy le meto coomo parámetro el LocalDate.
				//Después llamo a mostrarlas por pantalla
				facturaBBDD = af1.mostrartodasFacturas();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.toString());
			}
			// Guardar los Facturas en el ámbito request
			
			r.setAttribute("rtodos", facturaBBDD);
			
			//Redirigir a la página mostrartodos.jsp
			rd = r.getRequestDispatcher("/mostrarfacturasactualizadas.jsp");
			rd.forward(r, response);
			
			break;
		case 2:
			//Entra aquí cuando se hace clic en insertar facturas de menú de Facturas
			//Recogemos los valores del formulario insertarfactura (los valores que vienen en el name)
	        //Instanciamos un objeto de la clase Factura, con el constructor adecuado
	        //Los getParameter sólo devuelven String. 
	        //Los parámetros recogidos con getParameter se recogen de los campos name del 
	        //formulario, por lo que deben coincidir al 100% con el nombre ahí almacenado
			try {
				
				Factura f1 = new Factura (Integer.parseInt(r.getParameter("id")),
									Integer.parseInt(r.getParameter("idpedido")),
									Integer.parseInt(r.getParameter("idservicios")),
									Double.parseDouble(r.getParameter("importe")), 
									Integer.parseInt(r.getParameter("idformapago")),						
									Integer.parseInt(r.getParameter("idcontrato")));
									
				af1 = new AccesoFactura();
				numregistros = af1.insertarFactura(f1);
				//En el procedimiento almacenado si alguno de los id no existe en su tabla correspondiente, devuelve numregistros=-1
				//Para hacer eso he tenido que poner contador=0, pero devuelve -1. Cosas del Java
				if (numregistros > 0) {
					System.out.println("Se ha dado de alta el registro en nuestra BBDD ");
					r.setAttribute("mensaje", "Su alta ha sido exitosa");
				} else {
					System.out.println("¡Ops! Ha habido algún error. Lo sentimos");
					r.setAttribute("mensaje", "No se ha podido dar de alta");
				}
				//Redirigir a la página insertarfactura.jsp
				rd = r.getRequestDispatcher("/insertarfactura.jsp");
				
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


