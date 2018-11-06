package models;

import java.util.List;

public class Combo extends Produto {
	
	private double fator;
	
	public Combo(String nome, String descricao, double preco, double fator, List<Produto> produtos) {
		super(nome, descricao, preco);
		this.fator = 1 - fator;
	}
	
	public void setFator(double fator) {
		this.fator = 1 - fator;
	}
	
	@Override
	public double getPreco() {
		return this.preco * this.fator;
	}
}