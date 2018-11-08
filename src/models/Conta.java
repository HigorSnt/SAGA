package models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Conta implements Comparable<Conta> {
	
	private String fornecedor;
	private List<Compra> compras;
	
	public Conta(String fornecedor) {
		this.fornecedor = fornecedor;
		this.compras = new ArrayList<>();
	}
	
	public void adicionaCompra(String nomeProd, String data, double preco) {
		this.compras.add(new Compra(nomeProd, data, preco));
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
