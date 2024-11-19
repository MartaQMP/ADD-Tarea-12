package tarea12;

import java.util.List;
import java.util.Scanner;

public class Menu {
	static Scanner sc = new Scanner(System.in);

	protected void menu() {
		while (true) {
			System.out.println("1. Insertar alumno");
			System.out.println("2. Insertar grupo");
			System.out.println("3. Mostrar alumnos");
			System.out.println("4. Guardar alumnos en fichero binario");
			System.out.println("5. Leer alumnos de un fichero binario y guardarlo en BBDD");
			System.out.println("6. Modificar nombre alumno");
			System.out.println("7. Eliminar alumno");
			System.out.println("8. Eliminar alumnos de X curso");
			System.out.println("9. Eliminar alumnos que contengan X apellido");
			System.out.println("10. Guardar alumnos en fichero JSON");
			System.out.println("11. Leer alumnos de fichero JSON y guardarlo en BBDD");
			int opcion = sc.nextInt();
			if (opcion >= 1 && opcion <= 9) {
				opcionesMenu(opcion);
				break;
			}
		}
	}

	protected void opcionesMenu(int opcion) {
		switch (opcion) {
		case 1:
			Alumno alumno = new PedirDatosAlumno().pedirTodosLosDatos();
			new GuardarBBDD().insertarEnBBDD(alumno);
			System.out.println();
			menu();
			break;
		case 2:
			List <Alumno> alumnos =new GuardarBBDD().obtenerAlumnosBBDD();
			new GuardarBBDD().mostrarAlumnos(alumnos);
			menu();
			break;
		case 3:
			new Ficheros().guardarEnFichero();
			System.out.println();
			menu();
			break;
		case 4:
			new Ficheros().leerDeFichero();
			System.out.println();
			menu();
			break;
		case 5:
			new GuardarBBDD().modificarNombreAlumno();
			sc.nextLine();
			menu();
			break;
		case 6:
			new GuardarBBDD().borrarAlumnoPorNia();
			sc.nextLine();
			menu();
			break;
		case 7:
			new GuardarBBDD().borrarAlumnoPorApellido();
			menu();
			break;
		case 8:
			new Ficheros().guardarEnFicheroJSON();
			menu();
			break;
		default:
			new Ficheros().leerDeFicheroJSON();
			menu();
			break;
		}
	}
}
