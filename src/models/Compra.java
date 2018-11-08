package models;

public class Compra {
	
	private String nomeProd;
	private double preco;
	private String data;
	
	
	public Compra(String nomeProd, String data, double preco) {
		this.nomeProd = nomeProd;
		this.data = data.replace("/", "-");
		this.preco = preco;
	}
	
	public double getPreco() {
		return preco;
	}
	public String getData() {
		return data;
	}
	
	@Override
	public String toString() {
		return this.nomeProd + " - " + this.data;
	}
}
