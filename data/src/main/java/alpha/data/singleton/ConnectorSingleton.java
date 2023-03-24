package alpha.data.singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;



public class ConnectorSingleton {

	private static Connection conexion = null;

	private ConnectorSingleton() {
		// conector en clase privado para que no se pueda instanciar
	}

	public static Connection closeConnector() {
		if (conexion != null) {
			try {
				conexion.close();

			} catch (SQLException e) {
				System.err.println("Error al cerrar la conexión");
			}
		}
		return conexion;
	}

	public static boolean closeAll(ResultSet rs) {
		if (conexion != null) {
			try {
				conexion.close();
				rs.close();
				return true;
			} catch (SQLException e) {
				System.err.println("Error al cerrar la conexión closeAll()");
			}
		}
		return false;
	}

	public static Connection getConnector() {

		try {
			if (conexion == null) {

				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_servlet", "root", "");
					System.out.println("Conexion establecida");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("Error en Driver Manager");
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conexion;
	}

	// creamos un metodo que devuelva un resulset para no tener tanto codigo

	public static Optional<ResultSet> getResulsetBD(String query) {
		ConnectorSingleton.getConnector();
		// execute query optional of es sin nulo, instanciandolo asi en ofNullable
		// decimos que opuede ser nulo
		// Optional<ResultSet> rsResultSet = Optional.ofNullable(null);
		Optional<ResultSet> rsResultSet = Optional.empty();// este devuelve vacio
		// sin prepae statement no hay opcion para evitar inyecciones
		try {
			PreparedStatement stmt = conexion.prepareStatement(query);
			rsResultSet = Optional.of(stmt.executeQuery());
		} catch (SQLException e) {
			System.err.println("Error en getResulsetBD(String query)");
		}

		return rsResultSet;

	}
	
	public static Optional<ResultSet> getResulsetBDWithParams(String query,List<String>fields) {
		
		ConnectorSingleton.getConnector();
		// execute query optional of es sin nulo, instanciandolo asi en ofNullable
		// decimos que opuede ser nulo
		// Optional<ResultSet> rsResultSet = Optional.ofNullable(null);
		Optional<ResultSet> rsResultSet = Optional.empty();// este devuelve vacio
		// sin prepae statement no hay opcion para evitar inyecciones		
		try {
			PreparedStatement stmt = conexion.prepareStatement(query);
			for (int i = 1; i <= fields.size(); i++) {
			stmt.setString(i, fields.get(i-1));//le mandamos un list para inyecciones
			}
			rsResultSet = Optional.of(stmt.executeQuery());
		} catch (SQLException e) {
			System.err.println("Error en getResulsetBDWithParams(String query)");
		}

		return rsResultSet;

	}

	public static Optional<Boolean> existResulset(String query, int id) {
		// con preparestatement evitamos inyecciones
		ConnectorSingleton.getConnector();
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setInt(1, id);// valor uno a la inerrogacion
			ResultSet rset = ps.executeQuery();
			if (rset.next()) {
				return Optional.of(true);
			}
		} catch (SQLException e) {
			System.err.println("Error en existResulset(String query, int id)" + ConnectorSingleton.class);
			e.printStackTrace();
		}
		ConnectorSingleton.closeConnector();
		return Optional.of(false);
	}
}
