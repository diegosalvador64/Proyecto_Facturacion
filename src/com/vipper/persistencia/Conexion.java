package com.vipper.persistencia;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;



public class Conexion {


//	    Esta clase va tener principalmente dos métodos el abrir conexion
//	    Cerrar conexion
	    protected Connection miConexion;

	    public void abrirConexion() throws ClassNotFoundException, SQLException {
	        //Cargar el driver
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        String stringConexion = "jdbc:mysql://localhost:3306/facturacion?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&autoReconnect=true&useSSL=false";
	        miConexion = DriverManager.getConnection(stringConexion, "root", "Curso2019$");
	        System.out.println("Exito al abrir la conexion");
	    }

	    public void cerrarConexion() throws SQLException {
	        miConexion.close();
	    }

	}

	



