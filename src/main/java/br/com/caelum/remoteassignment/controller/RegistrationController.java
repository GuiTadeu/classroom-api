package br.com.caelum.remoteassignment.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.caelum.remoteassignment.model.Course;
import br.com.caelum.remoteassignment.model.Registration;
import br.com.caelum.remoteassignment.model.User;
import br.com.caelum.remoteassignment.po.RegistrationPO;
import br.com.caelum.remoteassignment.repository.CourseRepository;
import br.com.caelum.remoteassignment.repository.RegistrationRepository;
import br.com.caelum.remoteassignment.repository.UserRepository;

@RestController
@RequestMapping("/registration")
public class RegistrationController {
	
	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RegistrationRepository registrationRepository;
	
	@PostMapping("/course/{idCourse}/user/{idUser}")
	public ResponseEntity<Registration> register(@PathVariable Long idCourse, @PathVariable Long idUser) {
		Optional<Course> course = courseRepository.findById(idCourse);
		Optional<User> user = userRepository.findById(idUser);
		
		if(course.isPresent() && user.isPresent()) {
			if(registrationRepository.findUserInCourse(user.get(), course.get())) {
				return ResponseEntity.badRequest().build();
			} else {
				Registration registration = new RegistrationPO(course.get(), user.get()).converter();
				registrationRepository.save(registration);
				return ResponseEntity.ok(registration);
			}
		}
		
		return ResponseEntity.notFound().build();
	}
}
