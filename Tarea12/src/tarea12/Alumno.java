package tarea12;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Alumno implements Serializable{
		int nia, grupo;
		String nombre, apellidos, ciclo, curso;
		Character genero;
		Date fecNac;
		
		
		//Constructor
		public Alumno() {}
		
		public Alumno(int nia, String nombre, String apellidos, String ciclo, String curso, int grupo, Character gen,
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
		public int getGrupo() {
			return grupo;
		}
		public void setGrupo(int grupo) {
			this.grupo = grupo;
		}
		public Character getGenero() {
			return genero;
		}
		public void setGenero(Character gen) {
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
