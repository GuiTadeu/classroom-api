package br.com.caelum.remoteassignment.po;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import br.com.caelum.remoteassignment.model.Course;

/**
 * Classe criada para ser utilizada como Persistence
 * Object do tipo Course.
 * @author Guilherme Tadeu
 * @version 1.0.0
 * @see Course
 */
public class CoursePO {
	
	private static Long idGenerator = 1L;
	
	@NotBlank(message = "Name is Required")
	private String nome;
	
	@Min(value = 1, message = "Course Load Cannot be Below 1 Hour")
	private int cargaHoraria;
	
	public CoursePO() {}
	
	public CoursePO(String nome, int cargaHoraria) {
		this.nome = nome;
		this.cargaHoraria = cargaHoraria;
	}
	
	/**
	 * Método criado para converter um CoursePO
	 * em Course. Na conversão é feita a geração
	 * do ID que será persistido em banco.
	 * @see Course#Course(String, int)
	 * @return Course
	 */
	public Course converter() {
		Course course = new Course(nome, cargaHoraria);
		course.setId(idGenerator++);
		return course;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
}