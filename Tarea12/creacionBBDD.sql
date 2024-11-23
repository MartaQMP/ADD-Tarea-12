CREATE DATABASE Alumnos14;
USE Alumnos14;
CREATE TABLE Grupos (
    Id INT PRIMARY KEY,
    Nombre VARCHAR(50),
    Aula VARCHAR(50)
);
CREATE TABLE Alumno(
	Nia INT PRIMARY KEY,
	Nombre VARCHAR(50),
	Apellidos VARCHAR(100),
	Genero char(1),
	FechaNacimiento Date,
	Ciclo VARCHAR(50),
	Curso VARCHAR(50),
	Grupo INT,
	FOREIGN KEY (Grupo) REFERENCES Grupos(IGrupo)
);


