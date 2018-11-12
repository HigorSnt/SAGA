package models;

/**
 * Classe que molda um objeto do tipo produto.
 * 
 * @author Higor Santos - 118110808.
 *
 */
public class Produto implements Comparable<Produto>{
	
	/** O nome do produto. */
	private String nome;
	/** A descrição do produto. */
	private String descricao;
	/** O preço do produto. */
	protected double preco;
	
	/**
	 * Constrói um produto.
	 * 
	 * @param nome é o nome do produto.
	 * @param descricao é a descrição do produto.
	 * @param preco é o preço do produto.
	 */
	public Produto(String nome, String descricao, double preco){
		if (nome == null || nome.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
		}
		if (descricao == null || descricao.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");
		}
		if (preco <= 0) {
			throw new IllegalArgumentException("Erro no cadastro de produto: preco invalido.");
		}
		
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
	}
	
	/**
	 * Exibe o nome do produto.
	 * 
	 * @return Retorna o nome do produto.
	 */
	public String getNome() {
		return this.nome;
	}
	
	/**
	 * Exibe a descrição do produto.
	 * 
	 * @return Retorna a descrição do produto.
	 */
	public String getDescricao() {
		return this.descricao;
	}
	
	/**
	 * Exibe o preço do produto.
	 * 
	 * @return Retorna o preço do produto
	 */
	public double getPreco() {
		return this.preco;
	}
	
	/**
	 * Permite alterar o preço de um produto.
	 * 
	 * @param preco é o novo preço do produto.
	 */
	public void setPreco(double preco) {
		if (preco <= 0) {
			throw new IllegalArgumentException("Erro na edicao de produto: preco invalido.");
		}
		
		this.preco = preco;
	}
	
	@Override
	public int compareTo(Produto o) {
		if (this.getNome().equals(o.getNome())) {
			return this.getDescricao().compareTo(o.getDescricao());
		}
		return this.getNome().compareTo(o.getNome());
	}
	
	@Override
	public String toString() {
		return this.nome + " - " + this.descricao + " - R$" + String.format("%.2f", this.getPreco());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
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
		Produto other = (Produto) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	
}