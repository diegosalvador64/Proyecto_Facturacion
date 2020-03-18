package com.vipper.persistencia;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.vipper.modelo.Contratos;
import com.vipper.modelo.ExcepcionUno;
import com.vipper.modelo.Pedidos;

public class AccesoPedidos extends Conexion {
	public List<Pedidos> mostrartodosPedidos() throws ClassNotFoundException, SQLException {
		// Definir las variables
		String sql = "call mostrartodospedidos();";
		List<Pedidos> todos = new ArrayList<Pedidos>();
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
			Pedidos p1 = new Pedidos(
					rs.getInt("idpedido"),
					rs.getString("a.descripcion"),
					rs.getInt("a.id"),
					rs.getInt("a.idformapago"),
					rs.getDouble("total"),
					rs.getDate("fecha"),
					rs.getInt("a.idservicios"),
					rs.getInt("a.idcontrato"),
					rs.getDouble("importe_facturado"),
					rs.getString("nifClienteProveedor"),
					rs.getString("descripcionFormaPago"),
					rs.getString("descripcionServicios"));						
		
			//Valores de la tabla;
			//idpedido, a.descripcion, a.id, a.idformapago, total, fecha, a.idservicios, a.idcontrato, importe_facturado, 
			//   b.NIF as nifClienteProveedor, c.descripcion as descripcionFormaPago, d.descripcion as descripcionServicios
			
			
			// Añadimos los registros a la colección

			todos.add(p1);
		}
		
		// cerrar conexión

		cerrarConexion();

		return todos;

	}
	// Añadimos el método mostrar uno

	public Pedidos mostrarUnPedido(int id) throws ExcepcionUno, SQLException, ClassNotFoundException {
		// Definir las variables
		String sql = "call mostrarunpedido(?);";
		Pedidos uno = null;
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
		
		int num=0;

		if (rs.next()) {
			uno = new Pedidos(
					rs.getInt("idpedido"),
					rs.getString("a.descripcion"),
					rs.getInt("a.id"),
					rs.getInt("a.idformapago"),
					rs.getDouble("total"),
					rs.getDate("fecha"),
					rs.getInt("a.idservicios"),
					rs.getInt("a.idcontrato"),
					rs.getDouble("importe_facturado"),
					rs.getString("nifClienteProveedor"),
					rs.getString("descripcionFormaPago"),
					rs.getString("descripcionServicios"));
			num++;
		}
		//Comprobar si se recibe algún registro
		System.out.println("El número de registros es " + num);
		if (num==0) {
			throw new ExcepcionUno("No hay un jodido registro para este id");
		}

		// cerrar conexión

		cerrarConexion();

		return uno;

	}
	// Añadimos el método insertar un pedido
	
	public int insertarPedido(Pedidos p1) throws ClassNotFoundException, SQLException {
		// Abrir la conexion
		abrirConexion();
		//Declarar las variables
		String sql = "call insertarpedido(?,?,?,?,?,?,?,?);";
		CallableStatement st;
		int numRegistros;
		//String descripcion, int id, int idformapago, double total, Date fecha, int idservicios,
		//int idcontrato, double importe_facturado
		//Obtener el comando
		st = miConexion.prepareCall(sql);
		st.setString(1, p1.getDescripcion());
		st.setInt(2, p1.getId());
		st.setInt(3, p1.getIdformapago());
		st.setDouble(4, p1.getTotal());	
		st.setDate(5, p1.getFecha());	
		st.setInt(6, p1.getIdservicios());
		st.setInt(7, p1.getIdcontrato());	
		st.setDouble(8, p1.getImporte_facturado());
		//Ejecutar el comando
		numRegistros = st.executeUpdate();
		//Cerrar la conexion
		cerrarConexion();
		return numRegistros;

	}
}
