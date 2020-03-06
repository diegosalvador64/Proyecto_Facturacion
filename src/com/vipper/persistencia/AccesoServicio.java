package com.vipper.persistencia;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vipper.modelo.Pedido;
import com.vipper.modelo.Servicio;

public class AccesoServicio extends Conexion {

	
		public List<Servicio> mostrartodosservicios() throws ClassNotFoundException, SQLException {
			// Definir las variables
			String sql = "call mostrartodosservicios();";
			List<Servicio> todos = new ArrayList<Servicio>();
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
				Servicio s1 = new Servicio(rs.getInt("idservicios"), 
						rs.getString("descripcion"),
						rs.getDouble("coste"),
						rs.getInt("id"), 
						rs.getDouble("iva"));
				 		
				// Añadimos los registros a la colección

				todos.add(s1);
			}
			
			// cerrar conexión

			cerrarConexion();

			return todos;

		}
		// Añadimos el método mostrar uno

		public Servicio mostrarUnServicio(int id) throws SQLException, ClassNotFoundException {
			// Definir las variables
			String sql = "call mostrarunservicio(?);";
			Servicio uno = null;
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
				uno = new Servicio(rs.getInt("idservicios"), 
						rs.getString("descripcion"),
						rs.getDouble("coste"),
						rs.getInt("id"), 
						rs.getDouble("iva"));
			}
		

			// cerrar conexión

			cerrarConexion();

			return uno;

		}
		// Añadimos el método insertar un servicio
		
		public int insertarServicio(Servicio s1) throws ClassNotFoundException, SQLException {
			// Abrir la conexion
			abrirConexion();
			//Declarar las variables
			String sql = "call insertarservicio(?,?,?,?);";
			CallableStatement st;
			int numRegistros;

			//Obtener el comando
			st = miConexion.prepareCall(sql);
			st.setString(1, s1.getDescripcion());
			st.setDouble(2, s1.getCoste());
			st.setInt(3, s1.getId());
			st.setDouble(4, s1.getIva());
			
			//Ejecutar el comando
			numRegistros = st.executeUpdate();
			//Cerrar la conexion
			cerrarConexion();
			return numRegistros;

		}

}
