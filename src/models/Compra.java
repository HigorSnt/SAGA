package models;

import java.util.Comparator;

public class Compra {
	
	private String fornecedor;
	private String cliente;
	private String nomeProd;
	private String descProd;
	private double preco;
	private String data;
	
	
	public Compra(String fornecedor, String cliente, String nomeProd, String descProd, String data, double preco) {
		this.fornecedor = fornecedor;
		this.cliente = cliente;
		this.nomeProd = nomeProd;
		this.descProd = descProd;
		this.data = data;
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
	
	@Override
	public String toString() {
		return this.nomeProd + " - " + this.data.replace("/", "-");
	}

	public String getNomeProd() {
		return this.nomeProd;
	}
	
	public String getDescProd() {
		return descProd;
	}
}