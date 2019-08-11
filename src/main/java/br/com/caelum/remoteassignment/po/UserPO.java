package br.com.caelum.remoteassignment.po;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import br.com.caelum.remoteassignment.model.User;

/**
 * Classe criada para ser utilizada como Persistence
 * Object do tipo User.
 * @author Guilherme Tadeu
 * @version 1.0.0
 * @see User
 */
public class UserPO {
	
	private static Long idGenerator = 1L;
	
	@NotBlank(message = "Name is Required")
	private String name;
	
	@Email(message = "Invalid Email")
	@NotBlank(message = "Email is Required")
	private String email;

	public UserPO() {}
	
	public UserPO(String name, String email) {
		this.name = name;
		this.email = email;
	}
	
	/**
	 * Método criado para converter um UserPO
	 * em User. Na conversão é feita a geração
	 * do ID que será persistido em banco.
	 * @see User#User(String, String)
	 * @return User
	 */
	public User converter() {
		User user = new User(name, email);
		user.setId(idGenerator++);
		return user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}