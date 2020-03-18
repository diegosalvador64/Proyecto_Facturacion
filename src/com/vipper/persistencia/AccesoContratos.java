package com.vipper.persistencia;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vipper.modelo.Contratos;
import com.vipper.modelo.ExcepcionUno;

public class AccesoContratos extends Conexion {
	
	public List<Contratos> mostrartodosContratos() throws ClassNotFoundException, SQLException {
		// Definir las variables
		String sql = "call mostrartodoscontratos();";
		List<Contratos> todos = new ArrayList<Contratos>();
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
			Contratos c1 = new Contratos(
					rs.getInt("idcontrato"),
					rs.getInt("id_proveedor"), 
					rs.getDouble("comision"),
					rs.getString("encargado_facturacion"));
			 		
			// Añadimos los registros a la colección

			todos.add(c1);
		}
		
		// cerrar conexión

		cerrarConexion();

		return todos;

	}
	// Añadimos el método mostrar uno

	public Contratos mostrarUnContrato(int id) throws ExcepcionUno, SQLException, ClassNotFoundException {
		// Definir las variables
		String sql = "call mostraruncontrato(?);";
		Contratos uno = null;
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
			uno = new Contratos(
					rs.getInt("idcontrato"),
					rs.getInt("id_proveedor"), 
					rs.getDouble("comision"),
					rs.getString("encargado_facturacion"));
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
	// Añadimos el método insertar un Contratos
	
	public int insertarContrato(Contratos c1) throws ClassNotFoundException, SQLException {
		// Abrir la conexion
		abrirConexion();
		//Declarar las variables
		String sql = "call insertarcontrato(?,?,?);";
		CallableStatement st;
		int numRegistros;

		//Obtener el comando
		st = miConexion.prepareCall(sql);
		st.setInt(1, c1.getId());
		st.setDouble(2, c1.getComision());
		st.setString(3, c1.getEncargadofacturacion());
		
		//Ejecutar el comando
		numRegistros = st.executeUpdate();
		//Cerrar la conexion
		cerrarConexion();
		return numRegistros;

	}


}
