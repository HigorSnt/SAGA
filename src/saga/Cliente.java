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
		if (cpf.replace(".", "").length() == 11) {
			
		}
		if (nome.equals(null) || nome.equals("")) {
			throw new NullPointerException("Erro no cadastro do cliente: email nao pode ser vazio ou nulo.");
		} else if (email.equals(null) || email.equals("")) {
			throw new NullPointerException("Erro no cadastro do cliente: email nao pode ser vazio ou nulo.");
		} else if (localizacao.equals(null) || localizacao.equals("")) {
			throw new NullPointerException("Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.");
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
		verificaExcecao(nome);
		
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
		verificaExcecao(email);
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
		verificaExcecao(localizacao);
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
		return this.getCpf().compareTo(c.getCpf());
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