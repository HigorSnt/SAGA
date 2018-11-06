package models;

public class Compra {
	
	private Fornecedor fornecedor;
	private Cliente cliente;
	private double preco;
	
	public Compra(Fornecedor fornecedor, Cliente cliente, double preco) {
		this.fornecedor = fornecedor;
		this.cliente = cliente;
		this.preco = preco;
	}
}
