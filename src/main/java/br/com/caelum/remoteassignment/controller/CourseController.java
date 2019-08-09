package br.com.caelum.remoteassignment.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.caelum.remoteassignment.model.Course;
import br.com.caelum.remoteassignment.model.User;
import br.com.caelum.remoteassignment.po.CoursePO;
import br.com.caelum.remoteassignment.repository.CourseRepository;
import br.com.caelum.remoteassignment.repository.RegistrationRepository;
import br.com.caelum.remoteassignment.repository.UserRepository;

@RestController
@RequestMapping("/courses")
public class CourseController {
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private RegistrationRepository registrationRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/{idCourse}/users")
	public ResponseEntity<List<User>> getAllUsersInCourse(@PathVariable Long idCourse){
		Optional<Course> course = courseRepository.findById(idCourse);
		if(course.isPresent()) {
			List<User> users = registrationRepository.getAllUsersInCourse(course.get());
			return ResponseEntity.ok(users);
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/{idCourse}/find/user/{idUser}")
	public ResponseEntity<User> findUserInCourse( @PathVariable Long idCourse, @PathVariable Long idUser){
		Optional<Course> course = courseRepository.findById(idCourse);
		Optional<User> user = userRepository.findById(idUser);
		
		boolean found = false;
		
		if(user.isPresent() && course.isPresent())
			found = registrationRepository.findUserInCourse(user.get(), course.get());

		if(found)
			return ResponseEntity.ok(user.get());
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping
	public List<Course> list(){
		return courseRepository.getAll();
	}
	
	@PostMapping("/create")
	public ResponseEntity<Course> create(@Valid @RequestBody CoursePO coursePO, UriComponentsBuilder uriBuilder) {
		Course course = coursePO.converter();
		courseRepository.save(course);
		URI uri = uriBuilder.path("/users/{id}").buildAndExpand(course.getId()).toUri();
		return ResponseEntity.created(uri).body(course);
	}
	
	@GetMapping("/find/id/{id}")
	public ResponseEntity<Course> findById(@PathVariable Long id) {
		Optional<Course> course = courseRepository.findById(id);
		if(course.isPresent())
			return ResponseEntity.ok(course.get());
		return ResponseEntity.notFound().build();
	}
}
