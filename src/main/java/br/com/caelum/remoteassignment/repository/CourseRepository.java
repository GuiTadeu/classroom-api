package br.com.caelum.remoteassignment.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import br.com.caelum.remoteassignment.model.Course;

@Component
public class CourseRepository extends Repository<Course>{

	@Override
	public List<Course> getAll() {
		return new ArrayList<Course>(getDatabase().values());
	}

	@Override
	public Course save(Course entity) {
		getDatabase().put(entity.getId(), entity);
		return entity;
	}

	@Override
	public Optional<Course> findById(Long id) {
		return Optional.ofNullable(getDatabase().get(id));
	}
	
}
