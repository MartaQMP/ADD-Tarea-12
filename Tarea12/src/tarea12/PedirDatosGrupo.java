package tarea12;

import java.util.Scanner;

public class PedirDatosGrupo {
	static Scanner sc = new Scanner(System.in);

	protected Grupo pedirDatosGrupo() {
		int id = pedirID();
		String nombre = pedirNombreGrupo();
		String aula = pedirAula();
		Grupo g = new Grupo(id, nombre, aula);
		return g;
	}

	protected int pedirID() {
		System.out.println("Dime el ID del grupo");
		int id = sc.nextInt();
		sc.nextLine();
		return id;
	}

	protected String pedirNombreGrupo() {
		System.out.println("Dime el nombre del grupo");
		String nombreG = sc.nextLine();
		return nombreG;
	}

	protected String pedirAula() {
		System.out.println("Dime el aula del grupo");
		String aula = sc.nextLine();
		return aula;
	}
}
