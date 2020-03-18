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

		// Abrir la conexi�n

		abrirConexion();

		// recoger el comando de la conexi�n

		st = miConexion.prepareCall(sql);

		// Ejecutar el comando

		rs = st.executeQuery();
		// Recorrer el ResultSet para crear la colecci�n

		while (rs.next()) {
			Contratos c1 = new Contratos(
					rs.getInt("idcontrato"),
					rs.getInt("id_proveedor"), 
					rs.getDouble("comision"),
					rs.getString("encargado_facturacion"));
			 		
			// A�adimos los registros a la colecci�n

			todos.add(c1);
		}
		
		// cerrar conexi�n

		cerrarConexion();

		return todos;

	}
	// A�adimos el m�todo mostrar uno

	public Contratos mostrarUnContrato(int id) throws ExcepcionUno, SQLException, ClassNotFoundException {
		// Definir las variables
		String sql = "call mostraruncontrato(?);";
		Contratos uno = null;
		CallableStatement st = null;
		ResultSet rs = null;

		// Abrir la conexi�n

		abrirConexion();

		// recoger el comando de la conexi�n

		st = miConexion.prepareCall(sql);

		// Asignar valor al par�metro
		st.setInt(1, id);

		// Ejecutar el comando

		rs = st.executeQuery();
		// Recorrer el ResultSet para crear la colecci�n
		
		int num=0;

		if (rs.next()) {
			uno = new Contratos(
					rs.getInt("idcontrato"),
					rs.getInt("id_proveedor"), 
					rs.getDouble("comision"),
					rs.getString("encargado_facturacion"));
			num++;
		}
		//Comprobar si se recibe alg�n registro
		System.out.println("El n�mero de registros es " + num);
		if (num==0) {
			throw new ExcepcionUno("No hay un jodido registro para este id");
		}

		// cerrar conexi�n

		cerrarConexion();

		return uno;

	}
	// A�adimos el m�todo insertar un Contratos
	
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
