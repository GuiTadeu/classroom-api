package br.com.caelum.remoteassignment.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import br.com.caelum.remoteassignment.model.Course;
import br.com.caelum.remoteassignment.model.Registration;
import br.com.caelum.remoteassignment.model.User;

@Component
public class RegistrationRepository extends Repository<Registration> {

	public boolean findUserInCourse(User user, Course course) {		
		return getAllUsersInCourse(course).stream()
			.filter(users -> users.equals(user))
			.findFirst()
			.isPresent();
	}

	public List<User> getAllUsersInCourse(Course course) {		
		return getAll().stream()
			.filter(r -> r.getCourse().equals(course))
			.map(Registration::getUser)
			.collect(Collectors.toList());
	}

	@Override
	public List<Registration> getAll() {
		return new ArrayList<Registration>(getDatabase().values());
	}

	@Override
	public Registration save(Registration entity) {
		getDatabase().put(entity.getId(), entity);
		return entity;
	}

	@Override
	public Optional<Registration> findById(Long id) {
		return Optional.ofNullable(getDatabase().get(id));
	}
}
