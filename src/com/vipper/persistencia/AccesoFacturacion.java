package com.vipper.persistencia;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vipper.modelo.ClienteProveedor;

public class AccesoFacturacion extends Conexion {

	public List<ClienteProveedor> mostrartodosclientes() throws ClassNotFoundException, SQLException {
		// Definir las variables
		String sql = "call mostrartodoclientesproveedor();";
		List<ClienteProveedor> todos = new ArrayList<ClienteProveedor>();
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
			ClienteProveedor cp = new ClienteProveedor(rs.getInt("id"), rs.getString("NIF"), rs.getString("nombre"),
					rs.getString("direccion"), rs.getString("tipo"), rs.getString("email"), rs.getString("telefono"));

			// Añadimos los registros a la colección

			todos.add(cp);
		}

		// cerrar conexión

		cerrarConexion();

		return todos;

	}
	// Añadimos el método mostrar uno

	public ClienteProveedor mostrarUnoCliente(int id) throws SQLException, ClassNotFoundException {
		// Definir las variables
		String sql = "call mostraunoclienteproveedor(?);";
		ClienteProveedor uno = null;
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
			uno = new ClienteProveedor(rs.getInt("id"), rs.getString("NIF"), rs.getString("nombre"),
					rs.getString("direccion"), rs.getString("tipo"), rs.getString("email"), rs.getString("telefono"));

		}

		// cerrar conexión

		cerrarConexion();

		return uno;

	}

	public int insertarClienteProveedor(ClienteProveedor cp) throws ClassNotFoundException, SQLException {
		// Abrir la conexion
		abrirConexion();
		//Declarar las variables
		String sql = "call facturacion.insertunoclienteproveedor(?,?,?,?,?,?);";
		CallableStatement st;
		int numRegistros;

		//Obtener el comando
		st = miConexion.prepareCall(sql);
		st.setString(1, cp.getNif());
		st.setString(2, cp.getNombre());
		st.setString(3, cp.getDireccion());
		st.setString(4, cp.getTipo());
		st.setString(5, cp.getEmail());
		st.setString(6, cp.getTelefono());

		//Ejecutar el comando
		numRegistros = st.executeUpdate();
		//Cerrar la conexion
		cerrarConexion();
		return numRegistros;

	}
	
	public int modificarClienteProveedor(int id, String direccion ) throws ClassNotFoundException, SQLException {
		// Abrir la conexion
		abrirConexion();
		//Declarar las variables
		String sql = "call modificarclienteproveedor(?,?);";
		CallableStatement st;
		int numRegistros;

		//Obtener el comando
		st = miConexion.prepareCall(sql);
		st.setInt(1, id);
		st.setString(2, direccion);
	
		//Ejecutar el comando
		numRegistros = st.executeUpdate();
		//Cerrar la conexion
		cerrarConexion();
		return numRegistros;

	}

	public int borrarClienteProveedor(int id) throws ClassNotFoundException, SQLException {
		// Abrir la conexion
		abrirConexion();
		//Declarar las variables
		String sql = "call borrarclienteproveedor(?);";
		CallableStatement st;
		int numRegistros;

		//Obtener el comando
		st = miConexion.prepareCall(sql);
		st.setInt(1, id);
			
		//Ejecutar el comando
		numRegistros = st.executeUpdate();
		//Cerrar la conexion
		cerrarConexion();
		return numRegistros;

	}
	
	public String verificarPassword (String usuario) throws ClassNotFoundException, SQLException {
		//Declaramos las variables
		String sql="call verificarPassword(?);";
		//Declaramos un resultset
		CallableStatement st;
		//Hacemos ahora el resultset
		ResultSet rs;
		String password = null;
		
		//Abrir la conexión y decimos que la propague (primera opción)
		abrirConexion();
		
		//obtener el comando
		st = miConexion.prepareCall(sql);
		//Asignar el valor al parámetro de entrada
		
		st.setString(1, usuario);
		//Ejecutar el comando
		
		rs = st.executeQuery();
		
		if (rs.next()) {
			password = rs.getString("password"); //Este es el que coincide con nuestra BBDD
				
		}
		//Cerramos la conexión
		cerrarConexion();
		//Devolvemos la password
		return password;
	}
}
