package com.cursospring.jdbcTemplate.academia.mysql.dao;

import com.cursospring.jdbcTemplate.academia.mysql.model.Curso;

public interface CursoDAO {
	
	public void createCurso(Curso curso);
	
	public int numFilas();
	

}
