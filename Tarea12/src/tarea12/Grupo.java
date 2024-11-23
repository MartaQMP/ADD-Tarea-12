package tarea12;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Grupo implements Serializable {
	private int id;
	private String nombre;
	private String aula;
	private List <Alumno> alumnos;

	// Constructor
	public Grupo() {
	}

	public Grupo(int id, String g, String a) {
		this.id = id;
		this.nombre = g;
		this.aula = a;
		this.setAlumnos(new ArrayList<Alumno>());
	}

	// Getters y Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String grupo) {
		this.nombre = grupo;
	}

	public String getAula() {
		return aula;
	}

	public void setAula(String aula) {
		this.aula = aula;
	}
	
	public List <Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(List <Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	// toString
	@Override
	public String toString() {
		return "Grupo [id=" + id + ", grupo=" + nombre + "]";
	}

	
}
