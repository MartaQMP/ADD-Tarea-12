package tarea12;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Ficheros {
	private static Scanner sc = new Scanner(System.in);

	protected void guardarEnFichero() {
		List<Alumno> alumnos = new GuardarBBDD().obtenerAlumnosBBDD();
		ObjectOutputStream ois = null;
		FileOutputStream fos;
		try {
			fos = new FileOutputStream("ficheroAlumnos.dat");
			ois = new ObjectOutputStream(fos);
			for (Alumno alumno : alumnos) {
				ois.writeObject(alumno);
			}
			System.out.println("Alumnos guardados en fichero correctamente");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	protected void leerDeFichero() {
		System.out.println("Dime el la ruta del fichero binario");
		String ruta = sc.nextLine();
		FileInputStream fis;
		ObjectInputStream ois;
		try {
			fis = new FileInputStream(ruta);
			ois = new ObjectInputStream(fis);

			try {
				while (fis.available() > 0) {
					Alumno alumno = (Alumno) ois.readObject();
					new GuardarBBDD().insertarEnBBDD(alumno);
				}
			} finally {
				ois.close();
			}

		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Error al leer el fichero: " + e.getMessage());
		}
	}

	protected void guardarEnFicheroJSON() {
		List<Alumno> alumnos = new GuardarBBDD().obtenerAlumnosBBDD();
		ObjectMapper objectMapper = new ObjectMapper();
		File archivo = new File("ficheroAlumnos.json");

		try {
			objectMapper.writeValue(archivo, alumnos);
			System.out.println("Datos escritos");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected void leerDeFicheroJSON() {
		System.out.println("Dime la ruta del fichero JSON");
		String ruta = sc.nextLine();
		ArrayList<Alumno> alumnos = new ArrayList<>();
		ObjectMapper objectMapper = new ObjectMapper();
		File archivo = new File(ruta);

		try {
			alumnos = objectMapper.readValue(archivo, new TypeReference<ArrayList<Alumno>>() {
			});
			for (Alumno alumno : alumnos) {
				new GuardarBBDD().insertarEnBBDD(alumno);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
