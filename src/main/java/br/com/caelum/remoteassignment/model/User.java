package br.com.caelum.remoteassignment.model;

/**
 * Classe criada com a finalidade de definir
 * um modelo do tipo User.
 * @author Alura
 * @version 1.0.0
 * @see UserPO
 */
public class User extends Entity {

	private String name;
	private String email;
	
	public User() {}
	
	/**
	 * Método construtor criado para omitir
	 * a geração do ID.
	 * @author Guilherme Tadeu
	 * @see UserPO
	 */
	public User(String name, String email) {
		this.name = name;
		this.email = email;
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

	/**
	 * Método criado para a geração do hashCode
	 * e facilitar a performance da busca no banco.
	 * @see Repository#database
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		return result;
	}

	/**
	 * Método criado para comparar objetos do tipo
	 * User através do atributo Email.
	 * @see User#email
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}
}