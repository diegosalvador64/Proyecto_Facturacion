package com.vipper.persistencia;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;



public class Conexion {


//	    Esta clase va tener principalmente dos m�todos el abrir conexion
//	    Cerrar conexion
	    protected Connection miConexion;

	    public void abrirConexion() throws ClassNotFoundException, SQLException {
	        //Cargar el driver
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        //En serverTimezone=Europe/Madrid lo pongo as� para que inserte la fecha correctammnete desde un formulario con un campo formato Date
	        String stringConexion = "jdbc:mysql://localhost:3306/facturacion?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Europe/Madrid&autoReconnect=true&useSSL=false";
	        miConexion = DriverManager.getConnection(stringConexion, "root", "Curso2019$");   
	        System.out.println("Exito al abrir la conexion");
	    }

	    public void cerrarConexion() throws SQLException {
	        miConexion.close();
	    }

	}

	



