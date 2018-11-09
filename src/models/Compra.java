package models;

public class Compra {
	
	private String fornecedor;
	private String cliente;
	private String nomeProd;
	private double preco;
	private String data;
	
	
	public Compra(String fornecedor, String cliente, String nomeProd, String data, double preco) {
		this.fornecedor = fornecedor;
		this.cliente = cliente;
		this.nomeProd = nomeProd;
		this.data = data.replace("/", "-");
		this.preco = preco;
	}
	
	public String getCliente() {
		return cliente;
	}
	
	public String getFornecedor() {
		return fornecedor;
	}
	
	public double getPreco() {
		return preco;
	}
	public String getData() {
		return data;
	}
	
	public String getNomeProd() {
		return nomeProd;
	}
	
	@Override
	public String toString() {
		return this.nomeProd + " - " + this.data;
	}
}
