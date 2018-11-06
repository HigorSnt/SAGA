package models;

import java.util.List;

public class Combo extends Produto {
	
	private List<Produto> produtos;
	
	public Combo(String nome, String descricao, double preco, List<Produto> produtos) {
		super(nome, descricao, preco);
		this.produtos = produtos;
	}
}
