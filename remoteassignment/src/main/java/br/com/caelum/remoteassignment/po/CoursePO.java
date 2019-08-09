package br.com.caelum.remoteassignment.po;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import br.com.caelum.remoteassignment.model.Course;

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