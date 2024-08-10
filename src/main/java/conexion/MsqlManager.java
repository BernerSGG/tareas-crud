package conexion;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class MsqlManager {

	private static final String URL = "jdbc:mysql://localhost:3307/Colegio";
	private static final String USUARIO = "root";
	private static final String CONTRASEÑA = "TEAMOMAMI";

	public static Connection getConnection() {

		Connection conexion = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);
			return conexion;

		} catch (SQLException e) {
			System.out.println("Error al conectar a la base de datos: " + e.getMessage());
			return null;

		} catch (ClassNotFoundException e) {
			System.out.println("No se encontró el controlador JDBC" + e.toString());
			return null;

		}

	}

}


