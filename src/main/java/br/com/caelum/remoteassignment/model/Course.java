package br.com.caelum.remoteassignment.model;

/**
 * Classe criada com a finalidade de definir
 * um modelo do tipo Course.
 * @author Guilherme Tadeu
 * @version 1.0.0
 * @see CoursePO
 */
public class Course extends Entity {
	
	private String nome;
	private int cargaHoraria;
	
	public Course() {}
	
	/**
	 * Método construtor criado para omitir
	 * a geração do ID.
	 * @see CoursePO
	 */
	public Course(String nome, int cargaHoraria) {
		this.nome = nome;
		this.cargaHoraria = cargaHoraria;
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

	/**
	 * Método criado para a geração do hashCode
	 * e facilitar a performance da busca no banco.
	 * @see Repository#database
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	/**
	 * Método criado para comparar objetos do tipo
	 * Course através do atributo Nome.
	 * @see Course#nome
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
}
