package tarea12;

import java.io.Serializable;

public class Grupo implements Serializable{
	private int id;
	private String grupo;
	
	//Constructor
	public Grupo() {}
	
	public Grupo(int id, String g) {
		this.id=id;
		this.grupo=g;
	}

	// Getters y Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	// toString
	@Override
	public String toString() {
		return "Grupo [id=" + id + ", grupo=" + grupo + "]";
	}
	
	
	
}
