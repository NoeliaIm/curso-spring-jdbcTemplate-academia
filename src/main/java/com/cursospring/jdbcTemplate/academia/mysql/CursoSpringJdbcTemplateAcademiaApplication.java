package com.cursospring.jdbcTemplate.academia.mysql;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cursospring.jdbcTemplate.academia.mysql.dao.AlumnoDAO;
import com.cursospring.jdbcTemplate.academia.mysql.dao.CursoDAO;
import com.cursospring.jdbcTemplate.academia.mysql.model.Alumno;
import com.cursospring.jdbcTemplate.academia.mysql.model.Curso;

@SpringBootApplication
public class CursoSpringJdbcTemplateAcademiaApplication implements CommandLineRunner {
	
	@Autowired
	private CursoDAO cursoDAO;
	@Autowired
	private AlumnoDAO alumnoDAO;
	
	public static void main(String[] args) {
		SpringApplication.run(CursoSpringJdbcTemplateAcademiaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		int opcion=0;
		Scanner entrada = new Scanner(System.in);
		do {
			System.out.println("Elige una opción, para salir del programa usa 0");
			System.out.println(" 1- Crear curso");
			System.out.println(" 2- Crear alumno ");
			opcion= entrada.nextInt();
			switch(opcion) {
			case 1:
				createCurso();
				break;
			case 2: 
				createAlumno();
				break;
			}
		}while(opcion!=0);
		entrada.close();
		
		
	}

	private void createAlumno() {
		// TODO Auto-generated method stub
		
		Alumno alumno= new Alumno();
		Scanner entrada = new Scanner(System.in);
		System.out.println("Escribe el nombre del alumno");
		alumno.setNombre(entrada.nextLine());
		System.out.println("Escribe el email del alumno");
		alumno.setEmail(entrada.nextLine());
		System.out.println("Escribe la fecha de nacimiento del alumno");
		alumno.setFechaNac(entrada.nextLine());
		System.out.println("Escribe el id del curso en el que se matricula el alumno");
		alumno.setCurso(entrada.nextInt());
		alumnoDAO.createAlumno(alumno);
		
	}

	private void createCurso() {
		// TODO Auto-generated method stub
		Curso curso = new Curso();
		Scanner entrada = new Scanner(System.in);
		System.out.println("Escribe el nombre del curso");
		String nombreCurso= entrada.nextLine();
		curso.setNombreCurso(nombreCurso);
		cursoDAO.createCurso(curso);
		System.out.println("En total hay "+ cursoDAO.numFilas()+" cursos");
	}
	
	

}
