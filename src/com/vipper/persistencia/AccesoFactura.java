package com.vipper.persistencia;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.sun.xml.internal.ws.util.StringUtils;
import com.vipper.modelo.Contratos;
import com.vipper.modelo.Factura;
import com.vipper.modelo.Pedidos;

public class AccesoFactura extends Conexion {
	public void actualizarFacturas(LocalDate fecha) throws ClassNotFoundException, SQLException {
		
		ResultSet rs;
		//
		// Abrir la conexión

			abrirConexion();
		Statement st = null;
		//st = miConexion.createStatement();
        st = miConexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                   						ResultSet.CONCUR_UPDATABLE);
        
     // recoger el comando de la conexión y ejecutar el comnado
        rs = st.executeQuery(
            "SELECT * FROM facturas");

       	// recoger el comando de la conexión

		        
     // Recorrer el ResultSet para modificar las columnas que desee con las condiciones que estime convenientes
     //El IVA lo actualizo en función del Importe y del servicio, que tendrá asociado a un IVA. La fecha pongo la de hoy
     //Para el concepto lo relleno en función de la forma de pago 
     
        while (rs.next()) {
        		//Rellenar fecha
        			Date bdfecha = rs.getDate("fecha");
					if (bdfecha==null) {
						Date hoy = Date.valueOf(fecha);
		    			rs.updateDate("fecha", hoy);
						}
					
				//Rellenar 	concepto en función de la forma de pago
					
					int bdformapago = rs.getInt("idformapago");
					String concepto1=null;
					switch (bdformapago) {
					case 1:
						concepto1="Pagado a plazos";
						break;
					case 2:
						concepto1="Pagado al contado";
						break;
					case 3:
						concepto1="Pagado a plazos bancarios";
						break;
					case 4:
						concepto1="Pagado como buenamente se ha podido";
						break;
					default:
						break;
					}
					
					String bconcepto = rs.getString("concepto");
										
					if (bconcepto==null) {
						rs.updateString( "concepto", concepto1);
					}
					
        			
        		//Calcular el IVA a partir del importe en función del servicio
        			double bimporte = rs.getDouble("importe");
        			double piva=0;
        			int bservicio = rs.getInt("idservicios");
        			System.out.println("bservicio es " + bservicio);
        			switch (bservicio) {
						case 1:
						case 2:
							piva=0.04;
							break;
						case 3:
						case 4:
							piva=0.10;
							break;
						case 5:
							piva=0.15;
							break;
						case 6:
							piva=0.21;
							break;
						default:
							break;
        			}
        			System.out.println("El iva resultante es " + piva);
        			System.out.println("El importe es " + bimporte);
        			
        			Double biva= rs.getDouble("iva");
        			if (biva==0) {
        				rs.updateDouble("iva", bimporte * piva);
        			}
        			
        			
        			//Actualiza toda la fila
        			rs.updateRow();
        }
		
		
		// cerrar conexión

		cerrarConexion();

	}
	public List<Factura> mostrartodasFacturas() throws ClassNotFoundException, SQLException {
		// Definir las variables
		String sql = "call mostrartodasfacturas();";
		List<Factura> todos = new ArrayList<Factura>();
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
			Factura c1 = new Factura(
					rs.getInt("idfactura"),
					rs.getInt("id"), 
					rs.getInt("idpedido"),
					rs.getDate("fecha"),
					rs.getInt("idservicios"),
					rs.getDouble("importe"),
					rs.getInt("idformapago"),
					rs.getInt("idcontrato"),
					rs.getString("concepto"),
					rs.getDouble("iva"));
			 		
			// Añadimos los registros a la colección
			
			todos.add(c1);
		}
		
		// cerrar conexión

		cerrarConexion();

		return todos;

	}
	
	// Añadimos el método insertar una Factura
	
		public int insertarFactura(Factura f1) throws ClassNotFoundException, SQLException {
			// Abrir la conexion
			abrirConexion();
			//Declarar las variables
			String sql = "call insertarfactura(?,?,?,?,?,?);";
			CallableStatement st;
			int numRegistros=0;
			//String descripcion, int id, int idformapago, double total, Date fecha, int idservicios,
			//int idcontrato, double importe_facturado
			//Obtener el comando
			st = miConexion.prepareCall(sql);
			st.setInt(1, f1.getId());
			st.setInt(2, f1.getIdpedido());
			st.setInt(3, f1.getIdservicios());	
			st.setDouble(4, f1.getImporte());
			st.setInt(5, f1.getIdformapago());
			st.setInt(6, f1.getIdcontrato());
			//Ejecutar el comando
			numRegistros = st.executeUpdate();
			//Cerrar la conexion
			cerrarConexion();
			return numRegistros;
			
		}

}
