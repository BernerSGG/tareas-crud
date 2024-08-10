package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexion.MsqlManager;
import entidad.Estudiante;

public class selectDao {
	public static void leerEstudiante() {

		Connection conexion = MsqlManager.getConnection();

		List<Estudiante> listaEstudiantes = new ArrayList<>();

		if (conexion != null) {
			try {
				String consulta = "SELECT * FROM estudiantes";

				PreparedStatement statement = conexion.prepareStatement(consulta);

				ResultSet result = statement.executeQuery();

				while (result.next()) {
					Estudiante estudiante = new Estudiante();
					estudiante.setId(result.getInt("id"));
					estudiante.setNombre(result.getString("nombre"));
					estudiante.setApellido(result.getString("apellido"));
					estudiante.setFecha_nacimiento(result.getString("fecha_nacimiento"));
					estudiante.setGenero(result.getString("genero"));
					estudiante.setDireccion(result.getString("direccion"));
					estudiante.setTelefono(result.getString("telefono"));
					estudiante.setCorreo_electronico(result.getString("correo_electronico"));
					estudiante.setGrado(result.getString("grado"));
					estudiante.setFecha_inscripcion(result.getString("fecha_inscripcion"));
					listaEstudiantes.add(estudiante);
				}

				result.close();
				statement.close();
			} catch (SQLException e) {
				System.out.println("Error al leer estudiantes: " + e.getMessage());
			} finally {
				try {
					if (conexion != null) {
						conexion.close();
					}
				} catch (SQLException e) {
					System.out.println("Error al cerrar la conexión: " + e.getMessage());
				}
			}
		} else {
			System.out.println("No se pudo establecer la conexión.");
		}
	}

	public static boolean crearEstudiante (String nombre, String apellido, String fecha_nacimiento, String genero,
			String direccion, String telefono, String correo_electronico, String grado, String fecha_inscripcion) {

		Connection conexion = MsqlManager.getConnection();

		if (conexion != null) {
			try {
				String consulta = "INSERT INTO estudiantes (nombre, apellido, fecha_nacimiento, genero, direccion, telefono, correo_electronico, grado, fecha_inscripcion) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
				
				PreparedStatement statement = conexion.prepareStatement(consulta);
				statement.setString(1, nombre);
				statement.setString(2, apellido);
				statement.setString(3, fecha_nacimiento);
				statement.setString(4, genero);
				statement.setString(5, direccion);
				statement.setString(6, telefono);
				statement.setString(7, correo_electronico);
				statement.setString(8, grado);
				statement.setString(9, fecha_inscripcion);

				int filasInsertadas = statement.executeUpdate();

				statement.close();
				conexion.close();

				return filasInsertadas > 0;
			} catch (SQLException e) {
				System.out.println("Error al crear estudiante: " + e.getMessage());
				return false;
			} finally {
				try {
					if (conexion != null) {
						conexion.close();
					}
				} catch (SQLException e) {
					System.out.println("Error al cerrar la conexión: " + e.getMessage());
				}
			}
		} else {
			System.out.println("No se pudo establecer la conexión.");
			return false;
		}
	}
	
	
	public static boolean actualizarEstudiante(int id, String nombre, String apellido, String fecha_nacimiento, String genero,
	        String direccion, String telefono, String correo_electronico, String grado, String fecha_inscripcion) {

	    Connection conexion = MsqlManager.getConnection(); 

	    if (conexion != null) {
	        try {
	            String consulta = "UPDATE estudiantes SET nombre = ?, apellido = ?, fecha_nacimiento = ?, genero = ?, direccion = ?, telefono = ?, correo_electronico = ?, grado = ?, fecha_inscripcion = ? WHERE id = ?";
	            PreparedStatement statement = conexion.prepareStatement(consulta);
	            statement.setString(1, nombre);
	            statement.setString(2, apellido);
	            statement.setString(3, fecha_nacimiento);
	            statement.setString(4, genero);
	            statement.setString(5, direccion);
	            statement.setString(6, telefono);
	            statement.setString(7, correo_electronico);
	            statement.setString(8, grado);
	            statement.setString(9, fecha_inscripcion);
	            statement.setInt(10, id); 

	            int filasActualizadas = statement.executeUpdate();

	            statement.close();
	            conexion.close();

	            return filasActualizadas > 0;

	        } catch (SQLException e) {
	            System.out.println("Error al actualizar estudiante: " + e.getMessage());
	            return false;
	        } finally {
	            try {
	                if (conexion != null) {
	                    conexion.close();
	                }
	            } catch (SQLException e) {
	                System.out.println("Error al cerrar la conexión: " + e.getMessage());
	            }
	        }
	    } else {
	        System.out.println("No se pudo establecer la conexión.");
	        return false;
	    }
	}
	
	public static boolean eliminarEstudiante(int id) {

	    Connection conexion = MsqlManager.getConnection(); 

	    if (conexion != null) {
	        try {
	            String consulta = "DELETE FROM estudiantes WHERE id = ?";
	            PreparedStatement statement = conexion.prepareStatement(consulta);
	            statement.setInt(1, id);

	            int filasEliminadas = statement.executeUpdate();

	            statement.close();
	            conexion.close();

	            return filasEliminadas > 0;

	        } catch (SQLException e) {
	            System.out.println("Error al eliminar estudiante: " + e.getMessage());
	            return false;
	        } finally {
	            try {
	                if (conexion != null) {
	                    conexion.close();
	                }
	            } catch (SQLException e) {
	                System.out.println("Error al cerrar la conexión: " + e.getMessage());
	            }
	        }
	    } else {
	        System.out.println("No se pudo establecer la conexión.");
	        return false;
	    }
	}

}


