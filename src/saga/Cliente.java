package saga;

/**
 * Classe que molda um objeto do tipo Cliente.
 * 
 * @author higor
 *
 */
public class Cliente implements Comparable<Cliente>{
	/** CPF do cliente. */
	private String cpf;
	/** Nome do cliente. */
	private String nome;
	/** Email do cliente. */
	private String email;
	/** Localização onde o cliente trabalha. */
	private String localizacao;
	
	/**
	 * Constrói um cliente.
	 * 
	 * @param cpf é o identificador do cliente.
	 * @param nome é o nome do cliente.
	 * @param email é o email do cliente.
	 * @param localizacao é o local onde o cliente trabalha.
	 */
	public Cliente(String cpf, String nome, String email, String localizacao) {
		if (cpf.length() != 11 || (cpf.trim().equals("")) || (cpf.equals(null))) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: cpf invalido.");
		}else if (nome.equals(null) || (nome.trim().equals(""))) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.");
		} else if (email.equals(null) || (email.trim().equals(""))) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: email nao pode ser vazio ou nulo.");
		}else if (localizacao.equals(null) || (localizacao.trim().equals(""))) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.");
		}
		
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.localizacao = localizacao;
	}
	
	/**
	 * Informa o nome do cliente.
	 * 
	 * @return O nome do cliente.
	 */
	public String getNome() {
		return this.nome;
	}
	
	/**
	 * Atualiza o nome do cliente.
	 * 
	 * @param nome é o novo nome do cliente.
	 */
	public void setNome(String nome) {
		if (nome.equals(null)) {
			throw new NullPointerException("Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.");
		} else if (nome.trim().equals("")) {
			throw new IllegalArgumentException("Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.");
		}
		
		this.nome = nome;
	}

	/**
	 * Informa o email do cliente.
	 * 
	 * @return O email do cliente.
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 * Atualiza o email do cliente.
	 * 
	 * @param email é o novo email do cliente.
	 */
	public void setEmail(String email) {
		if (email.equals(null)) {
			throw new NullPointerException("Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.");
		}else if (email.trim().equals("")) {
			throw new IllegalArgumentException("Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.");
		}
		
		this.email = email;
	}

	/**
	 * Informa a localização do cliente.
	 * 
	 * @return A localização do cliente.
	 */
	public String getLocalizacao() {
		return this.localizacao;
	}

	/**
	 * Atualiza a localização do cliente.
	 * 
	 * @param localizacao é a nova localização do cliente.
	 */
	public void setLocalizacao(String localizacao) {
		if (localizacao.equals(null)) {
			throw new NullPointerException("Erro na edicao do cliente: novo valor nao pode ser vazia ou nula.");
		} else if (localizacao.trim().equals("")) {
			throw new IllegalArgumentException("Erro na edicao do cliente: novo valor nao pode ser vazia ou nula.");
		}
		
		this.localizacao = localizacao;
	}
	
	/**
	 * Informa o CPF do cliente.
	 * 
	 * @return O CPF do cliente.
	 */
	public String getCpf() {
		return this.cpf;
	}

	@Override
	public int compareTo(Cliente c) {
		return this.nome.compareTo(c.getNome());
	}

	@Override
	public String toString() {
		return this.nome + " - " + this.localizacao + " - " + this.email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}
	
}