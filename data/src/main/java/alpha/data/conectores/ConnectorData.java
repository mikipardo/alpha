package alpha.data.conectores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectorData {

	public static void main(String[] args) {
	
			Connection conexion = null;
		
				try {
					if(conexion == null) {
						
						try {
							Class.forName("com.mysql.cj.jdbc.Driver");
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						try {//este siempre es fijo en local
							conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_servlet", "root", "");
							System.out.println("va bene");
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							System.out.println("Error en Driver Manager");
						}
						// este comentario es para vver si funciona
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//execute query
			    String query = "select * from coches;";
			    try (Statement stmt = conexion.createStatement()) {
			      ResultSet rs = stmt.executeQuery(query);
			      while (rs.next()) {
			      
			        int id = rs.getInt("id");
			        String marca = rs.getString("marca");
			        String modelo = rs.getString("modelo");
			        Double precio = rs.getDouble("precio");
			        System.out.println(id + ", " + marca + ", " + modelo +
			                           ", " + precio + " €.");
			      }
			    } catch (SQLException e) {
			   System.err.println(e);
			    }
			
			    
			}
	
}
