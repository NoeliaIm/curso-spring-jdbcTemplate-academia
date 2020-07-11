package com.cursospring.jdbcTemplate.academia.mysql.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cursospring.jdbcTemplate.academia.mysql.dao.AlumnoDAO;
import com.cursospring.jdbcTemplate.academia.mysql.model.Alumno;

@Repository
public class AlumnoDAOImpl implements AlumnoDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void createAlumno(Alumno alumno) {
		// TODO Auto-generated method stub

			String createAlumnoSql = "INSERT INTO alumnos (Nombre, Email, FechaNac, Curso) VALUES (?, ?,?,?) ";
			int update = jdbcTemplate.update(createAlumnoSql, alumno.getNombre(), alumno.getEmail(), alumno.getFechaNac(), alumno.getCurso());
			if (update == 1) {
				System.out.println("El alumno se ha grabado");
			}
		}

	}

