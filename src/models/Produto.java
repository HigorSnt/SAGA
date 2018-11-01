package models;

/**
 * Classe que molda um objeto do tipo Produto.
 * 
 * @author Higor Santos - 118110808.
 *
 */
public class Produto  implements Comparable <Produto> {
	/** Nome do produto */
	private String nome;
	/** Descrição do produto */
	private String descricao;
	/** Preço do produto */
	private double preco;
	
	/**
	 * Constrói um produto.
	 * 
	 * @param nome é o nome do produto.
	 * @param descricao é a descrição do produto.
	 * @param preco é o preço do produto.
	 */
	public Produto(String nome, String descricao, double preco){
		if (nome.trim().equals("") || nome.equals(null)) {
			throw new IllegalArgumentException("Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
		} else if (descricao.trim().equals("") || descricao.equals(null)) {
			throw new IllegalArgumentException("Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");
		} else if (preco <= 0) {
			throw new IllegalArgumentException("Erro no cadastro de produto: preco invalido.");
		}
		
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
	}
	
	/**
	 * Informa o preço do produto.
	 * 
	 * @return Uma string com o preço do produto.
	 */
	public String getPreco() {
		return "R$" + String.format("%.2f", this.preco);
	}
	
	/**
	 * Informa o nome e a descrição do produto.
	 * 
	 * @return Uma string com o nome e a descrição do produto.
	 */
	public String getNomeDescricao() {
		return this.nome + " " + this.descricao;
	}

	/**
	 * Atualiza o preço do produto.
	 * 
	 * @param preco é o preço de um determinado produto.
	 */
	public void setPreco(double preco) {
		if (preco <= 0) {
			throw new IllegalArgumentException("Erro na edicao de produto: preco invalido.");
		}
		
		this.preco = preco;
	}
	
	@Override
	public int compareTo(Produto o) {
		return this.getNomeDescricao().compareTo(o.getNomeDescricao());
	}
	
	@Override
	public String toString() {
		return this.nome + " - " + this.descricao + " - R$" + String.format("%.2f", this.preco);
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
