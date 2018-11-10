package controllers;

import java.util.HashMap;
import java.util.Map;

import models.Conta;

public class ContaController {
	private Map<String, Conta> contas = new HashMap<>();
	
	public String adicionaCompra(String cliente, String fornecedor, String data, String nomeProd, double preco) {
		this.contas.put(cliente, new Conta());
		this.contas.get(cliente).adicionaCompra(fornecedor, cliente, nomeProd, data, preco);
		return cliente;
	}

	public double getDebito(String cliente, String fornecedor) {
		return this.contas.get(cliente).getDebito(fornecedor);
	}
	
}
