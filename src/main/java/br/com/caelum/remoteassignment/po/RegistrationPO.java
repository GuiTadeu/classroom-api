package br.com.caelum.remoteassignment.po;

import javax.validation.constraints.NotNull;

import br.com.caelum.remoteassignment.model.Course;
import br.com.caelum.remoteassignment.model.Registration;
import br.com.caelum.remoteassignment.model.User;

public class RegistrationPO {
	
	private static Long idGenerator = 1L;
	
	@NotNull(message="Course is Required")
	private Course course;
	
	@NotNull(message="User is Required")
	private User user;
	
	
	public RegistrationPO() {}
	
	public RegistrationPO(Course course, User user) {
		this.course = course;
		this.user = user;
	}
	
	public Registration converter() {
		Registration registration = new Registration(course, user);
		registration.setId(idGenerator++);
		return registration;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
