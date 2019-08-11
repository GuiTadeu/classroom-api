package br.com.caelum.remoteassignment.model;

/**
 * Classe criada para atribuir o ID as classes
 * herdeiras.
 * @author Alura
 * @version 1.0.0
 */
public abstract class Entity {
	
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
