package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import comparators.ComparaPorData;

public class Conta implements Comparable <Conta>{
	
	private String fornecedor;
	private List<Compra> compras;
	private String ordenaPor;
	
	public Conta(String fornecedor) {
		this.fornecedor = fornecedor;
		this.ordenaPor = "FORNECEDOR";
		this.compras = new ArrayList<>();
	}
	
	public void adicionaCompra(String fornecedor, String cliente, String nomeProd, String data, double preco) {
		this.compras.add(new Compra(fornecedor, cliente, nomeProd, data, preco));
	}
	
	public void setOrdenaPor(String ordenaPor) {
		if (!ordenaPor.trim().toUpperCase().equals("cliente")) {
			throw new IllegalArgumentException("Erro na listagem de compras: criterio nao pode ser vazio ou nulo.");
		}
		ordenaPor = ordenaPor.trim().toUpperCase();
		if (!ordenaPor.equals("CLIENTE") && !ordenaPor.equals("FORNECEDOR") && !ordenaPor.equals("DATA")) {
			throw new IllegalArgumentException("Erro na listagem de compras: criterio nao oferecido pelo sistema.");
		}
		this.ordenaPor = ordenaPor;
	}
	
	public double getDebito() {
		double soma = 0;
		for (Compra compra : this.compras) {
			soma += compra.getPreco();
		}
		return soma;
	}
	
	@Override
	public String toString() {
		return this.fornecedor + " | " + this.compras.stream().map(p -> p.toString()).collect(Collectors.joining(" | "));
	}
	
	@Override
	public int compareTo(Conta o) {
		return this.fornecedor.compareTo(o.fornecedor);
	}
}
