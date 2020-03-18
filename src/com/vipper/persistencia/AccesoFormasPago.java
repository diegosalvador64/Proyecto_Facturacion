package com.vipper.persistencia;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vipper.modelo.ExcepcionUno;
import com.vipper.modelo.FormasPago;

public class AccesoFormasPago extends Conexion {
	
	public List<FormasPago> mostrartodasFormasPago() throws ClassNotFoundException, SQLException {
		// Definir las variables
		String sql = "call mostrartodosformaspago();";
		List<FormasPago> todos = new ArrayList<FormasPago>();
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
			FormasPago f1 = new FormasPago(
					rs.getInt("idformapago"),
					rs.getString("descripcion"), 
					rs.getDouble("valor"));
			 
		// Añadimos los registros a la colección

			todos.add(f1);
		}
		
		// cerrar conexión

		cerrarConexion();

		return todos;

	}
	// Añadimos el método mostrar uno

	public FormasPago mostrarunaFormaPago(int idformapago) throws ExcepcionUno, SQLException, ClassNotFoundException {
		// Definir las variables
		String sql = "call mostrarunaformapago(?);";
		FormasPago uno = null;
		CallableStatement st = null;
		ResultSet rs = null;

		// Abrir la conexión

		abrirConexion();

		// recoger el comando de la conexión

		st = miConexion.prepareCall(sql);

		// Asignar valor al parámetro
		st.setInt(1, idformapago);
		
		// Ejecutar el comando

		rs = st.executeQuery();
		// Recorrer el ResultSet para crear la colección
		
		int num=0;

		if (rs.next()) {
			uno = new FormasPago(
					rs.getInt("idformapago"),
					rs.getString("descripcion"), 
					rs.getDouble("valor"));
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
	// Añadimos el método insertar una Forma de Pago
	
	public int insertarFormaPago(FormasPago f1) throws ClassNotFoundException, SQLException {
		// Abrir la conexion
		abrirConexion();
		//Declarar las variables
		String sql = "call insertarformapago(?,?);";
		CallableStatement st;
		int numRegistros;

		//Obtener el comando
		st = miConexion.prepareCall(sql);
		st.setString(1, f1.getDescripcion());
		st.setDouble(2, f1.getValor());
		
		//Ejecutar el comando
		numRegistros = st.executeUpdate();
		//Cerrar la conexion
		cerrarConexion();
		return numRegistros;

	}


}
