package tarea12;

import java.util.List;
import java.util.Scanner;

public class Menu {
	static Scanner sc = new Scanner(System.in);

	protected void menu() {
		while (true) {
			System.out.println("1. Insertar alumno");
			System.out.println("2. Insertar grupo");
			System.out.println("3. Mostrar alumnos con su grupo");
			System.out.println("4. Guardar alumnos en fichero binario");
			System.out.println("5. Leer alumnos de un fichero binario y guardarlo en BBDD");
			System.out.println("6. Modificar nombre alumno");
			System.out.println("7. Eliminar alumno");
			System.out.println("8. Eliminar alumnos de X grupo");
			System.out.println("9. Guardar grupos en fichero JSON");
			System.out.println("10. Leer grupos de fichero JSON y guardarlo en BBDD");
			int opcion = sc.nextInt();
			sc.nextLine();
			if (opcion >= 1 && opcion <= 10) {
				opcionesMenu(opcion);
				break;
			}
		}
	}

	protected void opcionesMenu(int opcion) {
		switch (opcion) {
		case 1:
			Alumno alumno = new PedirDatosAlumno().pedirTodosLosDatos();
			new OperacionesBBDD().insertarAlumnoEnBBDD(alumno);
			System.out.println();
			menu();
			break;
		case 2:
			Grupo grupo = new PedirDatosGrupo().pedirDatosGrupo();
			new OperacionesBBDD().insertarGrupoEnBBDD(grupo);
			menu();
			break;
		case 3:
			new OperacionesBBDD().mostrarAlumnos();
			menu();
			break;
		case 4:
			new Ficheros().guardarAlumnosEnFichero();
			System.out.println();
			menu();
			break;
		case 5:
			new Ficheros().leerAlumnosDeFichero();
			System.out.println();
			menu();
			break;
		case 6:
			new OperacionesBBDD().modificarNombreAlumno();
			sc.nextLine();
			menu();
			break;
		case 7:
			new OperacionesBBDD().borrarAlumnoPorNia();
			menu();
			break;
		case 8:
			List<String> nombresGrupos = new OperacionesBBDD().guardarNombresGrupos();
			System.out.println("Dime cual de los grupos quieres:");
			for(String nombreGrupo:nombresGrupos) {
				System.out.println(nombreGrupo);
			}
			String grupoEscogido = sc.nextLine();
			new OperacionesBBDD().borrarAlumnosPorGrupo(grupoEscogido);
			menu();
			break;
		case 9:
			new Ficheros().guardarGruposEnFicheroJSON();
			menu();
			break;
		default:
			new Ficheros().leerGrupoDeFicheroJSON();
			menu();
			break;
		}
	}
}
