package br.com.caelum.remoteassignment.repository;

import br.com.caelum.remoteassignment.model.Entity;

import java.util.*;

public abstract class Repository<E extends Entity> {

	private Map<Long, E> database = new HashMap<>();

	protected Map<Long, E> getDatabase() {
		return database;
	}

	public abstract List<E> getAll();

	public abstract E save(E entity);

	public abstract Optional<E> findById(Long id);
}
