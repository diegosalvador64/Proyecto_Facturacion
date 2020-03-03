package com.vipper.persistencia;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vipper.modelo.Pedido;

public class AccesoPedido extends Conexion {
	public List<Pedido> mostrartodospedidos() throws ClassNotFoundException, SQLException {
		// Definir las variables
		String sql = "call mostrartodospedidos();";
		List<Pedido> todos = new ArrayList<Pedido>();
		CallableStatement st;
		ResultSet rs;

		// Abrir la conexión

		abrirConexion();

		// recoger el comando de la conexión

		st = miConexion.prepareCall(sql);

		// Ejecutar el comando

		rs = st.executeQuery();
		// Recorrer el ResultSet para crear la colección

		while (rs.next()) {
			Pedido p1 = new Pedido(rs.getInt("idpedido"), rs.getString("descripcion"), 
					rs.getInt("id"), rs.getInt("idformapago"),rs.getDouble("total"), 
					rs.getDate("fecha"), 
					rs.getInt("idservicios"),
					rs.getInt("idcontrato"),
					rs.getDouble("importe_facturado"));
					
			// Añadimos los registros a la colección

			todos.add(p1);
		}

		// cerrar conexión

		cerrarConexion();

		return todos;

	}
	// Añadimos el método mostrar uno

	public Pedido mostrarUnPedido(int id) throws SQLException, ClassNotFoundException {
		// Definir las variables
		String sql = "call mostraunpedido(?);";
		Pedido uno = null;
		CallableStatement st = null;
		ResultSet rs = null;

		// Abrir la conexión

		abrirConexion();

		// recoger el comando de la conexión

		st = miConexion.prepareCall(sql);

		// Asignar valor al parámetro
		st.setInt(1, id);

		// Ejecutar el comando

		rs = st.executeQuery();
		// Recorrer el ResultSet para crear la colección

		if (rs.next()) {
			uno = new Pedido (rs.getInt("idpedido"), rs.getString("descripcion"), 
					rs.getInt("id"), rs.getInt("idformapago"),rs.getDouble("total"), 
							rs.getDate("fecha"), 
							rs.getInt("idservicios"),
							rs.getInt("idcontrato"),
							rs.getDouble("importe_facturado"));
		}
	

		// cerrar conexión

		cerrarConexion();

		return uno;

	}

	public int insertarPedido(Pedido p1) throws ClassNotFoundException, SQLException {
		// Abrir la conexion
		abrirConexion();
		//Declarar las variables
		String sql = "call insertpedido(?,?,?,?);";
		CallableStatement st;
		int numRegistros;

		//Obtener el comando
		st = miConexion.prepareCall(sql);
		st.setString(1, p1.getDescripcion());
		st.setInt(2, p1.getId());
		st.setInt(3, p1.getIdformapago());
		st.setDouble(4, p1.getTotal());
		
		

		//Ejecutar el comando
		numRegistros = st.executeUpdate();
		//Cerrar la conexion
		cerrarConexion();
		return numRegistros;

	}

}
