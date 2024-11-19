package tarea12;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PedirDatosAlumno {
	static Scanner sc = new Scanner(System.in);
	
	protected Alumno pedirTodosLosDatos() {
		int nia = pedirNia();
		String nombre = pedirNombre();
		String apellidos = pedirApellidos();
		char genero = pedirGenero();
		Date fecha = pedirFecNac();
		String ciclo = pedirCiclo();
		String curso = pedirCurso();
		String grupo = pedirGrupo();

		Alumno alumno = new Alumno(nia, nombre, apellidos, ciclo, curso, grupo, genero, fecha);
		return alumno;
	}
	

	protected int pedirNia() {
		int nia = 0;
		try {
			System.out.println("Introduce el NIA:");
			nia = sc.nextInt();
			sc.nextLine();
		} catch (InputMismatchException e) {
			System.out.println("Error: Debes introducir un número entero.");
			sc.next();
		}
		return nia;
	}

	protected String pedirNombre() {
		System.out.println("Dime el nombre");
		return sc.nextLine();
	}

	protected String pedirApellidos() {
		System.out.println("Dime los apellidos");
		return sc.nextLine();
	}

	protected char pedirGenero() {
		System.out.println("Dime el genero. M o H");
		String palabra = sc.next();
		while (!palabra.equalsIgnoreCase("M") && !palabra.equalsIgnoreCase("H")) {
			System.out.println("Genero no valido. Introduce M o H:");
			palabra = sc.next();
		}
		char g = palabra.charAt(0);
		return g;
	}

	protected Date pedirFecNac() {
		sc.nextLine();
		Date fecha = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setLenient(false);

		boolean fechaValida = false;

		do {
			System.out.println("Introduce tu fecha de nacimiento (dd/mm/aaaa)");
			String f = sc.nextLine();

			try {
				fecha = sdf.parse(f);
				fechaValida = true;
			} catch (ParseException e) {
				System.out
						.println("Fecha no válida, por favor, introduce una fecha en el formato correcto (dd/mm/aaaa)");
			}
		} while (!fechaValida);

		return fecha;
	}

	protected String pedirCiclo() {
		System.out.println("Dime el ciclo");
		return sc.next();
	}

	protected String pedirCurso() {
		System.out.println("Dime el curso");
		return sc.next();
	}

	protected String pedirGrupo() {
		System.out.println("Dime el grupo");
		return sc.next();
	}

}
