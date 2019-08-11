package br.com.caelum.remoteassignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.caelum.remoteassignment.model.Course;
import br.com.caelum.remoteassignment.model.Registration;
import br.com.caelum.remoteassignment.model.User;
import br.com.caelum.remoteassignment.po.CoursePO;
import br.com.caelum.remoteassignment.po.RegistrationPO;
import br.com.caelum.remoteassignment.po.UserPO;
import br.com.caelum.remoteassignment.repository.CourseRepository;
import br.com.caelum.remoteassignment.repository.RegistrationRepository;
import br.com.caelum.remoteassignment.repository.UserRepository;

/**
 * Controller criado para popular o banco de dados
 * e facilitar a realização de testes da API.
 * @author Guilherme Tadeu
 */

@Controller
public class PopulateDatabaseController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private RegistrationRepository registrationRepository;
	
	@GetMapping("/populate")
	@ResponseBody
	public String populate() {
		User user1 = new UserPO("Jack White", "jack@gmail.com").converter();
		User user2 = new UserPO("Robert Plant", "robert@gmail.com.br").converter();
		User user3 = new UserPO("Brant Bjork", "brant@gmail.com.br").converter();
		
		userRepository.save(user1);
		userRepository.save(user2);
		userRepository.save(user3);
		
		
		Course course1 = new CoursePO("Linux I", 4).converter();
		Course course2 = new CoursePO("Maven", 6).converter();
		Course course3 = new CoursePO("Spring Boot Parte 2", 8).converter();
		Course course4 = new CoursePO("Collections", 20).converter();
		
		courseRepository.save(course1);
		courseRepository.save(course2);
		courseRepository.save(course3);
		courseRepository.save(course4);
		
		Registration registration1 = new RegistrationPO(course1, user1).converter();
		Registration registration2 = new RegistrationPO(course1, user2).converter();
		Registration registration3 = new RegistrationPO(course2, user3).converter();
		Registration registration4 = new RegistrationPO(course2, user1).converter();

		
		registrationRepository.save(registration1);
		registrationRepository.save(registration2);
		registrationRepository.save(registration3);
		registrationRepository.save(registration4);
		
		return "Banco de dados populado com sucesso!";
	}	
}
