package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Classe que molda um objeto do tipo Fornecedor.
 * 
 * @author Higor Santos - 118110808.
 *
 */
public class Fornecedor implements Comparable<Fornecedor>{
	
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
		if (nome == null || nome.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");
		}
		if (email == null || email.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");
		}
		if (telefone == null || telefone.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.");
		}
		
		nome = nome.trim();
		email = email.trim();
		telefone = telefone.trim();
		
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
		if(email == null || email.trim().equals("")) {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: novo valor nao pode ser vazio ou nulo.");
		}
		
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
		if (telefone == null || telefone.trim().equals("")) {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: novo valors nao pode ser vazio ou nulo.");
		}
		
		this.telefone = telefone;
	}
	
	///////////////////////////////////			ÁREA DO PRODUTO			\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

	/**
	 * Cadastra um produto comercializado pelo fornecedor.
	 * 
	 * @param nome é o nome do produto.
	 * @param descricao é a descrição do produto.
	 * @param preco é o preco do produto.
	 */
	public void cadastraProduto(String nome, String descricao, double preco) {
		if (nome == null || nome.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
		} else if (descricao == null || descricao.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");
		}
		if (preco <= 0) {
			throw new IllegalArgumentException("Erro no cadastro de produto: preco invalido.");
		}
		
		nome = nome.trim();
		descricao = descricao.trim();
		
		String key = nome + " - " + descricao;
		if (this.produtos.containsKey(key)) {
			throw new IllegalArgumentException("Erro no cadastro de produto: produto ja existe.");
		}
		
		this.produtos.put(key, new Produto(nome, descricao, preco));
	}
	
	/**
	 * Dado o nome e uma descrição é retornado um produto de um fornecedor.
	 * 
	 * @param key é o nome e a descrição do produto.
	 * 
	 * @return Uma string com a representação do produto.
	 */
	public String retornaProduto(String key) {
		if (!this.produtos.containsKey(key)) {
			throw new IllegalArgumentException("Erro na exibicao de produto: produto nao existe.");
		}
		
		return this.produtos.get(key).toString();
	}
	
	/**
	 * Permite editar o preço do produto
	 * 
	 * @param key é o identificador do produto.
	 * @param preco é o novo preço do produto.
	 */
	public void editaProduto(String key, double preco) {
		if (!this.produtos.containsKey(key)) {
			throw new IllegalArgumentException("Erro na edicao de produto: produto nao existe.");
		}
		
		this.produtos.get(key).setPreco(preco);
	}
	
	/**
	 * Método que informa todos os produtos comercializados pelo fornecedor.
	 * 
	 * @return Uma string com todos os produtos comercializados pelo fornecedor, em ordem alfabética.
	 */
	public String exibeProdutosFornecedor() {
		List<Produto> lista = new ArrayList<>(this.produtos.values());
		Collections.sort(lista);
		return lista.stream().map(p -> this.nome + " - " + p.toString()).collect(Collectors.joining(" | "));		
	}
	
	/**
	 * Permite visualizar o preço de um produto.
	 * 
	 * @param nome é o nome do produto.
	 * @param descricao é a descrição do produto.
	 * 
	 * @return Uma string com o preço do produto.
	 */
	public String getPrecoProduto(String nome, String descricao) {
		if (nome == null || nome.trim().equals("")) {
			throw new IllegalArgumentException("Erro na remocao de produto: nome nao pode ser vazio ou nulo.");
		} else if (descricao == null || descricao.trim().equals("")) {
			throw new IllegalArgumentException("Erro na remocao de produto: descricao nao pode ser vazia ou nula.");
		}
		if(!this.produtos.containsKey(nome.trim() + " " + descricao.trim())) {
			throw new IllegalArgumentException("Erro na exibicao de produto: produto nao existe.");
		}
		
		return this.produtos.get(nome.trim() + " - " + descricao.trim()).mostraPreco();
	}
	
	/**
	 * Método que remove um produto.
	 * 
	 * @param nome é o nome do produto a ser removido.
	 * @param descricao é a descrição do produto a ser removido.
	 */
	public void removeProduto(String nome, String descricao) {
		if (nome == null || nome.trim().equals("")) {
			throw new IllegalArgumentException("Erro na remocao de produto: nome nao pode ser vazio ou nulo.");
		} else if (descricao == null || descricao.trim().equals("")) {
			throw new IllegalArgumentException("Erro na remocao de produto: descricao nao pode ser vazia ou nula.");
		}
		
		String key = nome.trim() + " - " + descricao.trim();
		
		if (!this.produtos.containsKey(key)) {
			throw new IllegalArgumentException("Erro na remocao de produto: produto nao existe.");
		}
		
		this.produtos.remove(key);
	}
	
	///////////////////////////////////			ÁREA DO COMBO			\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	
	public String adicionaCombo(String nome, String descricao, double fator, String produtos) {
		if (this.produtos.containsKey(nome + " - " + descricao)) {
			throw new IllegalArgumentException("Erro no cadastro de combo: combo ja existe.");
		}
		
		String[] p = produtos.trim().split(", ");
		double preco = 0;
		List<Produto> prod = new ArrayList<>();
		
		for (String s : p) {
			if (!this.produtos.containsKey(s)) {
				throw new IllegalArgumentException("Erro no cadastro de combo: produto nao existe.");
			}
			if (this.produtos.get(s).getClass() == Combo.class) {
				throw new IllegalArgumentException("Erro no cadastro de combo: um combo nao pode possuir combos na lista de produtos.");
			}
			preco += this.produtos.get(s).getPreco();
			prod.add(this.produtos.get(s));
		}
		
		this.produtos.put(nome + " - " + descricao, new Combo(nome, descricao, preco, fator, prod));
		return nome + " - " + descricao;
	}
	
	public void editaCombo(String nome, String descricao, double novoFator) {
		if (nome == null || nome.trim().equals("")) {
			throw new IllegalArgumentException("Erro na edicao de combo: nome nao pode ser vazio ou nulo.");
		}
		if (descricao == null || descricao.trim().equals("")) {
			throw new IllegalArgumentException("Erro na edicao de combo: descricao nao pode ser vazia ou nula.");
		}
		if (!this.produtos.containsKey(nome + " - " + descricao)) {
			throw new IllegalArgumentException("Erro na edicao de combo: produto nao existe.");
		}
		if (novoFator <= 0 || novoFator >= 1) {
			throw new IllegalArgumentException("Erro na edicao de combo: fator invalido.");
		}
		
		Combo c = (Combo)this.produtos.get(nome + " - " +  descricao);
		c.setFator(novoFator);
	}
	
	@Override
	public int compareTo(Fornecedor o) {
		return this.getNome().compareTo(o.getNome());
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