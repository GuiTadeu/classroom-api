package br.com.caelum.remoteassignment.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import br.com.caelum.remoteassignment.model.User;

@Component
public class UserRepository extends Repository<User> {

	public Optional<User> findByEmail(String email) {
		return getAll().stream()
			.filter(user -> user.getEmail().equals(email))
			.findFirst();
	}
	
	public List<User> findByEmailLike(String emailPart) {
		return getAll().stream()
			.filter(user -> user.getEmail().contains(emailPart))
			.collect(Collectors.toList());
	}

	public List<User> findByName(String name) {
		return getAll().stream()
				.filter(user -> user.getName().equals(name))
				.collect(Collectors.toList());
	}
	
	public List<User> findByNameLike(String namePart) {
		return getAll().stream()
				.filter(user -> user.getName().contains(namePart))
				.collect(Collectors.toList());
	}

	@Override
	public List<User> getAll() {
		return new ArrayList<User>(getDatabase().values());
	}

	@Override
	public User save(User entity) {
		getDatabase().put(entity.getId(), entity);
		return entity;
	}

	@Override
	public Optional<User> findById(Long id) {
		return Optional.ofNullable(getDatabase().get(id));
	}
}
