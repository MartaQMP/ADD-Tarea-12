package tarea12;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Alumno implements Serializable{
		int nia;
		String nombre, apellidos, ciclo, curso, grupo;
		char genero;
		Date fecNac;
		
		
		//Constructor
		public Alumno() {}
		
		public Alumno(int nia, String nombre, String apellidos, String ciclo, String curso, String grupo, Character gen,
				Date fecNac) {
			this.nia = nia;
			this.nombre = nombre;
			this.apellidos = apellidos;
			this.ciclo = ciclo;
			this.curso = curso;
			this.grupo = grupo;
			this.genero = gen;
			this.fecNac = fecNac;
		}
		
		
		//Getter y setter
		public int getNia() {
			return nia;
		}
		public void setNia(int nia) {
			this.nia = nia;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public String getApellidos() {
			return apellidos;
		}
		public void setApellidos(String apellidos) {
			this.apellidos = apellidos;
		}
		public String getCiclo() {
			return ciclo;
		}
		public void setCiclo(String ciclo) {
			this.ciclo = ciclo;
		}
		public String getCurso() {
			return curso;
		}
		public void setCurso(String curso) {
			this.curso = curso;
		}
		public String getGrupo() {
			return grupo;
		}
		public void setGrupo(String grupo) {
			this.grupo = grupo;
		}
		public char getGenero() {
			return genero;
		}
		public void setGenero(char gen) {
			this.genero = gen;
		}
		public Date getFecNac() {
			return fecNac;
		}
		public void setFecNac(Date fecNac) {
		this.fecNac = fecNac;
		}


		@Override
		public String toString() {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			return "Alumno [nia=" + nia + ", nombre=" + nombre + ", apellidos=" + apellidos + ", ciclo=" + ciclo
					+ ", curso=" + curso + ", grupo=" + grupo + ", gen=" + genero + ", fecNac=" +sdf.format(fecNac)+ "]";
		}
		
		
		
		
		
			
}
