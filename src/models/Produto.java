package models;

public class Produto implements Comparable<Produto>{
	
	private String nome;
	private String descricao;
	double preco;
	
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
		} else if (descricao == null || descricao.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");
		} else if (preco <= 0) {
			throw new IllegalArgumentException("Erro no cadastro de produto: preco invalido.");
		}
		
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
	}
	
	/**
	 * Informa o nome e a descrição do produto.
	 * 
	 * @return Uma string com o nome e a descrição do produto.
	 */
	public String getNomeDescricao() {
		return this.nome + " - " + this.descricao;
	}
	
	/**
	 * Informa o preço do produto.
	 * 
	 * @return Uma string com o preço do produto.
	 */
	public String mostraPreco() {
		return "R$" + String.format("%.2f", this.preco);
	}
	
	public double getPreco() {
		return this.preco;
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
}
