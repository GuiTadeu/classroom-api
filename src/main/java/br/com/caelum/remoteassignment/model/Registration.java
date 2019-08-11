package br.com.caelum.remoteassignment.model;

/**
 * Classe criada com a finalidade de definir
 * um modelo do tipo Registration.
 * @author Guilherme Tadeu
 * @version 1.0.0
 * @see RegistrationPO
 */
public class Registration extends Entity {
	
	private Course course;
	private User user;
	
	public Registration() {}
	
	/**
	 * Método construtor criado para omitir
	 * a geração do ID.
	 * @author Guilherme Tadeu
	 * @see RegistrationPO
	 */
	public Registration(Course course, User user) {
		this.course = course;
		this.user = user;	
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

	/**
	 * Método criado para a geração do hashCode
	 * e facilitar a performance da busca no banco.
	 * @see Repository#database
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((course == null) ? 0 : course.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	/**
	 * Método criado para comparar objetos do tipo
	 * Registration através da combinação dos atributos
	 * do tipo User e Course.
	 * @see User
	 * @see Course
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Registration other = (Registration) obj;
		if (course == null) {
			if (other.course != null)
				return false;
		} else if (!course.equals(other.course))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	
}
