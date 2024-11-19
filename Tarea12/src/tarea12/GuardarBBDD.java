package tarea12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class GuardarBBDD {
	static Scanner sc = new Scanner(System.in);
	static String direccionBBDD = "jdbc:mysql://localhost:3306/Alumnos14";
	static String usuario = "root";
	static String contraseña = "Admin-3015_MQM-P";

	protected void insertarEnBBDD(Alumno alumno) {
		Connection conexion = null;
		Statement sentencia = null;
		try {
			conexion = DriverManager.getConnection(direccionBBDD, usuario, contraseña);
			// Crea y ejecuta el Statement
			sentencia = conexion.createStatement();
			String sql = "INSERT INTO Alumno (Nia, Nombre, Apellidos, Genero, FechaNacimiento, Ciclo, Curso, Grupo) VALUES ("
					+ alumno.getNia() + ", '" + alumno.getNombre() + "', '" + alumno.getApellidos() + "', '"
					+ alumno.getGenero() + "', '" + convertirA_SQL_Date(alumno.getFecNac()) + "', '" + alumno.getCiclo()
					+ "', '" + alumno.getCurso() + "', '" + alumno.getGrupo() + "')";
			int filasInsertadas = sentencia.executeUpdate(sql);
			if (filasInsertadas > 0) {
				System.out.println("Alumno insertado");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (sentencia != null) {
					sentencia.close();
				}
				if (conexion != null) {
					conexion.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	protected java.sql.Date convertirA_SQL_Date(java.util.Date utilDate) {
		return new java.sql.Date(utilDate.getTime());
	}

	protected void mostrarAlumnos(List<Alumno> alumnos) {
		for (Alumno alumno : alumnos) {
			System.out.println(alumno);
		}
	}

	protected void borrarAlumnoPorNia() {
		System.out.println("Dime el nia");
		int nia = sc.nextInt();
		Connection conexion = null;
		Statement sentencia = null;
		try {
			// Establecer la conexión con la base de datos
			conexion = DriverManager.getConnection(direccionBBDD, usuario, contraseña);

			// Hago la sentencia
			sentencia = conexion.createStatement();
			String sql = "DELETE FROM Alumno WHERE Nia = " + nia;
			int filasEliminadas = sentencia.executeUpdate(sql);

			if (filasEliminadas > 0) {
				System.out.println("Alumno eliminado");
			} else {
				System.out.println("No se encontró ningún alumno con el NIA especificado");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (sentencia != null) {
					sentencia.close();
				}
				if (conexion != null) {
					conexion.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	protected void borrarAlumnoPorApellido() {
		System.out.println("Dime el apellido");
		String apellido = sc.nextLine();
		Connection conexion = null;
		Statement sentencia = null;
		try {
			conexion = DriverManager.getConnection(direccionBBDD, usuario, contraseña);

			// Hago la sentencia
			sentencia = conexion.createStatement();
			String sql = "DELETE FROM Alumno WHERE Apellidos LIKE '% " + apellido + "%' OR Apellidos LIKE '%" + apellido
					+ " %' OR Apellidos LIKE '%" + apellido + "%' OR Apellidos LIKE '% " + apellido + " %'";
			int filasEliminadas = sentencia.executeUpdate(sql);

			if (filasEliminadas > 0) {
				System.out.println("Alumno(s) eliminado(s)");
			} else {
				System.out.println("No se encontró ningún alumno con el apellido especificado");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (sentencia != null) {
					sentencia.close();
				}
				if (conexion != null) {
					conexion.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	protected List<Alumno> obtenerAlumnosBBDD() {
		List<Alumno> alumnos = new ArrayList<>();
		Connection conexion = null;
		Statement sentencia = null;
		ResultSet resultado = null;

		try {
			// Conexión a la base de datos
			conexion = DriverManager.getConnection(direccionBBDD, usuario, contraseña);

			// Hago la consulta
			sentencia = conexion.createStatement();
			String sql = "SELECT Nia, Nombre, Apellidos, Genero, FechaNacimiento, Ciclo, Curso, Grupo FROM Alumno";
			resultado = sentencia.executeQuery(sql);

			// Recorrer el resultado y agregar a la lista
			while (resultado.next()) {
				int nia = resultado.getInt("Nia");
				String nombre = resultado.getString("Nombre");
				String apellidos = resultado.getString("Apellidos");
				Character genero = resultado.getString("Genero").charAt(0);
				Date fechaNacimiento = resultado.getDate("FechaNacimiento");
				String ciclo = resultado.getString("Ciclo");
				String curso = resultado.getString("Curso");
				String grupo = resultado.getString("Grupo");

				// Crear un nuevo objeto Alumno y agregarlo a la lista
				Alumno alumno = new Alumno(nia, nombre, apellidos, ciclo, curso, grupo, genero, fechaNacimiento);
				alumnos.add(alumno);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultado != null) {
					resultado.close();
				}
				if (sentencia != null) {
					sentencia.close();
				}
				if (conexion != null) {
					conexion.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return alumnos;
	}

	protected void modificarNombreAlumno() {
		System.out.println("Dime el nia");
		int nia = sc.nextInt();
		Scanner sc = new Scanner(System.in);
		Connection conexion = null;
		Statement sentencia = null;
		try {
			conexion = DriverManager.getConnection(direccionBBDD, usuario, contraseña);

			// Pedir el nuevo nombre por teclado
			System.out.println("Introduce el nuevo nombre para el alumno con NIA " + nia + ": ");
			String nuevoNombre = sc.nextLine();

			// Hago la sentencia
			sentencia = conexion.createStatement();
			String sql = "UPDATE Alumno SET Nombre = '" + nuevoNombre + "' WHERE Nia = " + nia;
			int filasActualizadas = sentencia.executeUpdate(sql);

			if (filasActualizadas > 0) {
				System.out.println("El nombre del alumno ha sido actualizado correctamente.");
			} else {
				System.out.println("No se encontró ningún alumno con el NIA especificado.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			sc.close();
			try {
				if (sentencia != null) {
					sentencia.close();
				}
				if (conexion != null) {
					conexion.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
