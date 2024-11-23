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

	protected void guardarAlumnosEnFichero() {
		List<Alumno> alumnos = new OperacionesBBDD().obtenerAlumnosBBDD();
		ObjectOutputStream oos = null;
		FileOutputStream fos;
		try {
			fos = new FileOutputStream("ficheroAlumnos.dat");
			oos = new ObjectOutputStream(fos);
			for (Alumno alumno : alumnos) {
				oos.writeObject(alumno);
			}
			System.out.println("Alumnos guardados en fichero correctamente");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	protected void leerAlumnosDeFichero() {
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
					new OperacionesBBDD().insertarAlumnoEnBBDD(alumno);
				}
			} finally {
				ois.close();
			}

		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Error al leer el fichero: " + e.getMessage());
		}
	}

	protected void guardarGruposEnFicheroJSON() {
	    List<Grupo> grupos = new OperacionesBBDD().obtenerGruposConAlumnos();
	    ObjectMapper objectMapper = new ObjectMapper();
	    File archivo = new File("FicheroGrupos.json");

	    try {
	        objectMapper.writeValue(archivo, grupos);
	        System.out.println("Datos escritos");
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	protected void leerGrupoDeFicheroJSON() {
		System.out.println("Introduce la ruta del archivo JSON:");
		String ruta = sc.nextLine();
		List<Grupo> grupos;
		ObjectMapper objectMapper = new ObjectMapper();
		File archivo = new File(ruta);

		try {
			grupos = objectMapper.readValue(archivo, new TypeReference<List<Grupo>>() {
			});
			for (Grupo grupo : grupos) {
				new OperacionesBBDD().insertarGrupoEnBBDD(grupo);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
