package com.vipper.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vipper.modelo.ClienteProveedor;
import com.vipper.modelo.ExcepcionUno;
import com.vipper.persistencia.AccesoFacturacion;


/**
 * Servlet implementation class ServletFacturacion
 */
@WebServlet("/servletfacturacion")
public class ServletFacturacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletFacturacion() {
        super();
        // TODO Auto-generated constructor stub
    }
  //Método init para hacer cosas al ejecutarse la primera vez, que 
    //en este caso es recoger el parámetro inicial que hemos metido
    //en web.xml entre las etiquetas <init-param>
    @Override
    public void init(ServletConfig config) throws ServletException {
    	// TODO Auto-generated method stub
    	//Recuperar el parámetro inicial del web.xml que se llama "mensaje"
    	String jmensaje = config.getServletContext().getInitParameter("mensaje");
    	System.out.println("mensaje --> " + jmensaje);
    	//Recuperar el ámbito de la aplicación
    	ServletContext af1 = config.getServletContext();
    	//Guardamos aquí el mensaje. amensaje es un nombre nuevo de clave
    	//válido para todas las sesiones
    	af1.setAttribute("amensaje", jmensaje);
    	super.init(config);
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
		AccesoFacturacion af1=null;
		//boolean jusuariologueado= false; Variable de java
		ClienteProveedor jclienteproveedor=null;
		switch (jopcion) {
		case 1:
			jclienteproveedor =(ClienteProveedor) r.getAttribute("cp1"); //hacemos casting
			af1=new AccesoFacturacion();
			try {
				jclienteproveedor = af1.mostrarUnoCliente(jclienteproveedor.getId());
				System.out.println("Un cliente-proveedor de la BBDD" + jclienteproveedor.valueOf());
			} catch (ExcepcionUno e) {//Excepción personalizada para cuando no existen registros para el id
				// TODO Auto-generated catch block
				System.out.println(e.toString());
				r.setAttribute("mensaje", "El Cliente/Proveedor " + jclienteproveedor.getId() + " no existe");
			}	
			
			catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.toString());
			} 
			
			//Se guarda el producto con los datos que se obtienen de la BBDD
			//en el ámbito request
			r.setAttribute("cp1", jclienteproveedor);
			rd = r.getRequestDispatcher("/mostrarclienteproveedor.jsp");
			rd.forward(r, response);
			break;
			
		case 2:
			//Entra aquí cuando se hace clic en el enlace de mostrartodos de index.html
			//Declaramos la variable que es un list de productos
			//Instanciar ArrayList y AccesoProductos
			
			List<ClienteProveedor> clientesproveedoresBBDD = null;
			af1 = new AccesoFacturacion();
			try {
				clientesproveedoresBBDD = af1.mostrartodosclientes();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.toString());
			}
			// Guardar los productos en el ámbito request
			
			r.setAttribute("rtodos", clientesproveedoresBBDD);
			
			//Redirigir a la página mostrartodos.jsp
			rd = r.getRequestDispatcher("/mostrartodoscliente.jsp");
			rd.forward(r, response);
			
			break;
			
		case 3:
			//Recogemos los valores del formulario insertarcliente (los valores que vienen en el name)
	        //Instanciamos un objeto de la clase ClienteProveedor, con el constructor adecuado
	        //Los getParameter sólo devuelven String. 
	        //Los parámetros recogidos con getParameter se recogen de los campos name del 
	        //formulario, por lo que deben coincidir al 100% con el nombre ahí almacenado
			try {
			ClienteProveedor cp1 = new ClienteProveedor
	         	(r.getParameter("nif"), 
	        		r.getParameter("nombre"), 
	        		r.getParameter("direccion"), 
	        		r.getParameter("tipo").toUpperCase(),
	        		r.getParameter("email"),
	        		r.getParameter("telefono"));  
				af1 = new AccesoFacturacion();
				numregistros = af1.insertarClienteProveedor(cp1);
				if (numregistros > 0) {
					System.out.println("Se ha dado de alta el registro en nuestra BBDD ");
				} else {
					System.out.println("¡Ops! Ha habido algún error. Lo sentimos");
				}
				//Redirigir a la página mostrartodos.jsp
				rd = r.getRequestDispatcher("/insertarcliente.jsp");
				r.setAttribute("mensaje", "Su alta ha sido exitosa");
				rd.forward(r, response);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.toString());
			}
			
		case 4:
			try {
			af1 = new AccesoFacturacion();
			numregistros = af1.modificarClienteProveedor(Integer.parseInt(r.getParameter("id")), r.getParameter("direccion"));
			System.out.println("numregistros " + numregistros);
			if (numregistros > 0) {
				System.out.println("Se ha modificado el registro en nuestra BBDD ");
				r.setAttribute("mensaje", "Se ha modificado el registro");
			} else {
				System.out.println("¡Ops! Ha habido algún error. Lo sentimos");
				r.setAttribute("mensaje", "Ha habido error: no se ha modificado el registro");
			}
			//Redirigir a la página mostrartodos.jsp
			rd = r.getRequestDispatcher("/modificarclienteproveedor.jsp");
			rd.forward(r, response);
			} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
			}
			break;
			
		case 5:
			jclienteproveedor =(ClienteProveedor) r.getAttribute("cp1"); //hacemos casting
			af1=new AccesoFacturacion();
			try {
				numregistros = af1.borrarClienteProveedor(jclienteproveedor.getId());
				
				if (numregistros > 0) {
					System.out.println("Se ha borrado el registro");
					r.setAttribute("mensaje", "Se ha borrado el registro");
				} else {
					System.out.println("¡Ops! Ha habido algún error. Lo sentimos");
					r.setAttribute("mensaje", "No se ha borrado el registro");
				}
				
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.toString());
			}
			//Se guarda el producto con los datos que se obtienen de la BBDD
			//en el ámbito request
			r.setAttribute("cp1", jclienteproveedor);
			rd = r.getRequestDispatcher("/registroborradoclienteproveedor.jsp");
			rd.forward(r, response);
					
					
			break;	
		case 6:
			//Si la cookie no existe, se valida contra BBDD que el usuario
			//exista
			//Recogemos nombre y usuario del formulario
			//Acceder a la BBDD para verificar
			//Si es correcta la contraseña, redirigemos a /solicitarpago.jsp
			//y crear la cookie
			//Si no es correcto, redirigir a la página de registrarse
			String jusuario = r.getParameter("nombre");
			String jcontrasena = r.getParameter("contrasena");
			af1=new AccesoFacturacion();
			
			try {
				if (jcontrasena.equals(af1.verificarPassword(jusuario))) {
					//En el getRequestDispatcher la llamada va con barra
					rd = r.getRequestDispatcher("/menuprincipal.jsp");
					Cookie miCookie = new Cookie("usuariolog", jusuario);
					miCookie.setMaxAge(60*60);//ponemos una caducidad de 60 minutos a la cookie
					response.addCookie(miCookie);
					rd.forward(r, response);
				} else {
					rd = r.getRequestDispatcher("/index.jsp");
					r.setAttribute("mensaje", "Usuario o contraseña errónea");
					rd.forward(r, response);
				}
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


