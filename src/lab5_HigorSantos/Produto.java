package lab5_HigorSantos;

public class Produto {
	private String nome;
	private String descricao;
	private double preco;
	
	public Produto(String nome, String descricao, double preco){
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
	}
	
	public double getPreco() {
		return this.preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	@Override
	public String toString() {
		return this.nome + " - " + this.descricao + " - R$" + this.preco;
	}
	
}
