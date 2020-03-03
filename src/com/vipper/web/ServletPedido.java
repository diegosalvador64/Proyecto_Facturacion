package com.vipper.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vipper.modelo.ClienteProveedor;
import com.vipper.modelo.Pedido;
import com.vipper.persistencia.AccesoFacturacion;
import com.vipper.persistencia.AccesoPedido;

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
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest r, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int jopcion = Integer.parseInt(r.getParameter("op"));
		RequestDispatcher rd = null;
		int jid = 0;
		int numregistros = 0;
		HttpSession miSesion = null;
		AccesoPedido ap1 = null;
		// boolean jusuariologueado= false; Variable de java
		Pedido jpedido = null;
		switch (jopcion) {
		case 1:
			jpedido = (Pedido) r.getAttribute("p1"); // hacemos casting
			ap1 = new AccesoPedido();
			try {
				jpedido = ap1.mostrarUnPedido(jpedido.getId());
				System.out.println("Un pedido de la BBDD" + jpedido.valueOf());
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.toString());
			}
			// Se guarda el producto con los datos que se obtienen de la BBDD
			// en el ámbito request
			r.setAttribute("p1", jpedido);
			rd = r.getRequestDispatcher("/mostrarpedido.jsp");
			rd.forward(r, response);
			break;

		default:
			break;

		}

	}
}