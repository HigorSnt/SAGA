package saga;

import java.util.HashMap;
import java.util.Map;

/**
 * Classe que molda um objeto do tipo Fornecedor.
 * 
 * @author higor
 *
 */
public class Fornecedor {
	
	/** Nome do fornecedor. */
	private String nome;
	/** Email do fornecedor. */
	private String email;
	/** Telefone do fornecedor. */
	private String telefone;
	/** Produtos que são comercializados pelo fornecedor. */
	private Map <String, Produto> produtos;
	
	/**
	 * Constrói um Fornecedor.
	 * 
	 * @param nome é o nome do fornecedor.
	 * @param email é o email do fornecedor.
	 * @param telefone é o telefone do fornecedor.
	 */
	public Fornecedor(String nome, String email, String telefone) {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.produtos = new HashMap<>();
	}
	
	/**
	 * Informa o nome do fornecedor.
	 * 
	 * @return O nome do fornecedor.
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * Informa o email do fornecedor.
	 * 
	 * @return O email do fornecedor.
	 */
	public String getEmail() {
		return this.email;
	}
	
	/**
	 * Atualiza o email do fornecedor.
	 * 
	 * @param email é o novo email do fornecedor.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Informa o telefone do fornecedor.
	 * 
	 * @return O telefone do fornecedor.
	 */
	public String getTelefone() {
		return this.telefone;
	}

	/**
	 * Atualiza o telefone do fornecedor.
	 * 
	 * @param telefone é o novo telefone do fornecedor.
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	/**
	 * Cadastra um produto comercializado pelo fornecedor 
	 * 
	 * @param nome é o nome do produto.
	 * @param desc é a descrição do produto.
	 * @param preco é o preço do produto.
	 * 
	 * @return Um boolean informando se foi ou não bem sucedido o cadastro.
	 */
	public boolean cadastraProduto(String nome, String desc, double preco) {
		if (!this.produtos.containsKey(nome)) {
			return false;
		}
		
		this.produtos.put(nome, new Produto(nome, desc, preco));
		return true;
	}

	@Override
	public String toString() {
		return this.nome + " - " + this.email + " - " + this.telefone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Fornecedor other = (Fornecedor) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}