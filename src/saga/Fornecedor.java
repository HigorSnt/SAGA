package saga;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Classe que molda um objeto do tipo Fornecedor.
 * 
 * @author higor
 *
 */
public class Fornecedor{
	
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
		verificaExcecao(nome, email, telefone);
		
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
		verificaExcecao(email);
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
		verificaExcecao(telefone);
		this.telefone = telefone;
	}
	
	public boolean editaPrecoProduto(String key, double preco) {
		verificaExcecao(key);
		if (!this.produtos.containsKey(key)) {
			return false;
		}
		this.produtos.get(key).setPreco(preco);
		return true;
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
		verificaExcecao(nome, desc);
		String key = nome + " " + desc;
		if (!this.produtos.containsKey(key)) {
			return false;
		}
		
		this.produtos.put(key, new Produto(nome, desc, preco));
		return true;
	}
	
	/**
	 * Dado o nome e uma descrição é retornado um produto de um fornecedor.
	 * 
	 * @param key é o nome e a descrição do produto.
	 * 
	 * @return Uma string com a representação do produto.
	 */
	public String retornaProduto(String key) {
		verificaExcecao(key);
		if (!this.produtos.containsKey(key)) {
			return "PRODUTO NÃO CADASTRADO!";
		}
		
		return this.produtos.get(key).toString();
	}
	
	/**
	 * Método que informa todos os produtos comercializados pelo fornecedor.
	 * 
	 * @return Uma string com todos os produtos comercializados pelo fornecedor.
	 */
	public String retornaTodosProdutosDeFornecedor() {
		String saida = "";
		int cont = 0;
		
		List<Produto> lista = new ArrayList<Produto>(this.produtos.values());
		Collections.sort(lista);
		
		for(Produto p : lista) {
			if (!(cont == 0) || !(cont == this.produtos.size() - 1)) {
				saida += " | ";
			}
			saida += this.nome + " - " + p.toString();
			cont++;
		}
		return saida;
	}
	
	public boolean removeProduto(String key) {
		verificaExcecao(key);
		if (!this.produtos.containsKey(key)) {
			return false;
		}
		
		this.produtos.remove(key);
		return true;
	}
	
	/**
	 * Método que verifica se os dados passados são válidos.
	 * 
	 * @param args são os dados a serem verificados.
	 */
	private void verificaExcecao(String... args) {
		for (String s : args) {
			if (s.equals(null)) {
				throw new NullPointerException("ENTRADA NULA PASSADA!");
			} else if (s.equals("")) {
				throw new IllegalArgumentException("ENTRADA VAZIA PASSADA!");
			}
		}
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