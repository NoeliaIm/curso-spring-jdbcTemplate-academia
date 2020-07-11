package com.cursospring.jdbcTemplate.academia.mysql.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cursospring.jdbcTemplate.academia.mysql.dao.CursoDAO;
import com.cursospring.jdbcTemplate.academia.mysql.model.Curso;

@Repository
public class CursoDAOImpl implements CursoDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void createCurso(Curso curso) {
		// TODO Auto-generated method stub

		String createCursoSql = "INSERT INTO cursos (nombreCurso) VALUES (?) ";
		int update = jdbcTemplate.update(createCursoSql, curso.getNombreCurso());
		if (update == 1) {
			System.out.println("El curso se ha grabado");
		}
	}

	@Override
	public int numFilas() {
		// TODO Auto-generated method stub
		return this.jdbcTemplate.queryForObject("select count(*) from cursos", Integer.class);
	}

	
}
